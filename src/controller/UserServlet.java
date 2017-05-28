package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import Model.User;
import connect.JDBConnect;
import tools.md5;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		UserDAO dao = new UserDAO();
		String command=request.getParameter("command");
		String url="";
		User user= new User();
		HttpSession session=request.getSession();
		switch(command){
		case "insert":
			user.setUserID(4);
			user.setUserMail(request.getParameter("email"));
			user.setUserPass(md5.encryption(request.getParameter("pass")));
			user.setUserRole(false);
			dao.insertUser(user);
			session.setAttribute("user", user);
			url= "/index.jsp";
			break;
		case "login":
			user=dao.login(request.getParameter("email"),md5.encryption(request.getParameter("pass")));
			if(user!= null){
				session.setAttribute("user", user);
				url= "/index.jsp";
			}else{
				request.setAttribute("Error", "Error mail or password");
				url= "/login.jsp";
			}
			break;
		}
		RequestDispatcher rd= getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
