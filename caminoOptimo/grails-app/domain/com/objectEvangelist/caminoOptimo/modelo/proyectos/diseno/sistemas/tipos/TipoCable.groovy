package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos


import java.io.Serializable;

/**
 * Los tipos de cables que van a usarse dentro de este proyecto.
 *
 */
class TipoCable implements Serializable {
	
    static constraints = {
		referencia(blank:false)
		descripcion(blank:true,size:3..100)
		peso(nullable:false)
		seccionExterior(nullable:false)
		numeropuntas(nullable:false)
		seccionConductor(nullable:false)
    }
	
	
    /**
     * La referencia que tiene ese tipo de cable.
     */
    String referencia

    /**
     * La descripcion del tipo de cable.
     */
    String descripcion

    /**
     * El peso que tiene este tipo de cable.
     */
    BigDecimal peso

    /**
     * Diametro total del tipo de cable.
     */
    BigDecimal seccionExterior

    /**
     * El numero de puntas del tipo de cable.
     */
    Integer numeropuntas

    /**
     * Numero de cables.
     */
    Integer numeroCables

    /**
     * Seccion del conductor.
     */
    BigDecimal seccionConductor

	/**
	* 	@see java.lang.Object#toString()
	*/
   @Override
   def String toString(){
	   "$referencia"
   }
		
	Boolean enabled
	
	static hibernateFilters = {
		enabledFilter(condition:'enabled=1', default:true)
		numeroPuntasParam(condition: ':numeropuntas = numeropuntas', types: 'integer')
	}
}
