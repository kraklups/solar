(function($, window, document, SG, undefined ) {

	$(document).ready(function(){   
	
		$('#ElementPrkJS').change(function() {
		 
			var selected = $(this).children(":selected").text();
			
			switch (selected) {
				case "TaskPrk" :
					$("#taskprkform").attr('action','createTask');
					$("#elementstuff").hide();

					break;
				case "Monitor" :
					$("#taskprkform").attr('action','createMonitorTask');
					$("#elementstuff").hide();

					break;
				case "Track" :
					$("#taskprkform").attr('action','createTrackTask');
					$("#elementstuff").show();

					break;
				case "Upkeep" :
					$("#taskprkform").attr('action','createUpkeepTask');
					$("#elementstuff").hide();

					break;
				case "Synchronize" :
					$("#taskprkform").attr('action','createSynchronizeTask');
					$("#elementstuff").hide();

					break;
				default: 
					$("#taskprkform").attr('action','createTask');
					$("#elementstuff").hide();

			}
		}); 
		    
	});
  
 }(jQuery, window, window.document, (window.SolarGis = window.SolarGis || {}) ));
