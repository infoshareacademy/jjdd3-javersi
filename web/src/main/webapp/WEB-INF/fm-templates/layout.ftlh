<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://bootswatch.com/4/sandstone/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="site.css" crossorigin="anonymous">

    <style>
        #map {
            width: 100% px;
            height: 500px;
            background-color: grey;
        }

        #list-of-points {
            position: relative;
            overflow-y: scroll;
            height: 500px;
        }
    </style>

    <title>${title}</title>
</head>
<body style="padding-top: 70px;">
    <#include "/common/navbar.ftlh">

<div class="container body-content">

        <#include "/body-templates/" + body_template + ".ftlh">

        <#include "/common/footer.ftlh">
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

<script>
    $(document).ready(function () {

        $("#recordsAddedModal").modal('show');

    });

</script>
</body>
</html>