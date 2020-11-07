package com.project.beans;

public class User {

	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String tel;
	private String address;
	private String sex;
	
	
	public User(int id, String firstname, String lastname, String email, String password, String tel, String address, String sex) {
		this.id = id;
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail(email);
		this.setPassword(password);
		this.setTel(tel);
		this.setAddress(address);
		this.setSex(sex);	
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
