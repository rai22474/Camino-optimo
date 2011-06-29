package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import java.io.Serializable;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoRed;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.*
/**
 * Clase padre de todas las canalizaciones.
 *
 */
class Canalizacion extends ElementoTopologia {

    static constraints = {
    }
		
	/**
	* Calcula cual cual es la seccion que ocupa los cables dentro de una canalizacion.
	*/
   def public calculaSeccionOcupada() {
	   def seccionOcupada = 0
	   
	   getCables().each{cable ->
		   seccionOcupada += cable.getSeccionExterior()	
	   }
	   
	   return seccionOcupada
   }
   
   
}
