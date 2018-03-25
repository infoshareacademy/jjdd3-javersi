<h1>${title} - results</h1>
<hr/>

<div class="container">
    <div class="row">

        <div class="col-lg-4" id="list-of-points">
        <#list chargingPoints?sort_by("promoted")?reverse>
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

<h5>Address</h5>
    <p class="card-text">
        <#if chargingPoint.title??>
        <strong>Title:</strong>
        ${chargingPoint.title} </br>
        </#if>

        <#if chargingPoint.addressLine1??>
        <strong>Address:</strong>
        ${chargingPoint.addressLine1} </br>

        <#if chargingPoint.addressLine2??>
            ${chargingPoint.addressLine2}
            </br>
        </#if>
        </#if>

        <#if chargingPoint.postCode??>
        <strong>Post code:</strong>
        ${chargingPoint.postCode} </br>
        </#if>


        <#if chargingPoint.stateOrProvince??>
        <strong>Region:</strong>
        ${chargingPoint.stateOrProvince} </br>
        </#if>
    </p>

        <#list chargingPoint.connections>
        <h5>Connections</h5>
         <p class="card-text">
         <#items as connection>
         <strong>Ord. : </strong>
         ${connection?counter}</br>


            <strong>Description:</strong>
                ${connection.levelComments} </br>
                   <strong>Quantity:</strong>
                                ${connection.quantity} </br>
          </#items>
           </p>
       </#list>
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


