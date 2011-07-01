<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'caminoOptimo.css')}" />
        
        <link rel="shortcut icon" href="${resource(dir:'images',file:'caminoOptimoLogoIcono.gif')}" type="image/x-icon" />
        
        <g:layoutHead/>
        <g:javascript library="application" />
        <g:javascript library="jquery" plugin="jquery"/>
        <g:javascript library="jquery.dataTables.min" />
  	    <g:javascript library="jquery.corner" />
  	    <g:javascript library="jquery.tools.min" />
  	   	<script type="text/javascript" charset="utf-8"> 

			var oTable;
			var giRedraw = false;
			
			$(document).ready(function() {
				$(".transform").jqTransform();

				$("ul.tabs").tabs("div.topologia > div");
			 		    
				$('.dialog').corner("10px");
				$('.selectoresTopologia').corner("10px");

				/* Add a click handler to the rows - this could be used as a callback */
				$(".dataTable").click(function(event) {
					$(oTable.fnSettings().aoData).each(function (){
						$(this.nTr).removeClass('seleccionado');
					});
					$(event.target.parentNode).addClass('seleccionado');
				});
								
				/* Init the table */
				oTable = $('.dataTable').dataTable( {
					"bPaginate": false,
					"bLengthChange": true,
					"bFilter": true,
					"bSort": false,
					"bInfo": false,
					"bAutoWidth": false } );
			} );
			
			
			
			/* Get the rows which are currently selected */
			function fnGetSelected()
			{
				var aReturn = new Array();
				var aTrs = oTable.fnGetNodes();
				
				for ( var i=0 ; i<aTrs.length ; i++ ){
					if ( $(aTrs[i]).hasClass('seleccionado') ){
						aReturn.push( aTrs[i] );
					}
				}
				
				return aReturn[0].id;
			}
		</script> 	
  	   </head>
    <body>
    	
        <div class="cabecera">
	        <div id="spinner" class="spinner" style="display:none;">
	            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="Spinner" />
	        </div>
	        <div id="caminoOptimoLogo" class="logo"><a href="#"><img src="${resource(dir:'images',file:'caminoOptimoLogo.png')}" alt="CaminoOptimo" border="0" /></a></div>
			<g:link controller="logout">Cerrar sesión</g:link>	
	    </div>
	    <div class="cuerpo">
        	<g:layoutBody />
        </div>
        <div class="pie">
        	
        </div>
    </body>
</html>