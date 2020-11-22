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
import com.project.beans.Product;

/**
 * Servlet implementation class Product_info
 */
@WebServlet("/Product_info")
public class Product_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Product_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		
		// add product to cart
		if(request.getParameter("add_to_cart") != null) {
			request.setAttribute("add_to_cart", request.getParameter("add_to_cart"));
			cart = (Cart) session.getAttribute("cart");
			cart.addProduct(Integer.parseInt(request.getParameter("add_to_cart")));
			session.setAttribute("cart", cart);
		}
		
		// display Product info
		if(request.getParameter("id") != null) {
			int id = (int)Integer.parseInt(request.getParameter("id"));
			Access acce = new Access();
			Product product = acce.getProduct(id);
			if(product != null) {
				request.setAttribute("id", id);
				request.setAttribute("product", product);
			}
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
