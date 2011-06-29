package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno.sistemas.tipos


import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoCable
import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.tiposElementos.*

class TipoCableController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	/**
	 * Factoria de los tipos de cable.
	 */
	def tipoCableFactory
	
    def index = {
        //redirect(action: "list", params: params)
		
		TipoCable.enableHibernateFilter('numeroPuntasParam').setParameter('numeropuntas', 2)
				
		render (view:'index', model:[members:TipoCable.list()])
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
		def tipoCableInstanceList = proyecto.getDiseno().getTiposCable()
		
		[tipoCableInstanceList:tipoCableInstanceList, tipoCableInstanceTotal: tipoCableInstanceList.size()]
    }

    def create = {
        def tipoCableInstance = new TipoCable()
        tipoCableInstance.properties = params
        return [tipoCableInstance: tipoCableInstance]
    }

    def save = {
        def tipoCableInstance = tipoCableFactory.creaTipoCable(params,
			session.getAttribute('identificadorProyecto'))
						
        if (tipoCableInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'tipoCable.label', default: 'TipoCable'), tipoCableInstance.id])}"
            redirect(action: "show", id: tipoCableInstance.id)
        }
        else {
            render(view: "create", model: [tipoCableInstance: tipoCableInstance])
        }
    }

    def show = {
        def tipoCableInstance = TipoCable.get(params.id)
        if (!tipoCableInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoCable.label', default: 'TipoCable'), params.id])}"
            redirect(action: "list")
        }
        else {
            [tipoCableInstance: tipoCableInstance]
        }
    }

    def edit = {
        def tipoCableInstance = TipoCable.get(params.id)
        if (!tipoCableInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoCable.label', default: 'TipoCable'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [tipoCableInstance: tipoCableInstance]
        }
    }

    def update = {
        def tipoCableInstance = TipoCable.get(params.id)
        if (tipoCableInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (tipoCableInstance.version > version) {
                    
                    tipoCableInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'tipoCable.label', default: 'TipoCable')] as Object[], "Another user has updated this TipoCable while you were editing")
                    render(view: "edit", model: [tipoCableInstance: tipoCableInstance])
                    return
                }
            }
            tipoCableInstance.properties = params
            if (!tipoCableInstance.hasErrors() && tipoCableInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'tipoCable.label', default: 'TipoCable'), tipoCableInstance.id])}"
                redirect(action: "show", id: tipoCableInstance.id)
            }
            else {
                render(view: "edit", model: [tipoCableInstance: tipoCableInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoCable.label', default: 'TipoCable'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def tipoCableInstance = TipoCable.get(params.id)
        if (tipoCableInstance) {
            try {
                tipoCableInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'tipoCable.label', default: 'TipoCable'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'tipoCable.label', default: 'TipoCable'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tipoCable.label', default: 'TipoCable'), params.id])}"
            redirect(action: "list")
        }
    }
}
