package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos

import com.gargoylesoftware.base.testing.EqualsTester
import grails.test.*

/**
 * Pruebas para el tipo de red.
 *
 */
class TipoRedTests extends GrailsUnitTestCase {
   
	 /**
     * Prueba el metodo toString
     */
    def void testToString(){
		def tipoRed = new TipoRed(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", tipoRed.toString()			
	}
	
	/**
	 * Metodo que prueba el metodo equals
	 */
	def void testEquals(){
		def tipoRedOriginal = new TipoRed(referencia:"123456")
		def tipoRedIgual = new TipoRed(referencia:"123456")
		def tipoRedDistinto = new TipoRed(referencia:"454345")
		def objetoDistinto = new Object()
		
		new EqualsTester(tipoRedOriginal,
			tipoRedIgual,
			tipoRedDistinto,
			objetoDistinto) 
		
	}
}
