<%--<%@ page import="Sample.HelloWorld" %><%--<%@ page import="Sample.HelloWorld" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>SpannerApp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="SpannerApp.css">
</head>
<body>

<nav class="navbar navbar-light ">
    <div class="container-fluid">
        <div class="navbar-header">
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="menu.jsp">Company</a></li>
                <li><a href="information.jsp">Information</a></li>
                <li><a href="contact.jsp">Contact and Help</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>  Register</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="jumbotron jumbotron-sm pasek">
    <div class="container ">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h1 class="h1"> SpannerApp</h1>
            </div>
        </div>
    </div>
</div>
<div class="container text-center" >
    <div class="row">
        <div class="col-sm-4"><br>
            <br></div>
        <div class="col-sm-4">
            <br></div>
        <div class="col-sm-4"><br></div>
    </div></div>
<div class="container text-center">
    <h3>PLEASE SIGN IN</h3><br>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <form class="form-signin">

                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="email" type="email" class="form-control" name="email" value="" placeholder="Email Address">
                </div>
                </br>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="password" value="" placeholder="Password">
                </div>
                </br>
                <button type="submit"  class="btn btn-sky btn-lg btn-block"><a href="">Login</a></button>

            </form>
            <div class="col-sm-4"></div>
        </div>
    </div><br>
</div>
    <br>
    <div class="container text-center">
        </br>
        </br>
        </br>
        </br>
        </br>
    </div>


</body>
</html>

