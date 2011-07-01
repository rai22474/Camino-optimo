
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoCable" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoCable.label', default: 'TipoCable')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${tipoCableInstance}">
            <div class="errors">
                <g:renderErrors bean="${tipoCableInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <div>
                        <div>
                        
                            <div class="prop">
                                <div class="name">
                                    <label for="referencia"><g:message code="tipoCable.referencia.label" default="Referencia" /></label>
                                </div>
                                <div class="value ${hasErrors(bean: tipoCableInstance, field: 'referencia', 'errors')}">
                                    <g:textField name="referencia" value="${tipoCableInstance?.referencia}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div class="name">
                                    <label for="descripcion"><g:message code="tipoCable.descripcion.label" default="Descripcion" /></label>
                                </div>
                                <div class="value ${hasErrors(bean: tipoCableInstance, field: 'descripcion', 'errors')}">
                                    <g:textField name="descripcion" maxlength="100" value="${tipoCableInstance?.descripcion}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div class="name">
                                    <label for="peso"><g:message code="tipoCable.peso.label" default="Peso" /></label>
                                </div>
                                <div class="value ${hasErrors(bean: tipoCableInstance, field: 'peso', 'errors')}">
                                    <g:textField name="peso" value="${fieldValue(bean: tipoCableInstance, field: 'peso')}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div class="name">
                                    <label for="seccionExterior"><g:message code="tipoCable.seccionExterior.label" default="Seccion Exterior" /></label>
                                </div>
                                <div class="value ${hasErrors(bean: tipoCableInstance, field: 'seccionExterior', 'errors')}">
                                    <g:textField name="seccionExterior" value="${fieldValue(bean: tipoCableInstance, field: 'seccionExterior')}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div class="name">
                                    <label for="numeroPuntas"><g:message code="tipoCable.numeroPuntas.label" default="Numero Puntas" /></label>
                                </div>
                                <div class="value ${hasErrors(bean: tipoCableInstance, field: 'numeroPuntas', 'errors')}">
                                    <g:textField name="numeroPuntas" value="${fieldValue(bean: tipoCableInstance, field: 'numeroPuntas')}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div class="name">
                                    <label for="seccionConductor"><g:message code="tipoCable.seccionConductor.label" default="Seccion Conductor" /></label>
                                </div>
                                <div class="value ${hasErrors(bean: tipoCableInstance, field: 'seccionConductor', 'errors')}">
                                    <g:textField name="seccionConductor" value="${fieldValue(bean: tipoCableInstance, field: 'seccionConductor')}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div class="name">
                                    <label for="numeroCables"><g:message code="tipoCable.numeroCables.label" default="Numero Cables" /></label>
                                </div>
                                <div class="value ${hasErrors(bean: tipoCableInstance, field: 'numeroCables', 'errors')}">
                                    <g:textField name="numeroCables" value="${fieldValue(bean: tipoCableInstance, field: 'numeroCables')}" />
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
