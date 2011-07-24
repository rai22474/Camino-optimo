package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno.topologia


import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.TipoBandeja;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto

/**
 * Controlador que genera con la trabaja con la visualizacion de bandejas.
 *
 */
class BandejaController {

	/**
	 * Factoria de bandejas se resuelve por inyeccion de dependencias.
	 */
	def bandejaFactory
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
		def bandejaInstanceList = Bandeja.findAllByDiseno(proyecto.getDiseno())
	
        [bandejaInstanceList: bandejaInstanceList, bandejaInstanceTotal: bandejaInstanceList.size()]
    }

    def create = {
        def bandejaInstance = new Bandeja() 
        bandejaInstance.properties = params
		
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))		
		def tiposRed = proyecto.getDiseno().getTiposRed()
		def tiposBandeja = TipoBandeja.findAllByDiseno(proyecto.getDiseno())
		
        return [bandejaInstance: bandejaInstance,tiposRed:tiposRed,tiposBandeja:tiposBandeja]
    }

    def save = {
        def bandejaInstance = bandejaFactory.creaBandeja(params,
			session.getAttribute('identificadorProyecto')) 		
	
        if (bandejaInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'bandeja.label', default: 'Bandeja'), bandejaInstance.id])}"
            redirect(action: "show", id: bandejaInstance.id)
        }
        else {
            render(view: "create", model: [bandejaInstance: bandejaInstance])
        }
    }

    def show = {
        def bandejaInstance = Bandeja.get(params.id)
        if (!bandejaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bandeja.label', default: 'Bandeja'), params.id])}"
            redirect(action: "list")
        }
        else {
            [bandejaInstance: bandejaInstance]
        }
    }

    def edit = {
        def bandejaInstance = Bandeja.get(params.id)
        if (!bandejaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bandeja.label', default: 'Bandeja'), params.id])}"
            redirect(action: "list")
        }
        else {
			def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
			def tiposRed = proyecto.getDiseno().getTiposRed()
			def tiposBandeja = TipoBandeja.findAllByDiseno(proyecto.getDiseno())
			
            return [bandejaInstance: bandejaInstance,tiposRed:tiposRed, tiposBandeja:tiposBandeja]
        }
    }

    def update = {
        def bandejaInstance = Bandeja.get(params.id)
        if (bandejaInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (bandejaInstance.version > version) {
                    
                    bandejaInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'bandeja.label', default: 'Bandeja')] as Object[], "Another user has updated this Bandeja while you were editing")
                    render(view: "edit", model: [bandejaInstance: bandejaInstance])
                    return
                }
            }
            bandejaInstance.properties = params
            if (!bandejaInstance.hasErrors() && bandejaInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'bandeja.label', default: 'Bandeja'), bandejaInstance.id])}"
                redirect(action: "show", id: bandejaInstance.id)
            }
            else {
                render(view: "edit", model: [bandejaInstance: bandejaInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bandeja.label', default: 'Bandeja'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def bandejaInstance = Bandeja.get(params.id)
        if (bandejaInstance) {
            try {
                bandejaInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'bandeja.label', default: 'Bandeja'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'bandeja.label', default: 'Bandeja'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bandeja.label', default: 'Bandeja'), params.id])}"
            redirect(action: "list")
        }
    }
}
