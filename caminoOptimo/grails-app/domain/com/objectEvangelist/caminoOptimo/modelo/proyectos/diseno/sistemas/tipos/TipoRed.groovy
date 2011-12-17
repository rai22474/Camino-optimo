package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos

import java.io.Serializable
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.*
import groovy.transform.EqualsAndHashCode

/**
 * Clase que define los diferentes tipos de redes que vamos a tener.
 *
 */
@EqualsAndHashCode(includes="referencia")
class TipoRed implements Serializable{

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

	/**
	 * El diseño al que pertenece este tipo de red
	 */
	Diseno diseno
}
