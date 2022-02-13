package library.book;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String p_name;
	private int price;
	private int amount;
	private List<Cart> carts;
	
	public Book() {
	
	}
	
	public Book(String p_name, int price, int amount) {
		super();
		this.p_name = p_name;
		this.price = price;
		this.amount = amount;
		carts = new ArrayList<Cart>();
	}
	
	public void addCart(Cart cart) {
		carts.add(cart);
		
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
