package library.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import library.book.Cart;
import library.book.Book;

public class Member {
	private String name;
	private String id;
	private String password;
	private int birth;
	private String address;
	private List<Cart> carts;
	
	public Member() {
		
	}
	
	public Member(String name, String id, String password, int birth, String address) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.birth = birth;
		this.address = address;
		carts = new ArrayList<Cart>();
	}
	
	public void addCart(Cart cart) {
		carts.add(cart);
	}
	
	public List<Book> getCart() {
		List<Book> products = new ArrayList<Book>();
		for(Cart c : carts) {
			products.add(c.getProduct());
		}
		return products;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getbirth() {
		return birth;
	}

	public void setbirth(int birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
