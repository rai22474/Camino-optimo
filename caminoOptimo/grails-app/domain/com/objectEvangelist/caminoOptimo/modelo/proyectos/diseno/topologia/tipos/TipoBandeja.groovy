package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos


import java.io.Serializable;


/**
 * Clase que representa los tipos de bandeja que maneja la aplicación.
 *
 */
class TipoBandeja extends TipoCanal {

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
	
	/**
	 * 	@see java.lang.Object#toString()
	 */
	@Override
	public def String toString(){
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
		if (!(obj instanceof TipoBandeja)) {
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
