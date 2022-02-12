package mall.product;

import java.util.ArrayList;
import java.util.List;

import mall.member.Member;

public class Cart {
	Member member;
	Product product;
	String p_name;
	int price;
	int amount;
	List<Cart> cart;
	
	public Cart() {
		
	}
	
	public Cart(String p_name, int price, int amount) {
		this.p_name = p_name;
		this.price = price;
		this.amount = amount;
	}
	
	public Cart(Member member, Product product, String p_name, int price, int amount) {
		
		this.member = member;
		this.member.addCart(this);
		this.product = product;
		this.p_name = p_name;
		this.price = price;
		this.amount = amount;
		cart = new ArrayList<Cart>();
		
	}
	
	

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	
	
}
