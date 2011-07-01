<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Equipo" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'equipo.label', default: 'Equipo')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" controller="diseno" action="disenoProyecto">Diseño proyecto</g:link></span>            
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <div class="prueba">
                                                   
                        <div class="prop">
                            <span  class="name"><g:message code="equipo.referencia.label" default="Referencia" /></span>                            
                            <span  class="value">${fieldValue(bean: equipoInstance, field: "referencia")}</span>                           
                        </div>
                    
                        <div class="prop">
                            <span class="name"><g:message code="equipo.descripcion.label" default="Descripcion" /></span>          
                            <span class="value">${fieldValue(bean: equipoInstance, field: "descripcion")}</span>                           
                        </div>
                    
                        <div class="prop">
                            <span  class="name"><g:message code="equipo.ubicacion.label" default="Ubicacion" /></span>                           
                            <span  class="value">${fieldValue(bean: equipoInstance, field: "ubicacion")}</span>                           
                        </div>
                   </div>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${equipoInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
