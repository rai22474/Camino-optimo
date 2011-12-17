package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos

import com.gargoylesoftware.base.testing.EqualsTester

import grails.test.*


/**
 * Clase de pruebas para el tipo de cable.
 *
 */
class TipoCableTests extends GrailsUnitTestCase {
   
   /**
     * Prueba que un tipo de cable no puede tener una referencia vacia. 
     * 
     */
    public void testErrorReferenciaNula() {
    	def tipoCable = new TipoCable(referencia:null)
    	mockForConstraintsTests(TipoCable, [ tipoCable ])

		assertFalse 'La referencia del cable no puede ser nula ', tipoCable.validate()
		assertEquals 'Debe dar un error de cable',"nullable", tipoCable.errors["referencia"]       	
    }
	
	/**
     * Prueba que un tipo de cable no puede tener una referencia vacia.
     */
    public void testErrorReferenciaVacia() {
    	def tipoCable = new TipoCable(referencia:"")
    	mockForConstraintsTests(TipoCable, [ tipoCable ])

		assertFalse 'La referencia del cable no puede ser vacia', tipoCable.validate()
		assertEquals 'Debe dar un error referencia de cable',"blank", tipoCable.errors["referencia"]       	
    }
	
	/**
	 * Prueba que el tipo de cable no puede tener un peso nulo.
	 * 
	 */
	public void testErrorPesoNulo(){
		def tipoCable = new TipoCable(peso:null)
		mockForConstraintsTests(TipoCable, [ tipoCable ])
		
		assertFalse 'El peso del cable no puede ser nulo', tipoCable.validate()
		assertEquals 'Debe dar un error en el peso del cable',"nullable", tipoCable.errors["peso"]      
	}
	 
	/**
	 * Prueba que el tipo de cable no puede tener un diametro nulo.
	 * 
	 */
	public void testErrorSeccionExteriorNulo(){
		def tipoCable = new TipoCable(seccionExterior:null)
		mockForConstraintsTests(TipoCable, [ tipoCable ])
		
		assertFalse 'La seccion exterior del cable no puede ser nulo', tipoCable.validate()
		assertEquals 'Debe dar un error en el seccion exterior del cable',"nullable", tipoCable.errors["seccionExterior"]      
	} 
	
	/**
	 * Prueba que el tipo de cable no puede tener un peso nulo.
	 * 
	 */
	public void testErrorNumeroPuntasNulo(){
		def tipoCable = new TipoCable(numeroPuntas:null)
		mockForConstraintsTests(TipoCable, [ tipoCable ])
		
		assertFalse 'El número de puntas del cable no puede ser nulo', tipoCable.validate()
		assertEquals 'Debe dar un error en el número de puntas del cable',"nullable", tipoCable.errors["numeroPuntas"]      
	}
	
	/**
	 * Prueba que el tipo de cable no puede tener un peso nulo.
	 * 
	 */
	public void testErrorNumeroCablesNulo(){
		def tipoCable = new TipoCable(numeroCables:null)
		mockForConstraintsTests(TipoCable, [ tipoCable ])
		
		assertFalse 'El número de cables del cable no puede ser nulo', tipoCable.validate()
		assertEquals 'Debe dar un error en el número de cables del cable',"nullable", tipoCable.errors["numeroCables"]      
	}
	
	/**
	 * Prueba que la sección del conductor no puede tener un peso nulo.
	 * 
	 */
	public void testErrorSeccionConductorNulo(){
		def tipoCable = new TipoCable(seccionConductor:null)
		mockForConstraintsTests(TipoCable, [ tipoCable ])
		
		assertFalse 'La sección del conductor no puede ser nulo', tipoCable.validate()
		assertEquals 'Debe dar un error en la sección del conductor',"nullable", tipoCable.errors["seccionConductor"]      
	}
	
	/**
     * Prueba el metodo toString
     */
    void testToString(){
		def tipoCable = new TipoCable(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", tipoCable.toString()			
	}
	
	/**
	 * Metodo que prueba los equals.
	 */
	void testEquals(){
	
		TipoCable tipoCable = new TipoCable(referencia:'12345')
		TipoCable tipoCableIgual = new TipoCable(referencia:'12345')
		TipoCable tipoCableDistinto = new TipoCable(referencia:'23212')
		Object objetoDistinto = new Object()
		
		new EqualsTester(tipoCable,
			tipoCableIgual,
			tipoCableDistinto,
			objetoDistinto) 
		
	}
}
