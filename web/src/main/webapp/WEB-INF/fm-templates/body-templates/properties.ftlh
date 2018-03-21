<h1>Properties</h1>
<hr/>

<div class="col-12">
    <form method="post" action="/administration/properties" >
        <fieldset>
            <div class="form-group">
                 <label for="unit">Units</label>
                    <select class="form-control" id="unit" name="unit" style="width:150px;">
                    <#list units as unit>
                        <#if unit == current_unit>
                            <option selected>${unit}</option>
                        <#else>
                            <option>${unit}</option>
                        </#if>
                      </#list>
                    </select>
            </div>

            <div class="form-group">
                <label for="api_key">Google API Key</label>
                <input type="text" name="api_key" class="form-control" value="${api_key}" style="width:350px;">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </fieldset>
    </form>
</div>