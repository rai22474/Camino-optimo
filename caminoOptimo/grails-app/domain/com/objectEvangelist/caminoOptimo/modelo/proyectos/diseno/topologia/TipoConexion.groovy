package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import java.io.Serializable;
import java.util.HashSet

/**
 * Clase que representa los tipos de conexion.
 *
 */
public enum TipoConexion implements Serializable{
	
	/**
	 * Las elementos que se conectan dentro de una topologia.				
	 */
	TOPOLOGIA,
	
	/**
	 * La conexion de los elementos y lo que les compone.
	 */
	ESTRUCTURA,
	
	/**
	 * La conexion entre los elementos que forman uno compuesto.						
	 */
	COMPOSICION,
	
	/**
	 * Conexion de los elemento que forman una ruta
	 */
	RUTA,
	
	
}
