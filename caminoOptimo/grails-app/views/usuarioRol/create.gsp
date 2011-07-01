
<%@ page import="com.objectEvangelist.caminoOptimo.seguridad.UsuarioRol" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'usuarioRol.label', default: 'UsuarioRol')}" />
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
            <g:hasErrors bean="${usuarioRolInstance}">
            <div class="errors">
                <g:renderErrors bean="${usuarioRolInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <div>
                        <div>
                        
                            <div class="prop">
                                <div  class="name">
                                    <label for="rol"><g:message code="usuarioRol.rol.label" default="Rol" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: usuarioRolInstance, field: 'rol', 'errors')}">
                                    <g:select name="rol.id" from="${com.objectEvangelist.caminoOptimo.seguridad.Rol.list()}" optionKey="id" value="${usuarioRolInstance?.rol?.id}"  />
                                </div>
                            </div>
                        
                            <div class="prop">
                                <div  class="name">
                                    <label for="usuario"><g:message code="usuarioRol.usuario.label" default="Usuario" /></label>
                                </div>
                                <div  class="value ${hasErrors(bean: usuarioRolInstance, field: 'usuario', 'errors')}">
                                    <g:select name="usuario.id" from="${com.objectEvangelist.caminoOptimo.seguridad.Usuario.list()}" optionKey="id" value="${usuarioRolInstance?.usuario?.id}"  />
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
