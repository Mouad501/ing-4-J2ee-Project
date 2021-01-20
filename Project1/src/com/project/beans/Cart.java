package com.project.beans;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.project.bdd.Access;

public class Cart {
	
	private ArrayList<CartItem> listOfProducts;
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

	public ArrayList<CartItem> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(ArrayList<CartItem> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	public Cart() {
		listOfProducts = new ArrayList<CartItem>();
		total_price = 0;
		longueur = 0;
	}
	
	public void updateCart(int p_id, int q) throws IOException {
		Access accee = new Access();
		Product p = accee.getProduct(p_id);
		if(p==null) return;
		for(CartItem item : listOfProducts){
			if(item.getProduct().equals(p)) {
				this.total_price = this.total_price - (p.getPrix()*item.getQuantity());
				item.setQuantity(q);
				this.total_price = this.total_price + (p.getPrix()*item.getQuantity());
			}
		}
	}
	
	public void updateCart(Product p) {
		for(CartItem item : listOfProducts){
			if(item.getProduct().equals(p)) {
				item.setQuantity(item.getQuantity()+1);
				this.total_price = this.total_price + p.getPrix();
			}
		}
	}
	
	public void addProduct(int p_id) throws IOException {
		Access accee = new Access();
		Product p = accee.getProduct(p_id);
		if(p==null) return;
		if(listOfProducts.contains(new CartItem(p,1))) {
			updateCart(p);
			return ;
		}
		addProduct(p,1);
	}
	
	public void addProduct(Product p, int quantity) {
		this.listOfProducts.add(new CartItem(p,quantity));
		this.total_price = this.total_price + (p.getPrix() * quantity);
		this.longueur = this.longueur + 1;
	}
	
	public void removeProduct(int p_id) {
		for(CartItem item : listOfProducts){
			if(item.getProduct().getId() == p_id) {
				listOfProducts.remove(item);
				total_price = total_price - (item.getProduct().getPrix() * item.getQuantity());
				longueur = longueur - 1;
				return;
			}
		}
	}
}
