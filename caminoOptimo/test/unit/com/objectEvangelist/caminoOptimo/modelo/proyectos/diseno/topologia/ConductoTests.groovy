package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import grails.test.*

class ConductoTests extends GrailsUnitTestCase {
    
	/**
     * Prueba el metodo toString
     */
    void testToString(){
		def conducto = new Conducto(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", conducto.toString()			
	}
}
