package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos


import java.io.Serializable;

/**
 * Los tipos de cables que van a usarse dentro de este proyecto.
 *
 */
class TipoCable implements Serializable {
	
    static constraints = {
		referencia(blank:false)
		descripcion(blank:true,size:3..100)
		peso(nullable:false)
		seccionExterior(nullable:false)
		numeroPuntas(nullable:false)
		seccionConductor(nullable:false)
    }
	
	
    /**
     * La referencia que tiene ese tipo de cable.
     */
    String referencia

    /**
     * La descripcion del tipo de cable.
     */
    String descripcion

    /**
     * El peso que tiene este tipo de cable.
     */
    BigDecimal peso

    /**
     * Diametro total del tipo de cable.
     */
    BigDecimal seccionExterior

    /**
     * El numero de puntas del tipo de cable.
     */
    Integer numeroPuntas

    /**
     * Numero de cables.
     */
    Integer numeroCables

    /**
     * Seccion del conductor.
     */
    BigDecimal seccionConductor

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
		int result = 1
		result = prime * result	+ ((referencia == null) ? 0 : referencia.hashCode())
		return result
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false
		}
		
		if (!(obj instanceof TipoCable)) {
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
