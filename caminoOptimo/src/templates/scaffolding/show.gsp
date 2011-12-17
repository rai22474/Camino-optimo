<% import org.codehaus.groovy.grails.orm.hibernate.support.ClosureEventTriggeringInterceptor as Events %>
<%=packageName%>
<g:applyLayout name="mainLayout"> 
	<article>
        <div class="dialog">
         <%  excludedProps = ["id",
			 				  "version",
                              Events.ONLOAD_EVENT,
                              Events.BEFORE_INSERT_EVENT,
                              Events.BEFORE_UPDATE_EVENT,
                              Events.BEFORE_DELETE_EVENT]
             props = domainClass.properties.findAll { !excludedProps.contains(it.name) }
             Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
             props.each { p -> %>
             <div class="property">
                 <span class="name"><g:message code="${domainClass.propertyName}.${p.name}" default="${p.naturalName}" />:</span>
                 <%  if (p.isEnum()) { %>
                 <span valign="top" class="value">\${entityInstance?.${p.name}?.encodeAsHTML()}</span>
                 <%  } else if (p.oneToMany || p.manyToMany) { %>
                 <span  style="text-align: left;" class="value">
                     <ul>
                     <g:each in="\${entityInstance?.${p.name}}" var="${p.referencedDomainClass?.propertyName}Instance">
                         <li><g:link controller="${p.referencedDomainClass?.propertyName}" action="show" id="\${${p.referencedDomainClass?.propertyName}Instance.id}">\${${p.referencedDomainClass?.propertyName}Instance.encodeAsHTML()}</g:link></li>
                     </g:each>
                     </ul>
                 </span>
                 <%  } else if (p.manyToOne || p.oneToOne) { %>
                 <span class="value"><g:link controller="${p.referencedDomainClass?.propertyName}" action="show" id="\${entityInstance?.${p.name}?.id}">\${entityInstance?.${p.name}?.encodeAsHTML()}</g:link></span>
                 <%  } else if (p.type == Boolean.class || p.type == boolean.class) { %>
                 <span class="value"><g:formatBoolean boolean="\${entityInstance?.${p.name}}" /></span>
                 <%  } else if (p.type == Date.class || p.type == java.sql.Date.class || p.type == java.sql.Time.class || p.type == Calendar.class) { %>
                 <span class="value"><g:formatDate date="\${entityInstance?.${p.name}}" /></span>
                 <%  } else if (BigDecimal.class.isAssignableFrom(p.type)) { %>
                 <span class="value"><g:formatNumber number="\${entityInstance?.${p.name}}" /></span>
                 <%  } else { %>
                 <span class="value">\${fieldValue(bean: entityInstance, field: "${p.name}")}</span>
                 <%  } %>
             </div>
             <%  } %>
        </div>
    	 <span class="button"><g:link><g:message code="return"/></g:link></span>
 	</article>
</g:applyLayout>