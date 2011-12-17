package com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia

class ComponenteCanalizacion extends Canalizacion {

	/**
	* Calcula la seccion util de una seccion. La seccion util es la de la bandeja que es su padre.
	*/
   @Override
   public Object calculaSeccionUtil() {
	   def padres = recuperaPadres(TipoConexion.ESTRUCTURA)
	   return padres.size() == 0?0:padres.getAt(0).calculaSeccionUtil()
   }
}
