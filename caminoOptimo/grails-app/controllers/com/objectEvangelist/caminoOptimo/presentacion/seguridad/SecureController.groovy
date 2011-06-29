package com.objectEvangelist.caminoOptimo.presentacion.seguridad

import grails.plugins.springsecurity.Secured

class SecureController {

	@Secured(['ROLE_ADMIN'])
    def index = { 
		render 'Secure access only'
	}
}
