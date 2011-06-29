package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia;

import java.io.Serializable;

/**
 * Enumeracion  que representa cada uno de los elementos del tipo de topologia
 *
 */
public enum TipoElementoTopologia implements Serializable{
	/**
	 * Tipo de representa la seccion
	 */
	SECCION,
	
	/**
	 * Tipo que representa una bandeja
	 */
	BANDEJA,
	
	/**
	 * Tipo que representa un equipo
	 */
	EQUIPO,
	
	/**
	 * Tipo que representa un conduto
	 */
	CONDUCTO,
	
	/**
	 * El extremo de un conducto
	 */
	EXTREMO_CONDUCTO,
	
	/**
	 * Ruta de elementos
	 */
	RUTA
}
