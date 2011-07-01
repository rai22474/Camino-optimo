
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoCable" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoCable.label', default: 'TipoCable')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <g:sortableColumn property="referencia" title="${message(code: 'tipoCable.referencia.label', default: 'Referencia')}" />
                            <g:sortableColumn property="descripcion" title="${message(code: 'tipoCable.descripcion.label', default: 'Descripcion')}" />
                            <g:sortableColumn property="peso" title="${message(code: 'tipoCable.peso.label', default: 'Peso')}" />
                            <g:sortableColumn property="seccionExterior" title="${message(code: 'tipoCable.seccionExterior.label', default: 'Seccion Exterior')}" />
                            <g:sortableColumn property="numeroPuntas" title="${message(code: 'tipoCable.numeroPuntas.label', default: 'Numero Puntas')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${tipoCableInstanceList}" status="i" var="tipoCableInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:link action="show" id="${tipoCableInstance.id}">${fieldValue(bean: tipoCableInstance, field: "referencia")}</g:link></td>
                            <td>${fieldValue(bean: tipoCableInstance, field: "descripcion")}</td>
                            <td>${fieldValue(bean: tipoCableInstance, field: "peso")}</td>
                            <td>${fieldValue(bean: tipoCableInstance, field: "seccionExterior")}</td>
                            <td>${fieldValue(bean: tipoCableInstance, field: "numeroPuntas")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${tipoCableInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
