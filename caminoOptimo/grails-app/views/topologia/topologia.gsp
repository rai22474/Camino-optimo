<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
	<title>Diseño proyecto</title>
	<script type="text/javascript" charset="utf-8"> 
		$(document).ready(function() {
			$("ul.tabs").tabs("div.topologia > div");	
		}		 		    
	</script> 	
	<meta name="layout" content="main"/>
	
</head>
	<body>
		<div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
  			<span class="menuButton"><g:link class="list" controller="diseno" action="disenoProyecto">Diseño proyecto</g:link></span>            
        </div>
        <h1>Topologia</h1>
        <ul class="tabs">
				<li><a href="#">Equipos</a></li>
				<g:each in="${tiposRed}"  var="tipoRed">
					<li><a href="#">${tipoRed.referencia}</a></li>
				</g:each>
		</ul>
		<div class="topologia list">
			 <div>
			 	<table>
                    <thead>
                        <tr>
                            <g:sortableColumn property="referencia" title="${message(code: 'equipo.referencia.label', default: 'Referencia')}" />
                            <g:sortableColumn property="descripcion" title="${message(code: 'equipo.descripcion.label', default: 'Descripcion')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${equipos}" status="i" var="equipo">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:link action="editarTopologia" params="[idElementoTopologia:equipo.id]">${fieldValue(bean: equipo, field: "referencia")}</g:link></td>
                            <td>${fieldValue(bean: equipo, field: "descripcion")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
			 </div>
			 <g:each in="${tiposRed}"  var="tipoRed">
             	<div>
              		<table>
	                    <thead>
	                        <tr>
	                  		    <g:sortableColumn property="referencia" title="${message(code: 'bandeja.referencia.label', default: 'Referencia')}" />
	                            <g:sortableColumn property="descripcion" title="${message(code: 'bandeja.descripcion.label', default: 'Descripcion')}" />            
	                            <th><g:message code="bandeja.tipoCanal.label" default="Tipo Canal" /></th>                        
	                        </tr>
	                    </thead>
	                    <tbody>
	                    <g:each in="${canalizaciones}" status="i" var="canalizacion">
	                       <g:if test="${canalizacion.red.referencia == tipoRed.referencia}">
		                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
		                            <td><g:link action="editarTopologia"  params="[idElementoTopologia:canalizacion.id]">${fieldValue(bean: canalizacion, field: "referencia")}</g:link></td>                        
		                            <td>${fieldValue(bean: canalizacion, field: "descripcion")}</td>
		                            <td>${fieldValue(bean: canalizacion, field: "tipoCanal")}</td>
		                        </tr>
	                        </g:if>
	                    </g:each>
	                    </tbody>
	                </table>
             	</div>      	
			 </g:each>
		</div>
	</body>
</html>