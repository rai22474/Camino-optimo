package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos

import com.gargoylesoftware.base.testing.EqualsTester
import grails.test.*

/**
 * Pruebas para los tipos de bandejas.
 *
 */
class TipoBandejaTests extends GrailsUnitTestCase {
   
    /**
     * Prueba que un tipo de bandeja no puede tener una referencia vacia. 
     * 
     */
    public void testErrorReferenciaNula() {
    	def tipoBandeja = new TipoBandeja(referencia:null)
    	mockForConstraintsTests(TipoBandeja, [ tipoBandeja ])

		assertFalse 'El referencia de la bandeja no puede ser nula ', tipoBandeja.validate()
		assertEquals 'Debe dar un error de bandeja',"nullable", tipoBandeja.errors["referencia"]       	
    }
	
	/**
     * Prueba que un tipo de bandeja no puede tener una referencia vacia.
     */
    public void testErrorReferenciaVacia() {
    	def tipoBandeja = new TipoBandeja(referencia:"")
    	mockForConstraintsTests(TipoBandeja, [ tipoBandeja ])

		assertFalse 'El referencia de la bandeja no puede ser vacia', tipoBandeja.validate()
		assertEquals 'Debe dar un error referencia de bandeja',"blank", tipoBandeja.errors["referencia"]       	
    }
	
	/**
	 * Método que prueba que la bandeja debe ser único en la aplicación.
	 */
	public void testErrorReferenciaUnica(){
		def tipoBandeja = new TipoBandeja(referencia:"1234")
		def tipoBandejaDuplicada =  new TipoBandeja(referencia:"1234")
    	mockForConstraintsTests(TipoBandeja, [ tipoBandeja,tipoBandejaDuplicada ])

		assertFalse 'El código no puede estar duplicada ', tipoBandejaDuplicada.validate()
		assertEquals 'Debe dar un error de referencia duplicada',"unique", tipoBandejaDuplicada.errors["referencia"]       	
	}
	
	 /**
     * Prueba que un sistema no puede tener un ancho nulo. 
     * 
     */
    public void testErrorAnchoNula() {
    	def tipoBandeja = new TipoBandeja(referencia:"1234")
    	mockForConstraintsTests(TipoBandeja, [ tipoBandeja ])

		assertFalse 'El ancho de la bandeja no puede ser nulo ', tipoBandeja.validate()
		assertEquals 'Debe dar un error ancho de bandeja',"nullable", tipoBandeja.errors["ancho"]       	
    }
	
	 /**
     * Prueba que un tipo de bandeja no puede tener un alto nulo. 
     * 
     */
    public void testErrorAltoNula() {
    	def tipoBandeja = new TipoBandeja(referencia:"1234")
    	mockForConstraintsTests(TipoBandeja, [ tipoBandeja ])

		assertFalse 'El alto de la bandeja no puede ser nulo ', tipoBandeja.validate()
		assertEquals 'Debe dar un error alto de bandeja',"nullable", tipoBandeja.errors["alto"]       	
    }
	
	/**
     * Prueba que un tipo de bandeja no puede tener un peso nulo. 
     * 
     */
    public void testErrorPesoNula() {
    	def tipoBandeja = new TipoBandeja(referencia:"1234")
    	mockForConstraintsTests(TipoBandeja, [ tipoBandeja ])

		assertFalse 'El peso de la bandeja no puede ser nulo ', tipoBandeja.validate()
		assertEquals 'Debe dar un error peso de bandeja',"nullable", tipoBandeja.errors["peso"]       	
    }
	
	/**
     * Prueba el metodo toString
     */
    void testToString(){
		def tipoBandeja = new TipoBandeja(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", tipoBandeja.toString()			
	}
	
	/**
	* Prueba el equals del tipo bandeja.
	*/
   public void testEquals(){
	   
	   def tipoBandejaOriginal = new TipoBandeja(referencia:"referencia")
	   def tipoBandejaIgual = new TipoBandeja(referencia:"referencia")
	   def tipoBandejaDistinto = new TipoBandeja(referencia:"referenciaDistinta")
	   def objetoDistinto = new Object()
	   	   
	   new EqualsTester(tipoBandejaOriginal,
		   tipoBandejaIgual,
		   tipoBandejaDistinto,
		   objetoDistinto)
   }
}
