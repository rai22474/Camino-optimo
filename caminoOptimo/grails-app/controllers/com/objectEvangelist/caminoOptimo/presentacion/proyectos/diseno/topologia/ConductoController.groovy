package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno.topologia


import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.TipoConducto;

class ConductoController {

	/**
	 * Factoria de conductos.
	 */
	def conductoFactory
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
		def conductoInstanceList = Conducto.findAllByDiseno(proyecto.getDiseno(),params)
			
        [conductoInstanceList: conductoInstanceList, conductoInstanceTotal: Conducto.countByDiseno(proyecto.getDiseno())]
    }

	
    def create = {
     	
		def conductoInstance = new Conducto()
        conductoInstance.properties = params
		
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
		def tiposRed = proyecto.getDiseno().getTiposRed()
		def tiposConducto = TipoConducto.findAllByDiseno(proyecto.getDiseno())
			
        return [conductoInstance: conductoInstance,tiposRed:tiposRed,tiposConducto:tiposConducto]
    }

    def save = {
	     def conductoInstance = conductoFactory.creaConducto(params,
			                                                session.getAttribute('identificadorProyecto'))
		if (conductoInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'conducto.label', default: 'Conducto'), conductoInstance.id])}"
            redirect(action: "show", id: conductoInstance.id)
        }
        else {
	       render(view: "create", model: [conductoInstance: conductoInstance])
        }
    }

    def show = {
        def conductoInstance = Conducto.get(params.id)
        if (!conductoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'conducto.label', default: 'Conducto'), params.id])}"
            redirect(action: "list")
        }
        else {
            [conductoInstance: conductoInstance]
        }
    }

    def edit = {
        def conductoInstance = Conducto.get(params.id)
        if (!conductoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'conducto.label', default: 'Conducto'), params.id])}"
            redirect(action: "list")
        }
        else {
			def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))			
			def tiposRed = proyecto.getDiseno().getTiposRed()
			def tiposConducto = TipoConducto.findAllByDiseno(proyecto.getDiseno())
		
			return [conductoInstance: conductoInstance,tiposRed:tiposRed,tiposConducto:tiposConducto]
        }
    }

    def update = {
        def conductoInstance = Conducto.get(params.id)
        if (conductoInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (conductoInstance.version > version) {
                    
                    conductoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'conducto.label', default: 'Conducto')] as Object[], "Another user has updated this Conducto while you were editing")
                    render(view: "edit", model: [conductoInstance: conductoInstance])
                    return
                }
            }
            conductoInstance.properties = params
            if (!conductoInstance.hasErrors() && conductoInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'conducto.label', default: 'Conducto'), conductoInstance.id])}"
                redirect(action: "show", id: conductoInstance.id)
            }
            else {
                render(view: "edit", model: [conductoInstance: conductoInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'conducto.label', default: 'Conducto'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def conductoInstance = Conducto.get(params.id)
        if (conductoInstance) {
            try {
                conductoInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'conducto.label', default: 'Conducto'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'conducto.label', default: 'Conducto'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'conducto.label', default: 'Conducto'), params.id])}"
            redirect(action: "list")
        }
    }
}
