<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ProductDAO"%>
<%@page import="Model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/bootstrap.css" rel="stylesheet" type="text/css"

	media="all" />

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<script src="js/jquery.min.js"></script> 

<!-- Custom Theme files -->

<!--theme-style-->

<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

<!--//theme-style-->

<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="keywords"

	content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 

Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<script type="application/x-javascript">

	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>

<!--fonts-->

<link

	href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'

	rel='stylesheet' type='text/css'>

<!--//fonts-->

<script type="text/javascript" src="js/move-top.js"></script>

<script type="text/javascript" src="js/easing.js"></script>

<script type="text/javascript">

	jQuery(document).ready(function($) {

		$(".scroll").click(function(event) {

			event.preventDefault();

			$('html,body').animate({

				scrollTop : $(this.hash).offset().top

			}, 1000);

		});

	});

</script>

<!--slider-script-->

<script src="js/responsiveslides.min.js"></script>

<script>

	$(function() {

		$("#slider1").responsiveSlides({

			auto : true,

			speed : 500,

			namespace : "callbacks",

			pager : true,

		});

	});

</script>

<!--//slider-script-->

<script>

	$(document).ready(function(c) {

		$('.alert-close').on('click', function(c) {

			$('.message').fadeOut('slow', function(c) {

				$('.message').remove();

			});

		});

	});

</script>

<script>

	$(document).ready(function(c) {

		$('.alert-close1').on('click', function(c) {

			$('.message1').fadeOut('slow', function(c) {

				$('.message1').remove();

			});

		});

	});

</script>

<title>product</title>

</head>

<body>

	<%
		ProductDAO productDAO= new ProductDAO();
		long category_id=0;
		if(request.getParameter("categoryID")!= null){
			
			category_id=Long.parseLong(request.getParameter("categoryID"));
			
		}
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart== null ){
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		int pages = 0,firstResult=0,maxResult=0,total=0;
		if(request.getParameter("pages")!= null){
			pages =Integer.parseInt( request.getParameter("pages"));
		}
		total= productDAO.countProductbyCategory(category_id);
		if(total <=4){
			firstResult=0;
			maxResult=total;
		}else{
			firstResult=( pages -1) * 4 ;
			maxResult=4;
		}
		ArrayList<Product> listProduct=productDAO.getListProductbyPage(category_id, firstResult,maxResult);
	%>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">

		<div class="content">

			<div class="content-top">

				<h3 class="future">FEATURED</h3>

				<div class="content-top-in">

					<%
						for(Product p : listProduct){
					%>
					<div class="col-md-3 md-col">

						<div class="col-md">

							<a href="single.jsp?productID=<%= p.getProductID() %>"><img src="<%=p.getProductImage() %>" alt="<%=p.getProductName() %>" /></a>

							<div class="top-content">

								<h5>

									<a href="single.jsp?productID=<%= p.getProductID() %>"><%=p.getProductName() %></a>

								</h5>

								<div class="white">

									<a href="CartServlet?command=plus&productID=<%= p.getProductID() %>"

										class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD

										TO CART</a>

									<p class="dollar">

										<span class="in-dollar">$</span><span><%=p.getProductPrice() %>></span><span>0</span>

									</p>
									<div class="clearfix"></div>

								</div>
							



							</div>

						</div>

					</div>

					

									<%
										}
									%>
					<div class="clearfix"></div>

				</div>

			</div>
			

			<!---->

			<div class="content-middle">

				<h3 class="future">BRANDS</h3>

				<div class="content-middle-in">

					<ul id="flexiselDemo1">

						<li><img src="images/ap.png" /></li>

						<li><img src="images/ap1.png" /></li>

						<li><img src="images/ap2.png" /></li>

						<li><img src="images/ap3.png" /></li>



					</ul>

					<script type="text/javascript">

						$(window).load(function() {

							$("#flexiselDemo1").flexisel({

								visibleItems : 4,

								animationSpeed : 1000,

								autoPlay : true,

								autoPlaySpeed : 3000,

								pauseOnHover : true,

								enableResponsiveBreakpoints : true,

								responsiveBreakpoints : {

									portrait : {

										changePoint : 480,

										visibleItems : 1

									},

									landscape : {

										changePoint : 640,

										visibleItems : 2

									},

									tablet : {

										changePoint : 768,

										visibleItems : 3

									}

								}

							});



						});

					</script>

					<script type="text/javascript" src="js/jquery.flexisel.js"></script>



				</div>

			</div>

			<!---->

			<div class="content-bottom">

				<h3 class="future">LATEST</h3>

				<div class="content-bottom-in">

					<ul id="flexiselDemo2">

						<li><div class="col-md men">

								<a href="single.html" class="compare-in "><img

									src="images/pi4.jpg" alt="" />

									<div class="compare in-compare">

										<span>Add to Compare</span> <span>Add to Whislist</span>

									</div></a>

								<div class="top-content bag">

									<h5>

										<a href="single.html">Symbolic Bag</a>

									</h5>

									<div class="white">

										<a href="single.html"

											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD

											TO CART</a>

										<p class="dollar">

											<span class="in-dollar">$</span><span>4</span><span>0</span>

										</p>

										<div class="clearfix"></div>

									</div>

								</div>

							</div></li>

						<li><div class="col-md men">

								<a href="single.html" class="compare-in "><img

									src="images/pi5.jpg" alt="" />

									<div class="compare in-compare">

										<span>Add to Compare</span> <span>Add to Whislist</span>

									</div></a>

								<div class="top-content bag">

									<h5>

										<a href="single.html">Interesting Read</a>

									</h5>

									<div class="white">

										<a href="single.html"

											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD

											TO CART</a>

										<p class="dollar">

											<span class="in-dollar">$</span><span>2</span><span>5</span>

										</p>

										<div class="clearfix"></div>

									</div>

								</div>

							</div></li>

						<li><div class="col-md men">

								<a href="single.html" class="compare-in "><img

									src="images/pi6.jpg" alt="" />

									<div class="compare in-compare">

										<span>Add to Compare</span> <span>Add to Whislist</span>

									</div></a>

								<div class="top-content bag">

									<h5>

										<a href="single.html">The Carter</a>

									</h5>

									<div class="white">

										<a href="single.html"

											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD

											TO CART</a>

										<p class="dollar">

											<span class="in-dollar">$</span><span>1</span><span>0</span>

										</p>

										<div class="clearfix"></div>

									</div>

								</div>

							</div></li>

						<li><div class="col-md men">

								<a href="single.html" class="compare-in "><img

									src="images/pi7.jpg" alt="" />

									<div class="compare in-compare">

										<span>Add to Compare</span> <span>Add to Whislist</span>

									</div></a>

								<div class="top-content bag">

									<h5>

										<a href="single.html">Onesie</a>

									</h5>

									<div class="white">

										<a href="single.html"

											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD

											TO CART</a>

										<p class="dollar">

											<span class="in-dollar">$</span><span>6</span><span>0</span>

										</p>

										<div class="clearfix"></div>

									</div>

								</div>

							</div></li>



					</ul>

					<script type="text/javascript">

						$(window).load(function() {

							$("#flexiselDemo2").flexisel({

								visibleItems : 4,

								animationSpeed : 1000,

								autoPlay : true,

								autoPlaySpeed : 3000,

								pauseOnHover : true,

								enableResponsiveBreakpoints : true,

								responsiveBreakpoints : {

									portrait : {

										changePoint : 480,

										visibleItems : 1

									},

									landscape : {

										changePoint : 640,

										visibleItems : 2

									},

									tablet : {

										changePoint : 768,

										visibleItems : 3

									}

								}

							});



						});

					</script>

				</div>

			</div>

			<ul class="start">

				<li><a href="#"><i></i></a></li>

				<%
					for(int i=1;i<=(total/4)+1;i++){
				%>
				<li class="arrow"><a href="product.jsp?categoryID=<%=category_id%>&pages=<%=i%>"><%=i %></a></li>
				<%
					}
				%>

				<li><a href="#"><i class="next"> </i></a></li>

			</ul>

		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>