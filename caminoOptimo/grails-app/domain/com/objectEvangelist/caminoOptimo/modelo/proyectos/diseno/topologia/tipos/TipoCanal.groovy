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
	
}