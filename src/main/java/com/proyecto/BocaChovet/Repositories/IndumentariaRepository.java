package com.proyecto.BocaChovet.Repositories;

import com.proyecto.BocaChovet.Models.Indumentaria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta anotación le indica a Spring Boot que las clases
 * que implementan esta interfaz IndumentariaRepository son candidatas a la inyección
 * de dependencias. Esto significa que, sin nosotros programar nada,
 * podemos tener todas las funcionalidades incorporadas a nuestro
 * programa. Lo único que tenemos que hacer es poner las anotaciones
 * necesarias en el lugar apropiado.
 * Esta es una de las anotaciones que necesitamos. En esta interfaz
 * IndumentariaRepository ya no necesitamos hacer nada más.
 * La clase que hace todo el trabajo en este ejemplo es
 * IndumentariaController. La clase IndumentariaController es la que va a recibir la inyección
 * de la dependencia. Esto significa que la clase IndumentariaController va a tener una
 * variable declarada del tipo IndumentariaRepository. Solo la va a declarar, no vamos
 * a programar nada, o casi nada.
 */
@Repository
public interface IndumentariaRepository extends CrudRepository<Indumentaria, Long> {

}
