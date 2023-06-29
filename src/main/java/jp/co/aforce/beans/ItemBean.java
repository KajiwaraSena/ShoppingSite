package jp.co.aforce.beans;

import java.io.Serializable;

public class ItemBean implements Serializable {
	
	private String product_id;
	private String name;
	private int price;
	private int quantity;
	
	public ItemBean() {
		this.product_id = "";
		this.name = "";
		this.price = 0;
		this.quantity = 0;
	}
	
	public ItemBean(String product_id, String name, int price, int quantity) {
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


