package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.factory

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.*

/**
 * La factoria de tipos de bandaja
 *
 */
class TipoConductoFactory {

	/**
	 * Metodo que crea un nuevo tipo de bandeja.
	 */
	def creaTipoConducto(valores,identificadorProyecto){
		
		def tipoConducto = new TipoConducto(valores)
		
		def proyecto = Proyecto.get(identificadorProyecto)
		proyecto.getDiseno().agregaTipoCanal(tipoConducto)
	
		return tipoConducto
	}
}
