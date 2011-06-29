package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Cable;

/**
 * Cada una de la bandejas que forman el sistema.
 *
 */
class Bandeja extends CanalizacionCompuesta{

    static constraints = {
    }
		
	/**
	 * 	@see java.lang.Object#toString()
	 */
	@Override
	public def String toString(){
		return "$referencia"
	}
	
	/**
	 * @see com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.ElementoTopologia#obtenerTipoElementoTopologia()
	 */
	TipoElementoTopologia obtenerTipoElementoTopologia(){
    	TipoElementoTopologia.BANDEJA
	}
		
	/**
	* El porcentaje de llenado de una bandeja sera el maximo llenado de cada una de las secciones.
	*/
   def public getPorcentajeLlenado() {
	   return 0
   }  
}
