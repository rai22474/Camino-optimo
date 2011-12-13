package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia


import java.io.Serializable;

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.Diseno;

/**
 * Cada uno de los equipos que relacionan los cables.
 *
 */
class Equipo extends ElementoTopologia{

	static constraints = {
		referencia(nullable:false,blank:false,unique:true)
	}
	
	/**
	 * Devuelve un String con la referencia.
	 */
	@Override
	def String toString(){
    	"$referencia"
	}
	
	/**
	 * @see com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.ElementoTopologia#obtenerTipoElementoTopologia()
	 */
	TipoElementoTopologia obtenerTipoElementoTopologia(){
    	TipoElementoTopologia.EQUIPO
	}
		
	/**
	*
	* Indica si un elemento de topologia.
	*/
   def esElementoTopologiaFinal(){
	   return true
   }
		
	/**
	 * La ubicacion del equipo.
	 */
	String ubicacion
	
	/**
	 * El diseño al que pertenece este equipo.
	 */
	Diseno diseno
}
