package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.factory

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto

/**
 * Clase encargada de crear conductos
 *
 */
class ConductoFactory {

	/**
	 * Prefijo inicial
	 */
	static String PREFIJO_EXTREMO_INICIAL = "Inicio"
	
	/**
	* Prefijo inicial
	*/
   static String PREFIJO_EXTREMO_FINAL = "Fin"
	
	/**
	 * Metodo que sirve para crear un conducto.
	 */
	def creaConducto(valores,identificadorProyecto){
		def conducto = new Conducto(valores)
		
		def proyecto = Proyecto.get(identificadorProyecto)		
		proyecto.getDiseno().agregaCanalizacion(conducto)
		
		conducto.validate()
		
		if (conducto.errors.allErrors.size() == 0){
			creaExtremos(conducto)
		}
		
		return conducto
	}
	
	/**
	 * Metodo que crea los extremos de un conducto
	 */
	private def creaExtremos(conducto){
		def extremoInicial = creaExtremoConducto(PREFIJO_EXTREMO_INICIAL + "/" + conducto.referencia)
		def extremoFinal = creaExtremoConducto(PREFIJO_EXTREMO_FINAL + "/" +conducto.referencia)
		conducto.conecta(extremoInicial,TipoConexion.ESTRUCTURA)
		conducto.conecta(extremoFinal,TipoConexion.ESTRUCTURA)
		extremoInicial.conecta(extremoFinal,TipoConexion.COMPOSICION)
	}
	
	/**
	 * Metodo que crea uno de los extremos del conducto. 
	 *
	 */
	private def creaExtremoConducto(nombreExtremo){
		
		def extremo = new ExtremoConducto(referencia:nombreExtremo)
		if (!extremo.save()){
			extremo.errors.allErrors.each{error ->
				println "Ha ocurrido un error al crear entidad: ${error}"
			}
		}
		
		return extremo		
	}
	
}
