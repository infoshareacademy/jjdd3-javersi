<h1>Promoted Charging Points Settings</h1>
<hr/>
<#list chargingPoints>
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
                <td>${chargingPoint.addressInfo.country.title}</td>
                <td>${chargingPoint.addressInfo.town}</td>
                <td>${chargingPoint.addressInfo.latitude}</td>
                <td>${chargingPoint.addressInfo.longitude}</td>
                <td>
                    <a href="/promoted-settings?action=add&id=${chargingPoint.id?string["0"]}" rel="nofollow">Add</a>
                </td>
            </tr>
        </#items>
        </tbody>
    </table>
</#list>