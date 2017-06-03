<%@page import="DAO.ProductDAO"%>
<%@page import="Model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.categoryDAO"%>
<%@page import="Model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Product</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<%
		categoryDAO dao = new categoryDAO();
		ArrayList<Category> list =dao.getListCategory();
		ProductDAO p_dao = new ProductDAO();
		
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Tabel</h3>
			<h4><a href="${root}/admin/insertProduct.jsp"> Want more product ..</a></h4>
			<table class="data">
				<tr class="data">
					<th class="data" width="30px">No</th>
					<th class="data">Product ID</th>
					<th class="data">Category ID</th>
					<th class="data">Product Name</th>
					<th class="data">Product Image Link</th>
					<th class="data">Product Price</th>
					<th class="data" width="75px">Option</th>
				</tr>
				<%
					int count =0;
					for(Category c: list){
					ArrayList<Product> p_list=p_dao.getListProductbyCategory(c.getCategoryID());
					for(Product p : p_list){
						count++;
				%>
				<tr class="data">
					<td class="data" width="30px"><%=count %></td>
					<td class="data"><%=p.getProductID() %></td>
					<td class="data"><%=c.getCategoryID() %></td>
					<td class="data"><%=p.getProductName() %></td>
					<td class="data"><%=p.getProductImage() %></td>
					<td class="data"><%=p.getProductPrice() %></td>
					<td class="data" width="90px">
						<center>
							<a href="/demo/admin/updateProduct.jsp?command=updateP&productID=<%=p.getProductID()%>"><img src="../img/icon-left.png"></a>&nbsp;&nbsp; | &nbsp;&nbsp;
							<a href="/demo/ManagerProductServlet?command=deleteP&productID=<%=p.getProductID()%>"><img src="../img/not-available.png"></a>
						</center>
					</td>
				</tr>
				<%}} %>

			</table>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>