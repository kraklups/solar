(function($, window, document, SG, undefined ) {

	$(document).ready(function(){   
	
		$('#ElementPrkJS').change(function() {
		 
			var selected = $(this).children(":selected").text();
			
			switch (selected) {
				case "ElementPrk" :
					$("#elementprkform").attr('action','createElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;				

				case "ArrayPanel" :
					$("#elementprkform").attr('action','createArrayPanelElement');
					$("#stringlinestuff").show();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;										
					
				case "ArrayBox" :
					$("#elementprkform").attr('action','createArrayBoxElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;					
					
				case "Cell" :
					$("#elementprkform").attr('action','createCellElement');
					$("#stringlinestuff").show();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").show();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;
					
				case "Counter" :
					$("#elementprkform").attr('action','createCounterElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;					

				case "ElectricalSubstation" :
					$("#elementprkform").attr('action','createElectricalSubstationElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").show();

					break;					

				case "ExtractionPoint" :
					$("#elementprkform").attr('action','createExtractionPointElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;						
					
				case "Gps" :
					$("#elementprkform").attr('action','createGpsElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;						

				case "Inverter" :
					$("#elementprkform").attr('action','createInverterElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").show();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").show();
					$("#electricalsubstationstuff").show();
					$("#mediumvoltagestuff").hide();

					break;						

				case "MediumVoltage" :
					$("#elementprkform").attr('action','createMediumVoltageElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").show();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;						

				case "SolarTracker" :
					$("#elementprkform").attr('action','createSolarTrackerElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;					
					
				case "StringLine" :
					$("#elementprkform").attr('action','createStringLineElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").show();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;					

				case "WeatherStation" :
					$("#elementprkform").attr('action','createWeatherStationElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

					break;										
					
				default: 
					$("#elementprkform").attr('action','createElement');
					$("#stringlinestuff").hide();
					$("#arrayboxstuff").hide();
					$("#arraypanelstuff").hide();
					$("#extractionpointstuff").hide();
					$("#counterstuff").hide();
					$("#electricalsubstationstuff").hide();
					$("#mediumvoltagestuff").hide();

			}
		}); 
		    
	});
  
 }(jQuery, window, window.document, (window.SolarGis = window.SolarGis || {}) ));
