<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.TipoConducto" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoConducto.label', default: 'TipoConducto')}" />
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
                        
                         
                            <g:sortableColumn property="referencia" title="${message(code: 'tipoConducto.referencia.label', default: 'Referencia')}" />
                        
                            <g:sortableColumn property="descripcion" title="${message(code: 'tipoConducto.descripcion.label', default: 'Descripcion')}" />
                        
                            <g:sortableColumn property="diametroInterior" title="${message(code: 'tipoConducto.diametroInterior.label', default: 'Diametro Interior')}" />
                        
                            <g:sortableColumn property="diametroNominal" title="${message(code: 'tipoConducto.diametroNominal.label', default: 'Diametro Nominal')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${tipoConductoInstanceList}" status="i" var="tipoConductoInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${tipoConductoInstance.id}">${fieldValue(bean: tipoConductoInstance, field: "referencia")}</g:link></td>
                                                                           
                            <td>${fieldValue(bean: tipoConductoInstance, field: "descripcion")}</td>
                        
                            <td>${fieldValue(bean: tipoConductoInstance, field: "diametroInterior")}</td>
                        
                            <td>${fieldValue(bean: tipoConductoInstance, field: "diametroNominal")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${tipoConductoInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
