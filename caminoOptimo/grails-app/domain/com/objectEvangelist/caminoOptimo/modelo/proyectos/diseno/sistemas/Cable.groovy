package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas

import java.io.Serializable;

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*

/**
 * Cada uno de los cables que forma un sistema, da servicio a cada uno de los equipos.
 * 
 */
class Cable implements Serializable{
	
	static constraints = {
		referencia(blank:false)
		tipoCable(nullable:false)
		red(nullable:false)
		sistema(nullable:false)
		equipoOrigen(nullable:false)
		ruta(nullable:true)
	}
		
	
	
	/**
	 * Metodo que modifica la ruta del cable con la nueva informacion de canalizaciones.
	 */
	def modificaRuta(nuevaRuta){
		ruta?.delete()
		ruta?.eliminaCable(this)
		
		nuevaRuta.save()
		
		ruta = nuevaRuta
		ruta.agregaCable(this)	
	}
	
	/**
	 * Metodo que va a calcular cuales son las rutas por las que puede ir un cable.
	 */
	def calculaRutasPosibles(){
		return equipoOrigen.calculaRutasPosibles(equipoDestino)
	}
	
	/**
	 * La seccion exterior de un cable.  
	 */
	def getSeccionExterior(){
		tipoCable.getSeccionExterior()
	}
	
	/**
	 * 	@see java.lang.Object#toString()
	 */
	@Override
	def String toString(){
		"$referencia"
	}
	
	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31
		int result = 1
		return prime * result
				+ ((referencia == null) ? 0 : referencia.hashCode())
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false
		}
		if (!(obj instanceof Cable)) {
			return false
		}
	
		if (referencia == null) {
			if (obj.referencia != null) {
				return false
			}
		} else if (!referencia.equals(obj.referencia)) {
			return false
		}
		return true
	}

	/**
	 * La referencia del cable.
	 */
	String referencia
	
	/**
	 * Descripcion del cable.
	 */
	String descripcion
	
	/**
	 * El tipo de cable que tiene este cable.
	 */
	TipoCable tipoCable
	
	/**
	 * El tipo de red que tiene este cable.
	 */
	TipoRed red
	
	/**
	 * El sistema al pertenece el cable. 
	 */
	Sistema sistema
		
	/**
	 * El equipo del que parte el cable.
	 */
	Equipo equipoOrigen
	
	/**
	 * El equipo hacia el que va el cable.
	 */
	Equipo equipoDestino
	
	/**
	 * Cada la ruta por la que discurre el cable.
	 */
	Ruta ruta

	/**
	* Indica que el cable pertenece al sistema.
	*/
   static belongsTo = [ sistema : Sistema]
   
	
	/**
	 * Elementos topologia
	 */
	static hasMany = [elementosTopologia:ElementoTopologia]
}
