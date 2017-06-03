package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import Model.Category;
import Model.Product;

/**
 * Servlet implementation class ManagerProductServlet
 */
@WebServlet("/ManagerProductServlet")
public class ManagerProductServlet extends HttpServlet {
	ProductDAO dao = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command= request.getParameter("command");
		String productID = request.getParameter("productID");
		String url = "",error="";
		try{
			switch(command){
			case "deleteP":
				
				dao.deleteProduct(Long.parseLong(productID));
				url= "/admin/manager_product.jsp";
				break;
			}
		}catch(NumberFormatException e){
			
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command= request.getParameter("command");
		String productName = request.getParameter("productName");
		long productID = Long.parseLong(request.getParameter("productID"));
		long categoryID = Long.parseLong(request.getParameter("categoryID"));
		String productImage = request.getParameter("productImage");
		double productPrice = Double.parseDouble(request.getParameter("productPrice"));
		String productDes = request.getParameter("productDes");
		String url = "",errorN="";
		if(productName.equals("")){
			errorN ="Please input your product name";
			request.setAttribute("errorN",errorN);
		}
		Product p=new Product(productID, categoryID, productName, productImage, productPrice, productDes);
		if(errorN.equals("")){
			switch(command){
			case "insertP":
				dao.insertProduct(p);
				url= "/admin/manager_product.jsp";
				break;
			case "updateP":
				dao.updateProduct(p);
				url= "/admin/manager_product.jsp";
				break;
			}
		}else {
			url ="/admin/insertProduct.jsp";
			
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
