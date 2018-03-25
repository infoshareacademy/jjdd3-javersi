<h1>Api data upload</h1>
<hr/>
<div class="col-3">
    <form method="post" action="/administration/load-data-upload?option=all">
    <fieldset>
        <button type="submit" class="btn btn-primary">Upload all chargingpoints</button>
    </fieldset>
    </form>
    </br>
    <form method="post" action="/administration/load-data-upload?option=pl">
        <fieldset>
            <button type="submit" class="btn btn-primary">Upload all chargingpoints in India</button>
        </fieldset>
    </form>
</div>

<#if (recordsAdded) ??>
 <div class="modal fade" id="recordsAddedModal" role="document">
     <div class="modal-dialog">

         <!-- Modal content-->
         <div class="modal-content">
             <div class="modal-header">
                 <h4 class="modal-title">Data uploaded</h4>
                 <button type="button" class="close" data-dismiss="modal">&times;</button>

             </div>
             <div class="modal-body">
                 <p> ${recordsAdded} records have been added.</p>
             </div>
             <div class="modal-footer">

                 <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
             </div>
         </div>

     </div>
 </div>


</#if>

