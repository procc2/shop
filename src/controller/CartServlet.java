package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cart;
import Model.Item;
import Model.Product;
import DAO.ProductDAO;

/**
 * Servlet implementation class CartServlet
 */

public class CartServlet extends HttpServlet {
	private final ProductDAO productDAO = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String command = request.getParameter("command");
        String productID = request.getParameter("productID");
        Cart cart = (Cart) session.getAttribute("cart");
        
        try {
            Long idProduct = Long.parseLong(productID);
            Product product = productDAO.getProduct(idProduct);
            switch (command) {
                case "plus":
                    if (cart.getCartItems().containsKey(idProduct)) {
                        cart.insertToCart(idProduct, new Item(product,
                                cart.getCartItems().get(idProduct).getQuantity()));
                    } else {
                        cart.insertToCart(idProduct, new Item(product, 1));
                    }
                    break;
                case "remove":
                    cart.removeToCart(idProduct);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/demo/index.jsp");
        }
        session.setAttribute("cart", cart);
        response.sendRedirect("/demo/index.jsp");
    }

}
