
<%@ page import="com.objectEvangelist.caminoOptimo.seguridad.Usuario" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
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
            <g:hasErrors bean="${usuarioInstance}">
            <div class="errors">
                <g:renderErrors bean="${usuarioInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${usuarioInstance?.id}" />
                <g:hiddenField name="version" value="${usuarioInstance?.version}" />
                <div class="dialog">
                    <div>
                        <div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="username"><g:message code="usuario.username.label" default="Username" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: usuarioInstance, field: 'username', 'errors')}">
                                    <g:textField name="username" value="${usuarioInstance?.username}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="password"><g:message code="usuario.password.label" default="Password" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: usuarioInstance, field: 'password', 'errors')}">
                                    <g:textField name="password" value="${usuarioInstance?.password}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="accountExpired"><g:message code="usuario.accountExpired.label" default="Account Expired" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: usuarioInstance, field: 'accountExpired', 'errors')}">
                                    <g:checkBox name="accountExpired" value="${usuarioInstance?.accountExpired}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="accountLocked"><g:message code="usuario.accountLocked.label" default="Account Locked" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: usuarioInstance, field: 'accountLocked', 'errors')}">
                                    <g:checkBox name="accountLocked" value="${usuarioInstance?.accountLocked}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="enabled"><g:message code="usuario.enabled.label" default="Enabled" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: usuarioInstance, field: 'enabled', 'errors')}">
                                    <g:checkBox name="enabled" value="${usuarioInstance?.enabled}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="passwordExpired"><g:message code="usuario.passwordExpired.label" default="Password Expired" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: usuarioInstance, field: 'passwordExpired', 'errors')}">
                                    <g:checkBox name="passwordExpired" value="${usuarioInstance?.passwordExpired}" />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div   class="name">
                                  <label for="authorities"><g:message code="usuario.authorities.label" default="Authorities" /></label>
                                </div>
                                <div   class="value ${hasErrors(bean: usuarioInstance, field: 'authorities', 'errors')}">
                                    
                                </div>
                            </div>
                        
                        </div>
                        <div class="clearBoth"/>
                    </div>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
