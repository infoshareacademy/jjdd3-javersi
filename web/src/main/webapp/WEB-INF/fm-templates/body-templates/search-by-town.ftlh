<h1>${title}</h1>
<hr/>

<div class="col-3">
    <#if error??>
        <div class="alert alert-dismissible alert-danger">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${error}
        </div>
    </#if>
    <form method="get" action="/search-by-town">
        <fieldset>
            <div class="form-group">
                <label for="town">Town</label>
                <input type="text" name="town" class="form-control" placeholder="Enter town">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </fieldset>
    </form>
</div>
