package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import grails.test.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*;

/**
 * Prueba el elemento de topologia.
 *
 */
class ElementoTopologiaTests extends GrailsUnitTestCase {
	
	/**
	 * Metodo que sirve para probar conexiones
	 */
	void testElementosHijo() {
		
		def elementoTopologiaHijo = new ElementoTopologia(referencia:"referenciaHijo")	
		def conexion = new Conexion()
		
		def elementoTopologia = [getHijos: {[conexion]}] as ElementoTopologia 
		elementoTopologia.setReferencia('referenciaPadre')
		
		conexion.setPadre (elementoTopologia)
		conexion.setHijo(elementoTopologiaHijo)
		
		def hijos = elementoTopologia.recuperaHijos()
		
		assertNotNull 'Los elementos que conecto no son nulos ', hijos
		assertEquals 'El primer elemento debe ser hijo', elementoTopologiaHijo,hijos[0]
	}
	
	/**
	 * Metodo que sirve para probar conexiones
	 */
	void testElementosHijosPorTipo() {
		
		def elementoTopologiaHijo = new ElementoTopologia(referencia:"referenciaHijo")	
		def conexion = new Conexion()
		def conexionDistinta = new Conexion()
		
		def elementoTopologia = [getHijos: {[conexion, conexionDistinta]}] as ElementoTopologia 
		elementoTopologia.setReferencia('referenciaPadre')
		
		conexion.setHijo(elementoTopologiaHijo)
		conexion.setPadre (elementoTopologia)
		conexion.setTipoConexion(TipoConexion.TOPOLOGIA)	
		
		conexionDistinta.setHijo(elementoTopologiaHijo)
		conexionDistinta.setPadre (elementoTopologia)
		
		def hijos = elementoTopologia.recuperaHijos(TipoConexion.TOPOLOGIA)
		
		assertNotNull 'Los elementos que conecto no son nulos ', hijos
		assertTrue 'Debe devolver un elemento', hijos.size() == 1
		assertEquals 'El primer elemento debe ser hijo', elementoTopologiaHijo,hijos[0]
	}
	
	/**
	 * Metodo que sirve para probar conexiones
	 */
	void testElementosPadres() {
		def elementoTopologiaHijo = new ElementoTopologia(referencia:"referenciaHijo")	
		def conexion = new Conexion()
		
		def elementoTopologia = [getPadres: {[conexion]}] as ElementoTopologia 
		elementoTopologia.setReferencia('referenciaPadre')
		conexion.setHijo(elementoTopologia)
		conexion.setPadre (elementoTopologiaHijo)	
		
		def padres = elementoTopologia.recuperaPadres()
		
		assertNotNull 'Los elementos que conecto no son nulos ', padres
		assertEquals 'El primer elemento debe ser hijo', elementoTopologiaHijo,padres[0]
	}
	
	/**
	 * Metodo que sirve para probar conexiones
	 */
	void testElementosPadresPorTipo() {
		def elementoTopologiaHijo = new ElementoTopologia(referencia:"referenciaHijo")	
		def conexion = new Conexion()
		def conexionDistinta = new Conexion()
		
		def elementoTopologia = [getPadres: {[conexion, conexionDistinta]}] as ElementoTopologia 
		elementoTopologia.setReferencia('referenciaPadre')
		
		conexion.setHijo(elementoTopologia)
		conexion.setPadre (elementoTopologiaHijo)
		conexion.setTipoConexion(TipoConexion.TOPOLOGIA)	
		
		conexionDistinta.setHijo(elementoTopologia)
		conexionDistinta.setPadre (elementoTopologiaHijo)
		
		def padres = elementoTopologia.recuperaPadres (TipoConexion.TOPOLOGIA)
		
		assertNotNull 'Los elementos que conecto no son nulos ', padres
		assertTrue 'Debe devolver un elemento', padres.size() == 1
		assertEquals 'El primer elemento debe ser hijo', elementoTopologiaHijo,padres[0]
	}
	
	/**
	 * Prueba como se conectan las bandejas.
	 */
	void testConectar(){
		
		mockDomain(ElementoTopologia,[])
		mockDomain(Conexion,[])
		def elementoTopologiaPadre = new ElementoTopologia(referencia:"referenciaPadre")	
		def elementoTopologiaHijo = new ElementoTopologia(referencia:"referenciaHijo")	
		
		elementoTopologiaPadre.conecta(elementoTopologiaHijo,TipoConexion.TOPOLOGIA)
		
		assertTrue 'Debe haber un elemento conectado', elementoTopologiaPadre.getHijos().size() == 1
		assertTrue 'Debe tener un elemento conectado', elementoTopologiaHijo.getPadres().size() == 1
		assertTrue 'No debe tener un elemento conectado', elementoTopologiaPadre.getPadres() == null
		
		def conexion = elementoTopologiaPadre.getHijos().asList()[0]
		
		assertEquals 'El padre no es el correcto', conexion.getPadre(),elementoTopologiaPadre
		assertEquals 'El hijo no es el correcto',conexion.getHijo(),elementoTopologiaHijo
	}
	
	/**
	 * Prueba que ocurre cuando no hay ninguna ruta vacia. No hay conexiones.
	 */
	void testRutaVaciaNoHayConexiones(){
		
		mockDomain(ElementoTopologia,[])
		mockDomain(Ruta,[])
		
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		
		def rutas = elementoTopologia.calculaRutasPosibles() 
		
		assertNotNull 'Debe dar una ruta vacia', rutas	
		assertEquals 'Debe ser una lista vacia',rutas.size(), 1
	}
	
	/**
	 * Test que ocurre cuando encuentra una ruta.
	 */
	void testEncuentraRutas(){
		mockDomain(ElementoTopologia,[])
		mockDomain(Ruta,[])
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		conectarElementosHijos(elementoTopologia,1,TipoConexion.TOPOLOGIA)	
		def rutas = elementoTopologia.calculaRutasPosibles()
		
		assertNotNull 'No debe dar una ruta vacia', rutas
		assertEquals 'Debe ser una ruta ',rutas.size(), 1
		assertTrue 'Debe ser una ruta', rutas[0] instanceof Ruta
	}
	
	/**
	 * Calcula varias rutas
	 */
	void testVariosHijosGeneranVariasRutasTopologia(){		
		pruebaVariosHijosGeneranVariasRutas(4,TipoConexion.TOPOLOGIA)
	}
	
	/**
	 * Calcula una unica ruta
	 */
	void testSegmentosRutaConexionTopologia(){	
		pruebaSegmentosRuta(1,TipoConexion.TOPOLOGIA)
	}
	
	/**
	 * Calcula varias rutas
	 */
	void testVariosHijosGeneranVariasRutasComposicion(){
		pruebaVariosHijosGeneranVariasRutas(4,TipoConexion.COMPOSICION)
	}
	
	/**
	 * Calcula una unica ruta
	 */
	void testSegmentosRutaConexionComposicion(){
		pruebaSegmentosRuta(1,TipoConexion.COMPOSICION)
	}
	
	/**
	 * Calcula varias rutas
	 */
	void testVariosPadresGeneranVariasRutasComposicion(){
		pruebaVariosPadresGeneranVariasRutas(6,TipoConexion.COMPOSICION)
	}
	
	/**
	 * Calcula varias rutas
	 */
	void testVariosPadresGeneranVariasRutasTopologia(){
		pruebaVariosPadresGeneranVariasRutas(6,TipoConexion.TOPOLOGIA)
	}
	
	/**
	 * Calcula varias rutas
	 */
	void testVariosPadresHijosGeneranVariasRutas(){
		mockDomain(ElementoTopologia,[])
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		conectarElementosPadres(elementoTopologia,4,TipoConexion.COMPOSICION)
		conectarElementosHijos(elementoTopologia,2,TipoConexion.TOPOLOGIA)
		
		def rutas = elementoTopologia.calculaRutasPosibles()
		
		assertEquals 'El numero de rutas no es el esperado ',rutas.size(),6
	}
	
	/**
	 * Calcula varias rutas de un hijos con un nivel de hijos
	 */
	void testVariosHijosUnNivelHijos(){
		mockDomain(ElementoTopologia,[])
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		conectarElementosHijos(elementoTopologia,3,TipoConexion.TOPOLOGIA)
		
		elementoTopologia.getHijos().each {hijo-> 
			conectarElementosHijos(hijo.getHijo(),3,TipoConexion.COMPOSICION)
		}
		
		def rutas = elementoTopologia.calculaRutasPosibles()
		
		assertEquals 'El numero de rutas no es el esperado ',rutas.size(),9
	}
	
	/**
	* Calcula varias rutas de un hijos con un nivel de hijos
	*/
   void testVariosHijosVariosNivelesHijos(){
	   mockDomain(ElementoTopologia,[])
	   def elementoTopologia = new ElementoTopologia(referencia:"referencia")
	   conectarElementosHijos(elementoTopologia,3,TipoConexion.TOPOLOGIA)
	   
	   elementoTopologia.getHijos().each {conexion->
		   
		   def hijoPrimerNivel = conexion.getHijo()
		   conectarElementosHijos(hijoPrimerNivel,3,TipoConexion.COMPOSICION)
		   
		   hijoPrimerNivel.getHijos().each{conexionHijo->
			   conectarElementosHijos(conexionHijo.getHijo(),3,TipoConexion.TOPOLOGIA)
		   }
	   }
	   
	   def rutas = elementoTopologia.calculaRutasPosibles()
	   
	   assertEquals 'El numero de rutas no es el esperado ',rutas.size(),27
   }
   
	/**
	 * Calcula varias rutas de un hijos con un nivel de hijos
	 */
	void testRutaEntreDosElementos(){
		mockDomain(ElementoTopologia,[])
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		conectarElementosHijos(elementoTopologia,3,TipoConexion.TOPOLOGIA)
		
		def ultimoHijo 
		
		elementoTopologia.getHijos().each {conexion->
			
			def hijoPrimerNivel = conexion.getHijo()
			conectarElementosHijos(hijoPrimerNivel,3,TipoConexion.COMPOSICION)
			
			hijoPrimerNivel.getHijos().each{conexionHijo->
				def hijoSegundoNivel = conexionHijo.getHijo()
				conectarElementosHijos(hijoSegundoNivel,3,TipoConexion.TOPOLOGIA)
				ultimoHijo = hijoSegundoNivel
			}
		}
		
		def rutas = elementoTopologia.calculaRutasPosibles(ultimoHijo)
		
		assertEquals 'Solo hay una ruta posible',rutas.size(),3
  }
   
	/**
	 * Calcula varias rutas de un hijos con un nivel de hijos
	 */
	public void testVariosHijosVariosNivelesPadres(){
		mockDomain(ElementoTopologia,[])
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		conectarElementosPadres(elementoTopologia,3,TipoConexion.TOPOLOGIA)
		
		elementoTopologia.getPadres().each {conexion->
			
			def padrePrimerNivel = conexion.getPadre()
			conectarElementosPadres(padrePrimerNivel,4,TipoConexion.COMPOSICION)
			
			padrePrimerNivel.getPadres().each{conexionPadre->
				conectarElementosHijos(conexionPadre.getPadre(),2,TipoConexion.TOPOLOGIA)
			}
		}
		
		def rutas = elementoTopologia.calculaRutasPosibles()
		
		assertEquals 'El numero de rutas no es el esperado ',rutas.size(),24
	}
	
	/**
	 * Calcula varias rutas de padres con varios niveles de padres
	 */
	public void testVariosPadresUnNivelPadres(){
		mockDomain(ElementoTopologia,[])
		
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		conectarElementosPadres(elementoTopologia,4,TipoConexion.TOPOLOGIA)
		
		elementoTopologia.getPadres().each {padre->
			conectarElementosPadres(padre.getPadre(),3,TipoConexion.COMPOSICION)
		}
		
		def rutas = elementoTopologia.calculaRutasPosibles()
		
		assertEquals 'El numero de rutas no es el esperado ',rutas.size(),12
	}
	
	/**
	 * Calcula varias rutas con un padre y un nivel de hijos
	 */
	public void testVariosPadresUnNivelHijos(){
		mockDomain(ElementoTopologia,[])
		
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		conectarElementosPadres(elementoTopologia,3,TipoConexion.TOPOLOGIA)
		
		elementoTopologia.getPadres().each {padre->
			conectarElementosHijos(padre.getPadre(),6,TipoConexion.COMPOSICION)
		}
		
		def rutas = elementoTopologia.calculaRutasPosibles()
		
		assertEquals 'El numero de rutas no es el esperado ',rutas.size(),18
	}
	
	/**
	 * Calcula una ruta cuando la ruta acaba y empieza en el mismo elemento.
	 */
	public void testRutaCircular(){
		
		mockDomain(ElementoTopologia,[])
		
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		def elementoTopologia1 = new ElementoTopologia(referencia:"referencia1")
		def elementoTopologia2 = new ElementoTopologia(referencia:"referencia2")
		def elementoTopologia3 = new ElementoTopologia(referencia:"referencia3")
		
		elementoTopologia.conecta (elementoTopologia1, TipoConexion.COMPOSICION)
		elementoTopologia1.conecta (elementoTopologia2, TipoConexion.COMPOSICION)
		elementoTopologia2.conecta (elementoTopologia3, TipoConexion.COMPOSICION)
		elementoTopologia3.conecta (elementoTopologia, TipoConexion.COMPOSICION)
		
		def rutas = elementoTopologia.calculaRutasPosibles()
		
		assertEquals 'El numero de rutas no es el esperado ',rutas.size(),2
		assertEquals 'El numero de segmentos debe ser 4', rutas[0].recuperaHijos(TipoConexion.RUTA).size(),5
	}
	
	/**
	 * Metodo que prueba que se agrega un nuevo cable.
	 */
	public void testAgregaCable(){
	
		mockDomain(ElementoTopologia,[])
		mockDomain(Cable,[])
		
		ElementoTopologia elementoTopologia = new ElementoTopologia(referencia:"referencia")		
		Cable cable = new Cable(referencia:"referencia")
		
		elementoTopologia.agregaCable(cable)
		
		assertTrue 'Debe tener un cable asociado',elementoTopologia.getCables().size() == 1		
	}
	
	
	/**
	* Metodo que elimina un calbe.
	*/
   public void testEliminaCable(){
   
	   mockDomain(ElementoTopologia,[])
	   mockDomain(Cable,[])
	   
	   ElementoTopologia elementoTopologia = new ElementoTopologia(referencia:"referencia")
	   Cable cable = new Cable(referencia:"referencia")
	   
	   elementoTopologia.agregaCable(cable)
	   elementoTopologia.eliminaCable(cable)
	   
	   assertTrue 'Debe tener un cable asociado',elementoTopologia.getCables().size() == 0
   }
	
	/**
	 * Calcula varias rutas.
	 */
	void pruebaVariosHijosGeneranVariasRutas(numeroElementosAConectar,tipoConexion){
		mockDomain(ElementoTopologia,[])
		
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		conectarElementosHijos(elementoTopologia,numeroElementosAConectar,tipoConexion)
		def rutas = elementoTopologia.calculaRutasPosibles()
		
		assertEquals 'El numero de rutas hijas no es el esperado',rutas.size(), numeroElementosAConectar
	}
	
	/**
	 * Calcula varias rutas
	 */
	void pruebaVariosPadresGeneranVariasRutas(numeroElementosAConectar,tipoConexion){
		mockDomain(ElementoTopologia,[])
		
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		conectarElementosPadres(elementoTopologia,numeroElementosAConectar,tipoConexion)
		def rutas = elementoTopologia.calculaRutasPosibles()
		
		assertEquals 'El numero de rutas no es el esperado ',rutas.size(),numeroElementosAConectar
	}
	
	/**
	 * Un ruta al menos debe tener un segmento
	 */
	def pruebaSegmentosRuta(numeroElementosAConectar,tipoConexion){
		mockDomain(ElementoTopologia,[])
		
		def elementoTopologia = new ElementoTopologia(referencia:"referencia")
		
		conectarElementosHijos(elementoTopologia,numeroElementosAConectar,tipoConexion)
		def rutas = elementoTopologia.calculaRutasPosibles()
		
		assertEquals 'La lista debe tener dos segmentos elemento', rutas[0].recuperaHijos(TipoConexion.RUTA).size(), 2
	}
	
	/**
	 * Crea una topologia con dos elementos conectados
	 */
	def conectarElementosHijos(elementoTopologia,numeroElementosAConectar,tipoConexion){
		
		mockDomain(Conexion,[])
		
		(0..numeroElementosAConectar - 1).each{i->
			def elementoTopologiaIntermedio = new ElementoTopologia(referencia:elementoTopologia.referencia + "Intermedio" + i)
			elementoTopologia.conecta (elementoTopologiaIntermedio,tipoConexion)
		}
		
		return elementoTopologia
	}
	
	/**
	 * Crea una topologia con dos elementos conectados
	 */
	def conectarElementosPadres(elementoTopologia,numeroElementosAConectar,tipoConexion){
		mockDomain(Conexion,[])
		
		(0..numeroElementosAConectar - 1).each{i->
			def elementoTopologiaIntermedio = new ElementoTopologia(referencia:elementoTopologia.referencia + "padre" + i)
			elementoTopologiaIntermedio.conecta (elementoTopologia,tipoConexion)
		}
		
		return elementoTopologia
	}
}
