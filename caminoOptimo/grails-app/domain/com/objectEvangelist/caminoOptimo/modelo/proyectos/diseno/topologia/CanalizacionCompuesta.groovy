package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import java.io.Serializable;

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.Diseno;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Cable;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoRed;

/**
 * Clase padre de todas las canalizaciones.
 *
 */
class CanalizacionCompuesta extends Canalizacion {


	/**
	 * Cuando se agrega un cable a una bandeja se agrega a todas las secciones.
	 */
	def public agregaCable(Cable cable){
		agregaCableHijos (cable, TipoConexion.ESTRUCTURA)
	}

	/**
	 * Cuando se agrega un cable a una bandeja se elemina a todas sus secciones.
	 */
	def public eliminaCable(cable){
		eliminaCableHijos(cable,TipoConexion.ESTRUCTURA)
	}

	/**
	 * Calcula el llenado de una canalizacion compuesta. Sera el maximo de los llenados de los hijos.
	 */
	@Override
	public calculaSeccionOcupada() {
		def llenadoCanalizacion = 0
		recuperaHijos(TipoConexion.ESTRUCTURA).each {componente->
			def llenado = componente.calculaSeccionOcupada()
			println llenado
			if ( llenado > llenadoCanalizacion){
				llenadoCanalizacion = llenado
			}
		}

		return llenadoCanalizacion
	}

	/**
	 * El tipo de canal.
	 */
	TipoCanal tipoCanal

	/**
	 * El tipo de red que va a llevar este canal.
	 */
	TipoRed red

	/**
	 * La ubicacion de ese canal.
	 */
	String ubicacion

	/**
	 * La longitud total del canal.
	 */
	BigDecimal longitud

	/**
	 * El diseño al que pertenece este equipo.
	 */
	Diseno diseno
}
