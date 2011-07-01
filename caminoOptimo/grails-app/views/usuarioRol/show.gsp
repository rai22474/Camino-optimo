
<%@ page import="com.objectEvangelist.caminoOptimo.seguridad.UsuarioRol" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'usuarioRol.label', default: 'UsuarioRol')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
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
                            <div  class="name"><g:message code="usuarioRol.id.label" default="Id" /></div>
                            
                            <div  class="value">${fieldValue(bean: usuarioRolInstance, field: "id")}</div>
                            
                        </div>
                    
                        <div class="prop">
                            <div  class="name"><g:message code="usuarioRol.rol.label" default="Rol" /></div>
                            
                            <div  class="value"><g:link controller="rol" action="show" id="${usuarioRolInstance?.rol?.id}">${usuarioRolInstance?.rol?.encodeAsHTML()}</g:link></div>
                            
                        </div>
                    
                        <div class="prop">
                            <div  class="name"><g:message code="usuarioRol.usuario.label" default="Usuario" /></div>
                            
                            <div  class="value"><g:link controller="usuario" action="show" id="${usuarioRolInstance?.usuario?.id}">${usuarioRolInstance?.usuario?.encodeAsHTML()}</g:link></div>
                            
                        </div>
                    
                    </div>
                </div>
                <div class="clearBoth"></div>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${usuarioRolInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
