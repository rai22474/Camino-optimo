package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import grails.test.*

class ComponenteCanalizacionTests extends GrailsUnitTestCase {
   	
	/**
	* Prueba como devuelve la sección util.
	*/
   void testCalculaSeccionUtil() {
	   def canalizacion = creaMockCanalizacion()
	   def componenteCanalizacion = creaComponenteCanalizacionRecuperaPadres(canalizacion)
	   
	   def seccionUtil = componenteCanalizacion.calculaSeccionUtil()
	   
	   assertEquals "La sección util no es la esperada ",10,seccionUtil
   }
   
   /**
	* Devuelve 0 si no hay padres.
	*/
   void testCalculaSeccionUtilSiNoHayPadres(){
	   def canalizacion = creaComponenteCanalizacionRecuperaPadresVacios()
	   
	   def seccionUtil = canalizacion.calculaSeccionUtil()
	   
	   assertEquals "La sección util no es la esperada ",0,seccionUtil
   }

   /**
	* Crea un mock de la bandeja.
	*/
   private def creaMockCanalizacion(){
	   def canalizacion = mockFor(CanalizacionCompuesta, true)
	   canalizacion.demand.calculaSeccionUtil(1..1){->
		   return 10
	   }
	   
	   return canalizacion
   }
   
   /**
	* Devuelve una seccion para recuperar los padres.
	*/
   private def creaComponenteCanalizacionRecuperaPadres(final canalizacion) {
	   def componente = new ComponenteCanalizacion(){
		   def recuperaPadres(tipoConexion) {
			   return [canalizacion.createMock()]
		   }
	   }
			   
	   return componente
   }
   
   /**
   * Devuelve una seccion para recuperar los padres.
   */
  private def creaComponenteCanalizacionRecuperaPadresVacios() {
	  def componente = new ComponenteCanalizacion(){
		  def recuperaPadres(tipoConexion) {
			  return []
		  }
	  }
			  
	  return componente
  }
  
}
