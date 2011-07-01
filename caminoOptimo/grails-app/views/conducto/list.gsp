<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Conducto" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'conducto.label', default: 'Conducto')}" />
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
                        
                            <g:sortableColumn property="referencia" title="${message(code: 'conducto.referencia.label', default: 'Referencia')}" />
                        
                            <th><g:message code="conducto.red.label" default="Red" /></th>
                   	    
                            <g:sortableColumn property="descripcion" title="${message(code: 'conducto.descripcion.label', default: 'Descripcion')}" />
                        
                            <g:sortableColumn property="longitud" title="${message(code: 'conducto.longitud.label', default: 'Longitud')}" />
                        
                            <g:sortableColumn property="ubicacion" title="${message(code: 'conducto.ubicacion.label', default: 'Ubicacion')}" />
                        
                            <th><g:message code="conducto.tipoCanal.label" default="Tipo Canal" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${conductoInstanceList}" status="i" var="conductoInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${conductoInstance.id}">${fieldValue(bean: conductoInstance, field: "referencia")}</g:link></td>
                        
                            <td>${fieldValue(bean: conductoInstance, field: "red")}</td>
                        
                            <td>${fieldValue(bean: conductoInstance, field: "descripcion")}</td>
                        
                            <td>${fieldValue(bean: conductoInstance, field: "longitud")}</td>
                        
                            <td>${fieldValue(bean: conductoInstance, field: "ubicacion")}</td>
                        
                            <td>${fieldValue(bean: conductoInstance, field: "tipoCanal")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${conductoInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
