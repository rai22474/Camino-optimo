package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno

import com.objectEvangelist.caminoOptimo.modelo.proyectos.*;

/**
 * Clase encargarda de llevar el flujo del diseño de proyecto.
 *
 */
class DisenoController {

	def index = {
        redirect(action: "proyectosCurso")
    }
	
	def proyectosCurso = {
		redirect(controller: 'proyecto', action:'list')
    }
	
	def disenoProyecto = {		
		render(view: "disenoProyecto")
	}
	 
}
