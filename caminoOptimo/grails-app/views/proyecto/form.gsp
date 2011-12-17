
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto" %>
<div class="dialog">
    
	<div class="property">
	    <label for="codigo"><g:message code="entityInstance.codigo" default="Codigo" />:</label>
	    <div  class="value ${hasErrors(bean: entityInstance, field: 'codigo', 'errors')}">
	        <g:textField name="codigo" maxlength="20" value="${fieldValue(bean: entityInstance, field: 'codigo')}" />
	
	    </div>
	</div>
	
	<div class="property">
	    <label for="descripcion"><g:message code="entityInstance.descripcion" default="Descripcion" />:</label>
	    <div  class="value ${hasErrors(bean: entityInstance, field: 'descripcion', 'errors')}">
	        <g:textArea name="descripcion" value="${fieldValue(bean: entityInstance, field: 'descripcion')}" />
	
	    </div>
	</div>
</div>            
