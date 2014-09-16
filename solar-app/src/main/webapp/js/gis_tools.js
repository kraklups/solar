(function($, window, document, SG, undefined ) {
  SG.lon = 5;
  SG.lat = 40;
  SG.zoom = 4;

  SG.options = {
    clickout: true, toggle: false, 
    multiple: false, hover: false,
    toggleKey: "ctrlKey", // ctrl key removes from selection
    multipleKey: "shiftKey", // shift key adds to selection
  };
  
  SG.init = function() {

    OpenLayers.Feature.Vector.style['default']['strokeWidth'] = '2';

    SG.map = new OpenLayers.Map('map');

    layer = new OpenLayers.Layer.WMS( 
      "OpenLayers WMS",
      "http://vmap0.tiles.osgeo.org/wms/vmap0", 
      {layers: 'basic'} );
    
    SG.vlayer = new OpenLayers.Layer.Vector("Park");

    SG.map.addLayers([layer, SG.vlayer]);

    select = new OpenLayers.Control.SelectFeature(SG.vlayer, SG.options)

    SG.map.addControl(new OpenLayers.Control.MousePosition());
    SG.map.addControl(new OpenLayers.Control.EditingToolbar(SG.vlayer));
    SG.map.addControl(select);
    
    select.activate();

    SG.map.setCenter(new OpenLayers.LonLat(SG.lon, SG.lat), SG.zoom);
 
  };

  SG.serialize = function() {

    arrayTemp = [];
 
    SG.wkt = new OpenLayers.Format.WKT();

    SG.out = SG.wkt.write(SG.vlayer.features);
            
    xXx = SG.vlayer.features;

    for(var i = 0; i < xXx.length; i++) {              
      alert(xXx[i].geometry);
      arrayTemp.push(xXx[i].geometry);
    }
            
    alert(arrayTemp);

    SG.multipolygon = new OpenLayers.Geometry.MultiPolygon(arrayTemp);            

    document.getElementById('feat_wkt').value = SG.multipolygon;  

  };

  $(document).ready(function(){   
    SG.init(); 
  });

 }(jQuery, window, window.document, (window.SolarGis = window.SolarGis || {}) ));
