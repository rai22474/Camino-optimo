<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Cable" %>
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.TipoConexion" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cable.label', default: 'Cable')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>        
   	</script> 
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" controller="diseno" action="disenoProyecto">Diseño proyecto</g:link></span>                     
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        	<span class="menuButton"><g:link class="list" action="show" id="${cableInstance.id}">Detalle ${cableInstance.referencia}</g:link></span>
        	<span class="menuButton"><g:link class="list" action="editarRuta" id="${cableInstance.id}">Editar ruta ${cableInstance.referencia}</g:link></span>
        </div>
        <div class="body">
         	 <div class="list">	              
	            <h2>Secciones que componen la ruta para el cable ${cableInstance.referencia}</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Referencia</th>
                            <th>Descripcion</th>
                            <g:sortableColumn property="porcentajeLlenado" title="% Llenado" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${ruta.recuperaHijos(TipoConexion.RUTA)}" status="i" var="segmento">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td>${fieldValue(bean: segmento, field: "referencia")}</td>
                            <td>${fieldValue(bean: segmento, field: "descripcion")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>              
	     </div>
	     <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${cableInstance?.id}" />
                    <g:hiddenField name="numeroRuta" value="${numeroRuta}" />
                    <span class="button"><g:actionSubmit class="edit" action="salvarRuta" value="Salvar ruta" /></span>
                </g:form>
         </div>
    </body>
</html>
