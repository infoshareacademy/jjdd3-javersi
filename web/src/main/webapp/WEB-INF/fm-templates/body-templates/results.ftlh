<h1>${title} - results</h1>
<hr/>
<#list chargingPoints?sort_by("promoted")?reverse>
    <ul>
        <#items as chargingPoint>
            <#if chargingPoint.promoted>
                <div class="card text-white bg-success mb-3" style="max-width: 20rem;">
            <#else>
                 <div class="card border-primary mb-3" style="max-width: 20rem;">
            </#if>
                <h3 class="card-header">${chargingPoint.country} - ${chargingPoint.town}</h3>
                <div class="card-body">
                    <p class="card-text"><strong>Latitude:</strong> ${chargingPoint.latitudeString} <br/>
                        <strong>Longitude:</strong> ${chargingPoint.longitudeString}</p>
                </div>
            </div>
        </#items>
    </ul>
</#list>

<h2>Location of selected charging points on map</h2>
<div id="map"></div>
<script>
    function initMap() {
        var uluru = {lat: ${chargingPoints[0].latitude}, lng: ${chargingPoints[0].longitude}};
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 4,
            center: uluru
        });
        var marker = new google.maps.Marker({
            position: uluru,
            map: map
        });
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=&callback=initMap">
</script>
