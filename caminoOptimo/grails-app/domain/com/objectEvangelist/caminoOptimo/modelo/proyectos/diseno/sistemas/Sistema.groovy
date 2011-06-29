package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas



import java.io.Serializable;

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*;

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
	* 	@see java.lang.Object#toString()
	*/
   @Override
   def String toString(){
	   "$referencia"
   }
   
}
