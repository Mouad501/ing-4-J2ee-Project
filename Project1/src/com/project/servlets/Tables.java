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
import com.project.beans.Commande;
import com.project.beans.LigneDeCommande;
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
		
		
		//Verification of access right 
		HttpSession session = request.getSession();
		User admin = (User) session.getAttribute("admin");
		if(admin == null) {
			response.sendRedirect("Authentification");
			return ;
		}
		
		if(request.getParameter("deleteProduct") != null ) {
			Access acce = new Access();
			acce.deleteProduct(Integer.parseInt(request.getParameter("productID")));
		}
		
		
		//database access
		Access acce = new Access();

		
		// display products 
		ArrayList<Product> products = acce.getProducts();
		request.setAttribute("products", products);
		
		// display orders
		ArrayList<Commande> orders = acce.getOrders();
		request.setAttribute("orders", orders);
		
		// display orders Details
		ArrayList<LigneDeCommande> ordersDetails = acce.getOrdersDetails();
		request.setAttribute("ordersDetails", ordersDetails);
		
		//display clients
		ArrayList<User> clients = acce.getClients();
		request.setAttribute("clients", clients);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/tables.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//Verification of access right 
		HttpSession session = request.getSession();
		User admin = (User) session.getAttribute("admin");
		if(admin == null) {
			response.sendRedirect("Authentification");
			return ;
		}
		
		
		//database access
		Access db = new Access();
		
		String table  = (String)request.getParameter("table"); 
		String id  = (String)request.getParameter("id"); 
		String action  = request.getParameter("action"); 
		
		System.out.println(action+" dsdddddd");

        if(action.equals("del") ) {
        	
    		System.out.println("id "+id);

    		db.desactiverClient(Integer.parseInt(id));
    		response.sendRedirect("Tables");
    		return ;
		


        }

		this.getServletContext().getRequestDispatcher("/WEB-INF/tables.jsp").forward(request, response);
	}

}