<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Category</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
	<h3>Form</h3>
	<form action="${root}/ManagerCategoryServlet" method ="post">
		<table width="95%">
			<tr><% 
		if(request.getAttribute("error")!= null){
	%> 
	<td style="color:red" ><%=request.getAttribute("error") %></td> 
	<%} %>
	</tr>
			<tr><td width="125px" style="float: right"><b>Category name</b></td>
			<td><input type="text" class="pendek" name ="categoryName"></td></tr>
			<tr><td></td><td>
			<input type="hidden" name = "command" value = "insert">
			<input type="submit" class="button" value="Submit">
			</td></tr>
		</table>
		</form>
	</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>