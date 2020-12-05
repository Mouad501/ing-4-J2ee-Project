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
import com.project.beans.Product;
import com.project.beans.User;

/**
 * Servlet implementation class Tables
 */
@WebServlet("/Tables")
public class Tables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tables() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User admin = (User) session.getAttribute("admin");
		if(admin == null) {
			response.sendRedirect("/Project1/Authentification");
			return ;
		}
		
		// display products 
		Access acce = new Access();
		ArrayList<Product> products = acce.getProducts();
		request.setAttribute("products", products);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/tables.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/tables.jsp").forward(request, response);
	}

}
