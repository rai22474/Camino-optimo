<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Bandeja" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'bandeja.label', default: 'Bandeja')}" />
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
            	<div class="buttons">
	                <g:form>
	                    <g:hiddenField name="id" value="" />
	                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit') }" onclick="var seleccionado = fnGetSelected();document.forms[0].id.value = seleccionado;"/></span>
	                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
	                </g:form>
                </div>
                <table class="dataTable">
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="referencia" title="${message(code: 'bandeja.referencia.label', default: 'Referencia')}" />
                        
                            <th><g:message code="bandeja.red.label" default="Red" /></th>
                   	    
                            <g:sortableColumn property="descripcion" title="${message(code: 'bandeja.descripcion.label', default: 'Descripcion')}" />
                        
                            <g:sortableColumn property="longitud" title="${message(code: 'bandeja.longitud.label', default: 'Longitud')}" />
                        
                            <g:sortableColumn property="ubicacion" title="${message(code: 'bandeja.ubicacion.label', default: 'Ubicacion')}" />
                        
                            <th><g:message code="bandeja.tipoCanal.label" default="Tipo Canal" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${bandejaInstanceList}" status="i" var="bandejaInstance">
                        <tr id="${bandejaInstance.id}" class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${bandejaInstance.id}">${fieldValue(bean: bandejaInstance, field: "referencia")}</g:link></td>
                        
                            <td>${fieldValue(bean: bandejaInstance, field: "red")}</td>
                        
                            <td>${fieldValue(bean: bandejaInstance, field: "descripcion")}</td>
                        
                            <td>${fieldValue(bean: bandejaInstance, field: "longitud")}</td>
                        
                            <td>${fieldValue(bean: bandejaInstance, field: "ubicacion")}</td>
                        
                            <td>${fieldValue(bean: bandejaInstance, field: "tipoCanal")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${bandejaInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
