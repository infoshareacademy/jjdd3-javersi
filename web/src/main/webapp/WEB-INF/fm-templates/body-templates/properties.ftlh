<h1>Properties</h1>
<hr/>

<div class="col-3">
    <form method="get" action="/administration/properties" >
        <fieldset>
            <div class="form-group">
                 <label for="unit">Units</label>
                    <select class="form-control" id="unit" name="unit">
                    <#list units as unit>
                        <#if unit == current_unit>
                            <option selected>${unit}</option>
                        <#else>
                            <option>${unit}</option>
                        </#if>
                      </#list>
                    </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </fieldset>
    </form>
</div>