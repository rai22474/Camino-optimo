package com.objectEvangelist.caminoOptimo.presentacion.crud

/** 
 * Generic class that is the parent of all controller.
 */
abstract class SingleEntityManagementController {

	// the delete, save and update actions only accept POST requests
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index = {
		redirect(action: "list", params: params)
	}

	def list = {
		params.max = Math.min(params.max ? params.max.toInteger() : 10,  100)

		[entityInstanceList: getEntityClass().list(params), entityInstanceTotal:getEntityClass().count()]
	}

	def create = {
		def entityInstance = createEntityInstance()
		entityInstance.properties = params
		return [entityInstance: entityInstance]
	}

	def save = {
		def entityInstance = createEntityInstance(params)
		if (!entityInstance.hasErrors() && entityInstance.save()) {
			
			flash.message = getEntityName() + ".created"
			flash.args = [entityInstance.id]
			flash.defaultMessage = getEntityName() + " ${entityInstance.id} created"
			redirect(action: "list")
		}
		else {
			render(view: "create", model: [entityInstance: entityInstance])
		}
	}

	def show = {

		def selectedIdentifiers = getSelectedIdentifiers(params);
		def entityInstance =  getEntityClass().get(selectedIdentifiers[0])
		if (!entityInstance) {
			flash.message = getEntityName() +".not.found"
			flash.args = [params.id]
			flash.defaultMessage = getEntityName() + " not found with id ${params.id}"
			redirect(action: "list")
		}
		else {
			return [entityInstance: entityInstance]
		}
	}

	def edit = {
		def selectedIdentifiers = getSelectedIdentifiers(params);
		def entityInstance = getEntityClass().get(selectedIdentifiers[0])
		if (!entityInstance) {
			flash.message = getEntityName() + ".not.found"
			flash.args = [params.id]
			flash.defaultMessage = getEntityName() + " not found with id ${params.id}"
			redirect(action: "list")
		}
		else {
			return [entityInstance: entityInstance]
		}
	}

	def update = {
		def entityInstance = getEntityClass().get(params.id)
		if (entityInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (entityInstance.version > version) {

					entityInstance.errors.rejectValue("version", getEntityName() +".optimistic.locking.failure", "Another entity has updated this Entity while you were editing")
					render(view: "edit", model: [entityInstance: entityInstance])
					return
				}
			}
			entityInstance.properties = params
			if (!entityInstance.hasErrors() && entityInstance.save()) {
				flash.message = getEntityName() + ".updated"
				flash.args = [params.id]
				flash.defaultMessage = getEntityName() + " ${params.id} updated"
				redirect(action: "list")
			}
			else {
				render(view: "edit", model: [entityInstance: entityInstance])
			}
		}
		else {
			flash.message = getEntityName() + ".not.found"
			flash.args = [params.id]
			flash.defaultMessage = getEntityName() + " not found with id ${params.id}"
			redirect(action: "edit", id: params.id)
		}
	}


	def delete = {
		def selectedIdentifiers = getSelectedIdentifiers(params);
		def entityInstance = getEntityClass().get(selectedIdentifiers[0])
		if (entityInstance) {
			try {
				entityInstance.delete()
				flash.message = getEntityName() + ".deleted"
				flash.args = [params.id]
				flash.defaultMessage = getEntityName() + " ${params.id} deleted"
				redirect(action: "list")
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = getEntityName() + ".not.deleted"
				flash.args = [params.id]
				flash.defaultMessage = getEntityName() + " ${params.id} could not be deleted"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = getEntityName() + ".not.found"
			flash.args = [params.id]
			flash.defaultMessage = getEntityName() + " not found with id ${params.id}"
			redirect(action: "list")
		}
	}

	/**
	 * Returns the entity class name.
	 * @return the string with the name of the entity.
	 */
	def abstract protected String getEntityName();

	/**
	 * Return the class entity.
	 * @return The class for entity.
	 */
	def abstract protected getEntityClass();

	/**
	 * Create a new instance of this entity.
	 * @return the new instance.
	 */
	def abstract protected createEntityInstance();
		
	/**
	 * Create a entity instance with parameters.
	 * @param params the parameters of the entity.
	 * @return the 
	 */
	def abstract protected createEntityInstance(params);
	
	/**
	 * @param params
	 * @return
	 */
	def private getSelectedIdentifiers(params){
		def selectedIdentifiers = []
		def identifiers = params.identifier

		for (int i = 0;i<identifiers.size();i++){
			if (params.getAt(identifiers[i]) != null){
				selectedIdentifiers.add(identifiers[i])
			}
		}

		return selectedIdentifiers
	}
}
