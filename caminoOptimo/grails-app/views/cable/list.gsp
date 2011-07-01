<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Cable" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cable.label', default: 'Cable')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" controller="diseno" action="disenoProyecto">Diseño proyecto</g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="referencia" title="${message(code: 'cable.referencia.label', default: 'Referencia')}" />
                        
                            <th><g:message code="cable.tipoCable.label" default="Tipo Cable" /></th>
                   	    
                            <th><g:message code="cable.red.label" default="Red" /></th>
                   	    
                            <th><g:message code="cable.sistema.label" default="Sistema" /></th>
                   	    
                            <th><g:message code="cable.equipoOrigen.label" default="Equipo Origen" /></th>
                   	    	<th><g:message code="cable.equipoDestino.label" default="Equipo Destino" /></th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${cableInstanceList}" status="i" var="cableInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${cableInstance.id}">${fieldValue(bean: cableInstance, field: "referencia")}</g:link></td>
                                                
                            <td>${fieldValue(bean: cableInstance, field: "tipoCable")}</td>
                        
                            <td>${fieldValue(bean: cableInstance, field: "red")}</td>
                        
                            <td>${fieldValue(bean: cableInstance, field: "sistema")}</td>
                        
                            <td>${fieldValue(bean: cableInstance, field: "equipoOrigen")}</td>
                            <td>${fieldValue(bean: cableInstance, field: "equipoDestino")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${cableInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
