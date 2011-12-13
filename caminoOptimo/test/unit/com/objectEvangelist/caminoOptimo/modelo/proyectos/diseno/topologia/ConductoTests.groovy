package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import grails.test.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*

class ConductoTests extends GrailsUnitTestCase {
    
	/**
     * Prueba el metodo toString
     */
    void testToString(){
		def conducto = new Conducto(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", conducto.toString()			
	}
	
	/**
	 * Prueba que calcula la seccion util.
	 */
	void testCalculaSeccionUtil(){
		def tipoConducto = mockFor(TipoConducto,true)
		
		tipoConducto.demand.getDiametroNominal(1..1){->
			return 10
		}
		
		def conducto = new Conducto(tipoCanal:tipoConducto.createMock())
				
		assertEquals 'La seccion util debe ser 10',10,conducto.calculaSeccionUtil()
	}
}
