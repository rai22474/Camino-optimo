package com.objectEvangelist.caminoOptimo.presentacion.seguridad

import com.objectEvangelist.caminoOptimo.seguridad.*

class UsuarioRolController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [usuarioRolInstanceList: UsuarioRol.list(params), usuarioRolInstanceTotal: UsuarioRol.count()]
    }

    def create = {
        def usuarioRolInstance = new UsuarioRol()
        usuarioRolInstance.properties = params
        return [usuarioRolInstance: usuarioRolInstance]
    }

    def save = {
        def usuarioRolInstance = new UsuarioRol(params)
        if (usuarioRolInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), usuarioRolInstance.id])}"
            redirect(action: "show", id: usuarioRolInstance.id)
        }
        else {
            render(view: "create", model: [usuarioRolInstance: usuarioRolInstance])
        }
    }

    def show = {
        def usuarioRolInstance = UsuarioRol.get(params.id)
        if (!usuarioRolInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), params.id])}"
            redirect(action: "list")
        }
        else {
            [usuarioRolInstance: usuarioRolInstance]
        }
    }

    def edit = {
        def usuarioRolInstance = UsuarioRol.get(params.id)
        if (!usuarioRolInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [usuarioRolInstance: usuarioRolInstance]
        }
    }

    def update = {
        def usuarioRolInstance = UsuarioRol.get(params.id)
        if (usuarioRolInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (usuarioRolInstance.version > version) {
                    
                    usuarioRolInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'usuarioRol.label', default: 'UsuarioRol')] as Object[], "Another user has updated this UsuarioRol while you were editing")
                    render(view: "edit", model: [usuarioRolInstance: usuarioRolInstance])
                    return
                }
            }
            usuarioRolInstance.properties = params
            if (!usuarioRolInstance.hasErrors() && usuarioRolInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), usuarioRolInstance.id])}"
                redirect(action: "show", id: usuarioRolInstance.id)
            }
            else {
                render(view: "edit", model: [usuarioRolInstance: usuarioRolInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def usuarioRolInstance = UsuarioRol.get(params.id)
        if (usuarioRolInstance) {
            try {
                usuarioRolInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), params.id])}"
            redirect(action: "list")
        }
    }
}
