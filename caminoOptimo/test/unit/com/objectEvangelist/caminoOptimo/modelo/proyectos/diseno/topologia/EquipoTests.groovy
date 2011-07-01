package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Equipo;


import grails.test.*

/**
 * Clase que prueba las clases que para un equipo.
 *
 */
class EquipoTests extends GrailsUnitTestCase {
   
   /**
    * Metodo encargado probar que no ser permiten referencias no nulas.
    */
	public void testReferenciaCableNoNula(){
		def equipo = new Equipo(referencia:null)
		
		mockForConstraintsTests(Equipo, [ equipo ])
		
		assertFalse 'El referencia del equipo no puede ser nula ', equipo.validate()
		assertEquals 'Debe dar un error de equipo',"nullable", equipo.errors["referencia"]
	}
	
	/**
    * Metodo encargado probar que no se permiten referencias no nulas.
    */
	public void testReferenciaCableNoVacia(){
		def equipo = new Equipo(referencia:"")
		
		mockForConstraintsTests(Equipo, [ equipo ])
		
		assertFalse 'El referencia del equipo no puede ser vacia ', equipo.validate()
		assertEquals 'Debe dar un error de equipo',"blank", equipo.errors["referencia"]
	}
	
	/**
	 * Metodo encargado de probar que no se permiten referencias únicas.
	 */
	public void testReferenciaCableUnica(){
		def equipo = new Equipo(referencia:"12345")
		def equipoDuplicado = new Equipo(referencia:"12345")
		
		mockForConstraintsTests(Equipo, [ equipo, equipoDuplicado ])
		
		assertFalse 'La referencia no puede estar duplicada ', equipoDuplicado.validate()
		assertEquals 'Debe dar un error de referencia duplicada',"unique", equipoDuplicado.errors["referencia"]       	
	}
	
	/**
	 * Metodo que prueba el método toString
	 */
	public void testToString(){
		def equipo = new Equipo(referencia:"12345")
		assertEquals 'No es la descripcion esperada',"12345", equipo.toString()			
	}
	
	/**
	* Calcula una ruta entre elementos finales.
	*/
   public void testElementoTopologiaConElementoFinal(){
	   
	   mockDomain(ElementoTopologia,[])
	   
	   def elementoTopologia = new ElementoTopologia(referencia:"referencia")
	   def elementoTopologia1 = new Equipo(referencia:"equipo1")
	   def elementoTopologia2 = new ElementoTopologia(referencia:"referencia2")
	   def elementoTopologia3 = new ElementoTopologia(referencia:"referencia3")
	   
	   elementoTopologia.conecta (elementoTopologia1, TipoConexion.COMPOSICION)
	   elementoTopologia1.conecta (elementoTopologia2, TipoConexion.COMPOSICION)
	   elementoTopologia2.conecta (elementoTopologia3, TipoConexion.COMPOSICION)
	   elementoTopologia3.conecta (elementoTopologia, TipoConexion.COMPOSICION)
	   
	   def rutas = elementoTopologia.calculaRutasPosibles()
	   
	   assertEquals 'El numero de rutas no es el esperado ',rutas.size(),2
	   assertEquals 'El numero de segmentos debe ser 2', rutas[0].recuperaHijos(TipoConexion.RUTA).size(),2
   }
   
   /**
   * Calcula una ruta entre elementos finales.
   */
  public void testRutaEntreEquipos(){
	  
	  mockDomain(ElementoTopologia,[])
	  
	  def equipo = new Equipo(referencia:"Equipo")
	  def elementoTopologia1 = new ElementoTopologia(referencia:"referencia") 
	  def elementoTopologia2 = new ElementoTopologia(referencia:"referencia2")
	  def elementoTopologia3 = new ElementoTopologia(referencia:"referencia3")	  
	  def equipoFinal = new Equipo(referencia:"Equipo1")
	  
	  equipo.conecta (elementoTopologia1, TipoConexion.COMPOSICION)
	  elementoTopologia1.conecta (elementoTopologia2, TipoConexion.COMPOSICION)
	  elementoTopologia2.conecta (elementoTopologia3, TipoConexion.COMPOSICION)
	  elementoTopologia3.conecta (equipoFinal, TipoConexion.COMPOSICION)
	  	  
	  def rutas = equipo.calculaRutasPosibles()
	  
	  assertEquals 'El numero de rutas no es el esperado ',rutas.size(),1
	  assertEquals 'El numero de segmentos debe ser 5', rutas[0].recuperaHijos(TipoConexion.RUTA).size(),5
  }
}
