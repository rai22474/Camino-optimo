package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos


import java.io.Serializable
import groovy.transform.EqualsAndHashCode

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.*

/**
 * Los tipos de cables que van a usarse dentro de este proyecto.
 *
 */
@EqualsAndHashCode(includes="referencia")
class TipoCable implements Serializable {

	/**
	 * 	@see java.lang.Object#toString()
	 */
	@Override
	def String toString(){
		"$referencia"
	}

	static constraints = {
		referencia(blank:false)
		descripcion(blank:true,size:3..100)
		peso(nullable:false)
		seccionExterior(nullable:false)
		numeroPuntas(nullable:false)
		seccionConductor(nullable:false)
	}

	/**
	 * La referencia que tiene ese tipo de cable.
	 */
	String referencia

	/**
	 * La descripcion del tipo de cable.
	 */
	String descripcion

	/**
	 * El peso que tiene este tipo de cable.
	 */
	BigDecimal peso

	/**
	 * Diametro total del tipo de cable.
	 */
	BigDecimal seccionExterior

	/**
	 * El numero de puntas del tipo de cable.
	 */
	Integer numeroPuntas

	/**
	 * Numero de cables.
	 */
	Integer numeroCables

	/**
	 * Seccion del conductor.
	 */
	BigDecimal seccionConductor

	/**
	 * Diseno al que pertenece este tipo de cable
	 */
	Diseno diseno
}
