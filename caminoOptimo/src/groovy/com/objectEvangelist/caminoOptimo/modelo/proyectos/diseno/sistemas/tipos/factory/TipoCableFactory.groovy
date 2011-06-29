package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.factory


import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*

/**
 * Factoria que va a crear un nuevo tipo de cable.
 *
 */
class TipoCableFactory {

	/**
	 * Metodo que va crear una nueva instancia del tipo de cable.
	 */
	def creaTipoCable(valores,identificadorProyecto){
		def tipoCableInstance = new TipoCable(valores)
		
		def proyecto = Proyecto.get(identificadorProyecto)
		proyecto.getDiseno().addToTiposCable(tipoCableInstance)
		
		return tipoCableInstance
	}	
}
