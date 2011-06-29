package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Cable;

/**
 * Conductos por los que van los cables.
 *
 */
class Conducto extends CanalizacionCompuesta{

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
    	TipoElementoTopologia.CONDUCTO
	}
}
