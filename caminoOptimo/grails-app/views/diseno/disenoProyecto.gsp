<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
	<title>Diseño proyecto</title>
	<meta name="layout" content="main"/>
</head>
	<body>
		<div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" controller="diseno" action="index">Proyectos en curso</g:link></span>
        </div>
		
		<h1>Diseño proyecto</h1>
		
		<div class="equipos menu">
			<h2>Equipos</h2>
			<ul>
	            <li class="equipo opcionMenu"><g:link controller="equipo">Equipos</g:link></li>
	        </ul>
		</div>
		<div class="sistemas menu">
			<h2>Sistemas</h2>
			<ul>
	            <li class="tipoCable opcionMenu"><g:link controller="tipoCable">Tipos de cables</g:link></li>
	        	<li class="tipoRed opcionMenu"><g:link controller="tipoRed">Tipos de red</g:link></li>
	        </ul>
			<ul>
	            <li class="sistema opcionMenu"><g:link controller="sistema">Sistemas</g:link></li>
	            <li class="cable opcionMenu"><g:link controller="cable">Cables</g:link></li>
	        </ul>
		</div>
		<div class="topologia menu">
			<h2>Topologia</h2>
			<ul>
	        	<li class="tipoBandeja opcionMenu"><g:link controller="tipoBandeja">Tipos de bandejas</g:link></li>
	        	<li class="tipoConducto opcionMenu"><g:link controller="tipoConducto">Tipos de conductos</g:link></li>
	        </ul>
			<ul>
	            <li class="bandeja opcionMenu"><g:link controller="bandeja">Bandejas</g:link></li>
	            <li class="conducto opcionMenu"><g:link controller="conducto">Conductos</g:link></li>
	            <li class="topologia opcionMenu"><g:link controller="topologia">Definir topologia</g:link></li>
	        </ul>
		</div>
	</body>
</html>