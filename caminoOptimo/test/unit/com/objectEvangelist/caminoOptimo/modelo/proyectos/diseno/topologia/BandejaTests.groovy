package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import grails.test.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*

/**
 * Clase encargada de probar 
 * 
 */
class BandejaTests extends GrailsUnitTestCase {
    
	/**
     * Prueba el metodo toString
     */
    void testToString(){
		def bandeja = new Bandeja(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", bandeja.toString()			
	}
}
