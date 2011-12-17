package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas

import java.io.Serializable
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.*
import groovy.transform.EqualsAndHashCode

/**
 * Clase que representa un sistema. Un sistema es un conjunto de cables que representa una utilidad práctica por
 * ejemplo los cables del transformador.
 *
 */
@EqualsAndHashCode(includes="referencia")
class Sistema implements Serializable {

	/**
	 * 	@see java.lang.Object#toString()
	 */
	@Override
	def String toString(){
		"$referencia"
	}
	
	static constraints = {
		referencia(blank:false,unique:true)
		nombre(blank:false)
	}

	/**
	 * Código de tres letras que representa el sistema.
	 */
	String referencia

	/**
	 * Nombre del subsistema.
	 */
	String nombre

	/**
	 * Descripción del sistema.
	 */
	String descripcion

	/**
	 * Los cables que pertenecen a un sistema.
	 */
	static hasMany = [cables:Cable]

	/**
	 * El tipo de red que pertenece el sistema.
	 */
	TipoRed red

	/**
	 * El diseño al que pertence este sistema.
	 */
	Diseno diseno
}
