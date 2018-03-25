<div id="map"></div>

<script>
    var map;
</script>

<script>

    function addMyMarker(mapa, lat, lon, markerOptions) {
        markerOptions.position = new google.maps.LatLng(lat, lon);
        markerOptions.map = mapa;
        var marker = new google.maps.Marker(markerOptions);
        marker.setIcon('http://maps.google.com/mapfiles/ms/icons/green-dot.png')
    }

    function addMarker(mapa, lat, lon, markerOptions) {
        markerOptions.position = new google.maps.LatLng(lat, lon);
        markerOptions.map = mapa;
        var marker = new google.maps.Marker(markerOptions);
        marker.setIcon('http://maps.google.com/mapfiles/ms/icons/red-dot.png')
    }

    function initMap() {
            map = new google.maps.Map(document.getElementById('map'), {

<#if chargingPoints?size == 0>
            zoom: 3,
            center: {lat: 0, lng: 0}
            });

<#elseif chargingPoints?size == 1>
            zoom: 12,
            center: {lat: ${chargingPoints[0].latitude},lng: ${chargingPoints[0].longitude}}}
            );
<#else>
            zoom: 4,
            center: {lat: ${chargingPoints[0].latitude},lng: ${chargingPoints[0].longitude}}}
            );
</#if>

 <#if longitude??>
         addMyMarker(map, ${latitude}, ${longitude}, {title: 'My position'});
 </#if>

<#list chargingPoints>
    <#items as chargingPoint>
                addMarker(map, ${chargingPoint.latitude}, ${chargingPoint.longitude}, {title: '${chargingPoint.title}'});
    </#items>
</#list>
    }
</script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=${google_api_key}&callback=initMap">
</script>