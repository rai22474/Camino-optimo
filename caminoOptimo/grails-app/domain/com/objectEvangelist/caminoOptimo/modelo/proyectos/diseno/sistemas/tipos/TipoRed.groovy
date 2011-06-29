package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos

import java.io.Serializable;


/**
 * Clase que define los diferentes tipos de redes que vamos a tener.
 *
 */
class TipoRed implements Serializable{

    static constraints = {
    }
	
	/**
	 * 	@see java.lang.Object#toString()
	 */
	@Override
	def String toString(){
		"$referencia"
	}
	
	/**
	 * Referencia de cada uno de los tipo de red.
	 */
	String referencia
	
	/**
	 * La descripción del tipo de red.
	 */
	String descripcion
}
