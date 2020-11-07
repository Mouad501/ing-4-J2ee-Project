package com.project.servlets;

/* cedkoffeto@gmail.com, gracelodie20@gmail.com */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bdd.Access;
import com.project.beans.User;


@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("firstname") == "" || request.getParameter("lastname") == "" || request.getParameter("email") == "" || request.getParameter("password") == "" || request.getParameter("tel") == "" || request.getParameter("address") == "" || request.getParameter("sex") == null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		}
		else {
			User user = new User(-1, request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"), request.getParameter("password"), request.getParameter("tel"), request.getParameter("address"), request.getParameter("sex"));
			Access accee = new Access();
			boolean status = accee.insertUser(user);
			if(status) {
				request.setAttribute("user", user);
				this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
			}
			else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
			}
		}
	}

}
