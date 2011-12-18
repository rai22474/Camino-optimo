<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto" %>
<g:applyLayout name="mainLayout"> 
	<article>
	    <h1><g:message code="proyecto.create" default="Create Proyecto" /></h1>

	   	<g:applyLayout name="errorsLayout"/>

	    <g:form action="save" method="post" >	      	
	        <g:applyLayout name="../proyecto/form"/>    	
	      	<g:applyLayout name="formButtonsLayout"/>	       
	    </g:form>

	</article>
</g:applyLayout>	

