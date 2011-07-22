package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos



import java.io.Serializable
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.*


/**
 * La clase pare de los tipos de canales.
 *
 */
public class TipoCanal implements Serializable{


	/**
     * Restricciones para los campos.
     */
    static constraints = {
		referencia(blank:false,unique:true)
		descripcion(blank:true,size:3..100)
	}
	
		
	/**
	 * La referencía de la bandeja.
	 */
	String referencia
		
	/**
	 * La descripcion del tipo de bandeja.
	 */
	String descripcion
	
	/**
	 * El diseno al que pertenece este tipo de canal.
	 */
	Diseno diseno
	
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
	   if (!(obj instanceof TipoCanal)) {
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