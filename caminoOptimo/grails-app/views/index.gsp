<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Camino Optimo</title>
		<meta name="layout" content="main" />
	</head>
    <body>
		 <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
        </div>
		<div id="pageBody">
	        <h1>Bienvenido</h1>
	        <p>Camino optimo es una aplicacion para facilitar la creacion  y mantenimiento de sistemas de cableado.</p>
			<div class="menu proyectos">
				<h2>Proyectos</h2>
				<ul class="menu">
		            <li class="nuevoProyecto opcionMenu"><g:link controller="proyecto" action="create">Nuevo proyecto</g:link></li>
		        	<li class="proyectosExistentes opcionMenu"><g:link controller="proyecto">Continuar proyecto</g:link></li>
		        </ul>
			</div>
	       	<div class="menu proyectos">
				<h2>Usuarios</h2>
				<ul class="menu">
		            <li class="usuarios opcionMenu"><g:link controller="usuario">Usuarios</g:link></li>
		        	<li class="roles opcionMenu"><g:link controller="rol">Roles</g:link></li>
		        	<li class="rolesUsuario opcionMenu"><g:link controller="usuarioRol">Roles por usuario</g:link></li>
		        </ul>
			</div>
		</div>
    </body>
</html>