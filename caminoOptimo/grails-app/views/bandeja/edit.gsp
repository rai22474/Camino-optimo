<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Bandeja" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'bandeja.label', default: 'Bandeja')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" controller="diseno" action="disenoProyecto">Diseño proyecto</g:link></span>            
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${bandejaInstance}">
            <div class="errors">
                <g:renderErrors bean="${bandejaInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${bandejaInstance?.id}" />
                <g:hiddenField name="version" value="${bandejaInstance?.version}" />
                <div class="dialog">
                    <div>
                        <div>
                        
                        	<div class="prop">
                                <div   class="name">
                                  <label for="referencia"><g:message code="bandeja.referencia.label" default="Referencia" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: bandejaInstance, field: 'referencia', 'errors')}">
                                    <g:textField name="referencia" value="${bandejaInstance?.referencia}" />
                                </div>
                            </div>
                            
                            <div class="prop">
                                <div   class="name">
                                  <label for="red"><g:message code="bandeja.red.label" default="Red" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: bandejaInstance, field: 'red', 'errors')}">
                                    <g:select name="red.id" from="${tiposRed}" optionKey="id" value="${bandejaInstance?.red?.id}"  />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="descripcion"><g:message code="bandeja.descripcion.label" default="Descripcion" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: bandejaInstance, field: 'descripcion', 'errors')}">
                                    <g:textArea name="descripcion" value="${bandejaInstance?.descripcion}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="longitud"><g:message code="bandeja.longitud.label" default="Longitud" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: bandejaInstance, field: 'longitud', 'errors')}">
                                    <g:textField name="longitud" value="${fieldValue(bean: bandejaInstance, field: 'longitud')}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="ubicacion"><g:message code="bandeja.ubicacion.label" default="Ubicacion" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: bandejaInstance, field: 'ubicacion', 'errors')}">
                                    <g:textField name="ubicacion" value="${bandejaInstance?.ubicacion}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="tipoCanal"><g:message code="bandeja.tipoCanal.label" default="Tipo Canal" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: bandejaInstance, field: 'tipoCanal', 'errors')}">
                                    <g:select name="tipoCanal.id" from="${tiposBandeja}" optionKey="id" value="${bandejaInstance?.tipoCanal?.id}"  />
                                </div>
                            </div>
                        
                            
                        
                        </div>
                    </div>
                    <div class="clearBoth"></div>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
