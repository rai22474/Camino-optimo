package com.objectEvangelist.caminoOptimo.modelo.proyectos

import grails.clojure.ClojureProxy
import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;

import  com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.*

/**
 * Clase que representa un proyecto de cableado.
 *
 */
@EqualsAndHashCode(excludes="descripcion,diseno")
@ToString(excludes="diseno,descripcion",includeNames=false)
class Proyecto implements Serializable {
	
    /**
     * Las restricciones del bean.
     */
    static constraints = {
		codigo(blank:false,unique:true,size:3..20)
		descripcion(blank:false)
		diseno(nullable:true)		
    }
			
	/**
	 * Cada proyecto tiene un diseno asociado.
	 */
	Diseno diseno = new Diseno()

	/**
	 * El codigo del proyecto. Va a ser unico para todos los proyectos.
	 */
	String codigo
	
	/**
	 * La descripcion de proyecto.
	 */
	String descripcion
	
	/**	
	 * Metodo que muestra la información en string, en este caso el código.
	 */
	@Override
	def String toString(){
		return "$codigo"
	}
	
	/**
	 * Funcion que es un prueba de clojure. 
	 */
	def sumarNumeros(x,y){
		clojurePropertyName.add_numbers(x, y)		
	}
}
