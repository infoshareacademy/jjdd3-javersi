<h1>JSON file upload</h1>
<hr/>
<div class="col-3">
    <form method="post" action="/administration/json-file-upload"" enctype="multipart/form-data">
        <fieldset>
            <div class="form-group">
                <label for="jsonFile">JSON Charging points file:</label>
                <input type="file" class="form-control-file" id="jsonFile" name="jsonFile" aria-describedby="fileHelp">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </fieldset>
    </form>
</div>

<#if (recordsAdded) ??>
 <div class="modal fade" id="recordsAddedModal" role="document">
     <div class="modal-dialog">

         <!-- Modal content-->
         <div class="modal-content">
             <div class="modal-header">
                 <h4 class="modal-title">File uploaded</h4>
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

