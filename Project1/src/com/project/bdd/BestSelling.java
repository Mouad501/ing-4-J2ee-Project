package com.project.bdd;

public class BestSelling {
	
	private String product;
	private Float total;
	
	public BestSelling(String product, Float total) {
		super();
		this.product = product;
		this.total = total;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
	
	

}
