<%@page import="java.util.Map"%>
<%@page import="Model.Cart"%>
<%@page import="Model.User"%>
<%@page import="Model.Category"%>
<%@page import="DAO.categoryDAO"%>
<%@page import="Model.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shop</title>
<div id="fb-root"></div>
<script>
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.9&appId=235163996970924";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>
</head>
<body>
	<%
		categoryDAO CategoryDAO= new categoryDAO();
		User user = null;
		if(session.getAttribute("user")!=null){
			user= (User)session.getAttribute("user");
		}
		Cart cart= (Cart) session.getAttribute("cart");
		if(cart == null){
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
	%>
	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="header-top-in">
					<div class="logo">
						<a href="index.jsp"><img src="images/logo.png" alt=" "></a>
					</div>
					<div class="header-in">
						<ul class="icon1 sub-icon1">
							<%if(user!=null){ %>
							<li><a href="wishlist.html"><%=user.getUserMail() %></a></li>
							<%} %>
							<li><a href="wishlist.html">WISH LIST (0)</a></li>
							<li><a href="account.html"> MY ACCOUNT</a></li>
							<li><a href="#"> SHOPPING CART</a></li>
							<li><a href="checkout.jsp">CHECKOUT</a></li>
							<li><div class="cart">
									<a href="#" class="cart-in"> </a> <span> <%=cart.countItem() %></span>
								</div>
								<ul class="sub-icon1 list">
									<h3>Recently added items(2)</h3>
									<div class="shopping_cart">
										<%for(Map.Entry<Long,Item> list : cart.getCartItems().entrySet()){ %>
										<div class="cart_box">
											<div class="message">
												<div class="alert-close" ></div>
												<div class="list_img">
													<img src="<%=list.getValue().getProduct().getProductImage()%>" class="img-responsive" alt="">
												</div>
												<div class="list_desc">
													<h4>
														<a href="CartServlet?command=remove&productID=<%= list.getValue().getProduct().getProductID() %>"><%=list.getValue().getProduct().getProductName() %></a>
													</h4>
													<%=list.getValue().getQuantity() %> x<span class="actual"> $<%=list.getValue().getProduct().getProductPrice() %></span>
												</div>
												<div class="clearfix"></div>
											</div>
										</div>
										<%} %>
										
									</div>
									<div class="total">
										<div class="total_left">Cart Subtotal :</div>
										<div class="total_right">$<%=cart.totalCart() %></div>
										<div class="clearfix"></div>
									</div>
									<div class="login_buttons">
										<div class="check_button">
											<a href="checkout.jsp">Check out</a>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="clearfix"></div>
								</ul></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div class="header-bottom">
			<div class="container">
				<div class="h_menu4">
					<a class="toggleMenu" href="#">Menu</a>
					<ul class="nav">
						<li class="active"><a href="index.jsp"><i> </i>Desktops</a></li>
						<li><a href="#">Laptops & Notebooks</a>
							<ul class="drop">
							<%
								for(Category e : CategoryDAO.getListCategory()){
									if(e.getProductGender()==1){
							%>		
								<li><a href="product.jsp?categoryID=<%= e.getCategoryID() %>&pages=1"><%=e.getCategoryName() %></a></li>
							<%
								}}
							%> 
							</ul></li>
						<li><a href="#">Smartphone</a>
							<ul class="drop">
							<%
								for(Category e : CategoryDAO.getListCategory()){
									if(e.getProductGender()==2){
							%>		
								<li><a href="product.jsp?categoryID=<%= e.getCategoryID() %>&pages=1"><%=e.getCategoryName() %></a></li>
							<%
								}}
							%> 
							</ul></li>
						<li><a href="#">Tablet</a>
							<ul class="drop">
							<%
								for(Category e : CategoryDAO.getListCategory()){
									if(e.getProductGender()==3){
							%>		
								<li><a href="product.jsp?categoryID=<%= e.getCategoryID() %>&pages=1"><%=e.getCategoryName() %></a></li>
							<%
								}}
							%> 
							</ul></li>
						<li><a href="#">Camera</a>
							<ul class="drop">
							<%
								for(Category e : CategoryDAO.getListCategory()){
									if(e.getProductGender()==4){
							%>		
								<li><a href="product.jsp?categoryID=<%= e.getCategoryID() %>&pages=1"><%=e.getCategoryName() %></a></li>
							<%
								}}
							%> 
							</ul></li>
						<li><a href="contact.jsp">Contact </a></li>

					</ul>
					<script type="text/javascript" src="js/nav.js"></script>
				</div>
			</div>
		</div>
		<div class="header-bottom-in">
			<div class="container">
				<div class="header-bottom-on">
					<p class="wel">
						<a href="#">Welcome visitor you can login or create an
							account.</a>
					</p>
					<div class="header-can">
						<ul class="social-in">
							<li><a href="#"><i> </i></a></li>
							<li><a href="#"><i class="facebook"> </i></a></li>
							<li><a href="#"><i class="twitter"> </i></a></li>
							<li><a href="#"><i class="skype"> </i></a></li>
						</ul>
						<div class="down-top">
							<select class="in-drop">
								<option value="Dollars" class="in-of">Dollars</option>
								<option value="Euro" class="in-of">Euro</option>
								<option value="Yen" class="in-of">Yen</option>
							</select>
						</div>
						<div class="search">
							<form>
								<input type="text" value="Search" onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = '';}"> <input
									type="submit" value="">
							</form>
						</div>

						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<script type='text/javascript'>window._sbzq||function(e){e._sbzq=[];var t=e._sbzq;t.push(["_setAccount",65966]);var n=e.location.protocol=="https:"?"https:":"http:";var r=document.createElement("script");r.type="text/javascript";r.async=true;r.src=n+"//static.subiz.com/public/js/loader.js";var i=document.getElementsByTagName("script")[0];i.parentNode.insertBefore(r,i)}(window);</script>
</body>
</html>