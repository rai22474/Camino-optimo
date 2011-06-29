package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

/**
 * Cada uno de los extremos de un conducto.
 *
 */
class ExtremoConducto extends Canalizacion{
	
	static constraints = {
	}
	
	/**
	 * @see com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.ElementoTopologia#obtenerTipoElementoTopologia()
	 */
	TipoElementoTopologia obtenerTipoElementoTopologia(){
		TipoElementoTopologia.EXTREMO_CONDUCTO
	}
	
	/**
	 * El porcentaje de llenado dependiendo del tipo de conducto y de lo fijado en el diseño para 
	 * los conductos
	 *
	 */
	def public getPorcentajeLlenado(){
		return 0
	}
}
