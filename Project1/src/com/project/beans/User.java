package com.project.beans;

public class User {

	private int id;
	private String username;
	private String email;
	private String password;
	private String tel;
	private String address;
	private String role;
	private String active;
	
	
	public User(int id, String username, String email, String password, String tel, String address, String role, String active) {
		this.id = id;
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
		this.setTel(tel);
		this.setAddress(address);	
		this.role = role;
		this.setActive(active);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return this.email + " " + this.password + " " + this.id;
		
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
