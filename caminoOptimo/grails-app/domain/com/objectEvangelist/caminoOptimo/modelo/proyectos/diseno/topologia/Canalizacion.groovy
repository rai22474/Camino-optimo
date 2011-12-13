package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import java.io.Serializable;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoRed;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.*
/**
 * Clase padre de todas las canalizaciones.
 *
 */
class Canalizacion extends ElementoTopologia {

	/**
	 * @see com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.ElementoTopologia#toString()
	 */
	def String toString() {
		return "$referencia"
	}
	
	/**
	 * Devuelve el porcentaje de seccion ocupada.
	 */
	def calculaPorcentajeSeccionOcupada(){
		return calculaSeccionOcupada()/calculaSeccionUtil()
	}

	/**
	 * Calcula cual cual es la seccion que ocupa los cables dentro de una canalizacion.
	 */
	def calculaSeccionOcupada() {
		def seccionOcupada = 0

		println 'Los cables ' + getReferencia() + ' ' + getCables().size() 
		getCables().each {cable ->
			seccionOcupada += cable.getSeccionExterior()
		}

		return seccionOcupada
	}

	/**
	 * Metodo encargado que devuelve la seccion util de la canalizacion.
	 */
	def protected calculaSeccionUtil(){
	}
}
