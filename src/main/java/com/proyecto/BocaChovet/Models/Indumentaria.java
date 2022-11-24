package com.proyecto.BocaChovet.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Data genera todo el
 * código boiler plate que normalmente se
 * asocia con POJO simples (Plain Old Java Objects) y beans:
 * getters para todos los campos,
 * setters para todos los campos no finales e
 * implementaciones apropiadas de
 * toString,
 * equals y
 * hashCode
 * que involucran los campos de la clase, y
 * un constructor que inicializa todos los campos finales,
 * así como todos los campos no finales sin inicializador que se haya
 * marcado con @NonNull, para garantizar que el campo nunca sea nulo.
 *
 * Por esto, notar que no hemos implementado nada nosotros mismos
 * programando. Todo lo han hecho las anotaciones.
 *
 * Notar que esta anotación no tiene nada que ver con el mecanismo de
 * inyección de dependencia. Lo que hace es evitarnos la necesidad de
 * programar por nosotros mismos todos estos métodos.
 */
@Data
@Entity // Esto le dice a Hibernate que haga una tabla de esta clase
public class Indumentaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String producto;


    private String talle;


    private String precio;


    private String stock;
}