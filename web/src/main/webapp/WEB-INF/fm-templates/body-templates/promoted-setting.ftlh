<h1>Promoted charging points settings</h1>
<hr/>
<#list chargingPointDtoList>
     <table class="table table-hover">
        <thead>
            <th scope="col">Country</th>
            <th scope="col">Town</th>
            <th scope="col">Latitude</th>
            <th scope="col">Longitude</th>
            <th scope="col">Action</th>
        </thead>
        <tbody>
             <#items as chargingPoint>
                <tr>
                    <td>${chargingPoint.country}</td>
                    <td>${chargingPoint.town}</td>
                    <td>${chargingPoint.latitudeString}</td>
                    <td>${chargingPoint.longitudeString}</td>
                    <td>
                        <#if chargingPoint.promoted>
                            <a href="/administration/promoted-settings?action=remove&id=${chargingPoint.id?string["0"]}" class="btn btn-danger">Remove</a>
                        <#else>
                            <a href="/administration/promoted-settings?action=add&id=${chargingPoint.id?string["0"]}" class="btn btn-success">Promote</a>
                        </#if>
                    </td>
                </tr>
            </#items>
        </tbody>
    </table>
</#list>




