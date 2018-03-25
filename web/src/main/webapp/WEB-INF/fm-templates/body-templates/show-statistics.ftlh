<h1>${title} - results</h1>
<hr/>

<div class="container">
    <div class="row">

        <div class="col-lg-4" id="list-of-points">
        <#list locationList>
            <#items as location>
<div class="card border-primary mb-3" style="max-width: 20rem;">

    <h3 class="card-header">${location.name}</h3>
    <div class="card-body">
        <p class="card-text"><strong>Number of visits:</strong> ${location.numberOfVisits} <br/>
        </p>
    </div>
</div>
            </#items>
        </#list>

        </div>
    </div>
</div>

