<%@ page import="Sample.HelloWorld" %><%--<%@ page import="Sample.HelloWorld" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Case</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="spannerApp.css">
</head>
<body>
<!--
<div class="container">
    <h2 class="message"><%=HelloWorld.getMessage()%></h2>
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
        <li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
        <li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
        <li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
    </ul>

    <div class="tab-content">
        <div id="home" class="tab-pane fade in active">
            <h3>HOME</h3>
            <p>heheh xdxdxdxd.</p>
        </div>
        <div id="menu1" class="tab-pane fade">
            <h3>Menu 1</h3>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>
        <div id="menu2" class="tab-pane fade">
            <h3>Menu 2</h3>
            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
        </div>
        <div id="menu3" class="tab-pane fade">
            <h3>Menu 3</h3>
            <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
        </div>
    </div>
</div>-->
<nav class="navbar navbar-light ">
    <div class="container-fluid">
        <div class="navbar-header">
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Company</a></li>
                <li><a href="#">Information</a></li>
                <li><a href="#">Contact and Help</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>  NEW ACCOUNT-> Sign up</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container text-center">
    <div class="row">
        <div class="col-sm-4"><br>
            <br></div>
        <div class="col-sm-4">
            <br></br></div>
        <div class="col-sm-4"><br></br></div>
    </div>
</div>
<div class="container text-center">
    <h3>PLEASE SIGN IN</h3><br>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <form class="form-signin">

                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="email" type="email" class="form-control" name="email" value="${HelloWorld.getMessage()}" placeholder="Email Address">
                </div>
                </br>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="password" value="" placeholder="Password">
                </div>
                </br>
                <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>

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

