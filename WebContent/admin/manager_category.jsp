<%@page import="Model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.categoryDAO"%>
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
	<%
		categoryDAO dao = new categoryDAO();
		ArrayList<Category> list =dao.getListCategory();
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Category Table</h3>
			<a href="insertCategory.jsp"> Want more category ..</a>
			<table class="data">
				<tr class="data">
					<th class="data" width="30px">No</th>
					<th class="data">Category</th>
					<th class="data">Category Name</th>
					<th class="data" width="90px">Option</th>
				</tr>
				<%
					int count =0;
					for(Category c : list){
						count++;
				%>
				<tr class="data">
					<td class="data" width="30px"><%=count %></td>
					<td class="data"><%=c.getCategoryID() %></td>
					<td class="data"><%=c.getCategoryName() %></td>
					<td class="data" width="90px">
						<center>
							<a href="#"><img src="../img/icon-left.png"></a>&nbsp;&nbsp; | &nbsp;&nbsp;
							<a href="#"><img src="../img/not-available.png"></a>
						</center>
					</td>
				</tr>
				<%} %>
				
			</table>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>