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
import com.project.bdd.BestSelling;
import com.project.bdd.RecentOrders;
import com.project.beans.User;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
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
		
		Access acce = new Access();
		ArrayList<RecentOrders> orders = acce.getRecentOrders();
		request.setAttribute("orders", orders);
		
		ArrayList<BestSelling> products = acce.getBestSelling();
		request.setAttribute("products", products);
		
		acce.getStatistics();
		//System.out.println(acce.ca);
		session.setAttribute("ca", acce.ca);
		session.setAttribute("nbOrders", acce.nbOrders);
		session.setAttribute("nbUsers", acce.nbUsers);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
	}

}
