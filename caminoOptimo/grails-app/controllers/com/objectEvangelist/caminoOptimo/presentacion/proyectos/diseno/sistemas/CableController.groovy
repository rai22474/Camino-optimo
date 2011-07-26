package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno.sistemas

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto


class CableController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
		def sistemas = Sistema.findAllByDiseno(proyecto.getDiseno())
		
        [cableInstanceList: Cable.findAllBySistemaInList(sistemas,params),
			cableInstanceTotal:(sistemas.size() != 0?Cable.countBySistemaInList(sistemas):0)]
    }

    def create = {
        def cableInstance = new Cable()
        cableInstance.properties = params		
	    return [cableInstance: cableInstance]
    }

    def save = {
        def cableInstance = new Cable(params)
        if (cableInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'cable.label', default: 'Cable'), cableInstance.id])}"
            redirect(action: "show", id: cableInstance.id)
        }
        else {
            render(view: "create", model: [cableInstance: cableInstance])
        }
    }

    def show = {
        def cableInstance = Cable.get(params.id)
        if (!cableInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cable.label', default: 'Cable'), params.id])}"
            redirect(action: "list")
        }
        else {
            [cableInstance: cableInstance]
        }
    }

    
    def edit = {
        def cableInstance = Cable.get(params.id)
        if (!cableInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cable.label', default: 'Cable'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [cableInstance: cableInstance]
        }
    }

    def update = {
        def cableInstance = Cable.get(params.id)
        if (cableInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (cableInstance.version > version) {
                    
                    cableInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'cable.label', default: 'Cable')] as Object[], "Another user has updated this Cable while you were editing")
                    render(view: "edit", model: [cableInstance: cableInstance])
                    return
                }
            }
            cableInstance.properties = params
            if (!cableInstance.hasErrors() && cableInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'cable.label', default: 'Cable'), cableInstance.id])}"
                redirect(action: "show", id: cableInstance.id)
            }
            else {
                render(view: "edit", model: [cableInstance: cableInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cable.label', default: 'Cable'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def cableInstance = Cable.get(params.id)
        if (cableInstance) {
            try {
                cableInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'cable.label', default: 'Cable'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'cable.label', default: 'Cable'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cable.label', default: 'Cable'), params.id])}"
            redirect(action: "list")
        }
    }
	
	def editarRuta = {
		def cableInstance = Cable.get(params.id)

		if (!cableInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cable.label', default: 'Cable'), params.id])}"
            redirect(action: "list")
        }
        else {
			
			def rutas = cableInstance.calculaRutasPosibles()	
			render(view: "editarRuta", model: [cableInstance: cableInstance,rutas:rutas])
        }
	}
	
	def salvarRuta = {
    	def cableInstance = Cable.get(params.id)   	
		def rutasPosibles = cableInstance.calculaRutasPosibles()
		int posicion = new Integer(params.numeroRuta)
		
		cableInstance.modificaRuta(rutasPosibles[posicion])
		cableInstance.save()			
		redirect(action: "show", id: params.id)
	}
	
	def visualizarRuta = {
	
		def cableInstance = Cable.get(params.identificadorCable)		
		
		if (!cableInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cable.label', default: 'Cable'), params.id])}"
			redirect(action: "list")
		}
		else {
		
			def rutasPosibles = cableInstance.calculaRutasPosibles()			
			int posicion = new Integer(params.numeroRuta)		
			return [cableInstance:cableInstance,
					ruta:rutasPosibles[posicion],
					numeroRuta:params.numeroRuta]
		}
	}
}
