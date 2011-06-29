package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.factory

import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*

/**
 * Factoria de los objetos que son un tipo de red.
 *
 */
class TipoRedFactory {

	/**
	 * Metodo que crea un nuevo tipo de red para un proyecto concreto.
	 */
	def creaTipoRed(valores,identificadorProyecto){
		def tipoRedInstance = new TipoRed(valores)
		def proyecto = Proyecto.get(identificadorProyecto)
		proyecto.getDiseno().addToTiposRed(tipoRedInstance)
		
		return tipoRedInstance
	}
}
