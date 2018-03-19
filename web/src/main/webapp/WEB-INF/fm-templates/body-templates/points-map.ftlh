<div id="map"></div>

<script>
    var map;
</script>

<script>
    function dodajMarker(mapa, lat, lon, opcjeMarkera) {

        opcjeMarkera.position = new google.maps.LatLng(lat, lon);
        opcjeMarkera.map = mapa;
        var marker = new google.maps.Marker(opcjeMarkera);
    }

    function initMap() {
        var point = {lat: ${chargingPoints[0].latitude}, lng: ${chargingPoints[0].longitude}};
        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 4,
            center: point
        });

<#list chargingPoints>
    <#items as chargingPoint>
                dodajMarker(map, ${chargingPoint.latitude}, ${chargingPoint.longitude}, {title: '${chargingPoint.id}'});
    </#items>
</#list>
    }
</script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBBrFSULlN8Yj4yi5E_NqqOHFEYZYChgIA&callback=initMap">
</script>