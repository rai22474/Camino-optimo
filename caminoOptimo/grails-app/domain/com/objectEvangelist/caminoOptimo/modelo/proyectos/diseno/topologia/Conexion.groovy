package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import java.io.Serializable;

/**
 * Conexion entre dos elementos de topologia
 *
 */
class Conexion implements Serializable{

    static constraints = {
    }
	
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
