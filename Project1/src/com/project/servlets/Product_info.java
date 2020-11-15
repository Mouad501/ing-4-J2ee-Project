package com.project.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bdd.Access;
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
