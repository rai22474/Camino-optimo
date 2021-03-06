package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

import groovy.transform.EqualsAndHashCode;

import java.io.Serializable;

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.Diseno;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*


/**
 * Cada uno de los elementos que forman la topologia.
 *
 */
@EqualsAndHashCode
class ElementoTopologia implements Serializable{
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "$referencia";
	}
			
	/**
	 * Devuelve aquellos elementos con los que estoy conectado.
	 */
	def recuperaHijos(){		
		def hijos = [] 
		
		getHijos().each {conexion-> 
			hijos.add(conexion.getHijo())
		}
		
		return hijos
	}
	
	/**
	 * Devuelve aquellos elementos con los que estoy conectado.
	 */
	def recuperaHijos(tipoConexion){		
		def hijos = [] 		
		getHijos().each {conexion-> 
			if (conexion.getTipoConexion().equals(tipoConexion)){
				hijos.add(conexion.getHijo())
			}
		}
		
		return hijos
	}		
	
	/** 
	 * Devuelve aquellos elementos que estan conectado conmigo.
	 */
	def recuperaPadres(){
		def padres = []
		getPadres().each {conexion->
			padres.add(conexion.getPadre())	
		}
		
		return padres
	}	
	
	/**
	 * Devuelve aquellos elemento conectados conmigo por tipo
	 */
	def recuperaPadres(tipoConexion){
		def padres = []
		getPadres().each {conexion->
			if (conexion.getTipoConexion().equals(tipoConexion)){
				padres.add(conexion.getPadre())	
			}
		}
		
		return padres
	}									
	
	/**
	 * Metodo que sirve para conectar un elemento con otro.
	 */
	def conecta(elementoHijo, tipoConexion){
		def conexion = new Conexion(tipoConexion: tipoConexion)
		addToHijos(conexion);
		elementoHijo.addToPadres(conexion)
		
		conexion.setPadre(this)
		conexion.setHijo(elementoHijo)
	}
				
	/**
	 * Recupera los elemento relacionados con el actual por tipo de conexion.
	 */
	def recuperaElementoRelacionados(tipoConexion){
		return recuperaHijos(tipoConexion) + recuperaPadres(tipoConexion)
	}
	
	/**
	 * Calcula todas las rutas posibles de un elemento.
	 */
	def calculaRutasPosibles(){			
		return this.calculaRutas(new Ruta(referencia:referencia))	
	}	
	
	/**
	* Calcula las rutas posibles entre dos elementos.
	*/
   public calculaRutasPosibles(elementoDestino){
	   
	   def rutasPosibles = []
	   def rutas = this.calculaRutas(new Ruta())
	  	   
	   rutas.each {rutaPosible-> 
	   	 	if (rutaPosible.contiene(elementoDestino)){
	   	 		rutasPosibles.add(rutaPosible)
			}
		}
	   
	   return rutasPosibles
    }   
   
	/**
	 * Metodo que agrega un cable
	 */
	def public agregaCable(Cable cable){
		println referencia + ' ' + cable.equipoDestino + ' ' + cable.equipoOrigen
		cables.add(cable)
		
		println "El cable salvado " + cables.size()
	}
	
	
	/**
	 * Agrega a cables a los hijo de un tipo.
	 */
	def protected agregaCableHijos(Cable cable,TipoConexion tipoConexion){
				
		recuperaHijos(tipoConexion).each {hijo->
			println "agrego el cable al hijo " + hijo
			hijo.agregaCable(cable)
		}
	}
	
	/**
	 * Cuando se agrega un cable a todos los hijos de una tipo.
	 */
	def protected eliminaCableHijos(cable,TipoConexion tipoConexion){
		recuperaHijos(tipoConexion).each {hijo->
			hijo.eliminaCable(cable)
		}
	}
	
	/**
	 * Metodo que elimina un cable
	 */
	def eliminaCable(cable){
		cables.remove(cable)
	}
	
   /**
	* Devuelve los elementos relacionados.
	*/
    private recuperaElementosRelacionados(){
	    return recuperaElementoRelacionados(TipoConexion.TOPOLOGIA) +
			   recuperaElementoRelacionados(TipoConexion.COMPOSICION)
    }
	
	/**
	 * Calcula las rutas posibles del elemento relacionado.
	 */
	private calculaRutas(ruta){		
		def rutasPosibles = []
		
		def elementoPrevio = ruta.ultimoSegmento()					
						
		def elementoRelacionados = this.recuperaElementosRelacionados()
		def elementosNoRelacionados = elementoRelacionados - (elementoPrevio?.recuperaElementosRelacionados() + elementoPrevio)
		
		ruta.conecta(this,TipoConexion.RUTA)
		
		if (!esFinalRuta(ruta,elementosNoRelacionados)){
			elementosNoRelacionados.each{elementoRelacionado->
				rutasPosibles += elementoRelacionado.calculaRutas(ruta.bifurca())
			}			
		}else{
			rutasPosibles.add(ruta)
		}

		return rutasPosibles
	}
	
	/**
	* Indica si de ese elemento no hay mas rutas posibles	
	*/
	def esFinalRuta(ruta,elementosRelacionadosHijoNoRelacionados){		
		return elementosRelacionadosHijoNoRelacionados.size() == 0 || 
			  (ruta.recuperaHijos(TipoConexion.RUTA).size() != 1 && ruta.primerSegmento().equals(this)) ||
			  (this.esElementoTopologiaFinal()	&& !ruta.primerSegmento().equals(this))		   
	}
	
	/**
	 * 
	 * Indica si un elemento de topologia.
	 */
	def esElementoTopologiaFinal(){
		return false
	}
	
	/**
	 * Devuelve el tipo de topologia que tiene esta clase. 
	 */
	TipoElementoTopologia obtenerTipoElementoTopologia(){}
	
	static constraints = {
		referencia(nullable:true)
		descripcion(nullable: true)
	}
	
	/**
	* La referencia del equipo.
	*/
   String referencia
   
   /**
   * Descripcion del canal.
   */
   String descripcion
																											
	/**
	 * Los elementos de topologia con los que estoy conectado y los que estan conectados conmigo.
	 */
	List padres
	List hijos
	static mappedBy = [padres:'hijo',
					   hijos:'padre',
					   cables:'elementosTopologia']
	
	static hasMany = [hijos:Conexion,
					  padres:Conexion,
					  cables:Cable]
	
	
	static belongsTo = [Cable,Conexion]
	
	/**
	 * La lista de cables que estan asociadas a ese elemento de topologia.
	 */
	Set cables
}
