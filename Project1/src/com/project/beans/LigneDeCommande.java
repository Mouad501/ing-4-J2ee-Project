package com.project.beans;

public class LigneDeCommande {
	
	private long order_id;
	private long product_id;
	private long vendeur_id;
	private int quantity;
	
	public LigneDeCommande(long order_id, long product_id, long vendeur_id, int quantity) {
		super();
		this.setOrder_id(order_id);
		this.setProduct_id(product_id);
		this.vendeur_id = vendeur_id;
		this.setQuantity(quantity);
	}
	
	public long getOrder_id() {
		return order_id;
	}
	
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getVendeur_id() {
		return vendeur_id;
	}

	public void setVendeur_id(long vendeur_id) {
		this.vendeur_id = vendeur_id;
	}

	

}
