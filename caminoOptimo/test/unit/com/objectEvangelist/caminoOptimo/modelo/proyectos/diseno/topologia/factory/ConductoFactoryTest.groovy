package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.factory


import grails.test.GrailsUnitTestCase;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.factory.ConductoFactory
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*

import static org.junit.Assert.*;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.Diseno

/**
 * 
 * Prueba para la factoria de conductos
 */
class ConductoFactoryTest extends GrailsUnitTestCase {
	
	/**
	 * Prueba la creacion del conducto.
	 */
	void testCreacionConducto(){
		def conducto = creaConducto() 
		
		assertNotNull 'El conducto no puede ser nulo', conducto
		def extremos = conducto.recuperaHijos(TipoConexion.ESTRUCTURA)
		assertNotNull 'El conducto debe tener dos extremos', extremos
		assertEquals 'El conducto debe tener 2 extremos', extremos.size(), 2
		assertEquals 'El extremo debe ser Inicio/referencia','Inicio/referencia' ,extremos[0].referencia
		assertEquals 'El extremo debe ser Fin/referencia','Fin/referencia' ,extremos[1].referencia
	}
	
	/**
	 * Prueba de las union entre conductos
	 */
	void testUnionesConducto(){
		def conducto = creaConducto()
		def extremos = conducto.recuperaHijos(TipoConexion.ESTRUCTURA)
		
		def hijos = extremos[0].recuperaHijos(TipoConexion.COMPOSICION)
		
		assertTrue 'El primer extremo debe conectar con la segundo',hijos.size() == 1
		assertEquals 'El hijo debe ser el segundo extremo',hijos[0],extremos[1]
	}
	
	/**
	* Prueba la creacion del conducto.
	*/
   void testCreacionConductoErroneo(){
   
	   mockDomain(Diseno,[])
	   def proyecto = new Proyecto()
	   mockDomain(Proyecto,[proyecto])

	   mockDomain(Conducto,[])
	   mockDomain(ExtremoConducto,[])
	   
	   def conductoFactory = new ConductoFactory()
	   def conducto = conductoFactory.creaConducto([referencia:"referencia"],1)
	   
	   assertNotNull 'El conducto no puede ser nulo', conducto
	   def extremos = conducto.recuperaHijos(TipoConexion.ESTRUCTURA)
	   assertNotNull 'El conducto debe tener dos extremos', extremos
	   assertEquals 'El conducto no debe tener ningun  extremos', extremos.size(), 0
	
   }
	
   def creaConducto(){
	   
	   mockDomain(Diseno,[])
	   def proyecto = new Proyecto()
	   mockDomain(Proyecto,[proyecto])

	   mockDomain(Conducto,[])
	   mockDomain(ExtremoConducto,[])
	   
	   def conductoFactory = new ConductoFactory()
	   def conducto = conductoFactory.creaConducto([referencia:"referencia",longitud:"5",
		   red:new TipoRed(),
		   tipoCanal:new TipoCanal(),
		   descripcion:"descripcion",
		   ubicacion:"Al este"],1)
	   
	   return conducto
		   
   }
}
