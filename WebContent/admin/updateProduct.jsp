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
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
	<h3>Form</h3>
	
		<form action="${root}/ManagerProductServlet" method ="post">
		<table width="95%">
			<tr><td><b>Product Name</b></td><td><input type="text" name="productName" class="panjang"></td></tr>
			<tr><td><b >Category ID</b></td><td>
				<input type="radio" name="categoryID" id="radio" value="1">Apple
				<input type="radio" name="categoryID" id="radio" value="2">Samsung
				<input type="radio" name="categoryID" id="radio" value="3">Dell
				<input type="radio" name="categoryID" id="radio" value="4">Asus
				<input type="radio" name="categoryID" id="radio" value="5">Xiaomi
			</td></tr>
			<tr><td width="125px"><b>Product Price</b></td><td><input type="text" name="productPrice" class="pendek"></td></tr>
			<tr><td width="125px"><b>Product Gender</b></td><td><input type="text" name="productGender" class="pendek"></td></tr>
			<tr><td width="125px"><b>Product Image</b></td><td><input type="file" class="pendek" name = "productImage"></td></tr>
			<tr><td><b>Textarea</b></td><td><textarea name="productDes"></textarea></td></tr>
			<tr><td></td><td>
			<input type="hidden" name="command" value="updateP">
			<input type="hidden" name = "productID" value = "<%=request.getParameter("productID") %>">
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