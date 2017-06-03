package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.categoryDAO;
import Model.Category;

/**
 * Servlet implementation class ManagerCategoryServlet
 */
@WebServlet("/ManagerCategoryServlet")
public class ManagerCategoryServlet extends HttpServlet {
	categoryDAO dao = new categoryDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command= request.getParameter("command");
		String categoryID = request.getParameter("categoryID");
		String url = "",error="";
		try{
			switch(command){
			case "delete":
				
				dao.deleteCategory(Long.parseLong(categoryID));
				url= "/admin/manager_category.jsp";
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
		String categoryName = request.getParameter("categoryName");
		String url = "",error="";
		if(categoryName.equals("")){
			error ="Please input your category name";
			request.setAttribute("error",error);
		}
		if(categoryName.length()!=0){
			switch(command){
			case "insert":
				dao.insertCategory(new Category(new Date().getTime(), categoryName));
				url= "/admin/manager_category.jsp";
				break;
			case "update":
				dao.updateCategory(Long.parseLong(request.getParameter("categoryID")),request.getParameter("categoryName"));
				url= "/admin/manager_category.jsp";
				break;
			}
		}else {
			url ="/admin/insertCategory.jsp";
			request.getAttribute(error);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
