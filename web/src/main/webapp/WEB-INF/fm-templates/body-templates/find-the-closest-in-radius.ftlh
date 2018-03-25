<h1>Find all charging points in radius</h1>
<hr/>
<#if error??>
        <div class="alert alert-dismissible alert-danger">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${error}
        </div>
</#if>
<form method="get" action="/find-the-closest-in-radius">
    <fieldset>
        <div class='container'>
            <label for="latitude">Latitude</label>
            <div class="form-inline">
                <div class="form-group">
                    <select class="form-control" id="unit" name="directionLati" style="width:60px;">
                        <option>N</option>
                        <option>S</option>
                    </select>
                </div>
                <div class="form-group">
                    <div class="input-group ml-2">
                        <input type="number" class="form-control" name="degreesLati" style="width:70px;"
                               max="90" min="0" value="0" maxlength="2">
                        <div class="input-group-append">
                            <span class="input-group-text">°</span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group ml-2">
                        <input type="number" class="form-control" name="minutesLati" style="width: 60px;"
                               max="60" min="0" value="0" maxlength="2">
                        <div class="input-group-append">
                            <span class="input-group-text">'</span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group ml-2">
                        <input type="number" class="form-control" name="secondLati" style="width: 60px;"
                               max="60" min="0" value="0" maxlength="2">
                        <div class="input-group-append">
                            <span class="input-group-text">"</span>
                        </div>
                    </div>
                </div>
            </div>
            <label for="longitude">Longitude</label>
            <div class="form-inline">
                <div class="form-group">
                    <select class="form-control" id="unit" name="directionLong" style="width:60px;">
                        <option>E</option>
                        <option>W</option>
                    </select>
                </div>
                <div class="form-group">
                    <div class="input-group ml-2">
                        <input type="number" class="form-control" name="degreesLong" style="width:70px;"
                               max="180" min="0" value="0" maxlength="2">
                        <div class="input-group-append">
                            <span class="input-group-text">°</span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group ml-2">
                        <input type="number" class="form-control" name="minutesLong" style="width: 60px;"
                               max="60" min="0" value="0" maxlength="2">
                        <div class="input-group-append">
                            <span class="input-group-text">'</span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group ml-2">
                        <input type="number" class="form-control" name="secondLong" style="width: 60px;"
                               max="60" min="0" value="0" maxlength="2">
                        <div class="input-group-append">
                            <span class="input-group-text">"</span>
                        </div>
                    </div>
                </div>
            </div>
            <label for="radius">Radius</label>
            <div class="form-inline">
                <div class="form-group">
                    <div class="input-group" >
                        <input type="number" name="radius" class="form-control" value="0" style="width: 80px;">
                        <div class="input-group-append">
                            <span class="input-group-text">${current_unit}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </fieldset>
    <button type="submit" class="btn btn-primary mt-2">Submit</button>
</form>


