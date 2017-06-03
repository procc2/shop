<%@page import="DAO.UserDAO"%>
<%@page import="Model.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.BillDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Bill</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<%
		BillDAO dao = new BillDAO();
		ArrayList<Bill> list = dao.getListBill();
		UserDAO u_dao= new UserDAO();
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Bill management</h3>
			
			
			<table class="data">
				<tr class="data">
					<th class="data" width="30px">No</th>
					<th class="data" width="30px">Bill ID</th>
					<th class="data" width="30px">User ID</th>
					<th class="data">Guest Email</th>
					<th class="data">Total</th>
					<th class="data">Address</th>
					<th class="data">Purchase Day</th>
					<th class="data" width="75px">Options</th>
				</tr>
				<% int count =0;
				for (Bill bill : list ){
					count++;
					System.out.print(bill.getBillID());
					%>
				<tr class="data">
					<td class="data" width="30px"><%=count %></td>
					<td class="data" width="30px"><%=bill.getUserID()%></td>
					<td class="data" width="30px"><%=bill.getBillID() %></td>
					<td class="data"><%=u_dao.getUser(bill.getUserID()).getUserMail()%></td>
					<td class="data"><%=bill.getTotal() %></td>
					<td class="data"><%=bill.getAddress() %></td>
					<td class="data"><%=bill.getDate() %></td>
					<td class="data" width="200px">
						<center>
							<a href="#">Complete</a>&nbsp;&nbsp; || &nbsp;&nbsp;
							<a href="/demo/ManagerBillServlet?command=deleteB&billID=<%=bill.getBillID()%>">Cancel</a>
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