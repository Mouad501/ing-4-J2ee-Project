package com.project.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bdd.Access;
import com.project.beans.User;


@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Authentification() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/login_signup.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("signin")!=null) {
			String email = (String)request.getParameter("email");
			String password = (String)request.getParameter("password");
			Access acce = new Access();
			User user = acce.getUser(email, password);
			if(user == null) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/login_signup.jsp").forward(request, response);
			}
			else {
				if(user.getRole().equalsIgnoreCase("user")){
					session.setAttribute("user", user);
					response.sendRedirect("/Project1/Index");
				}
				if(user.getRole().equalsIgnoreCase("admin")) {
					session.setAttribute("admin", user);
					response.sendRedirect("/Project1/Dashboard");
				}
			}
		}
		
		if(request.getParameter("signup")!=null) {
			if(request.getParameter("username") == "" || request.getParameter("email") == "" || request.getParameter("password") == "" || request.getParameter("tel") == "" || request.getParameter("address") == "" ) {
				System.out.println("1");
				this.getServletContext().getRequestDispatcher("/WEB-INF/login_signup.jsp").forward(request, response);
			}
			else {
				User user = new User(-1, request.getParameter("username"), request.getParameter("email"), request.getParameter("password"), request.getParameter("tel"), request.getParameter("address"), "user", "actif");
				Access accee = new Access();
				boolean status = accee.insertUser(user);
				if(status) {
					session.setAttribute("user", user);
					response.sendRedirect("/Project1/Index");
				}
				else {
					this.getServletContext().getRequestDispatcher("/WEB-INF/login_signup.jsp").forward(request, response);
				}
			}
		}
	}

}
