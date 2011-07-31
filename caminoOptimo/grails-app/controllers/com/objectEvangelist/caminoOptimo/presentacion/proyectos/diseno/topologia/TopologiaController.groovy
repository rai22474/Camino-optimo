package com.objectEvangelist.caminoOptimo.presentacion.proyectos.diseno.topologia

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*

/**
 * Clase encargarda de llevar el flujo del diseño de proyecto.
 *
 */
class TopologiaController {

	/**
	 * Factoria de conductos.
	*/
    def conductoFactory
	
	/**
	 * Factoria de bandeja.
	*/
	def bandejaFactory
	
	def index = {
        redirect(action: "topologia", params: params)
    }
	 
	
	def topologia = {
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
		
		def tiposRed = TipoRed.findAllByDiseno(proyecto.getDiseno())
		def equipos = Equipo.findAllByDiseno(proyecto.getDiseno()) 
		def canalizaciones = CanalizacionCompuesta.findAllByDiseno(proyecto.getDiseno())
				
		[canalizaciones:canalizaciones, tiposRed:tiposRed, equipos:equipos]		
	} 
	
	/**
	 * Flujo para editar topologia.
	 */
	def editarTopologia = {	
		
		def elementoTopologia = ElementoTopologia.get(params.idElementoTopologia)
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
				
		def (listaBandejas, listaConductos) = recuperarCanalizaciones(elementoTopologia,proyecto.getDiseno())
		[elementoTopologia: elementoTopologia,
		 equipos:Equipo.findAllByDiseno(proyecto.getDiseno()),
		 bandejas:listaBandejas,
		 conductos:listaConductos]
	}

	/**
	 * Crear un nuevo equipo.
	 */
	def creaEquipo ={
		def equipoInstance = new Equipo()
        equipoInstance.properties = params
	    [equipoInstance:equipoInstance,
	 	 idElementoTopologia:params.idElementoTopologia]

	}
	/**
	* Metodo que sirve para salvar el conducto.
	*/
   def salvaEquipo = {
	   def equipoInstance = new Equipo(params)
	   
	   if (equipoInstance.save(flush: true)) {
		   flash.message = "${message(code: 'default.created.message', args: [message(code: 'equipo.label', default: 'Equipo'), equipoInstance.id])}"
		   redirect(action: "editarTopologia", params:["idElementoTopologia": params.idElementoTopologia])
	   }
	   else {
		   render(view: "creaEquipo", model: [equipoInstance: equipoInstance,
											  idElementoTopologia:params.idElementoTopologia])
	   }
   }
   
	
	/**
	 * Accion que sirve para conectar dos elementos de topologia.
	 */
	def conectarCanalizacion = {
		conectar(params.elementoOriginal, params.seccionConectar)
	}
	
	/**
	* Accion que sirve para conectar un equipo.
	*/
   def conectarEquipo = {
	   conectar(params.elementoOriginal, params.equipoConectar)
   }
	
   /**
   * Crea una nueva bandeja.
   */
   def creaBandeja ={
	  def bandejaInstance = new Bandeja()
	  bandejaInstance.properties = params
	  
	  def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
	  	  
	  def tiposRed = TipoRed.findAllByDiseno(proyecto.getDiseno())
	  def tiposBandeja = TipoBandeja.findAllByDiseno(proyecto.getDiseno())
	  
	  [bandejaInstance:bandejaInstance,
		tiposRed:tiposRed,
		tiposBandeja:tiposBandeja,  
		idElementoTopologia:params.idElementoTopologia]
   }
  
   /**
	 * Metodo que conecta dos elementos de topologia
	 */
	def conectar(elementoId, elementoConectarId){
		def elementoTopologia = ElementoTopologia.get(elementoId)
		def elementoConectar = ElementoTopologia.get(elementoConectarId)
		
		elementoTopologia.conecta (elementoConectar, TipoConexion.TOPOLOGIA)
		elementoTopologia.save()
		redirect(action: "editarTopologia", params:["idElementoTopologia": params.idElementoTopologia])
	}
	
	/**
	* Metodo que sirve para salvar el conducto.
	*/
	def salvaBandeja = {
		def bandejaInstance = bandejaFactory.creaBandeja(params)
		
		if (bandejaInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'bandeja.label', default: 'Bandeja'), bandejaInstance.id])}"
			redirect(action: "editarTopologia", params:["idElementoTopologia": params.idElementoTopologia])
		}
		else {
			render(view: "creaBandeja", model: [bandejaInstance: bandejaInstance,
						idElementoTopologia:params.idElementoTopologia])
		}
	}
      
	/**
	 * Flujo para crear un conducto.
	 */
	def creaConducto = {
		def conductoInstance = new Conducto()
        conductoInstance.properties = params
		
		def proyecto = Proyecto.get(session.getAttribute('identificadorProyecto'))
		
		def tiposRed = TipoRed.findAllByDiseno(proyecto.getDiseno())
		def tiposConducto = TipoConducto.findAllByDiseno(proyecto.getDiseno())
		
		
	    [conductoInstance:conductoInstance,
		 tiposRed:tiposRed,
		 tiposConducto:tiposConducto,	
	 	 idElementoTopologia:params.idElementoTopologia]
	}
	
	/**
	 * Metodo que sirve para salvar el conducto.
	 */
	def salvaConducto = {		
		def conductoInstance = conductoFactory.creaConducto(params)
		
		if (conductoInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'conducto.label', default: 'Conducto'), conductoInstance.id])}"
            redirect(action: "editarTopologia", params:["idElementoTopologia": params.idElementoTopologia])
        }
        else {
            render(view: "creaConducto", model: [conductoInstance: conductoInstance,
				                                 idElementoTopologia:params.idElementoTopologia])
        }
	}
	
	
	
	/**
	 * Cancelar el salvar el conducto
	 */
	def cancelaSalvar = {
		redirect(action: "editarTopologia",params:["idElementoTopologia": params.idElementoTopologia])
	}
	
	/**
	 * Metodo que va a devolver la lista de bandejas y conductos.
	 */
	private def recuperarCanalizaciones(elementoTopologia,diseno){		
		if (!elementoTopologia.obtenerTipoElementoTopologia().equals(TipoElementoTopologia.EQUIPO)){
			def tipoRed = elementoTopologia.red			
			[Bandeja.findAllByRedAndDiseno(tipoRed,diseno),Conducto.findAllByRedAndDiseno(tipoRed,diseno)]
		}
		else{
			[Bandeja.findAllByDiseno(diseno),Conducto.findAllByDiseno(diseno)]
		}
	}
}
