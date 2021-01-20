package com.project.bdd;

public class RecentOrders {
	
	private String productName;
	private int quantite;
	private int productId;
	private float price;
	private String date;
	private String costumer;

	public RecentOrders(String productName, int quantite, int productId, float price, String date, String costumer) {
		super();
		this.productName = productName;
		this.quantite = quantite;
		this.productId = productId;
		this.price = price;
		this.date = date;
		this.costumer = costumer;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCostumer() {
		return costumer;
	}

	public void setCostumer(String costumer) {
		this.costumer = costumer;
	}

}
