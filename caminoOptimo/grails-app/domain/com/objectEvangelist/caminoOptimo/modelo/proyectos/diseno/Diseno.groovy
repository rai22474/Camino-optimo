package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno


import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.*

/**
 * El diseno es la definición de los elementos que forman el sistema de cableado.
 */
class Diseno {
		
	/**
	 * Metodo que añade un nueva canalizacion al diseño.
	 */
	def agregaCanalizacion(canalizacion){
		addToCanalizaciones(canalizacion)
		canalizacion.setDiseno(this)
	}
		
	/**
	 * Metodo que a�ade un tipo de canal al dise�o.
	 */
	def agregaTipoCanal(tipoCanal){
		addToTiposCanalizacion(tipoCanal)
		tipoCanal.setDiseno(this)
	}
	
	/**
	 * Relaciones con los cables.
	 */
	static hasMany = [tiposCable:TipoCable,
					  tiposRed:TipoRed,
					  tiposCanalizacion:TipoCanal,
					  sistemas:Sistema,
					  canalizaciones:CanalizacionCompuesta]

	
	/**
	 * Relaciones.
	 */
	static belongsTo = [Proyecto]
	
	/**
	* El porcentaje maximo de llenado de las bandejas
	*/
	BigDecimal porcentajeMaximoLlenadoBandejas = 0
   
	/**
	* El porcentaje maximo de llenado de los conductos
	*/
	BigDecimal porcentajeMaximoLlenadoConductos = 0   
}
