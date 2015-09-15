(function($, window, document, SG, undefined ) {

	$(document).ready(function(){   
	
		$('#TaskPrkJS').change(function() {
		 
			var selected = $(this).children(":selected").text();
			
			switch (selected) {
				case "TaskPrk" :
					$("#taskprkform").attr('action','createTask');
					$("#trackstuff").hide();

					break;
				case "Monitor" :
					$("#taskprkform").attr('action','createMonitorTask');
					$("#trackstuff").hide();

					break;
				case "Track" :
					$("#taskprkform").attr('action','createTrackTask');
					$("#trackstuff").show();

					break;
				case "Upkeep" :
					$("#taskprkform").attr('action','createUpkeepTask');
					$("#trackstuff").hide();

					break;
				case "Synchronize" :
					$("#taskprkform").attr('action','createSynchronizeTask');
					$("#trackstuff").hide();

					break;
				default: 
					$("#taskprkform").attr('action','createTask');
					$("#trackstuff").hide();

			}
		}); 
		    
	});
  
 }(jQuery, window, window.document, (window.SolarGis = window.SolarGis || {}) ));
