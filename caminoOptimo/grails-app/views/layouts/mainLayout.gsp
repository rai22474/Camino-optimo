<!DOCTYPE html>
	<html>
    <head>
        <title>AtelGraphics Home</title>
        <link rel="shortcut icon" href="${resource(dir:'images',file:'caminoOptimoLogoIcono.gif')}" type="image/x-icon" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'caminoOptimo.css')}" />
       
       	<g:javascript library="application" />
        <g:javascript library="jquery" plugin="jquery" />
  	    <g:javascript library="jquery.tools.min" />
       	
        <g:layoutHead/>
    </head>
    <body>
  		<header>
  			<figure>
	  			<img src="${resource(dir:'images',file:'caminoOptimoLogo.png')}" alt="CaminoOptimo" border="0" />
	  		</figure>
			<nav class="userMenu">
	        	<ul>
					<li><g:link controller="logout">Cerrar sesión</g:link></li>
				</ul>
        	</nav>        	
  		</header>  		
  		<section>
  			<g:layoutBody/>        		
  		</section>
  		<footer> 
  			 	Camino Optimo 2011. Todos los derechos reservados.		
  		</footer>
    </body>
</html>
