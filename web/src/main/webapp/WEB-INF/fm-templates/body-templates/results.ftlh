<h1>${title} - results</h1>
<hr/>

<div class="container">
    <div class="row">

        <div class="col-lg-4" id="list-of-points">
        <#list chargingPoints>
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
        </#list>

        </div>
        <div class="col-lg-8 col-sm-12">
        <#include "/body-templates/points-map.ftlh">
        </div>
    </div>
</div>


