package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno.sistemas.tipos



import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoRed
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.tiposElementos.*


class TipoRedController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	/**
	 * La factoria de los tipos de red.
	 */
	def tipoRedFactory
	
    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)		
		
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))				
		def tipoRedInstanceList = TipoRed.findAllByDiseno(proyecto.getDiseno(),params)
		
        [tipoRedInstanceList:tipoRedInstanceList , tipoRedInstanceTotal: TipoRed.countByDiseno(proyecto.getDiseno())]
    }

    def create = {
        def tipoRedInstance = new TipoRed()
        tipoRedInstance.properties = params
        return [tipoRedInstance: tipoRedInstance]
    }

    def save = {
        def tipoRedInstance = tipoRedFactory.creaTipoRed(params,
			session.getAttribute('identificadorProyecto'))
		
        if (tipoRedInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'tipoRed.label', default: 'TipoRed'), tipoRedInstance.id])}"
            redirect(action: "show", id: tipoRedInstance.id)
        }
        else {
            render(view: "create", model: [tipoRedInstance: tipoRedInstance])
        }
    }

    def show = {
        def tipoRedInstance = TipoRed.get(params.id)
        if (!tipoRedInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoRed.label', default: 'TipoRed'), params.id])}"
            redirect(action: "list")
        }
        else {
            [tipoRedInstance: tipoRedInstance]
        }
    }

    def edit = {
        def tipoRedInstance = TipoRed.get(params.id)
        if (!tipoRedInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoRed.label', default: 'TipoRed'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [tipoRedInstance: tipoRedInstance]
        }
    }

    def update = {
        def tipoRedInstance = TipoRed.get(params.id)
        if (tipoRedInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (tipoRedInstance.version > version) {
                    
                    tipoRedInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'tipoRed.label', default: 'TipoRed')] as Object[], "Another user has updated this TipoRed while you were editing")
                    render(view: "edit", model: [tipoRedInstance: tipoRedInstance])
                    return
                }
            }
            tipoRedInstance.properties = params
            if (!tipoRedInstance.hasErrors() && tipoRedInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'tipoRed.label', default: 'TipoRed'), tipoRedInstance.id])}"
                redirect(action: "show", id: tipoRedInstance.id)
            }
            else {
                render(view: "edit", model: [tipoRedInstance: tipoRedInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoRed.label', default: 'TipoRed'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def tipoRedInstance = TipoRed.get(params.id)
        if (tipoRedInstance) {
            try {
                tipoRedInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'tipoRed.label', default: 'TipoRed'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'tipoRed.label', default: 'TipoRed'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoRed.label', default: 'TipoRed'), params.id])}"
            redirect(action: "list")
        }
    }
}
