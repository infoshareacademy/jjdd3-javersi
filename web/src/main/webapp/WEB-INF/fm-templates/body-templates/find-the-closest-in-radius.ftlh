<h1>Find the closest charging point in radius</h1>
<hr/>
    <form method="get" action="/find-the-closest-in-radius">
        <fieldset>
            <div class='container'>
                <label for="latitude">Latitude</label>
                <div class="row">
                    <div class="col-1">
                        <select class="form-control" id="unit" name="directionLati">
                            <option>N</option>
                            <option>S</option>
                        </select>
                    </div>
                    <div class="col-2">
                        <div class="form-group">

                            <input type="text" name="degreesLati" class="form-control" placeholder="Enter degrees">
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="form-group">
                            <input type="text" name="minutesLati" class="form-control" placeholder="Enter minutes">
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="form-group">
                            <input type="text" name="secondLati" class="form-control" placeholder="Enter second">
                        </div>
                    </div>
                </div>
                <label for="longitude">Longitude</label>
                <div class="row">
                    <div class="col-1">
                        <select class="form-control" id="unit" name="directionLong">
                            <option>E</option>
                            <option>W</option>
                        </select>
                     </div>
                    <div class="col-2">
                        <div class="form-group">

                            <input type="text" name="degreesLong" class="form-control" placeholder="Enter degrees">
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="form-group">
                            <input type="text" name="minutesLong" class="form-control" placeholder="Enter minutes">
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="form-group">
                            <input type="text" name="secondLong" class="form-control" placeholder="Enter second">
                        </div>
                    </div>
                </div>
                <label for="radius">Radius</label>
                <div class="row">
                    <div class="col-2">
                        <div class="form-group">
                            <input type="text" name="radius" class="form-control" placeholder="[${current_unit}]">
                        </div>
                    </div>
                </div>
        </fieldset>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>


