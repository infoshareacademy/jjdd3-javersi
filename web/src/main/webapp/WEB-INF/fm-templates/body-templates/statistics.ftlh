<h1>${title}</h1>
<hr/>

<div class="col-3">
<#if error??>
        <div class="alert alert-dismissible alert-danger">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${error}
        </div>
</#if>
    <form method="post" action="/statistics?location=country">
        <fieldset>
            <button type="submit" class="btn btn-primary" name="location">Show statistics for countries</button>
        </fieldset>
    </form>
    </br>
    <form method="post" action="/statistics?location=town">
        <fieldset>
            <button type="submit" class="btn btn-primary">Show statistics for towns</button>
        </fieldset>
    </form>
</div>
