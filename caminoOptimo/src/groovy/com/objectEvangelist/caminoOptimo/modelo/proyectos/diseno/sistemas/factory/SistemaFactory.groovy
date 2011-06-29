package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.factory

import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*

/**
 * Factoria de la clase sistema.
 *
 */
class SistemaFactory {
	
	/**
	 * Metodo que va a crear un sistema.
	 */
	def creaSistema(valores,identificadorProyecto){
	
		def sistemaInstance = new Sistema(valores)
		def proyecto = Proyecto.get(identificadorProyecto)
		proyecto.getDiseno().addToSistemas(sistemaInstance)
		
		return sistemaInstance
	}
}
