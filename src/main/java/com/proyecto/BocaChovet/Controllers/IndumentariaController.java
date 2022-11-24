package com.proyecto.BocaChovet.Controllers;

import com.proyecto.BocaChovet.Models.Indumentaria;
import com.proyecto.BocaChovet.Repositories.IndumentariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * La anotación @RestController es la combinación de @Controller
 * y @ResponseBody.
 * Está anotando la clase, o sea que todos los métodos la heredan y
 * no es necesario anotar cada uno de ellos. Todos tendrán la semántica
 * de @ResponseBody. Esto significa que la String retornada es la response, no
 * el nombre de una vista.
 */
@RestController

// La URL que va entre paréntesis en esta anotación habrá que agregarla detrás
// del puerto 8080 en todas las llamadas a esta aplicación.
// Por ejemplo @RequestMapping("/catalogo") resultaría en lo siguiente:
// localhost:8080/catalogo.... y detrás de esto habría que agregar el
// resto de la URL.
// En este caso, no necesitamos nada, y queda simplemente localhost:8080
@RequestMapping("")
public class IndumentariaController {

    /**
     * La anotación '@Autowired' significa que Spring va a inyectar en esta clase un
     * bean llamado 'indumentariaRepository' de tipo 'IndumentariaRepository'.
     * No hay en este proyecto una clase 'IndumentariaRepository'. Solo hay una
     * interfaz 'IndumentariaRepository'. Y esta interfaz lo único que hace es extender
     * 'CrudRepository'. No declara ni campos ni métodos. Nosotros no hacemos nada,
     * todo lo hace Spring por nosotros.
     * Esta es la inyección de dependencia. Nosotros lo único que hacemos es
     * declarar la variable 'indumentariaRepository' de tipo 'IndumentariaRepository', y ponerle
     * la anotación '@Autowired'. Y listo. Ya tenemos en esta clase 'IndumentariaController'
     * la variable 'indumentariaRepository' correctamente configurada e inicializada, de
     * manera que la podemos usar sin más.
     * Notar que tampoco hemos programado los métodos que estamos llamando,
     * y que están declarados en la interfaz 'CrudRepository'.
     * Los nombres de los métodos que nosotros creamos en esta clase
     * son arbitrarios. Pero los nombres de los métodos que invocamos
     * sobre el objeto 'indumentariaRepository' tienen que ser los de la interfaz.
     */
    @Autowired
    private IndumentariaRepository indumentariaRepository;

    @PostMapping("/agregar")
    // @RequestParam significa que es un parámetro de la petición GET o POST
    public String agregarIndumentaria(@RequestParam String producto, @RequestParam String talle, @RequestParam String precio, @RequestParam String stock){
        Indumentaria indumentaria = new Indumentaria();
        indumentaria.setProducto(producto);
        indumentaria.setTalle(talle);
        indumentaria.setPrecio(precio);
        indumentaria.setStock(stock);
        indumentariaRepository.save(indumentaria);
        return "Se agregó al catálogo la nueva indumentaria.";
    }

    @PostMapping("/eliminar/{id}")
    // @PathVariable indica que el parámetro 'id', de tipo Long, es una
    // variable de template que viene en la URI.
    public String eliminarIndumentariaById(@PathVariable Long id) {
        indumentariaRepository.deleteById(id);
        return "Se eliminó del catálogo la indumentaria.";
    }

    @GetMapping("/{id}")
    public String findIndumentariaById(@PathVariable Long id) {

        String resp = primeraParte();

        /**
         * El método findById() tiene un tipo de retorno Optional.
         * Dicho brevemente, significa que el objeto retornado puede estar
         * presente, o no estar presente. O está, o no está. Solo hay dos opciones.
         * Si está, lo puedo extraer con el método get(). En este caso, el get()
         * me devuelve simplemente el objeto de tipo Indumentaria, con sus campos
         * debidamente completados con los valores que JPA sacó de la tabla
         * correspondiente de la base de datos.
         */
        if (indumentariaRepository.findById(id).isPresent()) {

            /**
             * No necesito el operador new. Solo lo uso cuando quiero crear una
             * instancia que todavía no existe, por eso es 'nueva'. En este caso,
             * el objeto indumentaria ya existe, y me viene retornado por el método get().
             * No necesito crearlo, solo se lo asigno a la variable.
             */
            Indumentaria indumentaria = indumentariaRepository.findById(id).get();

            resp += "<tr>"
                    + "<td>" + indumentaria.getId() + "</td>"
                    + "<td>" + indumentaria.getProducto() + "</td>"
                    + "<td>" + indumentaria.getTalle() + "</td>"
                    + "<td>" + indumentaria.getPrecio() + "</td>"
                    + "<td>" + indumentaria.getStock() + "</td>"
                    + "</tr>";
        } else {
            resp += "<tr>"
                    + "<td>" + "-" + "</td>"
                    + "<td>" + "-" + "</td>"
                    + "<td>" + "-" + "</td>"
                    + "<td>" + "-" + "</td>"
                    + "<td>" + "-" + "</td>"
                    + "</tr>";

        }
        return resp + "</table>";
    }

    @GetMapping("/catalogo")
    public String getCatalogo() {
        // Esto devuelve un JSON o XML con los usuarios
        Iterable<Indumentaria> iterable = indumentariaRepository.findAll();
        String resp = primeraParte();

        /**
         * Ya terminé con la fila de los encabezados, y ahora tengo que
         * generar el cuerpo de la tabla, una fila por cada registro.
         * No puedo usar forEach() con una función lambda
         * porque el scope de las variables no lo permite.
         * Por eso uso el for mejorado, para recorrer el objeto iterable.
         */
        for (Indumentaria indumentaria : iterable) {
            resp += "<tr>"
                    + "<td>" + indumentaria.getId() + "</td>"
                    + "<td>" + indumentaria.getProducto() + "</td>"
                    + "<td>" + indumentaria.getTalle() + "</td>"
                    + "<td>" + indumentaria.getPrecio() + "</td>"
                    + "<td>" + indumentaria.getStock() + "</td>"
                    + "</tr>";
        }
        return resp + "</table>";
    }

    @GetMapping("")
    public String bienvenida() {
        return visual();
    }

    private String primeraParte() {

        /**
         * Lo que viene a continuación se llama text block,
         * y es tipo String.
         * Ese bloque de texto es todo que lo que está contenido entre los dos
         * delimitadores: el de apertura y el de cierre.
         * El delimitador de apertura es la triple comilla ' """ ' que está a la
         * derecha de la sentencia return.
         * El delimitador de cierre es la triple comilla ' """ ' que está al final.
         * Todo es seguido por el punto y coma, porque es el final de una sentencia.
         *
         * Comenzamos por poner unos estilos CSS, para que la tabla quede más linda.
         *
         * Cuando terminamos con los estilos, arrancamos con el HTML de la
         * tabla misma. Lo primero que hacemos es generar una fila y en las
         * celdas de esa fila poner los encabezados, que son los nombres de
         * las columnas o campos de la tabla que está en la base de datos.
         *
         * Dentro del estilo, el selector #catalogo indica que el estilo
         * que estamos definiendo es para ser usado solamente en el
         * elemento del DOM que tiene id='catalogo', o sea la tabla.
         */
        return """
                  <style>
                    #catalogo {
                      border-collapse: collapse;
                      width: 100%;
                    }
                    #catalogo td, #catalogo th {
                      border: 1px solid #000000;
                      padding: 8px;
                    }
                    #catalogo tr:nth-child(even) {
                    font-family: Comic Sans, Impact, cursive;
                    background-color: #0006FF;
                    color: yellow;
                    }
                    #catalogo tr:nth-child(odd) {
                    font-family: Comic Sans, Impact, cursive;
                    background-color: #FCFF00;
                    color: blue;
                    }
                    #catalogo th {
                      font-family: Arial, Helvetica, sans-serif;
                      padding-top: 12px;
                      padding-bottom: 12px;
                      text-align: left;
                      background-color: #04AA6D;
                      color: white;
                    }
                    h1 {
                      font-family: Arial, Helvetica, sans-serif;
                      border-collapse: collapse;
                      width: 100%;
                      text-align: center;
                      text-decoration: underline;
                      border: 1px solid #000000;
                      background-color: #04AA6D;
                      color: white;
                    }
                    body {
                      background-color: #484848;
                    }
                  </style>
                  <h1>Catálogo de Boca Chovet</h1>
                  <table id='catalogo'>
                    <tr>
                      <th>Id</th>
                      <th>Producto</th>
                      <th>Talle</th>
                      <th>Precio</th>
                      <th>Stock</th>
                    </tr>
                """;
    }

    private String visual() {

        return """
                  <style>
                    h1 {
                      font-family: Comic Sans, Impact, cursive;
                      width: 100%;
                      text-align: center;
                      border-collapse: collapse;
                      border: 1px solid #000000;
                      background-color: #FCFF00;
                      color: black;
                      position: fixed;
                    }
                    body {
                      background-color: #0006FF;
                    }
                  </style>
                  <h1>¡Bienvenido a Boca Chovet!</h1>
                  
                """;
    }
}
