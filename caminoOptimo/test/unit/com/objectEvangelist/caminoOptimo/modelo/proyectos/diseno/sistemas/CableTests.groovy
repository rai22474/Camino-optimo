package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas

import grails.test.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*

class CableTests extends GrailsUnitTestCase {
    
	
	/**
	 * Metodo que prueba que la referencia de un cable no es nula.
	 */
	public void testErrorReferenciaNula(){
		
		def cable = new Cable(referencia:null)
		
		mockForConstraintsTests(Cable, [ cable ])

		assertFalse 'El referencia del cable no puede ser nula ', cable.validate()
		assertEquals 'Debe dar un error de cable',"nullable", cable.errors["referencia"]    
		
	}
	
	/**
	 * Metodo que prueba que la referencia de un cable no es vacia.
	 */
	public void testErrorReferenciaVacia(){
		
		def cable = new Cable(referencia:"")
		
		mockForConstraintsTests(Cable, [ cable ])

		assertFalse 'El referencia del cable no puede ser nula ', cable.validate()
		assertEquals 'Debe dar un error de cable',"blank", cable.errors["referencia"]    
	}
	
	
	/**
	 * El tipo de cable no puede ser nulo.
	 */
	public void testTipoCableNulo(){
		
		def cable = new Cable(tipoCable:null)
		
		mockForConstraintsTests(Cable, [ cable ])

		assertFalse 'El tipo del cable no puede ser nula ', cable.validate()
		assertEquals 'Debe dar un error de cable',"nullable", cable.errors["tipoCable"]  
		
	}
	
	/**
	 * La red no puede ser nula.
	 */
	public void testRedNoNulo(){
	
		def cable = new Cable(red:null)
		
		mockForConstraintsTests(Cable, [ cable ])
		
		assertFalse 'La red no puede ser nula ', cable.validate()
		assertEquals 'Debe dar un error de cable',"nullable", cable.errors["red"]  
	}
	
	/**
	 * El sistema no puede ser nulo.
	 */
	public void testSistemaNoNulo(){
		def cable = new Cable(sistema:null)
		
		mockForConstraintsTests(Cable, [ cable ])
		
		assertFalse 'El sistema no puede ser nulo ', cable.validate()
		assertEquals 'Debe dar un error de cable',"nullable", cable.errors["sistema"]  
	}
	
	/**
	 * El equipo origen no debe se nulo.
	 */
	public void testEquipoOrigenNoNulo(){
		def cable = new Cable(equipoOrigen:null)
		
		mockForConstraintsTests(Cable, [ cable ])
		
		assertFalse 'El equipo origen no puede ser nulo', cable.validate()
		assertEquals 'Debe dar un error de cable',"nullable", cable.errors["equipoOrigen"]  
	}

	/**
	 * El equipo origen no debe se nulo.
	 */
	public void testEquipoDestinoNoNulo(){
		def cable = new Cable(equipoDestino:null)
		
		mockForConstraintsTests(Cable, [ cable ])
		
		assertFalse 'La sistema no puede ser nula ', cable.validate()
		assertEquals 'Debe dar un error de cable',"nullable", cable.errors["equipoDestino"]  
	}
	
	
	
	 /**
     * Prueba el metodo toString
     */
    void testToString(){
		def cable = new Cable(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", cable.toString()			
	}
	
	/**
	 * Método que calcula cuales son las rutas posibles de un cable.
	 */
	public void testCalculaRutasPosibles(){
	
		def ruta = new Ruta()
		def equipoOrigen = [calculaRutasPosibles: {[ruta]}] as Equipo
		def equipoDestino = new Equipo(referencia:"Referencia")	
		
		def cable = new Cable(referencia:'referencia',
			equipoOrigen:equipoOrigen,
			equipoDestino:equipoDestino)
		
		def rutas = cable.calculaRutasPosibles()
		
		assertNotNull 'Debe devolver rutas', rutas
		assertTrue 'La lista debe tener una ruta', rutas.size() == 1
		
	}
}
