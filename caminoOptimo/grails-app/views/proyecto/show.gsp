
<%@ page import="com.objectEvangelist.caminoOptimo.modelo.proyectos.Proyecto" %>
<g:applyLayout name="mainLayout"> 
	<article>
        <div class="dialog">
         
             <div class="property">
                 <span class="name"><g:message code="proyecto.codigo" default="Codigo" />:</span>
                 <span class="value">${fieldValue(bean: entityInstance, field: "codigo")}</span>
             </div>
             
             <div class="property">
                 <span class="name"><g:message code="proyecto.descripcion" default="Descripcion" />:</span>
                 <span class="value">${fieldValue(bean: entityInstance, field: "descripcion")}</span>
            </div>
        </div>
    	 <span class="button"><g:link><g:message code="return"/></g:link></span>
 	</article>
</g:applyLayout>