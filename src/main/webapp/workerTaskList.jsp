<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Worker Task List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="SpannerApp.css">
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
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>  Register</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h1 class="h1">
                    My Reports.<small> see all notifications!</small></h1>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">

        <section class="content">
            <div class="col-md-8 col-md-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="pull-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-success btn-filter" data-target="accepted">Accepted</button>
                                <button type="button" class="btn btn-warning btn-filter" data-target="pending">Pending</button>
                                <button type="button" class="btn btn-danger btn-filter" data-target="rejected">Rejected</button>
                                <button type="button" class="btn btn-default btn-filter" data-target="all">All</button>
                            </div>
                        </div>
                        <div class="table-container">
                            <table class="table table-filter">
                                <tbody>
                                <tr data-status="accepted">
                                    <td>
                                        <div class="ckbox">
                                            <input type="checkbox" id="checkbox1">
                                            <label for="checkbox1"></label>
                                        </div>
                                    </td>
                                    <td>
                                        <a href="javascript:;" class="star">
                                            <i class="glyphicon glyphicon-star"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <div class="media">
                                            <a href="#" class="pull-left">
                                                <img src="http://findicons.com/files/icons/2770/ios_7_icons/128/worker.png" class="media-photo">
                                            </a>
                                            <div class="media-body">
                                                <span class="media-meta pull-right">07.04.2017</span>
                                                <h4 class="title">

                                                    <span class="pull-right accepted">(Accepted)</span>
                                                </h4>
                                                <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr data-status="pending">
                                    <td>
                                        <div class="ckbox">
                                            <input type="checkbox" id="checkbox3">
                                            <label for="checkbox3"></label>
                                        </div>
                                    </td>
                                    <td>
                                        <a href="javascript:;" class="star">
                                            <i class="glyphicon glyphicon-star"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <div class="media">
                                            <a href="#" class="pull-left">
                                                <img src="http://findicons.com/files/icons/2770/ios_7_icons/128/worker.png" class="media-photo">
                                            </a>
                                            <div class="media-body">
                                                <span class="media-meta pull-right">07.04.2017</span>
                                                <h4 class="title">
                                                    Lorem Impsum
                                                    <span class="pull-right pending">(Pending)</span>
                                                </h4>
                                                <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr data-status="rejected">
                                    <td>
                                        <div class="ckbox">
                                            <input type="checkbox" id="checkbox2">
                                            <label for="checkbox2"></label>
                                        </div>
                                    </td>
                                    <td>
                                        <a href="javascript:;" class="star">
                                            <i class="glyphicon glyphicon-star"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <div class="media">
                                            <a href="#" class="pull-left">
                                                <img src="http://findicons.com/files/icons/2770/ios_7_icons/128/worker.png" class="media-photo">
                                            </a>
                                            <div class="media-body">
                                                <span class="media-meta pull-right">07.04.2017</span>
                                                <h4 class="title">
                                                    Lorem Impsum
                                                    <span class="pull-right rejected">(Rejected)</span>
                                                </h4>
                                                <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr data-status="accepted" class="selected">
                                    <td>
                                        <div class="ckbox">
                                            <input type="checkbox" id="checkbox4" checked>
                                            <label for="checkbox4"></label>
                                        </div>
                                    </td>
                                    <td>
                                        <a href="javascript:;" class="star star-checked">
                                            <i class="glyphicon glyphicon-star"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <div class="media">
                                            <a href="#" class="pull-left">
                                                <img src="http://findicons.com/files/icons/2770/ios_7_icons/128/worker.png" class="media-photo">
                                            </a>
                                            <div class="media-body">
                                                <span class="media-meta pull-right">07.04.2017</span>
                                                <h4 class="title">
                                                    Lorem Impsum
                                                    <span class="pull-right accepted">(Accepted)</span>
                                                </h4>
                                                <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr data-status="pending">
                                    <td>
                                        <div class="ckbox">
                                            <input type="checkbox" id="checkbox5">
                                            <label for="checkbox5"></label>
                                        </div>
                                    </td>
                                    <td>
                                        <a href="javascript:;" class="star">
                                            <i class="glyphicon glyphicon-star"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <div class="media">
                                            <a href="#" class="pull-left">
                                                <img src="http://findicons.com/files/icons/2770/ios_7_icons/128/worker.png" class="media-photo">
                                            </a>
                                            <div class="media-body">
                                                <span class="media-meta pull-right">07.04.2017</span>
                                                <h4 class="title">
                                                    Lorem Impsum
                                                    <span class="pull-right pending">(Pending)</span>
                                                </h4>
                                                <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
</div>
</div>

<script type="text/javascript">
    $(document).ready(function () {

        $('.star').on('click', function () {
            $(this).toggleClass('star-checked');
        });

        $('.ckbox label').on('click', function () {
            $(this).parents('tr').toggleClass('selected');
        });

        $('.btn-filter').on('click', function () {
            var $target = $(this).data('target');
            if ($target != 'all') {
                $('.table tr').css('display', 'none');
                $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
            } else {
                $('.table tr').css('display', 'none').fadeIn('slow');
            }
        });

    });
</script>
</body>
</html>
