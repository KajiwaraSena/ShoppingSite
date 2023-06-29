package jp.co.aforce.cart;

import java.io.Serializable;

public class CartItem implements Serializable{
	
	private String product_id;
	private String name;
	private int price;
	private int quantity;
	public CartItem() {
		super();
	}
	public CartItem(String product_id,String name, int price,int quantity) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getProduct_Id() {
		return product_id;
	}
	public void setProduct_Id(String product_id) {
		this.product_id = product_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
}
