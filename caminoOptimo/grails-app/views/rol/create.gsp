
<%@ page import="com.objectEvangelist.caminoOptimo.seguridad.Rol" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'rol.label', default: 'Rol')}" />
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
            <g:hasErrors bean="${rolInstance}">
            <div class="errors">
                <g:renderErrors bean="${rolInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
