package com.objectEvangelist.caminoOptimo.modelo.proyectos

import grails.test.*
import nl.jqno.equalsverifier.*

/**
 * Clase que prueba la entidad de dominio que representa un proyecto.
 *
 */
class ProyectoTests extends GrailsUnitTestCase {
    
    /**
     * Prueba que un proyecto no puede tener un código nulo.
     */
    public void testErrorCodigoNulo() {
    	def proyecto = new Proyecto(codigo:null,descripcion:"descripcion")
    	mockForConstraintsTests(Proyecto, [ proyecto ])

		assertFalse 'El código no puede ser nulo ', proyecto.validate()
		assertEquals 'Debe dar un error de código nulo',"nullable", proyecto.errors["codigo"]       	
    }
	
	/**
	 * Método que prueba que el código del proyecto debe ser único en la aplicación
	 */
	public void testErrorCodigoUnico(){
		def proyecto = new Proyecto(codigo:"1234",descripcion:"descripcion")
		def proyectoDuplicado =  new Proyecto(codigo:"1234",descripcion:"descripcion")
    	mockForConstraintsTests(Proyecto, [ proyecto,proyectoDuplicado ])

		assertFalse 'El código no puede estar duplicado ', proyectoDuplicado.validate()
		assertEquals 'Debe dar un error de código duplicado',"unique", proyectoDuplicado.errors["codigo"]       	

	}
	
	/**
	 * Método que prueba que el código tiene mas de tres caracteres
	 */
	public void testErrorCodigoMasCorto() {
		def proyecto = new Proyecto(codigo:"1",descripcion:"descripcion")
		mockForConstraintsTests(Proyecto, [ proyecto ])

		assertFalse 'El código no puede ser menor que tres caracteres ', proyecto.validate()
		assertEquals 'Debe dar un error de menos de tres caracteres',"size", proyecto.errors["codigo"]       	
	}
	
	/**
	 * Método que prueba que el código tiene mas de 20 caracteres
	 */
	public void testErrorCodigoMasLargo() {
		def proyecto = new Proyecto(codigo:"121212121212121212121331331313313133213",descripcion:"descripcion")
		mockForConstraintsTests(Proyecto, [ proyecto ])

		assertFalse 'El código no puede ser mayor que veinte caracteres ', proyecto.validate()
		assertEquals 'Debe dar un error de mayor de veinte caracteres',"size", proyecto.errors["codigo"]       	
	}
	
	/**
	 * Método que prueba que el código tiene mas de 20 caracteres
	 */
	public void testDescripcionVacia() {
		def proyecto = new Proyecto(codigo:"1234",descripcion:"")
		mockForConstraintsTests(Proyecto, [ proyecto ])

		assertFalse 'La descripcion no puede estar vacia ', proyecto.validate()
		assertEquals 'Debe dar un error de descripción vacia',"blank", proyecto.errors["descripcion"]       	
	}
	
	/**
	 * Método que prueba el método toString
	 */
	public void testToString(){
		def proyecto = new Proyecto(codigo:"12345")
		assertEquals 'No es la descripcion esperada',"12345", proyecto.toString()			
	}
	
	/**
	 *  Testea el equals y el hascode de las clase.
	 */
	public void testEquals(){
			
	}
}
