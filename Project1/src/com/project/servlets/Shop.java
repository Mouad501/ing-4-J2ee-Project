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
 * Servlet implementation class Shop
 */
@WebServlet("/Shop")
public class Shop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Shop() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		
		// display products by keywords
		if(request.getParameter("search")!=null) {
			Access acce = new Access();
			ArrayList<Product> products = acce.getProductsByKey(request.getParameter("search"));
			request.setAttribute("products", products);
		}
		else {
			// display products 
			Access acce = new Access();
			ArrayList<Product> products = acce.getProducts();
			request.setAttribute("products", products);
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
