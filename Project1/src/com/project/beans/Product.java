package com.project.beans;

public class Product {

	private int id;
	private int vendeur_id;
	private String designation;
	private String categorie;
	private String description;
	private Float prix;
	private String keyword;
	private String image;
	private int q_stock;
	
	
	public Product(int id, int vendeur_id, String designation, String categorie, String description, Float prix, String keyword,
			String image, int q_stock) {
		super();
		this.id = id;
		this.vendeur_id = vendeur_id;
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
	
	@Override
	public boolean equals(Object p) {
        if(p == null) return false;
        if(p == this) return true;
        if (this.getClass() != p.getClass()){ 
            return false;
        }
        if(((Product) p).getId() == this.getId()) return true;
        return false;
    }

	public int getVendeur_id() {
		return vendeur_id;
	}

	public void setVendeur_id(int vendeur_id) {
		this.vendeur_id = vendeur_id;
	}

}
