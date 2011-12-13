package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import grails.test.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.TipoBandeja;

/**
 * Clase encargada de probar 
 * 
 */
class BandejaTests extends GrailsUnitTestCase {
    
	/**
     * Prueba el metodo toString.
     */
    def void testToString(){
		def bandeja = new Bandeja(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", bandeja.toString()			
	}
	
	/**
	 * Devuelve la seccion util de la bandeja.
	 */
	def void testCalculaSeccionUtil(){
		def tipoBandeja = mockFor(TipoBandeja,true)
		
		tipoBandeja.demand.getAncho(1..1){->
			return 10			
		}
		
		def bandeja = new Bandeja(tipoCanal:tipoBandeja.createMock())
				
		assertEquals 'La seccion util debe ser 10',10,bandeja.calculaSeccionUtil()
	}
}
