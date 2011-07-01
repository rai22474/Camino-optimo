<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.TipoBandeja" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoBandeja.label', default: 'TipoBandeja')}" />
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
                        
                        
                            <g:sortableColumn property="referencia" title="${message(code: 'tipoBandeja.referencia.label', default: 'Referencia')}" />
                        
                            <g:sortableColumn property="descripcion" title="${message(code: 'tipoBandeja.descripcion.label', default: 'Descripcion')}" />
                        
                            <g:sortableColumn property="ancho" title="${message(code: 'tipoBandeja.ancho.label', default: 'Ancho')}" />
                        
                            <g:sortableColumn property="alto" title="${message(code: 'tipoBandeja.alto.label', default: 'Alto')}" />
                        
                            <g:sortableColumn property="peso" title="${message(code: 'tipoBandeja.peso.label', default: 'Peso')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${tipoBandejaInstanceList}" status="i" var="tipoBandejaInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${tipoBandejaInstance.id}">${fieldValue(bean: tipoBandejaInstance, field: "referencia")}</g:link></td>
                                                
                            <td>${fieldValue(bean: tipoBandejaInstance, field: "descripcion")}</td>
                        
                            <td>${fieldValue(bean: tipoBandejaInstance, field: "ancho")}</td>
                        
                            <td>${fieldValue(bean: tipoBandejaInstance, field: "alto")}</td>
                        
                            <td>${fieldValue(bean: tipoBandejaInstance, field: "peso")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${tipoBandejaInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
