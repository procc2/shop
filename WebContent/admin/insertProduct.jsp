<%@page import="Model.Category"%>
<%@page import="DAO.categoryDAO"%>
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
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
	<h3>Form</h3>
	
		<form action="${root}/ManagerProductServlet" method ="post">
		<table width="95%">
			<tr><td width="125px"><b>Product ID</b></td><td><input type="text" name="productID" class="pendek"></td></tr>
			<tr><td><b>Product Name</b></td><td><input type="text" name="productName" class="panjang"></td><% 
		if(request.getAttribute("errorN")!= null){
	%> 
	<td style="color:red" ><%=request.getAttribute("errorN") %></td><%} %> </tr>
			<tr><td><b >Category ID</b></td><td>
			<%for(Category c : dao.getListCategory()){ %>
				<input type="radio" name="categoryID" id="radio" value="<%=c.getCategoryID()%>"><%=c.getCategoryName()%>
				<%} %>
			</td></tr>
			<tr><td width="125px"><b>Product Price</b></td><td><input type="text" name="productPrice" class="pendek"></td></tr>
			<tr><td width="125px"><b>Product Image</b></td><td><input type="file" class="pendek" name = "productImage"></td></tr>
			<tr><td><b>Textarea</b></td><td><textarea name="productDes"></textarea></td></tr>
			<tr><td></td><td>
			<input type="hidden" name="command" value="insertP">
			<input type="submit" class="button" value="Submit">
			<input type ="reset" class="button" value= "Reset">
			</td></tr>
		</table>
		</form>
	</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>