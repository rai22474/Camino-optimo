<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.topologia.Equipo" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'equipo.label', default: 'Equipo')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
   			<span class="menuButton"><g:link class="list" controller="diseno" action="disenoProyecto">Diseño proyecto</g:link></span>            
  			<span class="menuButton"><g:link class="list" controller="topologia" action="index">Topologia</g:link></span>            
       </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${equipoInstance}">
            <div class="errors">
                <g:renderErrors bean="${equipoInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <g:hiddenField name="idElementoTopologia" value="${idElementoTopologia}" />   
                <div class="dialog">
                    <div>
                        <div>
                        
                            <div class="prop">
                                <div  class="name">
                                    <label for="referencia"><g:message code="equipo.referencia.label" default="Referencia" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: equipoInstance, field: 'referencia', 'errors')}">
                                    <g:textField name="referencia" value="${equipoInstance?.referencia}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div  class="name">
                                    <label for="descripcion"><g:message code="equipo.descripcion.label" default="Descripcion" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: equipoInstance, field: 'descripcion', 'errors')}">
                                    <g:textArea name="descripcion" value="${equipoInstance?.descripcion}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div  class="name">
                                    <label for="ubicacion"><g:message code="equipo.ubicacion.label" default="Ubicacion" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: equipoInstance, field: 'ubicacion', 'errors')}">
                                    <g:textField name="ubicacion" value="${equipoInstance?.ubicacion}" />
                                </div>
                            </div>
                        
                        </div>
                    </div>
                      <div class="clearBoth"></div>
                </div>
                <div class="buttons">
                    <g:actionSubmit class="save" value="Crear" action="salvaEquipo"/>
               		<g:actionSubmit class="save"  value="Cancelar" action="cancelaSalvar"/>              		
                </div>
            </g:form>
        </div>
    </body>
</html>
