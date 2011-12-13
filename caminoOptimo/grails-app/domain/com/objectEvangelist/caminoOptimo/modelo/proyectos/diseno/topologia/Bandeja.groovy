package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Cable;

/**
 * Cada una de la bandejas que forman el sistema.
 *
 */
class Bandeja extends CanalizacionCompuesta{

   /**
	 * 	@see java.lang.Object#toString()
	 */
	@Override
	def String toString(){
		return "$referencia"
	}
	
	/**
	 * @see com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.ElementoTopologia#obtenerTipoElementoTopologia()
	 */
	TipoElementoTopologia obtenerTipoElementoTopologia(){
    	TipoElementoTopologia.BANDEJA
	}
		
	/**
	 * @see com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Canalizacion#calculaSeccionUtil()
	 */
	@Override
	def calculaSeccionUtil() {
		tipoCanal.getAncho()
	}
}
