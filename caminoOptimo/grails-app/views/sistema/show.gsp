<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Sistema" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'sistema.label', default: 'Sistema')}" />
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
                        <div class="prop">
                            <span class="name"><g:message code="sistema.referencia.label" default="Referencia" /></span>                            
                            <span class="value">${fieldValue(bean: sistemaInstance, field: "referencia")}</span>                            
                        </div>
                    
                        <div class="prop">
                            <span class="name"><g:message code="sistema.nombre.label" default="Nombre" /></span>                          
                            <span class="value">${fieldValue(bean: sistemaInstance, field: "nombre")}</span>                         
                        </div>
                    
                        <div class="prop">
                            <span class="name"><g:message code="sistema.descripcion.label" default="Descripcion" /></span>                           
                            <span  class="value">${fieldValue(bean: sistemaInstance, field: "descripcion")}</span>                           
                        </div>                    
                </div>
            </div>            
             <div class="list">
                <h2>Cables que forman el sistema</h2>
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'cable.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="referencia" title="${message(code: 'cable.referencia.label', default: 'Referencia')}" />
                        
                            <th><g:message code="cable.tipoCable.label" default="Tipo Cable" /></th>
                   	    
                            <th><g:message code="cable.red.label" default="Red" /></th>
                   	    
                            <th><g:message code="cable.sistema.label" default="Sistema" /></th>
                   	    
                            <th><g:message code="cable.equipoOrigen.label" default="Equipo Origen" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${sistemaInstance.cables?}" status="i" var="cableInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link controller="cable" action="show" id="${cableInstance.id}">${fieldValue(bean: cableInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: cableInstance, field: "referencia")}</td>
                        
                            <td>${fieldValue(bean: cableInstance, field: "tipoCable")}</td>
                        
                            <td>${fieldValue(bean: cableInstance, field: "red")}</td>
                        
                            <td>${fieldValue(bean: cableInstance, field: "sistema")}</td>
                        
                            <td>${fieldValue(bean: cableInstance, field: "equipoOrigen")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${sistemaInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
