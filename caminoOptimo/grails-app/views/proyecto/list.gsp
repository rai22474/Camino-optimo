
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto" %>
<g:applyLayout name="mainLayout"> 
	 <article>
	     <h1><g:message code="proyecto.list" default="Proyecto List" /></h1>
	     <g:if test="${flash.message}">
	     <div class="message"><g:message code="${flash.message}" args="${flash.args}" default="${flash.defaultMessage}" /></div>
	     </g:if>
	     <g:form action="save" method="post" >
			<div class="tableActions">
				<nav class="singleElementActions">
		            <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
		       		<span class="button"><g:actionSubmit class="show" action="show" value="${message(code: 'default.show.label', default:'Show')}" /></span>
		       		<span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code:'default.button.delete.label', default:'Delete')}" /> </span>
		        </nav>
		        <nav class="noElementActions">
		        	<span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>	        	
		        </nav>
			</div> 
			 <div class="list">
		        <table>
		            <thead>
		                <tr>
		                <th>Selection</th>
		                
		           	    <g:sortableColumn property="codigo" title="Codigo" titleKey="proyecto.codigo" />
		           	    <g:sortableColumn property="descripcion" title="Descripcion" titleKey="proyecto.descripcion" />
		           	    
		                </tr>
		            </thead>
		            <tbody>
		            <g:each in="${entityInstanceList}" status="i" var="proyectoInstance">
		                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	              		<td><input type="hidden" name="identifier" value="${proyectoInstance.id}"/><input type="checkbox" id="${proyectoInstance.id}" name="${proyectoInstance.id}"/></td>
					   
		                
			                    <td>${fieldValue(bean: proyectoInstance, field: "codigo")}</td>			                
			                    <td>${fieldValue(bean: proyectoInstance, field: "descripcion")}</td>
			                
			                
		                </tr>
		            </g:each>
		            </tbody>
		        </table>
		    </div>
		    <div class="paginateButtons">
		        <g:paginate total="${entityInstanceTotal}" />
		    </div>		
	     </g:form>
	 </article>
</g:applyLayout>	
