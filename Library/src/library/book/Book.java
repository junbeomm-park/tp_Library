package library.book;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String bookName;
	private String writer;
	private String publisher;
	private String category;
	private int amount;
	private List<Cart> carts;
	
	public Book() {
	
	}
	
	public Book(String bookName, String writer, String publisher, String category, int amount ) {
		super();
		this.bookName = bookName;
		this.writer = writer;
		this.publisher = publisher;
		this.category = category;
		this.amount = amount;
		carts = new ArrayList<Cart>();
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
	
	
}
