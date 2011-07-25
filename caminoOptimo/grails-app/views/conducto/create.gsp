<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Conducto" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'conducto.label', default: 'Conducto')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" controller="diseno" action="disenoProyecto">Diseño proyecto</g:link></span>            
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${conductoInstance}">
            <div class="errors">
                <g:renderErrors bean="${conductoInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <div>
                        <div>
                        	 <div class="prop">
                                <div  class="name">
                                    <label for="referencia"><g:message code="conducto.referencia.label" default="Referencia" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: conductoInstance, field: 'referencia', 'errors')}">
                                    <g:textField name="referencia" value="${conductoInstance?.referencia}" />
                                </div>
                            </div>
                            <div class="prop">
                                <div  class="name">
                                    <label for="red"><g:message code="conducto.red.label" default="Red" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: conductoInstance, field: 'red', 'errors')}">
                                    <g:select name="red.id" from="${tiposRed}" optionKey="id" value="${conductoInstance?.red?.id}"  />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div  class="name">
                                    <label for="descripcion"><g:message code="conducto.descripcion.label" default="Descripcion" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: conductoInstance, field: 'descripcion', 'errors')}">
                                    <g:textArea name="descripcion" value="${conductoInstance?.descripcion}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div  class="name">
                                    <label for="longitud"><g:message code="conducto.longitud.label" default="Longitud" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: conductoInstance, field: 'longitud', 'errors')}">
                                    <g:textField name="longitud" value="${fieldValue(bean: conductoInstance, field: 'longitud')}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div  class="name">
                                    <label for="ubicacion"><g:message code="conducto.ubicacion.label" default="Ubicacion" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: conductoInstance, field: 'ubicacion', 'errors')}">
                                    <g:textField name="ubicacion" value="${conductoInstance?.ubicacion}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div  class="name">
                                    <label for="tipoCanal"><g:message code="conducto.tipoCanal.label" default="Tipo Canal" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: conductoInstance, field: 'tipoCanal', 'errors')}">
                                    <g:select name="tipoCanal.id" from="${tiposConducto}" optionKey="id" value="${conductoInstance?.tipoCanal?.id}"  />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearBoth"></div>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
