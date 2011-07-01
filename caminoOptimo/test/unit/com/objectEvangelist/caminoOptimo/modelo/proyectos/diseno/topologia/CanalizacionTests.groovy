
package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import grails.test.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*


/**
 * Clase encargada de probar los metodos de la canalizacion.
 * 
 */
class CanalizacionTests extends GrailsUnitTestCase {
  			
	
  /**
   * Metodo que calcula la seccion ocupada de una canalizacion.  
   */
   void testCalculaSeccionOcupada(){
	  
	   mockDomain(Canalizacion,[])
	   mockDomain(Cable,[])
	   mockDomain(TipoCable,[])
	   
	   def tipoCable = new TipoCable(seccionExterior:10)
	   def tipoCableSegundo = new TipoCable(seccionExterior:20)
	   
	   def cable = new Cable(referencia:"referencia",tipoCable:tipoCable)
	   def cableSegundo = new Cable(referencia:"referenciaSegundo",tipoCable:tipoCableSegundo)
	   
	   def canalizacion = new Canalizacion(referencia:"referencia")
	   canalizacion.agregaCable (cable)
	   canalizacion.agregaCable (cableSegundo)
	   
	   def seccionOcupada = canalizacion.calculaSeccionOcupada()
	   
	   assertEquals 'La seccion ocupada debe ser la suma de las secciones exteriores de los cables',30,seccionOcupada
	   	    
   }
}
