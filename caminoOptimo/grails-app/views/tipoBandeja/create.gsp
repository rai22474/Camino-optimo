<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.tipos.TipoBandeja" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoBandeja.label', default: 'TipoBandeja')}" />
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
            <g:hasErrors bean="${tipoBandejaInstance}">
            <div class="errors">
                <g:renderErrors bean="${tipoBandejaInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <div>
                        <div>
                        
                            <div class="prop">
                                <div   class="name">
                                    <label for="referencia"><g:message code="tipoBandeja.referencia.label" default="Referencia" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: tipoBandejaInstance, field: 'referencia', 'errors')}">
                                    <g:textField name="referencia" value="${tipoBandejaInstance?.referencia}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                    <label for="descripcion"><g:message code="tipoBandeja.descripcion.label" default="Descripcion" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: tipoBandejaInstance, field: 'descripcion', 'errors')}">
                                    <g:textArea name="descripcion" maxlength="100" value="${tipoBandejaInstance?.descripcion}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                    <label for="ancho"><g:message code="tipoBandeja.ancho.label" default="Ancho" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: tipoBandejaInstance, field: 'ancho', 'errors')}">
                                    <g:textField name="ancho" value="${fieldValue(bean: tipoBandejaInstance, field: 'ancho')}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                    <label for="alto"><g:message code="tipoBandeja.alto.label" default="Alto" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: tipoBandejaInstance, field: 'alto', 'errors')}">
                                    <g:textField name="alto" value="${fieldValue(bean: tipoBandejaInstance, field: 'alto')}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                    <label for="peso"><g:message code="tipoBandeja.peso.label" default="Peso" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: tipoBandejaInstance, field: 'peso', 'errors')}">
                                    <g:textField name="peso" value="${fieldValue(bean: tipoBandejaInstance, field: 'peso')}" />
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
