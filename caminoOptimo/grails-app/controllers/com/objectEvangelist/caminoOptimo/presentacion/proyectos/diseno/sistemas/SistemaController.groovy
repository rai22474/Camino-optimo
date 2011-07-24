package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno.sistemas

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto

class SistemaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	/**
	 * Factoria para los sistema.
	 */
	def sistemaFactory
	
    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
       
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
		def sistemaInstanceList = proyecto.getDiseno().getSistemas()
		
		[sistemaInstanceList: sistemaInstanceList, sistemaInstanceTotal: sistemaInstanceList.size()]
    }

    def create = {
        def sistemaInstance = new Sistema()
        sistemaInstance.properties = params
        
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
				
		return [sistemaInstance: sistemaInstance,tiposRed:proyecto.getDiseno().getTiposRed()]
    }

    def save = {
        def sistemaInstance = sistemaFactory.creaSistema(params,
			                                             session.getAttribute('identificadorProyecto'))
		
        if (sistemaInstance.save(flush: true)) {						
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'sistema.label', default: 'Sistema'), sistemaInstance.id])}"
            redirect(action: "show", id: sistemaInstance.id)
        }
        else {
            render(view: "create", model: [sistemaInstance: sistemaInstance])
        }
    }

    def show = {
        def sistemaInstance = Sistema.get(params.id)
        if (!sistemaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'sistema.label', default: 'Sistema'), params.id])}"
            redirect(action: "list")
        }
        else {
            [sistemaInstance: sistemaInstance]
        }
    }

    def edit = {
        def sistemaInstance = Sistema.get(params.id)
        if (!sistemaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'sistema.label', default: 'Sistema'), params.id])}"
            redirect(action: "list")
        }
        else {
			def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
			
            return [sistemaInstance: sistemaInstance,tiposRed:proyecto.getDiseno().getTiposRed()]
        }
    }

    def update = {
        def sistemaInstance = Sistema.get(params.id)
        if (sistemaInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (sistemaInstance.version > version) {
                    
                    sistemaInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'sistema.label', default: 'Sistema')] as Object[], "Another user has updated this Sistema while you were editing")
                    render(view: "edit", model: [sistemaInstance: sistemaInstance])
                    return
                }
            }
            sistemaInstance.properties = params
            if (!sistemaInstance.hasErrors() && sistemaInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'sistema.label', default: 'Sistema'), sistemaInstance.id])}"
                redirect(action: "show", id: sistemaInstance.id)
            }
            else {
                render(view: "edit", model: [sistemaInstance: sistemaInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'sistema.label', default: 'Sistema'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def sistemaInstance = Sistema.get(params.id)
        if (sistemaInstance) {
            try {
                sistemaInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'sistema.label', default: 'Sistema'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'sistema.label', default: 'Sistema'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'sistema.label', default: 'Sistema'), params.id])}"
            redirect(action: "list")
        }
    }
}
