(function($, window, document, SG, undefined ) {

	$(document).ready(function(){   
	
		$('#ElementPrkJS').change(function() {
		 
			var selected = $(this).children(":selected").text();
			
			switch (selected) {
				case "ElementPrk" :
					$("#elementprkform").attr('action','createElement');
					$("#stringlinestuff").hide();

					break;				

				case "ArrayPanel" :
					$("#elementprkform").attr('action','createArrayPanelElement');
					$("#stringlinestuff").hide();

					break;										
					
				case "Cell" :
					$("#elementprkform").attr('action','createCellElement');
					$("#stringlinestuff").show();

					break;
					
				default: 
					$("#elementprkform").attr('action','createElement');
					$("#stringlinestuff").hide();

			}
		}); 
		    
	});
  
 }(jQuery, window, window.document, (window.SolarGis = window.SolarGis || {}) ));
