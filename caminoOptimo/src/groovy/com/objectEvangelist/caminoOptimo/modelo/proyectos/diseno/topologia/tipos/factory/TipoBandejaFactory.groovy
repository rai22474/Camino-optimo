package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.factory

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.*

/**
 * La factoria de tipos de bandeja
 *
 */
class TipoBandejaFactory {

	/**
	 * Metodo que crea un nuevo tipo de bandeja.
	 */
	def creaTipoBandeja(valores,identificadorProyecto){
		
		def tipoBandeja = new TipoBandeja(valores)
		
		def proyecto = Proyecto.get(identificadorProyecto)
		proyecto.getDiseno().agregaTipoCanal(tipoBandeja)
	
		return tipoBandeja
	}
}
