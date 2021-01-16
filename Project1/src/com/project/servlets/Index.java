package com.project.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bdd.Access;
import com.project.beans.Cart;
import com.project.beans.Product;

/**
 * Servlet implementation class Index
 */
@WebServlet(
		 urlPatterns = {"/Index", ""}
		)
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
			
		// get all products to display them
		Access acce = new Access();
		ArrayList<Product> products = acce.getProducts();
		request.setAttribute("products", products);
		
		// add product to cart
		if(request.getParameter("id") != null) {
			Cart cart = (Cart) session.getAttribute("cart");
			cart.addProduct(Integer.parseInt(request.getParameter("id")));
			session.setAttribute("cart", cart);
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
