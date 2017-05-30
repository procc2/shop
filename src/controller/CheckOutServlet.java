package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BillDAO;
import DAO.BillDetailDAO;
import Model.Bill;
import Model.BillDetail;
import Model.Cart;
import Model.Item;
import Model.User;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private final BillDAO bd = new BillDAO();
	private final BillDetailDAO bdd = new BillDetailDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String payment = request.getParameter("payment");
		String address = request.getParameter("address");
		String url = "";
		if (address == "") {
			request.setAttribute("Errorcheckout", "Empty addressed");
			url = "/checkout.jsp";
		} else {
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			User user = (User) session.getAttribute("user");
			if (cart.countItem() == 0) {
				request.setAttribute("Out", "No item have choosen!");
				url = "/checkout.jsp";
			} else {
				try {
					long ID = new Date().getTime();
					Bill bill = new Bill();
					bill.setBillID(ID);
					bill.setAddress(address);
					bill.setPayment(payment);
					bill.setUserID(user.getUserID());
					bill.setTotal(cart.totalCart());
					bill.setDate(new Timestamp(new Date().getTime()));
					for (Map.Entry<Long, Item> list : cart.getCartItems().entrySet()) {
						bdd.insertBillDetail(new BillDetail(0, ID, list.getValue().getProduct().getProductID(),
								list.getValue().getProduct().getProductPrice(), list.getValue().getQuantity()));
					}
					cart = new Cart();
					session.setAttribute("cart", cart);
					url = "/index.jsp";
				} catch (Exception e) {

				}
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
