package com.project.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bdd.Access;
import com.project.beans.User;


@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Authentification() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getParameter("email");
		String password = (String)request.getParameter("password");
		Access acce = new Access();
		User user = acce.getUser(email, password);
		if(user == null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(request, response);
		}
		else {
			request.setAttribute("user", user);
			this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
		}
		
	}

}
