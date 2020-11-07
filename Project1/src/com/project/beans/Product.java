package com.project.beans;

public class Product {

	private int id;
	private String designation;
	private String categorie;
	private String description;
	private Float prix;
	private String keyword;
	private String image;
	private int q_stock;
	
	
	public Product(int id, String designation, String categorie, String description, Float prix, String keyword,
			String image, int q_stock) {
		super();
		this.id = id;
		this.designation = designation;
		this.categorie = categorie;
		this.description = description;
		this.prix = prix;
		this.keyword = keyword;
		this.image = image;
		this.q_stock = q_stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQ_stock() {
		return q_stock;
	}

	public void setQ_stock(int q_stock) {
		this.q_stock = q_stock;
	}

}
