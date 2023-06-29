package jp.co.aforce.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{
	private List<CartItem> list;
	private int total;
	public Cart() {
		super();
		list=new ArrayList<>();
		total=0;
	}

	public List<CartItem> getList() {
		return list;
	}
	public void setList(List<CartItem> list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	

}
