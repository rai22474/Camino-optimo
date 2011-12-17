package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos


import java.io.Serializable;

/**
 * Los tipos de conducto que tiene el sistema.
 *
 */
class TipoConducto extends TipoCanal{

	/**
	 * 	@see java.lang.Object#toString()
	 */
	@Override
	public def String toString(){
		"$referencia"
	}

	/**
	 * Diametro interior del conducto.
	 */
	BigDecimal diametroInterior

	/**
	 * Diametro nominal del conducto.
	 */
	BigDecimal diametroNominal
}
