<%@page import="Model.Category"%>
<%@page import="DAO.categoryDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Product</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
<script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
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
			<tr><td width="125px"><b>Product Gender</b></td><td><input type="text" name="productGender" class="pendek"></td></tr>
			<tr><td width="125px"><b>Product Image</b></td><td><input type="file" class="pendek" name = "productImage"></td></tr>
			<tr><td><b>Product Description</b></td><td><textarea class="form-textarea" name="productDes" id="content"></textarea>
			<script type="text/javascript" language="javascript">
  				 CKEDITOR.replace('content', {width: '500px',height: '300px'});
			</script>
			</td></tr>
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