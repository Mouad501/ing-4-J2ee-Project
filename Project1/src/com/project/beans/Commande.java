package com.project.beans;

public class Commande {
	
	private long id;
	private long id_user;
	private String Date;
	
	
	
	public Commande(long id, long id_user, String Date) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.setDate(Date);
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId_user() {
		return id_user;
	}
	
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	

}
