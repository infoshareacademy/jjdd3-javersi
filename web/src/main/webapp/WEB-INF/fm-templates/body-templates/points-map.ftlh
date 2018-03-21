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

<#list chargingPoints>
    <#items as chargingPoint>
                addMarker(map, ${chargingPoint.latitude}, ${chargingPoint.longitude}, {title: '${chargingPoint.id}'});
    </#items>
</#list>
    }
</script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBBrFSULlN8Yj4yi5E_NqqOHFEYZYChgIA&callback=initMap">
</script>

