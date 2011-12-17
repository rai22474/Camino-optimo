<g:applyLayout name="mainLayout"> 
	<section>
		<nav class="mainMenu">
	      	<ul>
				<li><a href="${createLink(uri:'/index.gsp')}"><g:message code="atelGraphics.home"/></a></li>
				<li><a href="${createLink(uri:'/users/products.gsp')}"><g:message code="atelGraphics.products"/></a></li>
				<li><a href="${createLink(uri:'/users/forum.gsp')}"><g:message code="atelGraphics.forum"/></a></li>
				<li><g:link controller="consults"><g:message code="atelGraphics.contact"/></g:link></li>
			</ul>
     	</nav>	
     	<g:layoutBody/>        	        	
	</section>
</g:applyLayout> 		 	
