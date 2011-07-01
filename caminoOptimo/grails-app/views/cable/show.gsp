<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.Cable" %>
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.TipoConexion" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cable.label', default: 'Cable')}" />
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
                            <span class="name"><g:message code="cable.referencia.label" default="Referencia" /></span>
                            <span  class="value">${fieldValue(bean: cableInstance, field: "referencia")}</span>
                            
                        </div>
                    
                    	 <div class="prop">
                            <span class="name"><g:message code="cable.descripcion.label" default="Descripcion" /></span>                            
                            <span class="value">${fieldValue(bean: cableInstance, field: "descripcion")}</span>                            
                        </div>
                        
                        <div class="prop">
                            <span class="name"><g:message code="cable.tipoCable.label" default="Tipo Cable" /></span>
                            <span class="value"><g:link controller="tipoCable" action="show" id="${cableInstance?.tipoCable?.id}">${cableInstance?.tipoCable?.encodeAsHTML()}</g:link></span>
                            
                        </div>
                    
                        <div class="prop">
                            <span  class="name"><g:message code="cable.red.label" default="Red" /></span>
                            <span  class="value"><g:link controller="tipoRed" action="show" id="${cableInstance?.red?.id}">${cableInstance?.red?.encodeAsHTML()}</g:link></span>
                            
                        </div>
                    
                        <div class="prop">
                            <span  class="name"><g:message code="cable.sistema.label" default="Sistema" /></span>
                            
                            <span valign="top" class="value"><g:link controller="sistema" action="show" id="${cableInstance?.sistema?.id}">${cableInstance?.sistema?.encodeAsHTML()}</g:link></span>
                            
                        </div>
                    
                        <div class="prop">
                            <span  class="name"><g:message code="cable.equipoOrigen.label" default="Equipo Origen" /></span>
                            <span class="value"><g:link controller="equipo" action="show" id="${cableInstance?.equipoOrigen?.id}">${cableInstance?.equipoOrigen?.encodeAsHTML()}</g:link></span>
                            
                        </div>
                    
                        <div class="prop">
                            <span class="name"><g:message code="cable.equipoDestino.label" default="Equipo Destino" /></span>                           
                            <span class="value"><g:link controller="equipo" action="show" id="${cableInstance?.equipoDestino?.id}">${cableInstance?.equipoDestino?.encodeAsHTML()}</g:link></span>
                        </div>
                    
                  </div>
            </div>
            
            <div class="list">
                <h2>Ruta del cable</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Ruta</th>
                            <g:sortableColumn property="distancia" title="Distancia" />
                            <g:sortableColumn property="llenado" title="% Llenado" />
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="odd">
                            <td>${cableInstance.ruta?.recuperaHijos(TipoConexion.RUTA)}</td>
                            <td>${fieldValue(cableInstance.ruta?.distancia)}</td>
                            <td>${fieldValue(cableInstance.ruta?.porcentajeLlenado)}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${cableInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                	<span class="button"><g:actionSubmit class="edit" action="editarRuta" value="Editar ruta cable" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
