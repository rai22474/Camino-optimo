package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import java.io.Serializable;

/**
 * Conexión entre dos elementos de topología.
 *
 */
class Conexion implements Serializable{

 	/** 
 	 * @see java.lang.Object#toString()
 	 */
 	@Override
	public String toString() {
    	return "$tipoConexion"
	}
	/**
	 * El tipo de conexion que tiene esta conexion
	 */
	TipoConexion tipoConexion
	
	/**
	 * Elemento de topologia que se relaciona
	 */
	ElementoTopologia padre
	
	/**
	 * Elemento de topologia relacionado
	 */
	ElementoTopologia hijo
}
