package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.factory


import java.util.HashMap;

import grails.test.GrailsUnitTestCase;


import static org.junit.Assert.*;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.factory.BandejaFactory;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.Diseno

/**
 * Clase que prueba la factoria de bandejas.
 *
 */
class BandejaFactoryTest extends GrailsUnitTestCase{

	/**
	 * Prueba las bandejas.
	 */
	void testCreaBandeja(){
		
		def bandeja = creaBandejaPrueba()
				
		assertNotNull 'La bandeja no puede ser nula', bandeja
		def secciones =  bandeja.recuperaHijos(TipoConexion.ESTRUCTURA)
		assertNotNull 'La bandeja debe tener secciones', secciones
		assertEquals 'La bandeja debe tener 6 secciones', secciones.size(), 6
	}
	
	/**
	 * Prueba la conexion entre secciones.
	 */
	void testConexionEntreSecciones(){
		def bandeja = creaBandejaPrueba()
		
		def secciones =  bandeja.recuperaHijos(TipoConexion.ESTRUCTURA)
		def primeraSeccion = secciones[0]
		
		def seccionesConectadas = primeraSeccion.recuperaHijos(TipoConexion.COMPOSICION)
		assertTrue 'La primera seccion debe tener un hijo',seccionesConectadas.size() == 1
		assertEquals 'La seccion conectada debe ser la segunda',seccionesConectadas[0] ,secciones[1]
	}
	
	/**
	 * Prueba que la ultima seccion no tiene conexiones.
	 */
	void testUltimaSeccionSinConexion(){
		def bandeja = creaBandejaPrueba()
		
		def secciones =  bandeja.recuperaHijos(TipoConexion.ESTRUCTURA)
				
		def ultimaSeccion = secciones[5]
		assertTrue 'La ultima seccion no debe conectar con nadie',ultimaSeccion.recuperaHijos(TipoConexion.COMPOSICION).size() == 0
	}
	
	/**
	* Prueba las bandejas.
	*/
   void testCreaBandejaDatosErroneos(){
	   
	   mockDomain(Diseno,[])
	   def proyecto = new Proyecto()
	   mockDomain(Proyecto,[proyecto])
	   mockDomain(Bandeja,[])
	   mockDomain(Seccion,[])
	   
	   def bandejaFactory = new BandejaFactory()
						   
	   def bandeja = bandejaFactory.creaBandeja([referencia:"referencia",longitud:"aaadsfadfa"],1)
			   
	   assertNotNull 'La bandeja no puede ser nula', bandeja
	   assertNotNull 'La bandeja debe tener secciones', bandeja.recuperaHijos(TipoConexion.ESTRUCTURA)
	   assertEquals 'La bandeja debe tener 0 secciones', bandeja.recuperaHijos(TipoConexion.ESTRUCTURA).size(), 0	   
   }

   /**
   * Crea bandeja para hacer pruebas
   */
   def creaBandejaPrueba(){
	    	   
	   mockDomain(Diseno,[])
	   
	   def proyecto = new Proyecto()
	   mockDomain(Proyecto,[proyecto])
	   mockDomain(Bandeja,[])
	   mockDomain(Seccion,[])
	   mockDomain(TipoRed,[])
	   mockDomain(TipoCanal,[])
	   
	   def bandejaFactory = new BandejaFactory()
					   
	   def bandeja = bandejaFactory.creaBandeja([referencia:"referencia",
		   longitud:"5",
		   red:new TipoRed(),
		   tipoCanal:new TipoCanal(),
		   descripcion:"descripcion",
		   ubicacion:"Al este"],1)
   		
	   return bandeja
   }
}
