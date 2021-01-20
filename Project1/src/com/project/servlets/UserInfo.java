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
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			response.sendRedirect("/Project1/Authentification");
			return;
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(request.getParameter("save")!=null) {
			if(request.getParameter("username") == "" || request.getParameter("email") == "" || request.getParameter("password") == "" || request.getParameter("tel") == "" || request.getParameter("address") == "" ) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
			}
			else {
				User userUpdate = new User(user.getId(), request.getParameter("username"), request.getParameter("email"), request.getParameter("password"), request.getParameter("tel"), request.getParameter("address"), "user", "actif");
				Access accee = new Access();
				boolean status = false;
				try {
					status = accee.UpdateUser(userUpdate);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(status) {
					session.setAttribute("user", userUpdate);
				}
				this.getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
			}
		}
	}

}
