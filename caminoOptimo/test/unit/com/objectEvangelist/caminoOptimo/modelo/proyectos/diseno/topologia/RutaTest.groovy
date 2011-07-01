package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import grails.test.GrailsUnitTestCase;

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*
import static org.junit.Assert.*;

/**
 * Clase que va a probar como funcionan las rutas.
 *
 */
class RutaTest extends GrailsUnitTestCase{

	/**
	 * Metodo encargado de probar que se inserten segmentos
	 */
	public void testInsertarSegmentos(){
	
		mockDomain(Ruta,[])
		mockDomain(ElementoTopologia,[])
		def ruta = new Ruta()
		
		def elementoTopologia = new ElementoTopologia()				
		ruta.conecta(elementoTopologia,TipoConexion.RUTA)
		
		assertNotNull 'La lista no puede ser nula',ruta.recuperaHijos(TipoConexion.RUTA)
		assertTrue 'La lista debe tener un elemento', ruta.recuperaHijos(TipoConexion.RUTA).size() == 1
	}
	
	/**
	 * Metodo que bifurcan los metodos
	 */
	public void testBifurcarRuta(){
	
		mockDomain(Ruta,[])
		mockDomain(ElementoTopologia,[])
		def ruta = new Ruta()
		
		def elementoTopologia = new ElementoTopologia(referencia:'referencia')
		ruta.conecta(elementoTopologia,TipoConexion.RUTA)
		
				
		def rutaBifurcada = ruta.bifurca() 
		
		assertNotNull 'La ruta bifurcada no puede ser nula', rutaBifurcada
		assertTrue 'La ruta debe tener dos segmentos', rutaBifurcada.recuperaHijos(TipoConexion.RUTA).size() == 1
	}
	
	/**
	 * Metodo que recupera el ultimo elemento de un ruta
	 */
	public void testUltimoElemento(){
		mockDomain(Ruta,[])
		mockDomain(ElementoTopologia,[])
		
		def ruta = new Ruta()
		
		def elementoTopologia = new ElementoTopologia(referencia:'referencia')
		ruta.conecta(elementoTopologia,TipoConexion.RUTA)
		def elementoTopologia1 = new ElementoTopologia(referencia:'referencia1')
		ruta.conecta(elementoTopologia1,TipoConexion.RUTA)
		
		def segmento = ruta.ultimoSegmento()
		
		assertNotNull 'El segmento recuperado no puede ser nulo',segmento
		assertEquals 'Debe ser el ultimo elemento insertado',segmento,elementoTopologia1
	}	
	
	/**
	* Metodo que recupera el ultimo elemento de un ruta
	*/
   public void testUltimoElementoListaVacia(){
	   
	   mockDomain(Ruta,[])
	   mockDomain(ElementoTopologia,[])
	   def ruta = new Ruta()
	  	   
	   def segmento = ruta.ultimoSegmento()
	   
	   assertNull 'El segmento recuperado debe ser nulo',segmento
   }
   
	/**
	 * Metodo que agrega un cable a una bandeja.
	 */
	void testAgregarCable(){
		
		Cable cable = new Cable(referencia:"referenciaCable")
		def ruta = creaRutaPrueba()
		ruta.agregaCable(cable)
		
		def elementosTopologia = ruta.recuperaHijos(TipoConexion.RUTA)
		
		assertTrue 'Debe tener un cable asignado',elementosTopologia[0].getCables().size() == 1
		assertTrue 'La segunda seccion debe tener un cable asignado',elementosTopologia[1].getCables().size() == 1
	}
	
	/**
	 * Metodo que agrega un cable a una bandeja.
	 */
	void testEliminaCable(){
		
		def ruta = creaRutaPrueba()
		
		//Preparacion
		Cable cable = new Cable(referencia:"referenciaCable")
		
		def elementosTopologia = ruta.recuperaHijos(TipoConexion.RUTA)
		elementosTopologia[0].agregaCable(cable)
		elementosTopologia[1].agregaCable(cable)
		
		//Prueba
		ruta.eliminaCable(cable)
		
		assertTrue 'No debe tener un cable asignado',elementosTopologia[0].getCables().size() == 0
		assertTrue 'La segunda seccion no debe tener un cable asignado',elementosTopologia[0].getCables().size() == 0
	}
	
	
	/**
	 * Crea una ruta para probar
	 */
	private creaRutaPrueba(){
		mockDomain (Ruta,[])
		mockDomain (ElementoTopologia,[])
		mockDomain (Cable,[])
		
		Ruta ruta = new Ruta(referencia:"1234")
		
		ElementoTopologia elementoTopologia = new ElementoTopologia(referencia:"referenciaSeccion")
		ElementoTopologia segundoElementoTopologia =  new ElementoTopologia(referencia:"segundaSeccion")
		
		ruta.conecta (elementoTopologia,TipoConexion.RUTA)
		ruta.conecta (segundoElementoTopologia,TipoConexion.RUTA)
		
		return ruta
 }
   
	
}
