package controller;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BillDAO;
import Model.Bill;
import Model.Category;

/**
 * Servlet implementation class ManagerBillServlet
 */
@WebServlet("/ManagerBillServlet")
public class ManagerBillServlet extends HttpServlet {
	BillDAO dao = new BillDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command= request.getParameter("command");
		String billID = request.getParameter("billID");
		String url = "",error="";
		try{
			switch(command){
			case "deleteB":
				
				dao.deleteBill(Long.parseLong(billID));
				url= "/admin/manager_bill.jsp";
				break;
			case "updateB":
				doPost(request, response);
				break;
			}
		}catch(Exception e){
			
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command= request.getParameter("command");
		long billID = Long.parseLong(request.getParameter("billID"));
		long userID = Long.parseLong(request.getParameter("userID"));
		double total =Double.parseDouble( request.getParameter("total"));
		String payment = request.getParameter("payment");
		String address = request.getParameter("address");
		
		Timestamp date = null;
		try {
			date = (Timestamp) new SimpleDateFormat("yyyy-MMM-dd HH:mm.", Locale.ENGLISH).parse(request.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "";
			switch(command){
			case "updateB":
				dao.updateBill(new Bill(billID, userID, total, payment, address, date) );
				url= "/admin/manager_category.jsp";
				break;
			}
	
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
