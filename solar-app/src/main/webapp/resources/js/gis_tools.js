(function($, window, document, SG, undefined ) {
  
  SG.init = function() {

    lon = 5;
    lat = 40;
    zoom = 4;

    options = {
      clickout: true, toggle: false, 
      multiple: false, hover: false,
      toggleKey: "ctrlKey", // ctrl key removes from selection
      multipleKey: "shiftKey", // shift key adds to selection
    };

    OpenLayers.Feature.Vector.style['default']['strokeWidth'] = '2';

    map = new OpenLayers.Map('map');

    layer = new OpenLayers.Layer.WMS( 
      "OpenLayers WMS",
      "http://vmap0.tiles.osgeo.org/wms/vmap0", 
      {layers: 'basic'} );
    
    vlayer = new OpenLayers.Layer.Vector("Park");

    map.addLayers([layer, vlayer]);

    select = new OpenLayers.Control.SelectFeature(vlayer, options)

    map.addControl(new OpenLayers.Control.MousePosition());
    map.addControl(new OpenLayers.Control.EditingToolbar(vlayer));
    map.addControl(select);
    
    select.activate();

    map.setCenter(new OpenLayers.LonLat(lon, lat), zoom);
 
  };

  SG.serialize = function() {

    arrayTemp = [];
 
    wkt = new OpenLayers.Format.WKT();
            
    xXx = vlayer.features;

    for(var i = 0; i < xXx.length; i++) {
      if (xXx[i].geometry.CLASS_NAME == "OpenLayers.Geometry.Polygon") {
        arrayTemp.push(xXx[i].geometry);
      }
    }
     
    if (arrayTemp.length >0) { 
      multipolygon = new OpenLayers.Geometry.MultiPolygon(arrayTemp);            

      document.getElementById('mapPark').value = multipolygon;  
    } else {
      document.getElementById('mapPark').value = []; 
    }
 
  };

  $(document).ready(function(){   
    SG.init();
    $('#gisOpenLayers').click(function() {
    	  SG.serialize();
    }); 
  });

 }(jQuery, window, window.document, (window.SolarGis = window.SolarGis || {}) ));
