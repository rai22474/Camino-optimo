<g:if test="${flash.message}">
 	<div class="message"><g:message code="${flash.message}" args="${flash.args}" default="${flash.defaultMessage}" /></div>
</g:if>
<g:hasErrors bean="${entityInstance}">
	 <div class="errors">
	     <g:renderErrors bean="${entityInstance}" as="list" />
	 </div>
</g:hasErrors>	
  