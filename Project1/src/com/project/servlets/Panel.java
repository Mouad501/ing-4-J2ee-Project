package com.project.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bdd.Access;
import com.project.beans.Cart;
import com.project.beans.User;

/**
 * Servlet implementation class Panel
 */
@WebServlet("/Cart")
public class Panel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Panel() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		
		// clear cart
		if(request.getParameter("clear") != null) {
			session.setAttribute("cart", new Cart());
		}
		
		// remove product from the cart
		if(request.getParameter("id_remove") != null) {
			cart.removeProduct(Integer.parseInt(request.getParameter("id_remove")));
			session.setAttribute("cart", cart);
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(request.getParameter("id_update") != null) {
			if(request.getParameter("quantity") != null) {
				cart.updateCart(Integer.parseInt(request.getParameter("id_update")), Integer.parseInt(request.getParameter("quantity")));
			}
		}
		
		if(request.getParameter("Buy") != null) {
			User user = (User) session.getAttribute("user");
			if(user == null) {
				response.sendRedirect("/Project1/Authentification");
				return;
			}
			else {
				if(cart.getLongueur() > 0) {
					Access accee = new Access();
					boolean test_success = accee.addOrder(user.getId(), cart);
					if(test_success) {
						session.setAttribute("cart", new Cart());
					}
				}
			}
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
	}

}
