<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Error Page</title>
    <!-- Bootstrap core CSS -->
    <link href="/error_page/css/bootstrap.css" rel="stylesheet">
    <!-- FONT AWESOME CSS -->
    <link href="/error_page/css/font-awesome.min.css" rel="stylesheet" />
    <!--GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Nova+Flat' rel='stylesheet' type='text/css'>
    <!-- custom CSS here -->
    <link href="/error_page/css/style.css" rel="stylesheet" />
</head>
<#include "common.ftl">

<body>


<div class="container">

    <div class="row pad-top text-center">
        <div class="col-md-6 col-md-offset-3 text-center">
            <h1>  What have you done? </h1>
            <h5> Now Go Back Using Below LInk</h5>
            <span id="error-link"></span>
            <h2>! ERROR DECETED !</h2>
        </div>
    </div>

    <div class="row text-center">
        <div class="col-md-8 col-md-offset-2">

            <h3> <i  class="fa fa-lightbulb-o fa-5x"></i> </h3>
            <a href="${base}/" class="btn btn-primary">GO TO HOME PAGE</a>
        </div>

    </div>

</div>
<!-- /.container -->


<!--Core JavaScript file  -->
<script src="/error_page/js/jquery-1.10.2.js"></script>
<!--bootstrap JavaScript file  -->
<script src="/error_page/js/bootstrap.js"></script>
<!--Count Number JavaScript file  -->
<script src="/error_page/js/countUp.js"></script>
<!--Custom JavaScript file  -->
<script src="/error_page/js/custom.js"></script>
</body>
</html>
