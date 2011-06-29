package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.factory

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto
/**
 * Factoria para crear las bandejas.
 *
 */
class BandejaFactory {

	/**
	 * Prefijo de todas las secciones de una bandeja.
	 */
	static final String PREFIJO_SECCION = "Sec" 
		
	/**
	 * Prefijo para la separacion de la bandeja.
	 */
	static final String SEPARADOR_BANDEJA = "/"

	/**
	 * Crea una nueva bandeja con el numero de secciones. 
	 */
	def creaBandeja(valores,identificadorProyecto){
		def bandeja = new Bandeja(valores)
		def proyecto = Proyecto.get(identificadorProyecto)
		proyecto.getDiseno().agregaCanalizacion(bandeja)
		
		bandeja.validate()
		
		if (bandeja.errors.allErrors.size() == 0){	
			
			def seccionAnterior
			
			(0..bandeja.longitud).each{i->				
				def seccion = creaSeccion(bandeja,i)
				bandeja.conecta(seccion,TipoConexion.ESTRUCTURA)
				
				if (seccionAnterior != null){
					seccionAnterior.conecta(seccion,TipoConexion.COMPOSICION)
				}
				
				seccionAnterior = seccion
			}
		}
		
		return bandeja
	}	
	
	/**
	 * Crea una nueva seccion.
	 */
	private def creaSeccion(bandeja,i){
		def seccion = new Seccion(referencia:creaNombreSeccion(bandeja,i))
		
		if (!seccion.save()){
			seccion.errors.allErrors.each{error ->
				println "Ha ocurrido un error al crear entidad: ${error}"
			}
		}
		
		return seccion
	}
	
	/**
	 * Crea un nombre de seccion.	
	 */
	private def creaNombreSeccion(bandeja,i){
		return PREFIJO_SECCION + i + SEPARADOR_BANDEJA + bandeja.referencia
	}
}
