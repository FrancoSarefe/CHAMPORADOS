<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"%>

<head>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>CHAMP CAFETERIA</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- bootstrap css -->
    <link rel="stylesheet" href="./static/css2/bootstrap.min.css">
    <!-- owl css -->
    <link rel="stylesheet" href="./static/css2/owl.carousel.min.css">
    <!-- style css -->
    <link rel="stylesheet" href="./static/css2/style.css">
    <!-- responsive-->
    <link rel="stylesheet" href="./static/css2/responsive.css">
    <!-- awesome fontfamily -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>

<header style="background-color: #C91F45;">
    <div class="container-fluid" >
        <div class="row" style="background-color: #C91F45;">
            <div class="col-md-3">
                <div class="full">
                    <a class="logo" href="index.jsp"><img src="./static/images/logo1.png" alt="#" width="200" height="100" /></a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="full">
                    <div class="right_header_info">
                        <ul>
                            <li class="dinone">Contact Us : <img style="margin-right: 15px;margin-left: 15px;" src="./static/images/phone_icon.png" alt="#"><a href="#">09770566290</a></li>
                            <li class="dinone"><img style="margin-right: 15px;" src="./static/images/mail_icon.png" alt="#"><a href="#">theChamporados@gmail.com</a></li>
                            <li class="dinone"><img style="margin-right: 15px;height: 21px;position: relative;top: -2px;" src="./static/images/location_icon.png" alt="#"><a href="#">3rd Ave, Taguig, 1634 Metro Manila
</a></li>
                                <li class="button_user" ><a class="button" href="${pageContext.request.contextPath }/login.jsp" style="background-color: #1f1f1f; color: white;">Login</a>
                            
                            <a class="button" href="${pageContext.request.contextPath }/registration.jsp">Register</a></li>
            
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<script src="./static/js2/jquery.min.js"></script>
    <script src="./static/js2/popper.min.js"></script>
    <script src="./static/js2/bootstrap.bundle.min.js"></script>
    <script src="./static/js2/owl.carousel.min.js"></script>
    <script src="./static/js2/custom.js"></script>
     <script src="./static/js2/jquery.mCustomScrollbar.concat.min.js"></script>
    
     <script src="./static/js2/jquery-3.0.0.min.js"></script>
   <script type="text/javascript">
        $(document).ready(function() {
            $("#sidebar").mCustomScrollbar({
                theme: "minimal"
            });

            $('#dismiss, .overlay').on('click', function() {
                $('#sidebar').removeClass('active');
                $('.overlay').removeClass('active');
            });

            $('#sidebarCollapse').on('click', function() {
                $('#sidebar').addClass('active');
                $('.overlay').addClass('active');
                $('.collapse.in').toggleClass('in');
                $('a[aria-expanded=true]').attr('aria-expanded', 'false');
            });
        });
    </script>

    <style>
    #owl-demo .item{
        margin: 3px;
    }
    #owl-demo .item img{
        display: block;
        width: 100%;
        height: auto;
    }
    </style>

     
      <script>
         $(document).ready(function() {
           var owl = $('.owl-carousel');
           owl.owlCarousel({
             margin: 10,
             nav: true,
             loop: true,
             responsive: {
               0: {
                 items: 1
               },
               600: {
                 items: 2
               },
               1000: {
                 items: 5
               }
             }
           })
         })
      </script> 

