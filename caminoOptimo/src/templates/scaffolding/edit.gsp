<% import org.codehaus.groovy.grails.orm.hibernate.support.ClosureEventTriggeringInterceptor as Events %>
<%=packageName%>
<g:applyLayout name="mainLayout"> 	     
	<article>
	     <h1><g:message code="${domainClass.propertyName}.edit" default="Edit ${className}" /></h1>	  
	     <g:applyLayout name=errorsLayout"/>
	     
	     <g:form method="post" action="update">
	         <g:hiddenField name="id" value="\${entityInstance?.id}" />
	         <g:hiddenField name="version" value="\${entityInstance?.version}" />
			
			 <g:applyLayout name="../${domainClass.propertyName}/form"/> 	      		         
	       	 <g:applyLayout name="formButtonsLayout"/>
	     </g:form>	
	</article>
</g:applyLayout>