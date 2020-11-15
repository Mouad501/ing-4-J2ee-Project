package com.project.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.beans.Product;
import com.project.beans.User;

public class Access {

	public Access() {
		super();
	}
	
	public Product getProduct(int id) {
		Product product = null;
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.cj.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    System.out.println("err");
		}
		
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "Mouadsat10";
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		String sql = "SELECT * FROM products WHERE id = ?;";
		try {
			
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    
		    /* Requette SQL */ 
		    statement = connexion.createStatement();
		    PreparedStatement preparedStatement = connexion.prepareStatement(sql);
		    preparedStatement.setInt(1, id);
		    resultat = preparedStatement.executeQuery();
		    if(resultat.next()) {
		    	product = new Product(resultat.getInt("id"), resultat.getString("designation"),
		    			 resultat.getString("categorie"), resultat.getString("description"), resultat.getFloat("prix"),
		    			 resultat.getString("keyword"), resultat.getString("image"), resultat.getInt("q_stock"));
		    }
		    connexion.close(); 

		} catch ( SQLException e ) {
			System.out.println(e.getMessage());
		}
		
		return product;
	}
	
	public ArrayList<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.cj.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    System.out.println("err");
		}
		
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "Mouadsat10";
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		String sql = "SELECT * FROM products;";
		try {
			
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    
		    /* Requette SQL */ 
		    statement = connexion.createStatement();
		    resultat = statement.executeQuery(sql);
		    while(resultat.next()){
		    	 Product product = new Product(resultat.getInt("id"), resultat.getString("designation"),
		    			 resultat.getString("categorie"), resultat.getString("description"), resultat.getFloat("prix"),
		    			 resultat.getString("keyword"), resultat.getString("image"), resultat.getInt("q_stock"));
		    	 products.add(product);
		    	 System.out.println(products.size());
		    }
		    connexion.close(); 

		} catch ( SQLException e ) {
			System.out.println(e.getMessage());
		}
		
		return products;
	}
	
	public User getUser(String email, String password) {
		User user = null;
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.cj.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    System.out.println("err");
		}
		
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "Mouadsat10";
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		String sql = "SELECT * FROM users WHERE email='" + email + "' AND password='" + password + "';";
		try {
			
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    
		    /* Requette SQL */ 
		    statement = connexion.createStatement();
		    resultat = statement.executeQuery(sql);
		    if(resultat.next()){
		    	user = new User(resultat.getInt("id"), resultat.getString("username"), resultat.getString("email"), resultat.getString("password"), resultat.getString("tel"), resultat.getString("address"));
		    }
		    connexion.close(); 

		} catch ( SQLException e ) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}
	
	public boolean insertUser(User user) {
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.cj.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    System.out.println("err");
		}
		
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "Mouadsat10";
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		String sql = "INSERT INTO users(username, email, password, tel, address) VALUES ('" + user.getUsername() +"', '" + user.getEmail() +"', '" + user.getPassword() +"', '" + user.getTel() +"', '" + user.getAddress() +"');";
		try {
			
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    
		    /* Requette SQL */ 
		    statement = connexion.createStatement();
		    int status = statement.executeUpdate(sql);
		    if(status == 0){
		    	return false;
		    }
		    sql = "SELECT * FROM users WHERE email='" + user.getEmail() + "' AND password='" + user.getPassword() + "';";
		    resultat = statement.executeQuery(sql);
		    if(resultat.next()) {
		    	user.setId(resultat.getInt("id"));
		    	return true;
		    }
		    connexion.close(); 

		} catch ( SQLException e ) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
