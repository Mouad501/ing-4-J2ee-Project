package com.project.beans;

import java.util.ArrayList;

import com.project.bdd.Access;

public class Cart {
	
	private ArrayList<Product> listOfProduct;
	private float total_price;
	private int longueur;
	
	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public ArrayList<Product> getListOfProduct() {
		return listOfProduct;
	}

	public void setListOfProduct(ArrayList<Product> listOfProduct) {
		this.listOfProduct = listOfProduct;
	}

	public Cart() {
		listOfProduct = new ArrayList<Product>();
		total_price = 0;
		longueur = 0;
	}
	
	public void addProduct(int p_id) {
		Access accee = new Access();
		Product p = accee.getProduct(p_id);
		if(p==null) return;
		if(listOfProduct.contains(p)) return ;
		this.listOfProduct.add(p);
		this.total_price = this.total_price + p.getPrix();
		this.longueur = this.longueur + 1;
	}
	
	public void removeProduct(int p_id) {
		for(Product product : listOfProduct){
			if(product.getId() == p_id) {
				listOfProduct.remove(product);
				total_price = total_price - product.getPrix();
				longueur = longueur - 1;
				return;
			}
		}
	}
}
