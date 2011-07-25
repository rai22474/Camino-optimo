<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'caminoOptimo.css')}" />
        
        <link rel="shortcut icon" href="${resource(dir:'images',file:'caminoOptimoLogoIcono.gif')}" type="image/x-icon" />
        
        <g:layoutHead/>
        <g:javascript library="application" />
        <g:javascript library="jquery" plugin="jquery" />
  	    <g:javascript library="jquery.tools.min" />
  	   	
  	   	<script type="text/javascript" charset="utf-8"> 
			$(document).ready(function() {
				$("ul.tabs").tabs("div.topologia > div");	
			}		 		    
		</script> 	
  	   </head>
    <body>
    	
        <div class="cabecera">
	        <div id="spinner" class="spinner" style="display:none;">
	            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="Spinner" />
	        </div>
	        <div id="caminoOptimoLogo" class="logo"><a href="#"><img src="${resource(dir:'images',file:'caminoOptimoLogo.png')}" alt="CaminoOptimo" border="0" /></a></div>
			<g:link controller="logout">Cerrar sesión</g:link>	
	    </div>
	    <div class="cuerpo">
        	<g:layoutBody />
        </div>
        <div class="pie">
        	
        </div>
    </body>
</html>