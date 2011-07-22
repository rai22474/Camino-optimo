package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas


import com.gargoylesoftware.base.testing.EqualsTester
import grails.test.*

/**
 * Clase que prueba la clase sistema.
 *
 */
class SistemaTests extends GrailsUnitTestCase {
    
	/**
	 * Prueba que la referencia de un sistema es nula.
	 */
	public void testErrorReferenciaNula() {
    	def sistema = new Sistema(referencia:null)
    	mockForConstraintsTests(Sistema, [ sistema ])

		assertFalse 'El referencia del sistema no puede ser nula ', sistema.validate()
		assertEquals 'Debe dar un error de sistema',"nullable", sistema.errors["referencia"]       	
    }
	
	/**
	 * Prueba que la referencia de un sistema es vacia.
	 */
	public void testErrorReferenciaVacia() {
    	def sistema = new Sistema(referencia:"")
    	mockForConstraintsTests(Sistema, [ sistema ])

		assertFalse 'El referencia del sistema no puede ser vacia ', sistema.validate()
		assertEquals 'Debe dar un error de sistema',"blank", sistema.errors["referencia"]       	
    }
	
	/**
	 * No hay referencia duplicada.
	 */
	public void testErrorReferenciaDuplicada(){
	
		def sistema = new Sistema(referencia:"123123")
		def sistemaDuplicado = new Sistema(referencia:"123123")
    	mockForConstraintsTests(Sistema, [ sistema, sistemaDuplicado ])
		
		assertFalse 'La referencia no puede estar duplicada ', sistemaDuplicado.validate()
		assertEquals 'Debe dar un error de referencia duplicada',"unique", sistemaDuplicado.errors["referencia"]       	
	}
	
	/**
	 * Prueba que el nombre no puede ser nulo.
	 */
	public void testErrorNombreNulo(){
		def sistema = new Sistema(nombre:null)
		
		mockForConstraintsTests(Sistema, [sistema])
		
		assertFalse 'El referencia del sistema no puede ser vacia', sistema.validate()
		assertEquals 'Debe dar un error de sistema',"nullable", sistema.errors["nombre"]
	}
	
	/**
	 * Prueba que el nombre no puede ser vacio.
	 */
	public void testErrorNombreVacio(){
		def sistema = new Sistema(nombre:"")
		
		mockForConstraintsTests(Sistema, [sistema])
		
		assertFalse 'El referencia del sistema no puede ser vacia', sistema.validate()
		assertEquals 'Debe dar un error de sistema',"blank", sistema.errors["nombre"]
	}
	
	/**
     * Prueba el metodo toString
     */
    public void testToString(){
		def sistema = new Sistema(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", sistema.toString()			
	}
	
	/**
	 * Prueba el equals del sistema. 
	 */
	public void testEquals(){
		
		def sistemaOriginal = new Sistema(referencia:"referencia")
		def sistemaIgual = new Sistema(referencia:"referencia")
		def sistemaDistinto = new Sistema(referencia:"referenciaDistinta")
		def objetoDistinto = new Object()
		
		
		new EqualsTester(sistemaOriginal,
			sistemaIgual,
			sistemaDistinto,
			objetoDistinto)
		
	}
}
