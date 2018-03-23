<h1>Find all charging points in radius</h1>
<hr/>
<form method="get" action="/find-the-closest-in-radius-by-address">
    <fieldset>
        <div class='container'>
            <div class="form-group">
                <label for="town">Address</label>
            <input type="text" name="address" class="form-control" placeholder="Enter address">
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


