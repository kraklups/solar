  var lon = 5;
  var lat = 40;
  var zoom = 4;
  var map, layer, vlayer, wkt, out, multipolygon;
  var options = {
  	clickout: true, toggle: false, 
    multiple: false, hover: false,
    toggleKey: "ctrlKey", // ctrl key removes from selection
    multipleKey: "shiftKey", // shift key adds to selection
  };

  OpenLayers.Feature.Vector.style['default']['strokeWidth'] = '2';

  function init(){

    map = new OpenLayers.Map('map');

    multiPolygonFeature = new OpenLayers.Geometry.MultiPolygon();

    layer = new OpenLayers.Layer.WMS( 
      "OpenLayers WMS",
      "http://vmap0.tiles.osgeo.org/wms/vmap0", 
      {layers: 'basic'} );
    
    vlayer = new OpenLayers.Layer.Vector("Park");

    map.addLayers([layer, vlayer]);

    var select = new OpenLayers.Control.SelectFeature(vlayer, options)

    map.addControl(new OpenLayers.Control.MousePosition());
    map.addControl(new OpenLayers.Control.EditingToolbar(vlayer));
    map.addControl(select);
    
	select.activate();

    map.setCenter(new OpenLayers.LonLat(lon, lat), zoom);
  }

  function serialize() {
    var arrayTemp = [];
 
    wkt = new OpenLayers.Format.WKT();

    out = wkt.write(vlayer.features);
            
    var xXx = vlayer.features;

    for(var i = 0; i < xXx.length; i++) {              
      alert(xXx[i].geometry);
      arrayTemp.push(xXx[i].geometry);
    }
            
    alert(arrayTemp);

    multipolygon = new OpenLayers.Geometry.MultiPolygon(arrayTemp);            

    document.getElementById('feat_wkt').value = multipolygon;

  }
      