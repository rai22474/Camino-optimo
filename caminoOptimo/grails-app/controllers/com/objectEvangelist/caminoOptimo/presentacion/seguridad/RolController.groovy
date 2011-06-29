package com.objectEvangelist.caminoOptimo.presentacion.seguridad

import com.objectEvangelist.caminoOptimo.seguridad.*

class RolController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [rolInstanceList: Rol.list(params), rolInstanceTotal: Rol.count()]
    }

    def create = {
        def rolInstance = new Rol()
        rolInstance.properties = params
        return [rolInstance: rolInstance]
    }

    def save = {
        def rolInstance = new Rol(params)
        if (rolInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'rol.label', default: 'Rol'), rolInstance.id])}"
            redirect(action: "show", id: rolInstance.id)
        }
        else {
            render(view: "create", model: [rolInstance: rolInstance])
        }
    }

    def show = {
        def rolInstance = Rol.get(params.id)
        if (!rolInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rol.label', default: 'Rol'), params.id])}"
            redirect(action: "list")
        }
        else {
            [rolInstance: rolInstance]
        }
    }

    def edit = {
        def rolInstance = Rol.get(params.id)
        if (!rolInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rol.label', default: 'Rol'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [rolInstance: rolInstance]
        }
    }

    def update = {
        def rolInstance = Rol.get(params.id)
        if (rolInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (rolInstance.version > version) {
                    
                    rolInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'rol.label', default: 'Rol')] as Object[], "Another user has updated this Rol while you were editing")
                    render(view: "edit", model: [rolInstance: rolInstance])
                    return
                }
            }
            rolInstance.properties = params
            if (!rolInstance.hasErrors() && rolInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'rol.label', default: 'Rol'), rolInstance.id])}"
                redirect(action: "show", id: rolInstance.id)
            }
            else {
                render(view: "edit", model: [rolInstance: rolInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rol.label', default: 'Rol'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def rolInstance = Rol.get(params.id)
        if (rolInstance) {
            try {
                rolInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'rol.label', default: 'Rol'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'rol.label', default: 'Rol'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rol.label', default: 'Rol'), params.id])}"
            redirect(action: "list")
        }
    }
}
