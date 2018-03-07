<h1>Find the closest charging point in radius</h1>
<hr/>

    <form method="get" action="/find-the-closest-in-radius">
        <fieldset>
            <div class='container'>
                <label for="longitude">Longitude</label>
                <div class="row">
                    <div class="col-2">
                        <div class="form-group">

                            <input type="text" name="degrees" class="form-control" placeholder="Enter degrees">
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="form-group">
                            <input type="text" name="minutes" class="form-control" placeholder="Enter minutes">
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="form-group">
                            <input type="text" name="second" class="form-control" placeholder="Enter second">
                        </div>
                    </div>
                </div>
                <label for="latitude">Latitude</label>
                <div class="row">
                    <div class="col-2">
                        <div class="form-group">

                            <input type="text" name="degrees" class="form-control" placeholder="Enter degrees">
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="form-group">
                            <input type="text" name="minutes" class="form-control" placeholder="Enter minutes">
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="form-group">
                            <input type="text" name="second" class="form-control" placeholder="Enter second">
                        </div>
                    </div>
                </div>
                <label for="radius">Radius</label>
                <div class="row">
                    <div class="col-2">
                        <div class="form-group">
                            <input type="text" name="unit" class="form-control" placeholder="[metres]">
                        </div>
                    </div>
                </div>
        </fieldset>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>


