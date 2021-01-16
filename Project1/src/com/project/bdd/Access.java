package com.project.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.beans.Cart;
import com.project.beans.CartItem;
import com.project.beans.Product;
import com.project.beans.User;

public class Access {

	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	private Connection connexion;
	
	
	public Access() {
		
		dbUrl = "jdbc:mysql://mysql.abdellah.ma:32895/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		dbUsername = "root";
		dbPassword =  "uirproject1";
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.cj.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    System.out.println("err");
		}
		
		try {
			connexion = DriverManager.getConnection( dbUrl, dbUsername, dbPassword );
		} catch ( SQLException e ) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public boolean addOrder(int user_id, Cart cart) {
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.cj.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    System.out.println("err");
		}
		
		/* Connexion à la base de données */
		String url = "jdbc:mysql://mysql.abdellah.ma:32895/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "uirproject1";
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		String sql1 = "CALL addcommande(?,@p0);";
		String sql2 = "SELECT @p0;";
		String sql3 = "INSERT INTO lignedecommande(order_id, product_id, quantite) VALUES(?,?,?);";
		int id_commande=-1;
		try {
			
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    
		    /* Requette SQL */ 
		    statement = connexion.createStatement();
		    PreparedStatement preparedStatement = connexion.prepareStatement(sql1);
		    preparedStatement.setInt(1, user_id);
		    preparedStatement.executeUpdate();
		    preparedStatement = connexion.prepareStatement(sql2);
		    resultat = preparedStatement.executeQuery();
		    if(resultat.next()) {
		    	id_commande = resultat.getInt("@p0");
		    }
		    if(id_commande == -1) return false;
		    for(CartItem item : cart.getListOfProducts()) {
		    	preparedStatement = connexion.prepareStatement(sql3);
		    	preparedStatement.setInt(1, id_commande);
			    preparedStatement.setInt(2, item.getProduct().getId());
			    preparedStatement.setInt(3, item.getQuantity());
			    preparedStatement.executeUpdate();
		    }
		    connexion.close(); 

		} catch ( SQLException e ) {
			System.out.println(e.getMessage());
		}
		
		return true;
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
		String url = "jdbc:mysql://mysql.abdellah.ma:32895/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "uirproject1";
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
		String url = "jdbc:mysql://mysql.abdellah.ma:32895/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "uirproject1";
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
		String url = "jdbc:mysql://mysql.abdellah.ma:32895/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "uirproject1";
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
		    	user = new User(resultat.getInt("id"), resultat.getString("username"), resultat.getString("email"), resultat.getString("password"), resultat.getString("tel"), resultat.getString("address"), resultat.getString("role"), resultat.getString("active"));
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
		String url = "jdbc:mysql://mysql.abdellah.ma:32895/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "uirproject1";
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

	public ArrayList<User> getClients() {
		// Get clients list
		
		ArrayList<User> clients = new ArrayList<User>();
		
	
		
		
		Statement statement = null;
		ResultSet resultat = null;
		String sql = "SELECT * FROM users WHERE role ='user';";
		
		/* Request SQL */ 
		try {
			
		   
		   
		    statement = connexion.createStatement();
		    resultat = statement.executeQuery(sql);
		    
		    while(resultat.next()){
		    	 User client = new User(
		    			 resultat.getInt("id"), 
		    			 resultat.getString("username"),
		    			 resultat.getString("email"),
		    			 resultat.getString("password"),
		    			 resultat.getString("tel"),
		    			 resultat.getString("address"),
		    			 resultat.getString("role"),
		    			 resultat.getString("active")
		    			 );
		    	 
		    	 
		    	 clients.add(client);
		    	 System.out.println(clients.size());
		    }
		    connexion.close(); 

		} catch ( SQLException e ) {
			System.out.println(e.getMessage());
		}
		
		return clients;
	}

	public void desactiverClient(int id) {
		try {
		    Class.forName( "com.mysql.cj.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    System.out.println("err");
		}
		
		/* Connexion à la base de données */
		String url = "jdbc:mysql://mysql.abdellah.ma:32895/ecom_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "uirproject1";
		Connection connexion = null;
		int resultat;
		String sql = "UPDATE users SET active='non-actif' WHERE id = ?";
		try {
			
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    
		    /* Requette SQL */ 
		    
		    PreparedStatement preparedStatement = connexion.prepareStatement(sql);
		    preparedStatement.setInt(1, id);
		    resultat =preparedStatement.executeUpdate();
		    
		    connexion.close(); 

		} catch ( SQLException e ) {
			System.out.println(e.getMessage());
		}
		
	}


}
