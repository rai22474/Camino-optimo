package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Cable;

/**
 * Conductos por los que van los cables.
 *
 */
class Conducto extends CanalizacionCompuesta{

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
	def TipoElementoTopologia obtenerTipoElementoTopologia(){
		TipoElementoTopologia.CONDUCTO
	}

	/**
	 * @see com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Canalizacion#calculaSeccionUtil()
	 */
	@Override
	def calculaSeccionUtil() {
		tipoCanal.getDiametroNominal()
	}
}
