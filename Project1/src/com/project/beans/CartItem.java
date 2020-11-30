package com.project.beans;

public class CartItem {

	private Product product;
	private int quantity;
	
	public CartItem(Product p, int quantity) {
		this.setProduct(p);
		this.setQuantity(quantity);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product p) {
		this.product = p;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object item) {
        if(item == null) return false;
        if(item == this) return true;
        if (this.getClass() != item.getClass()){ 
            return false;
        }
        if(((CartItem) item).getProduct().getId() == this.product.getId()) return true;
        return false;
    }

}
