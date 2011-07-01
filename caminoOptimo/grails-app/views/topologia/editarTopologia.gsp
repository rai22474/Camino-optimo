<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.TipoConexion" %>
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.TipoElementoTopologia" %>

<html>
<head>
	<title>Diseño proyecto</title>
	<meta name="layout" content="main"/>
</head>
	<body>
		<div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
  			<span class="menuButton"><g:link class="list" controller="diseno" action="disenoProyecto">Diseño proyecto</g:link></span>            
  			<span class="menuButton"><g:link class="list" controller="topologia" action="index">Topologia</g:link></span>            
   			<span class="menuButton"><g:link class="create" action="creaEquipo" params="[idElementoTopologia:elementoTopologia.id]">Crear equipo</g:link></span>
        	<span class="menuButton"><g:link class="create" action="creaBandeja" params="[idElementoTopologia:elementoTopologia.id]">Crear bandeja</g:link></span>
        	<span class="menuButton"><g:link class="create" action="creaConducto" params="[idElementoTopologia:elementoTopologia.id]">Crear conducto</g:link></span>
        </div>
               
        <div>
        	<g:set var="esUnEquipo" value="${elementoTopologia.obtenerTipoElementoTopologia() == TipoElementoTopologia.EQUIPO}"/>
        	<h1>Editar Topologia ${elementoTopologia.referencia}</h1>
        	<h2>Conexion</h2>
           	<div class="selectoresTopologia">    	             
	             <g:form>	             	
	            	<g:hiddenField name="idElementoTopologia" value="${elementoTopologia.id}" />  
	                <div class="selector">
	                	<g:if test="${esUnEquipo}" >
	                		<label for="elementoOriginal">Equipo</label>
	                	</g:if>
	                	<g:else>
	                		<label for="elementoOriginal">Canalización</label>
	                	</g:else>
	                	<span>${elementoTopologia.referencia}</span> 	          
	 				</div>
	 				<g:if test="${esUnEquipo}" >
						<g:hiddenField name="elementoOriginal" value="${elementoTopologia.id}" /> 
					</g:if>
					<g:else>			
		 				<div class="selector">
		 					<label for="elementoOriginal">Seccion/Extremo</label>
			 				<select name="elementoOriginal">
		 						<g:each in="${elementoTopologia.recuperaHijos(TipoConexion.ESTRUCTURA)}" var="hijo">
									<option value="${hijo.id}">${hijo.referencia}</option>
								</g:each>							
			 				</select>  
		 				</div>
	 				</g:else>
	 				<div class="selector">
	 					<label for="elementoConectar">Canalización</label>
		           		<select id="elementoConectar" name="elementoConectar">              			
							<optgroup label="Bandejas">										
								<g:each in="${bandejas}" status="i" var="bandeja">
									<option value="${bandeja.id}">${bandeja.referencia}</option>
								</g:each>	
							</optgroup>
							<optgroup label="Conductos">
								<g:each in="${conductos}" status="i" var="conducto">
									<option value="${conducto.id}">${conducto.referencia}</option>
								</g:each>
							</optgroup>
						</select>
					</div>					
					<div class="selector">
						<label for="seccionConectar">Seccion/Extremo</label>
		           		<select id="seccionConectar" name="seccionConectar">              			
							<optgroup label="Bandejas">										
								<g:each in="${bandejas}" status="i" var="bandeja">
									<optgroup label="${bandeja.referencia}">
										<g:each in="${bandeja.recuperaHijos(TipoConexion.ESTRUCTURA)}" var="seccion">
											<option value="${seccion.id}">${seccion.referencia}</option>
										</g:each>									
									</optgroup>
								</g:each>	
								</optgroup>
								<optgroup label="Conductos">
									<g:each in="${conductos}" status="i" var="conducto">
										<optgroup label="${conducto.referencia}">
											<g:each in="${conducto.recuperaHijos(TipoConexion.ESTRUCTURA)}" var="extremo">
												<option value="${extremo.id}">${extremo.referencia}</option>
											</g:each>
										</optgroup>		
									</g:each>
								</optgroup>
							</select>
							<g:if test="${!esUnEquipo}" >
								<label for="equipoConectar">Equipos</label>
								<select id="equipoConectar" name="equipoConectar">   
			           				<g:each in="${equipos}" status="i" var="equipo">
										<option value="${equipo.id}">${equipo.referencia}</option>
									</g:each>						
								</select>
							</g:if>
					</div>
					<div class="selector">
				 		<span class="button"><g:actionSubmit class="create" action="conectarCanalizacion" value="Conectar canalizacion" /></span>
			 			
			 			<g:if test="${!esUnEquipo}" >
			 				<span class="button"><g:actionSubmit class="create" action="conectarEquipo" value="Conectar equipo" /></span>
			 			</g:if>		
		 			</div>
		 			<div class="clearBoth"></div>
				</g:form>						
			</div>
			 <div class="conexiones list">
	       		<g:if test="${!esUnEquipo}" >
		       		<div>
		       			<h2>Equipos</h2>
	             		 <g:set var="i" value="${1}"/>
						 <table>
		                    <thead>
		                        <tr>
		                  		    <th>Canalización</th>
									<th/>  
		                  		    <th>Equipo conectado</th>
		                         </tr>
		                    </thead>
		                    <tbody>
		                       	<g:each in="${elementoTopologia.recuperaElementoRelacionados(TipoConexion.ESTRUCTURA)}" var="hijo">
					           		<g:each  in="${hijo.recuperaElementoRelacionados(TipoConexion.TOPOLOGIA)}" var="conectaConmigo">
						                  <g:if test="${conectaConmigo.obtenerTipoElementoTopologia() == TipoElementoTopologia.EQUIPO}">
					                    	      <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
												  		<td>${fieldValue(bean: elementoTopologia, field: "referencia")}</td>
												  		<td>${fieldValue(bean: hijo, field: "referencia")}</td>	
							                        	<td><g:link action="editarTopologia" params="[idElementoTopologia:conectaConmigo.id]">${fieldValue(bean: conectaConmigo, field: "referencia")}</g:link></td>												
														<g:set var="i" value="${i + 1}" />
							                       </tr>
					                    	  </g:if>   
					                    </g:each>     
					              </g:each>
				            </tbody>
	                	</table>
	            	</div> 
				</g:if> 	            	
            	<div>
            		<h2>Canalizaciones</h2>
             		<g:set var="i" value="${1}"/>
             		<table>
	                    <thead>
	                        <tr>
								<g:if test="${esUnEquipo}">
									<th>Equipo</th>
								</g:if>
								<g:else>
	                  		    	<th>Canalización</th>
								</g:else>  
								<g:if test="${!esUnEquipo}">
								  	<th/>
								 </g:if>
	                  		    <th>Canalización conectada</th>
								<th/>
	                        </tr>
	                    </thead>
	                    <tbody>	
	                    	<g:if test="${esUnEquipo}">
	                    		<g:each  in="${elementoTopologia.recuperaElementoRelacionados(TipoConexion.TOPOLOGIA)}" var="conectaCon">
	                    			<g:if test="${conectaCon.obtenerTipoElementoTopologia() != TipoElementoTopologia.EQUIPO}">			                        
		                    			<g:each  in="${conectaCon.recuperaElementoRelacionados(TipoConexion.ESTRUCTURA)}" var="padre">				                       
						                      <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
											 	  <td>${fieldValue(bean: elementoTopologia, field: "referencia")}</td>						                         	
												  <td><g:link action="editarTopologia" params="[idElementoTopologia:padre.id]">${fieldValue(bean: padre, field: "referencia")}</g:link></td>
							                      <td>${fieldValue(bean: conectaCon, field: "referencia")}</td>                        
												  <g:set var="i" value="${i + 1}" />
											  </tr>
					                    </g:each>		                    			
	                    			</g:if>
	                    		</g:each>
	                    	</g:if>
	                    	<g:else>	                    
			                    <g:each in="${elementoTopologia.recuperaElementoRelacionados(TipoConexion.ESTRUCTURA)}" var="hijo">			              
				                    <g:each in="${hijo.recuperaElementoRelacionados(TipoConexion.TOPOLOGIA)}" var="conectaCon">
				                        <g:if test="${conectaCon.obtenerTipoElementoTopologia() != TipoElementoTopologia.EQUIPO}">				                       
					                        <g:each in="${conectaCon.recuperaElementoRelacionados(TipoConexion.ESTRUCTURA)}" var="padre">               
						                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
													<td>${fieldValue(bean: elementoTopologia, field: "referencia")}</td>
													<td>${fieldValue(bean: hijo, field: "referencia")}</td>
													<td><g:link action="editarTopologia"  params="[idElementoTopologia:padre.id]">${fieldValue(bean: padre, field: "referencia")}</g:link></td>                           
							                        <td>${fieldValue(bean: conectaCon, field: "referencia")}</td>                        
													<g:set var="i" value="${i + 1}" />
												</tr>
					                        </g:each>
				                        </g:if>
				                    </g:each>
			                    </g:each>
			                 </g:else>   
	                    </tbody>
                	</table>
	             </div>
           	</div>   
		</div>
	</body>
</html>