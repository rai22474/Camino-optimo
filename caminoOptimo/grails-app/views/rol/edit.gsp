
<%@ page import="com.objectEvangelist.caminoOptimo.seguridad.Rol" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'rol.label', default: 'Rol')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${rolInstance}">
            <div class="errors">
                <g:renderErrors bean="${rolInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${rolInstance?.id}" />
                <g:hiddenField name="version" value="${rolInstance?.version}" />
                <div class="dialog">
                    <div>
                        <div>
                        
                            <div class="prop">
                                <div  class="name">
                                  <label for="authority"><g:message code="rol.authority.label" default="Authority" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: rolInstance, field: 'authority', 'errors')}">
                                    <g:textField name="authority" value="${rolInstance?.authority}" />
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
