<% import org.codehaus.groovy.grails.orm.hibernate.support.ClosureEventTriggeringInterceptor as Events %>
<%=packageName%>
<g:applyLayout name="mainLayout"> 
	 <article>
	     <h1><g:message code="${domainClass.propertyName}.list" default="${className} List" /></h1>
	     <g:if test="\${flash.message}">
	     <div class="message"><g:message code="\${flash.message}" args="\${flash.args}" default="\${flash.defaultMessage}" /></div>
	     </g:if>
	     <g:form action="save" method="post" <%= multiPart ? " enctype=\"multipart/form-data\"" : "" %>>
			<nav class="singleElementActions">
	            <span class="button"><g:actionSubmit class="edit" action="edit" value="\${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
	       		<span class="button"><g:actionSubmit class="show" action="show" value="\${message(code: 'default.show.label', default:'Show')}" /></span>
	       		<span class="button"><g:actionSubmit class="delete" action="delete" value="\${message(code:'default.button.delete.label', default:'Delete')}" /> </span>
	        </nav>
	        <nav class="noElementActions">
	        	<span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>	        	
	        </nav>
			 
			 <div class="list">
		        <table>
		            <thead>
		                <tr>
		                <th>Selection</th>
		                <%  excludedProps = ["version",
						 				    "id", 	
		                                     Events.ONLOAD_EVENT,
		                                     Events.BEFORE_INSERT_EVENT,
		                                     Events.BEFORE_UPDATE_EVENT,
		                                     Events.BEFORE_DELETE_EVENT]
		                    props = domainClass.properties.findAll { !excludedProps.contains(it.name) && it.type != Set.class }
		                    Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
		                    props.eachWithIndex { p, i ->
		           	        if (i < 6) {
		           	            if (p.isAssociation()) { %>
		           	    <th><g:message code="${domainClass.propertyName}.${p.name}" default="${p.naturalName}" /></th>
		           	    <%      } else { %>
		           	    <g:sortableColumn property="${p.name}" title="${p.naturalName}" titleKey="${domainClass.propertyName}.${p.name}" />
		                <%  }   }   } %>
		                </tr>
		            </thead>
		            <tbody>
		            <g:each in="\${entityInstanceList}" status="i" var="${propertyName}">
		                <tr class="\${(i % 2) == 0 ? 'odd' : 'even'}">
	              		<td><input type="hidden" name="identifier" value="\${${propertyName}.id}"/><input type="checkbox" id="\${${propertyName}.id}" name="\${${propertyName}.id}"/></td>
					   
		                <%  props.eachWithIndex { p, i ->
		                 if (i < 6) {
						
			                 if (p.type == Boolean.class || p.type == boolean.class) { %>
			                    <td><g:formatBoolean boolean="\${${propertyName}.${p.name}}" /></td>
			                <%          } else if (p.type == Date.class || p.type == java.sql.Date.class || p.type == java.sql.Time.class || p.type == Calendar.class) { %>
			                    <td><g:formatDate date="\${${propertyName}.${p.name}}" /></td>
			                <%          } else if (BigDecimal.class.isAssignableFrom(p.type)) { %>
			                    <td><g:formatNumber number="\${${propertyName}.${p.name}}" /></td>
			                <%          } else { %>
			                    <td>\${fieldValue(bean: ${propertyName}, field: "${p.name}")}</td>
			                <%  }   }   } %>
		                </tr>
		            </g:each>
		            </tbody>
		        </table>
		    </div>
		    <div class="paginateButtons">
		        <g:paginate total="\${entityInstanceTotal}" />
		    </div>		
	     </g:form>
	 </article>
</g:applyLayout>	
