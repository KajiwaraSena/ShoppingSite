package jp.co.aforce.cart;

public class CartLogic {
	public void execute(Cart cart,CartItem vege) {
		cart.getList().add(vege);
		cart.setTotal(cart.getTotal()+vege.getPrice());
	}
}
