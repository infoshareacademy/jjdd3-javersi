<h1>Search by town</h1>
<hr/>

<#list chargingPoints>
    <ul>
        <#items as chargingPoint>
            <li> <strong>Title:</strong>${chargingPoint.statusType.title} <br/>
                <strong>Town:</strong> ${chargingPoint.addressInfo.town} <br/>
                <strong>Country:</strong> ${chargingPoint.addressInfo.country.title} <br/>
                <strong>Latitude:</strong> ${chargingPoint.addressInfo.latitude} <br/>
                <strong>Longitude:</strong> ${chargingPoint.addressInfo.longitude} </li>
            <#sep> <p>#####################</p> </#sep>
        </#items>
    </ul>
</#list>