package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*
import grails.test.*


/**
 * Pruebas de los metodos de la clase seccion.
 * 
 */
class SeccionTests extends GrailsUnitTestCase {
   

    /**
     * El porcentaje de llenado de una seccion vacia es 0
     */
    void testPorcentajeLlenadoSeccionVacia() {
		
		def seccion = new Seccion(referencia:"referencia")
		
		def porcentajeLlenado = seccion.getPorcentajeLlenado()
		
		assertEquals "El porcentaje de llenado debe ser 0",0,porcentajeLlenado
    }
	
	/**
	 * 
	 */
}
