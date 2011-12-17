package com.objectEvangelist.caminoOptimo.presentacion.proyectos

import com.objectEvangelist.caminoOptimo.modelo.proyectos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoCable
import com.objectEvangelist.caminoOptimo.presentacion.crud.SingleEntityManagementController;

import grails.plugins.springsecurity.*

/**
 * Controlador de proyectos.
 */
@Secured(['ROLE_ADMIN'])
class ProyectoController extends SingleEntityManagementController {

	/**
	 * Returns the entity class name.
	 * @return the string with the name of the entity.
	 */
	def protected String getEntityName(){
		return "proyecto"
	}

	/**
	 * Return the class entity.
	 * @return The class for entity.
	 */
	def protected getEntityClass(){
		return Proyecto
	}

	/**
	 * Create a new instance of this entity.
	 * @return the new instance.
	 */
	def protected createEntityInstance(){
		return new Proyecto()
	}

	/**
	 * Create a entity instance with parameters.
	 * @param params the parameters of the entity.
	 * @return the new instance.
	 */
	def protected createEntityInstance(params){
		return new Proyecto(params)
	}


	/**
	 * The design of the project.
	 */
	def disenoProyecto = {
		def proyectoInstance = Proyecto.get(params.id)
		if (!proyectoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'proyecto.label', default: 'Proyecto'), params.id])}"
			redirect(action: "list")
		}
		else {
			session.putAt('identificadorProyecto',params.id)
			render(view: "/diseno/disenoProyecto", model: [proyectoInstance: proyectoInstance]);
		}
	}
}
