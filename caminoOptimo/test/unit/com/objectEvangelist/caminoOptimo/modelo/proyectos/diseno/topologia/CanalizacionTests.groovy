
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
	 * Prueba que se calcula el porcentaje de sección ocupada.
	 */
	void testCalculaPorcetajeSeccionOcupadaCienPorCien(){
			
		def Canalizacion canalizacion = creaCanalizacionOcupada(12,12)		
		def porcentajeOcupacion = canalizacion.calculaPorcentajeSeccionOcupada()
		
		assertEquals "El porcentaje debe ser 100%",1,porcentajeOcupacion			
	}

	/**
	* Prueba que se calcula el procentaje de sección ocupada.
	*/
   void testCalculaPorcetajeSeccionOcupadaCincuentaPorCiento(){
		   
	   def Canalizacion canalizacion = creaCanalizacionOcupada(6,12)
	   
	   def porcentajeOcupacion = canalizacion.calculaPorcentajeSeccionOcupada()
	   
	   assertEquals "El porcentaje debe ser 50%",0.50,porcentajeOcupacion
   }
	
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
	
	/**
	 * Crea una canalizacion con seccion util y ocupada 
	 */
	private creaCanalizacionOcupada(final seccionOcupada, final seccionUtil) {
		new Canalizacion(){
			
			public Object calculaSeccionOcupada() {
				return seccionOcupada
			}
			
			public calculaSeccionUtil(){
				return seccionUtil
			}
		}
	}
}
