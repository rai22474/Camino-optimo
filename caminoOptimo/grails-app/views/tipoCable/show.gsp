<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoCable" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoCable.label', default: 'TipoCable')}" />
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
                <div>
                    <div>
                        <div class="prop">
                            <div class="name"><g:message code="tipoCable.referencia.label" default="Referencia" /></div>
                            <div  class="value">${fieldValue(bean: tipoCableInstance, field: "referencia")}</div>
                        </div>
                    
                        <div class="prop">
                            <div class="name"><g:message code="tipoCable.descripcion.label" default="Descripcion" /></div>
                            <div  class="value">${fieldValue(bean: tipoCableInstance, field: "descripcion")}</div>
                        </div>
                    
                        <div class="prop">
                            <div class="name"><g:message code="tipoCable.peso.label" default="Peso" /></div>
                            <div  class="value">${fieldValue(bean: tipoCableInstance, field: "peso")}</div>
                        </div>
                    
                        <div class="prop">
                            <div class="name"><g:message code="tipoCable.seccionExterior.label" default="Seccion Exterior" /></div>
                            <div  class="value">${fieldValue(bean: tipoCableInstance, field: "seccionExterior")}</div>
                        </div>
                    
                        <div class="prop">
                            <div class="name"><g:message code="tipoCable.numeroPuntas.label" default="Numero Puntas" /></div>
                            <div  class="value">${fieldValue(bean: tipoCableInstance, field: "numeroPuntas")}</div>
                        </div>
                    
                        <div class="prop">
                            <div class="name"><g:message code="tipoCable.seccionConductor.label" default="Seccion Conductor" /></div>
                            <div  class="value">${fieldValue(bean: tipoCableInstance, field: "seccionConductor")}</div>
                        </div>
                    
                        <div class="prop">
                            <div class="name"><g:message code="tipoCable.numeroCables.label" default="Numero Cables" /></div>
                            <div  class="value">${fieldValue(bean: tipoCableInstance, field: "numeroCables")}</div>
                        </div>
                    </div>
                </div>
              	<div class="clearBoth"></div>  
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${tipoCableInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
