package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos

import com.gargoylesoftware.base.testing.EqualsTester
import grails.test.*

/**
 * Pruebas para los tipos de bandejas.
 *
 */
class TipoCanalTests extends GrailsUnitTestCase {
   
	/**
     * Prueba el metodo toString
     */
    void testToString(){
		def tipoCanal = new TipoCanal(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", tipoCanal.toString()			
	}
	
	/**
	* Prueba el equals del tipo canal.
	*/
   public void testEquals(){
	   
	   def tipoCanalOriginal = new TipoCanal(referencia:"referencia")
	   def tipoCanalIgual = new TipoCanal(referencia:"referencia")
	   def tipoCanalDistinto = new TipoCanal(referencia:"referenciaDistinta")
	   def objetoDistinto = new Object()
	   
	   
	   new EqualsTester(tipoCanalOriginal,
		   tipoCanalIgual,
		   tipoCanalDistinto,
		   objetoDistinto)
	   
   }
}
