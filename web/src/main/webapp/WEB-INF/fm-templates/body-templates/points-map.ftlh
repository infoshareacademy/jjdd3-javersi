<div id="map"></div>

<script>
    var map;
</script>

<script>
    function addMarker(mapa, lat, lon, markerOptions) {

        markerOptions.position = new google.maps.LatLng(lat, lon);
        markerOptions.map = mapa;
        var marker = new google.maps.Marker(markerOptions);
    }

    function initMap() {
        var point = {lat: ${chargingPoints[0].latitude}, lng: ${chargingPoints[0].longitude}};
        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 4,
            center: point
        });

<#list chargingPoints>
    <#items as chargingPoint>
                addMarker(map, ${chargingPoint.latitude}, ${chargingPoint.longitude}, {title: '${chargingPoint.id}'});
    </#items>
</#list>
    }
</script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=${google_api_key}&callback=initMap">
</script>