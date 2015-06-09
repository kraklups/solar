(function($, window, document, SG, undefined ) {

	$(document).ready(function(){   
	
		var refreshId = setInterval( function() 
	    		{
			
	        	    $.ajax({
	        	    	url: 'http://localhost:9090/solar-app/rest/alarmTriggered/1',	        	        
	        	        contentType: 'application/json; charset=UTF-8',
	        	        dataType: 'json',
	        	    	type: 'GET',
	        	        success: function (data, status, jqXHR) {	        	        	
	        	        	
	        	        	if(data.length != 0) {
	        	        		$("#alertstuff").show();	        	        		
	        	        	} else {
	        	        	} 
	        	        },
	        	        error: function (jqXHR, status) {
	        	        	// msg error
	        	        }
	        	    }); 
	        	    
	    		}, 5000);
		
		$("#alerthide").on('click', function() {
			$("#alertstuff").hide();
		});
		
	});
  
 }(jQuery, window, window.document, (window.SolarGis = window.SolarGis || {}) ));