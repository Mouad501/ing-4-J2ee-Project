package com.project.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bdd.Access;
import com.project.beans.User;

/**
 * Servlet implementation class Forms
 */
@WebServlet("/Forms")
public class Forms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forms() {
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
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Forms.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(request.getParameter("userInsert")!=null) {
			if(request.getParameter("username") == "" || request.getParameter("email") == "" || request.getParameter("password") == "" || request.getParameter("tel") == "" || request.getParameter("address") == "" || request.getParameter("role") == "") {
				this.getServletContext().getRequestDispatcher("/WEB-INF/Forms.jsp").forward(request, response);
			}
			else {
				User user = new User(-1, request.getParameter("username"), request.getParameter("email"), request.getParameter("password"), request.getParameter("tel"), request.getParameter("address"), request.getParameter("role"), "actif");
				Access accee = new Access();
				boolean status = false;
				try {
					status = accee.insertUser(user);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(status) {
					this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
				}
				else {
					this.getServletContext().getRequestDispatcher("/WEB-INF/Forms.jsp").forward(request, response);
				}
			}
		}
	}

}
