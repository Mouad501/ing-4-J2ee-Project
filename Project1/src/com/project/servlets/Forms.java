package com.project.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.project.bdd.Access;
import com.project.beans.Product;
import com.project.beans.User;


/**
 * Servlet implementation class Forms
 */
@WebServlet("/Forms")
@MultipartConfig
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
		
		if(request.getParameter("editProduct")!=null) {
			if(request.getParameter("id") == "" || request.getParameter("variable") == "" || request.getParameter("value") == "") {
				this.getServletContext().getRequestDispatcher("/WEB-INF/Forms.jsp").forward(request, response);
			}
			Access acce = new Access();
			acce.UpdateProduct(Integer.parseInt(request.getParameter("id")), request.getParameter("variable"), request.getParameter("value"));
			this.getServletContext().getRequestDispatcher("/WEB-INF/Forms.jsp").forward(request, response);
		}
		
		if(request.getParameter("addProduct")!=null) {
			if(request.getParameter("designation") == "" || request.getParameter("categorie") == "" || request.getParameter("description") == "" || request.getParameter("prix") == "" || request.getParameter("keyword") == "" || request.getParameter("quantite") == "" || request.getParameter("image") == "") {
				this.getServletContext().getRequestDispatcher("/WEB-INF/Forms.jsp").forward(request, response);
			}
			else {
				/*
				ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
				List<FileItem> multifiles = null;
				//System.out.println(request.getParameter("image").getClass());
				try {
					multifiles = sf.parseRequest(request);
				} catch (FileUploadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String img = "0";
				for(FileItem item : multifiles) {
					try {
						item.write(new java.io.File("C:/Users/user/git/ing-4-J2ee-Project/Project1/WebContent/images/" + item.getName()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					img = item.getName();
				}
				System.out.println(img);
				*/
				
				Product p = new Product(-1, -1, request.getParameter("designation"), request.getParameter("categorie"), request.getParameter("description"), (float) Double.parseDouble(request.getParameter("prix")), request.getParameter("keyword"), request.getParameter("image"), Integer.parseInt(request.getParameter("quantite")));
				Access accee = new Access();
				boolean status = false;
				status = accee.addProduct(p);
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
