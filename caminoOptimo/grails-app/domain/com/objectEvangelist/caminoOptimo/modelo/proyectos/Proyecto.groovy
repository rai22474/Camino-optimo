package com.objectEvangelist.caminoOptimo.modelo.proyectos

import  com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.*

/**
 * Clase que representa un proyecto de cableado.
 *
 */
class Proyecto implements Serializable {

    /**
     * Las restricciones del bean.
     */
    static constraints = {
		codigo(blank:false,unique:true,size:3..20)
		descripcion(blank:false)
		diseno(nullable:true)		
    }
			
	/**
	 * Cada proyecto tiene un diseno asociado.
	 */
	Diseno diseno = new Diseno()

	/**
	 * El codigo del proyecto. Va a ser unico para todos los proyectos.
	 */
	String codigo
	
	/**
	 * La descripcion de proyecto.
	 */
	String descripcion
	
		
	@Override
	def String toString(){
		return "$codigo"
	}
		
	@Override
	public int hashCode() {
		final prime = 31
		result = 1
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode())
		return result;
	}
	
	@Override
	public boolean equals(Object other) {
		
		if (other == null) {
			return false
		}
		
		if (!(other instanceof Proyecto)) {
			return false
		}
		
		if (codigo == null) {
			if (other.codigo != null) {
				return false
			}
		} else if (!codigo.equals(other.codigo)) {
			return false
		}
		
		return true;
	}
}
