package com.objectEvangelist.caminoOptimo.seguridad


class Rol {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
