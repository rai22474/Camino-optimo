
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.diseno.sistemas.tipos.TipoCable" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'member.label', default: 'Member')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>       
	    <g:each in="${members}" var="member">
	        member: ${member.descripcion} (enabled:${member.enabled})<br/>
	       
	        <br/>
	    </g:each>
    </body>
</html>
