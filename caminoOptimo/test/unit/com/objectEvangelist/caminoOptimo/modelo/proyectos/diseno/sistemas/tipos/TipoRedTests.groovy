package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos

import grails.test.*

/**
 * Pruebas para el tipo de red.
 *
 */
class TipoRedTests extends GrailsUnitTestCase {
   
	 /**
     * Prueba el metodo toString
     */
    void testToString(){
		def tipoRed = new TipoRed(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", tipoRed.toString()			
	}
}
