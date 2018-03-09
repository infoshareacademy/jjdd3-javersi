<h1>Results</h1>
<hr/>
<#list chargingPoints>
    <ul>
        <#items as chargingPoint>
            <li>
                <strong>Town:</strong> ${chargingPoint.addressInfo.town} <br/>
                <strong>Country:</strong> ${chargingPoint.addressInfo.country.title} <br/>
                <strong>Latitude:</strong> ${chargingPoint.addressInfo.latitude} <br/>
                <strong>Longitude:</strong> ${chargingPoint.addressInfo.longitude}
            </li>
        </#items>
    </ul>
</#list>