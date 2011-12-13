package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import grails.test.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*

/**
 * Clase encargada de probar 
 * 
 */
class CanalizacionCompuestaTests extends GrailsUnitTestCase {
  			
	/**
	 * Metodo que agrega un cable a una bandeja.
	 */
	void testAgregarCable(){
			
		Cable cable = new Cable(referencia:"referenciaCable")
		def canalizacionCompuesta = creaCanalizacionCompuestaPrueba()
		canalizacionCompuesta.agregaCable(cable)
				
		def elementosTopologia = canalizacionCompuesta.recuperaHijos(TipoConexion.ESTRUCTURA)
		
		assertTrue 'Debe tener un cable asignado',elementosTopologia[0].getCables().size() == 1
		assertTrue 'La segunda seccion debe tener un cable asignado',elementosTopologia[1].getCables().size() == 1
	}
	
	/**
	* Metodo que agrega un cable a una bandeja.
	*/
   void testEliminaCable(){
	   def canalizacionCompuesta = creaCanalizacionCompuestaPrueba()
	   
	   //Preparacion
	   Cable cable = new Cable(referencia:"referenciaCable")	   
	  
	   def elementosTopologia = canalizacionCompuesta.recuperaHijos(TipoConexion.ESTRUCTURA)
	   elementosTopologia[0].agregaCable(cable)
	   elementosTopologia[1].agregaCable(cable)
	   
	   //Prueba
	   canalizacionCompuesta.eliminaCable(cable)
	   	   	   
	   assertTrue 'No debe tener un cable asignado',elementosTopologia[0].getCables().size() == 0
	   assertTrue 'La segunda seccion no debe tener un cable asignado',elementosTopologia[0].getCables().size() == 0
   }
   
  /**
   * Metodo que calcula el llenado de la seccion ocupada.
   */
   void testCalculaSeccionOcupada(){
	   
	   def primerElementoTopologia = [calculaSeccionOcupada:{8}] as Canalizacion
	   def segundoElementoTopologia = [calculaSeccionOcupada:{4}] as Canalizacion
	   def tercerElementoTopologia = [calculaSeccionOcupada:{2}] as Canalizacion
	   
	   def canalizacionCompuesta = new CanalizacionCompuesta(){			
		   def recuperaHijos(tipoConexion){
		   		return [primerElementoTopologia, segundoElementoTopologia,tercerElementoTopologia]
		   }  
	   } 
	
	   def llenadoCanalizacion = canalizacionCompuesta.calculaSeccionOcupada()
	   
	   assertEquals 'El llenado debe ser el maximo', llenadoCanalizacion, 8   
   }
    
   /**
    * Crea una bandeja con secciones para las prueba
    */
   private creaCanalizacionCompuestaPrueba(){
	   mockDomain (CanalizacionCompuesta,[])
	   mockDomain (ElementoTopologia,[])
	   mockDomain (Cable,[])
	   
	   CanalizacionCompuesta canalizacionCompuesta = new CanalizacionCompuesta(referencia:"1234")
	   
	   ElementoTopologia elementoTopologia = new ElementoTopologia(referencia:"referenciaSeccion")
	   ElementoTopologia segundoElementoTopologia =  new ElementoTopologia(referencia:"segundaSeccion")
	   
	   canalizacionCompuesta.conecta (elementoTopologia,TipoConexion.ESTRUCTURA)
	   canalizacionCompuesta.conecta (segundoElementoTopologia,TipoConexion.ESTRUCTURA)
   
	   return canalizacionCompuesta
   }
}
