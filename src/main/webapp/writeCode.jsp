
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>SpannerApp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>-->
    <link rel="stylesheet" href="SpannerApp.css">

    </head>
<body>
<nav class="navbar navbar-light ">
    <div class="container-fluid">
        <div class="navbar-header">
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="menu.jsp">Home</a></li>
                <li><a href="menu.jsp">Company</a></li>
                <li><a href="information.jsp">Information</a></li>
                <li><a href="contact.jsp">Contact and Help</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Register</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="jumbotron pasek">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h1 class="h1">SpannerApp
                     <small> Check what you have!</small></h1>
            </div>
        </div>
    </div>
</div>

<div class="container text-center">
    <h3></h3><br>
    <div class="row">
        <div class="col-sm-5">
            <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
            <p>Logo Spannerapp</p>
        </div>
        <div class="col-sm-1">

        </div>
        <div class="col-sm-4">
        <h3>Check the serial number</h3>
        <form class="form-signin">

            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-barcode"></i></span>
                <input id="code"  class="form-control" name="code" value="EXTR/19855" placeholder="">
            </div>
            </br>
            <a href=""> <button type="submit"  class="btn btn-primary btn-lg btn-block">Search</button></a>

        </form>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div><br>


</body>
</html>