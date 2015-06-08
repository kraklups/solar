(function($, window, document, SG, undefined ) {

	$(document).ready(function(){   
	
		var refreshId = setInterval( function() 
	    		{
			
	        	    $.ajax({
	        	    	url: 'http://localhost:9090/rest/alarmTriggered/1',	        	        
	        	        contentType: 'application/json; charset=utf-8',
	        	        dataType: 'json',
	        	    	type: 'GET',
	        	        success: function (data, status, jqXHR) {
	        	        	 alert("GET ajax!");
	        	        },

	        	        error: function (jqXHR, status) {
	        	        	alert("GET fucked!");
	        	        }
	        	    }); 
	        	    
	    		}, 2000);		    
		
	});
  
 }(jQuery, window, window.document, (window.SolarGis = window.SolarGis || {}) ));