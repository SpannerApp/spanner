
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="SpannerApp.css">
    <style>
        div.scroll {
            background-color: #87CEEB;
            width: 1000px;
            height: 300px;
            overflow: scroll;
        }
        div.header {
            background-color: #87CEEB;
            width: 100px;
            height: 100px;
            overflow: hidden;
        }
        </style>
</head>
<body>

<nav class="navbar navbar-light">
    <div class="container-fluid">
        <div class="navbar-header">
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="menu.jsp">Company</a></li>
                <li><a href="information.jsp">Information</a></li>
                <li><a href="contact.jsp">Contact and Help</a></li>
                <li><a href="admin.jsp">Admin</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>  Register</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>  Back</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>  Log out</a></li>
            </ul>
        </div>
    </div>
</nav>
    <div class="jumbotron pasek">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-lg-12">
                    <h1 class="h1">
                        Spanner App <small> Workers in company</small></h1>
                </div>
            </div>
        </div>
    </div>

<div class="container">
    <h2>Users</h2>
<div class = "scroll">

        <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">

            <thead >
            <tr>
                <th>User No</th>
                <th>FirstName</th>
                <th>Lastname</th>
                <th>Mail</th>
                <th>Password</th>
                <th>Type</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>annan@gmail.com</td>
                <td>xxxxxx</td>
                <td>WORKER</td>
            </tr>
            </tbody>
            <tbody>
            <tr>
                <td>2</td>
                <td>Jacob</td>
                <td>Sandler</td>
                <td>j.sandler@gmail.com</td>
                <td>xxxxxx</td>
                <td>MANAGER</td>
            </tr>
            </tbody>
            <tbody>
            <tr>
                <td>3</td>
                <td>Leon</td>
                <td>Kosinski</td>
                <td>l.kosinski@gmail.com</td>
                <td>xxxxxx</td>
                <td>SERWIS</td>
            </tr>
            </tbody>
            <tbody>
            <tr>
                <td>4</td>
                <td>Anna</td>
                <td>Dane</td>
                <td>a.dane@gmail.com</td>
                <td>xxxxxx</td>
                <td>WORKER</td>
            </tr>
            </tbody>
            <tbody>
            <tr>
                <td>5</td>
                <td>Mary</td>
                <td>White</td>
                <td>mary.white@gmail.com</td>
                <td>xxxxxx</td>
                <td>MANAGER</td>
            </tr>
            <tr>
                <td>6</td>
                <td>Amy</td>
                <td>Black</td>
                <td>amy.black@gmail.com</td>
                <td>xxxxxx</td>
                <td>WORKER</td>
            </tr>
            <tr>
                <td>7</td>
                <td>Hans</td>
                <td>Kloppenberg</td>
                <td>hans.hans@gmail.com</td>
                <td>xxxxxx</td>
                <td>SERWIS</td>
            </tr>
            <tr>
                <td>8</td>
                <td>Caroline</td>
                <td>Lipstick</td>
                <td>caor.caroline@gmail.com</td>
                <td>xxxxxx</td>
                <td>WORKER</td>
            </tr>
            <tr>
                <td>9</td>
                <td>Henry</td>
                <td>Pomstuck</td>
                <td>hi.henry@gmail.com</td>
                <td>xxxxxx</td>
                <td>MANAGER</td>
            </tr>
            <tr>
                <td>10</td>
                <td>Pablo</td>
                <td>Greenseem</td>
                <td>pablo.greenseem@gmail.com</td>
                <td>xxxxxx</td>
                <td>WORKER</td>
            </tr>
            <tr>
                <td>11</td>
                <td>Gary</td>
                <td>White</td>
                <td>gary.white@gmail.com</td>
                <td>xxxxxx</td>
                <td>MANAGER</td>
            </tr>
            <tr>
                <td>12</td>
                <td>Lime</td>
                <td>Domestock</td>
                <td>lime.limon@gmail.com</td>
                <td>xxxxxx</td>
                <td>SERWIS</td>
            </tr>
            <tr>
                <td>13</td>
                <td>Olivia</td>
                <td>Horizontal</td>
                <td>olivia.horizontal@gmail.com</td>
                <td>xxxxxx</td>
                <td>WORKER</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</div>

<%--check if script and sort--%>
<script>
    $(document).ready(function() {
        $('#example').DataTable();
    } );
</script>
<script src="sorttable.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>

</body>
</html>