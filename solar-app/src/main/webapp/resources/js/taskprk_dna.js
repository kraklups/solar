(function($, window, document, SG, undefined ) {

	$(document).ready(function(){   
	
		$('#TaskPrkJS').change(function() {
		 
			var selected = $(this).children(":selected").text();
			
			switch (selected) {
				case "TaskPrk" :
					$("#merde").attr('action','createTask');
					alert("createTask");
					break;
				case "Monitor" :
					$("#merde").attr('action','createMonitorTask');
					alert("createMonitorTask");
					break;
				default: 
					$("#merde").attr('action','createTask');
					alert("createTaskDefault");
			}
		}); 
		    
	});
  
 }(jQuery, window, window.document, (window.SolarGis = window.SolarGis || {}) ));
