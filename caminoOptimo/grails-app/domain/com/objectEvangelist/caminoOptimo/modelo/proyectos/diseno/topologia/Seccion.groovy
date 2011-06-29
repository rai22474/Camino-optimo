package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

/**
 * 
 * Cada una de las secciones que forman una bandeja
 *
 */
class Seccion extends Canalizacion {

    static constraints = {
    }
	
	/**
	 * @see com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.ElementoTopologia#obtenerTipoElementoTopologia()
	 */
	TipoElementoTopologia obtenerTipoElementoTopologia(){
    	TipoElementoTopologia.SECCION
	}	
	
	/** 
	 * Metodo que devuelve cual es el porcentaje de llenado de la seccion con respecto al tipo
	 * de la bandeja a la que pertecene y a lo fijado en el diseño para bandejas.
	 * 
	 */
	def public getPorcentajeLlenado(){
		return 0
	}
	
}
