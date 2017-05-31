package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import Model.User;
import tools.md5;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	UserDAO userDAO=new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");
		String url="";
		User user = new User();
		HttpSession session = request.getSession();
		switch(command){
		case"insert":
			user.setUserID(7);
			user.setUserMail(request.getParameter("email"));
			user.setUserPass(md5.encryption(request.getParameter("pass")));
			user.setUserRole(false);
			userDAO.insertUser(user);
			session.setAttribute("user",user);
			url="/index.jsp";
			break;
		case "login":
			user=userDAO.login(request.getParameter("email"),md5.encryption(request.getParameter("pass")));
			if(user!= null){
				session.setAttribute("user", user);
				url= "/index.jsp";
			}else{
				request.setAttribute("Error", "Error mail or password");
				url="/login.jsp";
			}
			
			break;
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
