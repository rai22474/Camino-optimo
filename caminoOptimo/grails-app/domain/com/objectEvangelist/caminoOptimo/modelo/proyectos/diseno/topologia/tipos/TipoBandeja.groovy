package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos


import java.io.Serializable
import groovy.transform.EqualsAndHashCode

/**
 * Clase que representa los tipos de bandeja que maneja la aplicación.
 *
 */
class TipoBandeja extends TipoCanal {
	
	/**
	 * 	@see java.lang.Object#toString()
	 */
	@Override
	public def String toString(){
		"$referencia"
	}
	
	/**
	* Restricciones para los campos.
	*/
   static constraints = {
	   referencia(blank:false,unique:true)
	   descripcion(blank:true,size:3..100)
	   ancho(nullable:false)
	   alto(nullable:false)
	   peso(nullable:false)
   }
   
   /**
	* El ancho de la bandeja.
	*/
   BigInteger ancho
 
   /**
	* El alto de la bandeja.
	*/
   BigInteger alto

   /**
	* El peso de la bandeja.
	*/
   BigInteger peso
}
