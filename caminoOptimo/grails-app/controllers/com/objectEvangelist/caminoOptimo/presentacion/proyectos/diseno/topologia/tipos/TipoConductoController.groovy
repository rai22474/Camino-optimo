package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno.topologia.tipos


import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.TipoConducto;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.*

class TipoConductoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	/**
	 * La factoria de los tipos de conductos.
	 */
	def tipoConductoFactory
	
    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
		def tipoConductoInstanceList = TipoConducto.findAllByDiseno(proyecto.getDiseno(),params)
				
		[tipoConductoInstanceList: tipoConductoInstanceList, tipoConductoInstanceTotal: TipoConducto.countByDiseno(proyecto.getDiseno())]
    }

    def create = {
        def tipoConductoInstance = new TipoConducto()
        tipoConductoInstance.properties = params
        return [tipoConductoInstance: tipoConductoInstance]
    }

    def save = {
        def tipoConductoInstance = tipoConductoFactory.creaTipoConducto(params,
																		session.getAttribute('identificadorProyecto'))
		
        if (tipoConductoInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'tipoConducto.label', default: 'TipoConducto'), tipoConductoInstance.id])}"
            redirect(action: "show", id: tipoConductoInstance.id)
        }
        else {
            render(view: "create", model: [tipoConductoInstance: tipoConductoInstance])
        }
    }

    def show = {
        def tipoConductoInstance = TipoConducto.get(params.id)
        if (!tipoConductoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoConducto.label', default: 'TipoConducto'), params.id])}"
            redirect(action: "list")
        }
        else {
            [tipoConductoInstance: tipoConductoInstance]
        }
    }

    def edit = {
        def tipoConductoInstance = TipoConducto.get(params.id)
        if (!tipoConductoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoConducto.label', default: 'TipoConducto'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [tipoConductoInstance: tipoConductoInstance]
        }
    }

    def update = {
        def tipoConductoInstance = TipoConducto.get(params.id)
        if (tipoConductoInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (tipoConductoInstance.version > version) {
                    
                    tipoConductoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'tipoConducto.label', default: 'TipoConducto')] as Object[], "Another user has updated this TipoConducto while you were editing")
                    render(view: "edit", model: [tipoConductoInstance: tipoConductoInstance])
                    return
                }
            }
            tipoConductoInstance.properties = params
            if (!tipoConductoInstance.hasErrors() && tipoConductoInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'tipoConducto.label', default: 'TipoConducto'), tipoConductoInstance.id])}"
                redirect(action: "show", id: tipoConductoInstance.id)
            }
            else {
                render(view: "edit", model: [tipoConductoInstance: tipoConductoInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoConducto.label', default: 'TipoConducto'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def tipoConductoInstance = TipoConducto.get(params.id)
        if (tipoConductoInstance) {
            try {
                tipoConductoInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'tipoConducto.label', default: 'TipoConducto'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'tipoConducto.label', default: 'TipoConducto'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoConducto.label', default: 'TipoConducto'), params.id])}"
            redirect(action: "list")
        }
    }
}
