package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno.topologia.tipos


import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.TipoBandeja;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.*

class TipoBandejaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	/**
	 * La factory para crear los tipos de bandeja.
	 */
	def tipoBandejaFactory
	
    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
		def tipoBandejaInstanceList = TipoBandeja.findAllByDiseno(proyecto.getDiseno())
			
	    [tipoBandejaInstanceList: tipoBandejaInstanceList, tipoBandejaInstanceTotal: tipoBandejaInstanceList.size()]
    }

    def create = {
        def tipoBandejaInstance = new TipoBandeja()
        tipoBandejaInstance.properties = params
        return [tipoBandejaInstance: tipoBandejaInstance]
    }

    def save = {
		
        def tipoBandejaInstance = tipoBandejaFactory.creaTipoBandeja(params,session.getAttribute('identificadorProyecto')) 
					
        if (tipoBandejaInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'tipoBandeja.label', default: 'TipoBandeja'), tipoBandejaInstance.id])}"
            redirect(action: "show", id: tipoBandejaInstance.id)
        }
        else {
            render(view: "create", model: [tipoBandejaInstance: tipoBandejaInstance])
        }
    }

    def show = {
        def tipoBandejaInstance = TipoBandeja.get(params.id)
        if (!tipoBandejaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoBandeja.label', default: 'TipoBandeja'), params.id])}"
            redirect(action: "list")
        }
        else {
            [tipoBandejaInstance: tipoBandejaInstance]
        }
    }

    def edit = {
        def tipoBandejaInstance = TipoBandeja.get(params.id)
        if (!tipoBandejaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoBandeja.label', default: 'TipoBandeja'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [tipoBandejaInstance: tipoBandejaInstance]
        }
    }

    def update = {
        def tipoBandejaInstance = TipoBandeja.get(params.id)
        if (tipoBandejaInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (tipoBandejaInstance.version > version) {
                    
                    tipoBandejaInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'tipoBandeja.label', default: 'TipoBandeja')] as Object[], "Another user has updated this TipoBandeja while you were editing")
                    render(view: "edit", model: [tipoBandejaInstance: tipoBandejaInstance])
                    return
                }
            }
            tipoBandejaInstance.properties = params
            if (!tipoBandejaInstance.hasErrors() && tipoBandejaInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'tipoBandeja.label', default: 'TipoBandeja'), tipoBandejaInstance.id])}"
                redirect(action: "show", id: tipoBandejaInstance.id)
            }
            else {
                render(view: "edit", model: [tipoBandejaInstance: tipoBandejaInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoBandeja.label', default: 'TipoBandeja'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def tipoBandejaInstance = TipoBandeja.get(params.id)
        if (tipoBandejaInstance) {
            try {
                tipoBandejaInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'tipoBandeja.label', default: 'TipoBandeja'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'tipoBandeja.label', default: 'TipoBandeja'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoBandeja.label', default: 'TipoBandeja'), params.id])}"
            redirect(action: "list")
        }
    }
}
