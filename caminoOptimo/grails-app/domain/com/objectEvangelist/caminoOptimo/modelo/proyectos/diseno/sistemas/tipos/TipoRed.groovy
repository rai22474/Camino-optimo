package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos

import java.io.Serializable;


/**
 * Clase que define los diferentes tipos de redes que vamos a tener.
 *
 */
class TipoRed implements Serializable{

    static constraints = {
    }
	
	/**
	* Referencia de cada uno de los tipo de red.
	*/
   String referencia
   
   /**
	* La descripción del tipo de red.
	*/
   String descripcion
	
	/**
	 * 	@see java.lang.Object#toString()
	 */
	@Override
	def String toString(){
		"$referencia"
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31
		def result = 1
		return prime * result	+ ((referencia == null) ? 0 : referencia.hashCode())
	}

	/** 
	 *  @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false
		}
		
		if (!(obj instanceof TipoRed)) {
			return false
		}
		if (referencia == null) {
			if (obj.referencia != null) {
				return false
			}
		} else if (!referencia.equals(obj.referencia)) {
			return false
		}
		
		return true
	}

	
}
