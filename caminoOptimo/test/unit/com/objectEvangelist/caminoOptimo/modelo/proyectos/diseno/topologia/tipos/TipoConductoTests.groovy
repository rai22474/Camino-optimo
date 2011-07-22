package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos

import com.gargoylesoftware.base.testing.EqualsTester
import grails.test.*

/**
 * Pruebas para el tipo de conducto.
 *
 */
class TipoConductoTests extends GrailsUnitTestCase {
   
   /**
     * Prueba que un tipo de conducto no puede tener una referencia vacia. 
     * 
     */
    public void testErrorReferenciaNula() {
    	def tipoConducto = new TipoConducto(referencia:null)
    	mockForConstraintsTests(TipoConducto, [ tipoConducto ])

		assertFalse 'La referencia del conducto no puede ser nula ', tipoConducto.validate()
		assertEquals 'Debe dar un error de conducto',"nullable", tipoConducto.errors["referencia"]       	
    }
	
	/**
     * Prueba que un tipo de conducto no puede tener una referencia vacia.
     */
    public void testErrorReferenciaVacia() {
    	def tipoConducto = new TipoConducto(referencia:"")
    	mockForConstraintsTests(TipoConducto, [ tipoConducto ])

		assertFalse 'La referencia del conducto no puede ser vacia', tipoConducto.validate()
		assertEquals 'Debe dar un error referencia de conducto',"blank", tipoConducto.errors["referencia"]       	
    }
	
	/**
	 * Prueba que el tipo de conducto no puede tener un peso nulo.
	 * 
	 */
	public void testErrorDiametroInteriorNulo(){
		def tipoConducto = new TipoConducto(diametroInterior:null)
		mockForConstraintsTests(TipoConducto, [ tipoConducto ])
		
		assertFalse 'El diametro interior no puede ser nulo', tipoConducto.validate()
		assertEquals 'Debe dar un error en el diametro interior',"nullable", tipoConducto.errors["diametroInterior"]      
	}
	
	/**
	 * Prueba que el tipo de conducto no puede tener un peso nulo.
	 * 
	 */
	public void testErrorDiametroNominalNulo(){
		def tipoConducto = new TipoConducto(diametroNominal:null)
		mockForConstraintsTests(TipoConducto, [ tipoConducto ])
		
		assertFalse 'El diametro nominal no puede ser nulo', tipoConducto.validate()
		assertEquals 'Debe dar un error en el diametro nominal',"nullable", tipoConducto.errors["diametroNominal"]      
	}
	
	/**
     * Prueba el metodo toString
     */
    void testToString(){
		def tipoConducto = new TipoConducto(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", tipoConducto.toString()			
	}
	
	/**
	* Prueba el equals del tipo canal.
	*/
   public void testEquals(){
	   
	   def tipoConductoOriginal = new TipoConducto(referencia:"referencia")
	   def tipoConductoIgual = new TipoConducto(referencia:"referencia")
	   def tipoConductoDistinto = new TipoConducto(referencia:"referenciaDistinta")
	   def objetoDistinto = new Object()
	   
	   
	   new EqualsTester(tipoConductoOriginal,
		   tipoConductoIgual,
		   tipoConductoDistinto,
		   objetoDistinto)
	   
   }
}
