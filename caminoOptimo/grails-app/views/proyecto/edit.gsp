
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto" %>
<g:applyLayout name="mainLayout"> 	     
	<article>
	     <h1><g:message code="proyecto.edit" default="Edit User" /></h1>	  
	     <g:applyLayout name=errorsLayout"/>
	     
	     <g:form method="post" action="update">
	         <g:hiddenField name="id" value="${entityInstance?.id}" />
	         <g:hiddenField name="version" value="${entityInstance?.version}" />
			
			 <g:applyLayout name="../proyecto/form"/> 	      		         
	       	 <g:applyLayout name="formButtonsLayout"/>
	     </g:form>	
	</article>
</g:applyLayout>