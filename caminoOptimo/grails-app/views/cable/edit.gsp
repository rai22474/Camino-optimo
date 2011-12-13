<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Cable" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cable.label', default: 'Cable')}" />
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
            <g:hasErrors bean="${cableInstance}">
            <div class="errors">
                <g:renderErrors bean="${cableInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${cableInstance?.id}" />
                <g:hiddenField name="version" value="${cableInstance?.version}" />
                <div class="dialog">
                    <div>
                        <div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="referencia"><g:message code="cable.referencia.label" default="Referencia" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: cableInstance, field: 'referencia', 'errors')}">
                                    <g:textField name="referencia" value="${cableInstance?.referencia}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="tipoCable"><g:message code="cable.tipoCable.label" default="Tipo Cable" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: cableInstance, field: 'tipoCable', 'errors')}">
                                    <g:select name="tipoCable.id" from="${tiposCable}" optionKey="id" value="${cableInstance?.tipoCable?.id}"  />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="red"><g:message code="cable.red.label" default="Red" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: cableInstance, field: 'red', 'errors')}">
                                    <g:select name="red.id" from="${tiposRed}" optionKey="id" value="${cableInstance?.red?.id}"  />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="sistema"><g:message code="cable.sistema.label" default="Sistema" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: cableInstance, field: 'sistema', 'errors')}">
                                    <g:select name="sistema.id" from="${sistemas}" optionKey="id" value="${cableInstance?.sistema?.id}"  />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="equipoOrigen"><g:message code="cable.equipoOrigen.label" default="Equipo Origen" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: cableInstance, field: 'equipoOrigen', 'errors')}">
                                    <g:select name="equipoOrigen.id" from="${equipos}" optionKey="id" value="${cableInstance?.equipoOrigen?.id}"  />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="equipoDestino"><g:message code="cable.equipoDestino.label" default="Equipo Destino" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: cableInstance, field: 'equipoDestino', 'errors')}">
                                    <g:select name="equipoDestino.id" from="${equipos}" optionKey="id" value="${cableInstance?.equipoDestino?.id}"  />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="descripcion"><g:message code="cable.descripcion.label" default="Descripcion" /></label>
                                </div>
                                <div class="value ${hasErrors(bean: cableInstance, field: 'descripcion', 'errors')}">
                                    <g:textArea name="descripcion" value="${cableInstance?.descripcion}" />
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
