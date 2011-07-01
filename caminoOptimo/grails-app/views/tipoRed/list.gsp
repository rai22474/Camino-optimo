<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoRed" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoRed.label', default: 'TipoRed')}" />
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
                <table class="dataTable">
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="referencia" title="${message(code: 'tipoRed.referencia.label', default: 'Referencia')}" />
                  	      
                            <g:sortableColumn property="descripcion" title="${message(code: 'tipoRed.descripcion.label', default: 'Descripcion')}" />
                        
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${tipoRedInstanceList}" status="i" var="tipoRedInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${tipoRedInstance.id}">${fieldValue(bean: tipoRedInstance, field: "referencia")}</g:link></td>
                        
                            <td>${fieldValue(bean: tipoRedInstance, field: "descripcion")}</td>
                                              
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${tipoRedInstanceTotal}" />
            </div>
        </div>
        
	
    </body>
</html>
