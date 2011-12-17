<% import org.codehaus.groovy.grails.orm.hibernate.support.ClosureEventTriggeringInterceptor as Events %>
<%=packageName%>
<g:applyLayout name="mainLayout"> 
	<article>
	    <h1><g:message code="${domainClass.propertyName}.create" default="Create ${className}" /></h1>

	   	<g:applyLayout name=errorsLayout"/>

	    <g:form action="save" method="post" >	      	
	        <g:applyLayout name="../${domainClass.propertyName}/form"/>    	
	      	<g:applyLayout name="formButtonsLayout"/>	       
	    </g:form>

	</article>
</g:applyLayout>	

