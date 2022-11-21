<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"%>


<html lang="en">

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
<!-- body -->

<body class="main-layout">
    <!-- loader  -->
    <div class="loader_bg">
        <div class="loader"><img src="./static/images/loading.gif" alt="" /></div>
    </div>

    <div class="wrapper">
    <!-- end loader -->


    <div id="content">
    <!-- header -->
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
    <!-- end header -->
    <!-- start slider section -->
    <div class="slider_section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="full">
                        <div id="main_slider" class="carousel vert slide" data-ride="carousel" data-interval="5000">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="slider_cont">
                                                <h3>Every CHAMPion deserves a feast</h3>
                                                <p>It is a new established cafeteria developed by The CHAMPorado's which is dedicated to the CHAMP cargo system company where the employees can order their food using this website.</p>
                                                <a class="main_bt_border" href="./login.jsp">Order Now</a>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <div class="slider_image full text_align_center">
                                                <img class="img-responsive" src="./static/images/ChamporadoSlide.png" alt="#" style="background-color: ; width: 800px; margin-top: 50px;"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="slider_cont">
                                                <h3>Every CHAMPion deserves a feast</h3>
                                                <p>It is a new established cafeteria developed by The CHAMPorado's which is dedicated to the CHAMP cargo system company where the employees can order their food using this website.</p>
                                                <a class="main_bt_border" href="./login.jsp">Order Now</a>
                                            </div>
                                        </div>
                                        <div class="col-md-7 full text_align_center">
                                            <div class="slider_image">
                                                <img class="img-responsive" src="./static/images/burger_slide.png" alt="#" style="background-color: ; width: 700px; margin-top: 50px;"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                 <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="slider_cont">
                                                <h3>Every CHAMPion deserves a feast</h3>
                                                <p>It is a new established cafeteria developed by The CHAMPorado's which is dedicated to the CHAMP cargo system company where the employees can order their food using this website.</p>
                                                <a class="main_bt_border" href="./login.jsp">Order Now</a>
                                            </div>
                                        </div>
                                        <div class="col-md-7 full text_align_center">
                                            <div class="slider_image">
                                                <img class="img-responsive" src="./static/images/rs3.png" alt="#" style="background-color: ; width: 600px; margin-top: 50px;"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#main_slider" role="button" data-slide="prev">
                                <i class="fa fa-angle-up"></i>
                            </a>
                            <a class="carousel-control-next" href="#main_slider" role="button" data-slide="next">
                                <i class="fa fa-angle-down"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>












    <!-- section -->
    <section class="resip_section">
        <div class="container">
            <div class="row">
         <div class="col-md-12">
       <div class="ourheading">
    <h2>Our Dishes</h2>
  </div>
</div>    
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="owl-carousel owl-theme">

                <div class="item">
                    <div class="product_blog_img">
                        <img src="./static/images/rs1.png" alt="#" />
                    </div>
                    <div class="product_blog_cont">
                        <h3>Homemade</h3>
                        <h4><span class="theme_color">&#8369</span>180.00</h4>
                    </div>
                </div>
                <div class="item">
                    <div class="product_blog_img">
                        <img src="./static/images/rs2.png" alt="#" />
                    </div>
                    <div class="product_blog_cont">
                        <h3>Noodles</h3>
                        <h4><span class="theme_color">&#8369</span>200.00</h4>
                    </div>
                </div>
                <div class="item">
                    <div class="product_blog_img">
                        <img src="./static/images/rs3.png" alt="#" />
                    </div>
                    <div class="product_blog_cont">
                        <h3>Egg</h3>
                        <h4><span class="theme_color">&#8369</span>150.00</h4>
                    </div>
                </div>
                <div class="item">
                    <div class="product_blog_img">
                        <img src="./static/images/rs4.png" alt="#" />
                    </div>
                    <div class="product_blog_cont">
                        <h3>Sushi Dizzy</h3>
                        <h4><span class="theme_color">&#8369</span>100.00</h4>
                    </div>
                </div>
                <div class="item">
                    <div class="product_blog_img">
                        <img src="./static/images/rs5.png" alt="#" />
                    </div>
                    <div class="product_blog_cont">
                        <h3>The Coffee Break</h3>
                        <h4><span class="theme_color">&#8369</span>450.00</h4>
                    </div>
                </div>
                <div class="item">
                    <div class="product_blog_img">
                        <img src="./static/images/rs1.png" alt="#" />
                    </div>
                    <div class="product_blog_cont">
                        <h3>Homemade</h3>
                        <h4><span class="theme_color">&#8369</span>80.00</h4>
                    </div>
                </div>
                <div class="item">
                    <div class="product_blog_img">
                        <img src="./static/images/rs2.png" alt="#" />
                    </div>
                    <div class="product_blog_cont">
                        <h3>Noodles</h3>
                        <h4><span class="theme_color">&#8369</span>200.00</h4>
                    </div>
                </div>
                <div class="item">
                    <div class="product_blog_img">
                        <img src="./static/images/rs3.png" alt="#" />
                    </div>
                    <div class="product_blog_cont">
                        <h3>Egg</h3>
                        <h4><span class="theme_color">&#8369</span>350.00</h4>
                    </div>
                </div>
                <div class="item">
                    <div class="product_blog_img">
                        <img src="./static/images/rs4.png" alt="#" />
                    </div>
                    <div class="product_blog_cont">
                        <h3>Sushi Dizzy</h3>
                        <h4><span class="theme_color">&#8369</span>400.00</h4>
                    </div>
                </div>
                <div class="item">
                    <div class="product_blog_img">
                        <img src="./static/images/rs5.png" alt="#" />
                    </div>
                    <div class="product_blog_cont">
                        <h3>The Coffee Break</h3>
                        <h4><span class="theme_color">&#8369</span>220.00</h4>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</div>
</div>
</section>
<div class="bg_bg">
<!-- about -->
<div class="about">
    <div class="container">
      <div class="row">
         <div class="col-md-12">
             <div class="title">
                <i><img src="./static/images/dish.png" alt="#"/></i>
                <h2>About CHAMP cafeteria</h2>
                <span>It is a new established cafeteria developed by The CHAMPorado's which is dedicated to the CHAMP cargo system company where the employees can order their food using this website.
                </span>
             </div>
          </div>
       </div>
       <div class="row">
         <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
             <div class="about_box">
                 <h3>Best Food</h3>
                 <p>Champorado is a thick Filipino rice pudding. Originally prepared with chocolate, nowadays it is usually made with cooked glutinous rice blended with sugar and cocoa powder. The origins of the dish derive from a Mexican chocolate-based drink known as champurrado, which was introduced during the colonial period.

Usually enjoyed as a hearty breakfast or a sweet afternoon snack, Filipino champorado can be served hot or cold, drizzled with condensed milk, or accompanied by salted dry fish.</p>
                 <a href="">Read More <i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
             </div>
         </div>
         
          <div class="col-xl-5 col-lg-5 col-md-10 col-sm-12 about_img_boxpdnt" >
             <div class="about_img" style="background-color: #C91F45;">
                 <figure><img src="./static/images/Champorado.jpg" alt="#/" style="border: 1px solid gray;"></figure>
             </div>
         </div>      
       </div> 
    </div>
</div>
<!-- end about -->

<!-- blog -->
<div class="blog">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="title">
          <i><img src="./static/images/dish.png" alt="#"/></i>
          <h2>Our Best Seller</h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 mar_bottom">
        <div class="blog_box">
          <div class="blog_img_box">
            <figure><img src="./static/images/blog_img1.png" alt="#"/>
             <span style="width: 150px;">21 NOV 2022</span>
            </figure>
          </div>
          <h3>Spicy Barger</h3>
          <p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the </p>
        </div>
      </div>
       <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 mar_bottom">
        <div class="blog_box">
          <div class="blog_img_box">
            <figure><img src="./static/images/blog_img2.png" alt="#"/>
             <span style="width: 150px;">21 NOV 2022</span>
            </figure>
          </div>
          <h3>Egg & Tosh</h3>
          <p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the </p>
        </div>
      </div>
       <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
        <div class="blog_box">
          <div class="blog_img_box">
            <figure><img src="./static/images/blog_img3.png" alt="#"/>
             <span style="width: 150px;">21 NOV 2022</span>
            </figure>
          </div>
          <h3>Pizza</h3>
          <p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the </p>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- end blog -->

</div>
    <!-- footer -->
    <fooetr>
        <div class="footer" style="background-color: #C91F45; height: 200px;" >
           
            
             <img src="./static/images/logo1.png" alt="logo" style="width: 400px; margin-top: -50px; margin-left: 650px;"/>
            <div class="copyright" style="margin-top: -10px;">
                <div class="container">
                    <p>© 2019 All Rights Reserved. Design by<a href="https://html.design/"> Free Html Templates</a></p>
                </div>
            </div>
        </div>
    </fooetr>
    <!-- end footer -->

    </div>
    </div>
    <div class="overlay"></div>
    <!-- Javascript files-->
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

</body>

</html>