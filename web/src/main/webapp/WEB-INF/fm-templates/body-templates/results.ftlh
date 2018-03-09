<h1>Results</h1>
<hr/>
<#list chargingPoints>
    <ul>
        <#items as chargingPoint>
            <div class="card border-primary mb-3" style="max-width: 20rem;">
                <h3 class="card-header">${chargingPoint.addressInfo.country.title} - ${chargingPoint.addressInfo.town}</h3>
                <div class="card-body">
                    <p class="card-text"><strong>Latitude:</strong> ${chargingPoint.addressInfo.latitude} <br/>
                        <strong>Longitude:</strong> ${chargingPoint.addressInfo.longitude}</p>
                </div>
            </div>
        </#items>
    </ul>
</#list>