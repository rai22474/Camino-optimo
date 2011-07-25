package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas

import java.io.Serializable;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.*


/**
 * Clase que representa un sistema. Un sistema es un conjunto de cables que representa una utilidad práctica por
 * ejemplo los cables del transformador.
 *
 */
class Sistema implements Serializable {

    static constraints = {
		referencia(blank:false,unique:true)
		nombre(blank:false)
    }
		
	/**
	 * Código de tres letras que representa el sistema.
	 */
	String referencia
	
	/**
	 * Nombre del subsistema. 
	 */
	String nombre
	
	/**
	 * Descripción del sistema.
	 */
	String descripcion
	
	/**
	 * Los cables que pertenecen a un sistema.
	 */
	static hasMany = [cables:Cable]
	
	/**
	 * El tipo de red que pertenece el sistema.
	 */
	TipoRed red	
	
	/**
	 * El diseño al que pertence este sistema.
	 */
	Diseno diseno
	
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
		final int prime = 31;
		def result = 1;
		return prime * result + ((referencia == null) ? 0 : referencia.hashCode())
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false
		}
		if (!(obj instanceof Sistema)) {
			return false
		}
		
		if (referencia == null) {
			if (obj.referencia != null) {
				return false
			}
		} else if (!referencia.equals(obj.referencia)) {
			return false
		}
		return true;
	}
   
   
   
}
