package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.factory

import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Equipo
/**
 * Factoria para la creación de equipos.
 *
 */
class EquipoFactory {

	
	/**
	 * Metodo encargado de crear el equipo
	 */
	def creaEquipo(valores,identificadorProyecto){
		
		def equipo = new Equipo(valores)
		def proyecto = Proyecto.get(identificadorProyecto)
		
		equipo.setDiseno(proyecto.getDiseno())
		
		return equipo
	}
}
