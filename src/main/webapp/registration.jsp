<!DOCTYPE html>
<html ng-app="login" lang="en">
<head>
    <title>SpannerApp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>

    <script src="login.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>-->
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
<div class="pasek">
    <div class="jumbotron ">
        <div class="container ">
            <div class="row">
                <div class="col-sm-12 col-lg-12">
                    <h1 class="h1"> SpannerApp</h1>
                </div>
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

    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4" ng-controller="controller">
                <h2 class="form-signin-heading">Registration</h2>
                <div class="alert alert-danger" ng-show="error">
                    There was a problem logging in. Please try again.
                </div>
                <div class="alert alert-success" ng-show="!error">
                    We have found user:{{username}} with password:{{password}}
                </div>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="name" type="text" class="form-control" name="username" ng-model="name" placeholder="Name" required>
                </div>
                </br>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input id="surname" type="text" class="form-control" name="username" ng-model="surname" placeholder="Surname" required >
            </div>
            </br>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="password" ng-model="password" placeholder="Password" required>
                </div>
                </br>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input id="password2" type="password" class="form-control" name="password" ng-model="password2" placeholder="Confirm Password" required>
        </div>
        </br>
            <div class="input-group">
                <label><input type="checkbox"  name="" required> I accept the terms and conditions</label>
            </div>
            </br>
                <button ng-click="Registration()"  class="btn btn-sky btn-lg btn-block">Sign In</button>

             </div>
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
