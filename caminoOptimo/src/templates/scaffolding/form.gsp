<% import org.codehaus.groovy.grails.orm.hibernate.support.ClosureEventTriggeringInterceptor as Events %>
<%=packageName%>
<div class="dialog">
    <%  excludedProps = ["version",
                            "id",
                            Events.ONLOAD_EVENT,
                            Events.BEFORE_INSERT_EVENT,
                            Events.BEFORE_UPDATE_EVENT,
                            Events.BEFORE_DELETE_EVENT]
           props = domainClass.properties.findAll { !excludedProps.contains(it.name) }
           Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
           props.each { p ->
               cp = domainClass.constrainedProperties[p.name]
               display = (cp ? cp.display : true)
               if (display) { %>
           <div class="property">
               <label for="${p.name}"><g:message code="entityInstance.${p.name}" default="${p.naturalName}" />:</label>
               <div  class="value \${hasErrors(bean: entityInstance, field: '${p.name}', 'errors')}">
                   ${renderEditor(p)}
               </div>
           </div>
      <%  }   } %>
      
</div>            
