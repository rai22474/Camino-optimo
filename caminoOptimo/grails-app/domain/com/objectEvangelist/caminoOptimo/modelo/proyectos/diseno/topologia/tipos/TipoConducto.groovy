package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos


import java.io.Serializable;


/**
 * Los tipos de conducto que tiene el sistema.
 *
 */
class TipoConducto extends TipoCanal{

    static constraints = {
	}
	
	

    /**
     * Diametro interior del conducto.
     */
    BigDecimal diametroInterior

    /**
     * Diametro nominal del conducto.
     */
    BigDecimal diametroNominal
	
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
	   if (!(obj instanceof TipoConducto)) {
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
