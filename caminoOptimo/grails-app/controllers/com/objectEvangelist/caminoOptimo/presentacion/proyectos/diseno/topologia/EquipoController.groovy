package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno.topologia

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Equipo
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.equipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto


class EquipoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	/**
	 * La factoria para crear el equipo
	 */
	def equipoFactory
	
	
    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))		
		def equipoInstanceList = Equipo.findAllByDiseno(proyecto.getDiseno()) 
							
        [equipoInstanceList: equipoInstanceList, equipoInstanceTotal: equipoInstanceList.size()]
    }

    def create = {
        def equipoInstance = new Equipo()
        equipoInstance.properties = params
        return [equipoInstance: equipoInstance]
    }

    def save = {
        def equipoInstance = equipoFactory.creaEquipo(params,session.getAttribute('identificadorProyecto')) 
							
        if (equipoInstance.save(flush: true)) {			
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'equipo.label', default: 'Equipo'), equipoInstance.id])}"
            redirect(action: "show", id: equipoInstance.id)
        }
        else {
            render(view: "create", model: [equipoInstance: equipoInstance])
        }
    }

    def show = {
        def equipoInstance = Equipo.get(params.id)
        if (!equipoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'equipo.label', default: 'Equipo'), params.id])}"
            redirect(action: "list")
        }
        else {
            [equipoInstance: equipoInstance]
        }
    }

    def edit = {
        def equipoInstance = Equipo.get(params.id)
        if (!equipoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'equipo.label', default: 'Equipo'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [equipoInstance: equipoInstance]
        }
    }

    def update = {
        def equipoInstance = Equipo.get(params.id)
        if (equipoInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (equipoInstance.version > version) {
                    
                    equipoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'equipo.label', default: 'Equipo')] as Object[], "Another user has updated this Equipo while you were editing")
                    render(view: "edit", model: [equipoInstance: equipoInstance])
                    return
                }
            }
            equipoInstance.properties = params
            if (!equipoInstance.hasErrors() && equipoInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'equipo.label', default: 'Equipo'), equipoInstance.id])}"
                redirect(action: "show", id: equipoInstance.id)
            }
            else {
                render(view: "edit", model: [equipoInstance: equipoInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'equipo.label', default: 'Equipo'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def equipoInstance = Equipo.get(params.id)
        if (equipoInstance) {
            try {
                equipoInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'equipo.label', default: 'Equipo'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'equipo.label', default: 'Equipo'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'equipo.label', default: 'Equipo'), params.id])}"
            redirect(action: "list")
        }
    }
}
