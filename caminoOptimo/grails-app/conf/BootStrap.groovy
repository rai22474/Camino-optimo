import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoRed;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.factory.BandejaFactory;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.factory.ConductoFactory;
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.TipoCanal;

import com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.*
import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.*
import com.objectEvangelist.caminoOptimo.seguridad.*

import com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.*

class BootStrap {

	def springSecurityService
	
    def init = { servletContext ->
		def rolAdministracion = new Rol(authority: 'ROLE_ADMIN').save(flush: true)
		def rolUsuario = new Rol(authority: 'ROLE_USER').save(flush: true)
		
		String password = springSecurityService.encodePassword('password')
		def usuarioTest = new Usuario(username: 'me', enabled: true, password: password)
		usuarioTest.save(flush: true)
		
		UsuarioRol.create usuarioTest, rolAdministracion, true
				
		def proyecto = creaProyecto()
		
		def tipoCable = creaTipoCable()
		def redes = crearTipoRedes()
		def equipos = creaEquipo(proyecto.getDiseno())
		
		/*def sistema = creaSistema(redes[0])
		
		creaCable(tipoCable,redes[0],sistema,equipos[0],equipos[3])
		
		def tipoBandeja = creaTipoBandeja()		 
		def bandejas = creaBandejas(tipoBandeja,redes)
		
		
		def tipoConducto = creaTipoConducto()
		def conductos = creaConductos(tipoConducto,redes)			
		
		creaTopologia(bandejas,conductos,equipos)*/
		 
	}
	
	/**
	 * Crea una topologia para pruebas
	 */
	private def creaTopologia(bandejas,conductos,equipos){
		def seccion = bandejas[0].recuperaHijos(TipoConexion.ESTRUCTURA)[0]
		equipos[0].conecta(seccion,TipoConexion.TOPOLOGIA)
		
		def seccionFinal = bandejas[0].recuperaHijos(TipoConexion.ESTRUCTURA)[9]
		seccionFinal.conecta(equipos[3],TipoConexion.TOPOLOGIA)
	}
	
	/**
	 * Metodo que crea un nuevo proyecto.
	 */
	private def creaProyecto() {
		def proyecto = new Proyecto(codigo:"PROY-00012",
									descripcion:"Proyecto de cableado generico")
		
		proyecto.getDiseno().setPorcentajeMaximoLlenadoBandejas(40)
		proyecto.getDiseno().setPorcentajeMaximoLlenadoConductos(30)
		
		println proyecto.sumarNumeros(6, 3)
		salvaEntidad(proyecto)
		return proyecto		
	}
	
	
	/**
	 * Crea un nuevo tipo de cable. 
	 */
	private def creaTipoCable(){
		def tipoCable = new TipoCable(referencia:"TC-001",
		descripcion:"El tipo de cable",
		peso:1,
		seccionExterior:10,
		numeroPuntas:3,
		seccionConductor:1,
		numeroCables:2,
		enabled:true)
		
		salvaEntidad(tipoCable)
		
		def tipoCable2 = new TipoCable(referencia:"TC-002",
			descripcion:"El tipo de cable segundo",
			peso:1,
			seccionExterior:10,
			numeroPuntas:2,
			seccionConductor:1,
			numeroCables:3,
			enabled:true)
			
			salvaEntidad(tipoCable2)
	
		return tipoCable
	} 
	
	/**
	 * Tipo de red.
	 */
	private def crearTipoRedes(){
		
		def redes = []
		def instrumentacion = new TipoRed(referencia:"Y",
			descripcion:"Tipo de red de instrumentacion")
				
		salvaEntidad(instrumentacion)
		redes.add(instrumentacion)
		def control = new TipoRed(referencia:"C",
			descripcion:"Tipo de red de control")
				
		salvaEntidad(control)

		redes.add(control)
		def media = new TipoRed(referencia:"M",
			descripcion:"Tipo de red de media")
				
		salvaEntidad(media)

		redes.add(media)
		def baja = new TipoRed(referencia:"B",
			descripcion:"Tipo de red de baja")
				
		salvaEntidad(baja)

		redes.add(baja)
		def alta = new TipoRed(referencia:"A",
			descripcion:"Tipo de red de alta")
				
		salvaEntidad(alta)
		redes.add(alta)
				
		return redes
	}
	
	/**
	 * Crea un nuevo equipo
	 */
	private def creaEquipo(diseno){
		def equipos = []
		(0..3).each{i->
			def equipo = new Equipo(referencia:"EQ-00"+ i,
				descripcion:"El equipo que mola",
				ubicacion:"Al norte",
				diseno:diseno)
			salvaEntidad(equipo)
			equipos.add(equipo)
		}
		return equipos
		
		
	}
	
	/**
	 * Crea un sistema
	 */
	private def creaSistema(red){
		def sistema = new Sistema(referencia:"SIS-001",
			nombre:"Nombre del sistema",
			descripcion:"Un sistema que mola",
			red:red)
		salvaEntidad(sistema)
		return sistema
	}
	
	/**
	 * Crea un cable 
	 */
	private def creaCable(tipoCable,red,sistema,equipoOrigen,equipoDestino){
		def cable = new Cable(referencia:"CB-001",
							  descripcion:"Cable principal",
							  tipoCable:tipoCable,
							  red:red,
							  sistema:sistema,
							  equipoOrigen:equipoOrigen,
							  equipoDestino:equipoDestino)
		salvaEntidad(cable)	
	}
	
	/**
	 * Crea un tipo de bandeja.
	 */
	private def creaTipoBandeja(){
		def tipoBandeja = new TipoBandeja(referencia:"CA-001",
			descripcion:"bandeja muy bonita",
			peso:10,
			ancho:10,
			alto:10);
		salvaEntidad(tipoBandeja)
		return tipoBandeja
	}
	
	/**
	 * Crea un tipo de bandeja.
	 */
	private def creaTipoConducto(){
		def tipoConducto = new TipoConducto(referencia:"GA-001",
			diametroInterior:10,
			diametroNominal:10,
			descripcion:'Descripcion')
		salvaEntidad(tipoConducto)
		return tipoConducto
	}
	
	private def creaBandejas(tipoBandeja,redes){
		
		def bandejas = []
		def bandejaFactory = new BandejaFactory()
		
		redes.each{red->
			(0..3).each{i->
				def bandeja = bandejaFactory.creaBandeja([referencia:"BAN-" + i + red,
					longitud:10,
					red:red,
					tipoCanal:tipoBandeja,
					descripcion:"descripcion",
					ubicacion:"Al este"])
						
				salvaEntidad(bandeja)
				bandejas.add(bandeja)
			}
		}
		return bandejas
	}
	
	private def creaConductos(tipoConducto,redes){
		
		def conductos = []
		def conductoFactory = new ConductoFactory()
				
		redes.each{red->
			(0..3).each{i->
				def conducto = conductoFactory.creaConducto([referencia:"CON-" + i +red,
										  tipoCanal:tipoConducto,
										  red:red,
										  descripcion:"Descripcion conducto",
										  ubicacion:"Al este",
									  	  longitud:100])
				
				salvaEntidad(conducto)
			}
		}
		return conductos
	}
	
	/**
	 * Salva una entidad que se pasa por parametro
	 * @param entidad la entidad al salvar.
	 */
	private def salvaEntidad(Object entidad){
		if (!entidad.save()){
			entidad.errors.allErrors.each{error ->
				println "Ha ocurrido un error al crear entidad: ${error}"
			}
		}
	} 
	 
	  
     def destroy = {
     }
} 