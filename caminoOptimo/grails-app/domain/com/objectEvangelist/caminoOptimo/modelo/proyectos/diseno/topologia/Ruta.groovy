package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Cable;

/**
 * Clase que representa una ruta dentro de una topologia.
 *
 */
class Ruta extends ElementoTopologia{
	
	/**
	 * Devuelve el tipo de topologia que tiene esta clase.
	 */
	TipoElementoTopologia obtenerTipoElementoTopologia(){
		TipoElementoTopologia.RUTA
	}
			
	/**
	 * Crea una nueva bifurcacion de la ruta actual
	 */
	def bifurca(){
		def nuevaRuta = new Ruta(referencia:"referencia")
		
		recuperaHijos(TipoConexion.RUTA).each{segmento->
			nuevaRuta.conecta(segmento,TipoConexion.RUTA)
		}
			
		return nuevaRuta
	}
	
	/**
	 * Indica devuelve el ultimo segmento de la ruta.
	 */
	def ultimoSegmento(){
		if (recuperaHijos(TipoConexion.RUTA).isEmpty()){
			return null
		}
		
		return recuperaHijos(TipoConexion.RUTA).last()
	}
	
	/**
	 * Indica si contiene un elemento de topologia.
	 */
	def primerSegmento(){
		if (recuperaHijos(TipoConexion.RUTA).isEmpty()){
			return null
		}
		
		recuperaHijos(TipoConexion.RUTA).first()
	}
	
	/**
	 * Indica si contiene un elemento. 
	 */
	def contiene(elementoTopologia){
		return recuperaHijos(TipoConexion.RUTA).contains(elementoTopologia)
	}
	
	/**
	 * Cuando se agrega un cable a una bandeja se agrega a todas las secciones.
	 */
	def public agregaCable(Cable cable){
		agregaCableHijos (cable, TipoConexion.RUTA)
	}
	
	/**
	 * Cuando se agrega un cable a una bandeja se elemina a todas sus secciones.
	 */
	def public eliminaCable(cable){
		eliminaCableHijos(cable,TipoConexion.RUTA)
	}
		
	/**
	 * La distancia que recorre que tiene esa ruta.
	 */
	def getDistancia(){
		return 0
	}
	
	/**
	 * Devuelve el porcentaje de llenado de la ruta. Es el porcentaje de llenado del
	 * segmento que mas lleno esta.
	 */
	def getPorcentajeLlenado(){
		return 0
	}
	
	
}
