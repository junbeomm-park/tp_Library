package library.book;

import java.util.ArrayList;
import java.util.List;

import library.reservation.Reservation;

public class Book {
	private String bookName;
	private String writer;
	private String publisher;
	private String category;
	private int amount;
	private List<Reservation> reservates;
	
	public Book() {
	
	}
	
	public Book(String bookName, String writer, String publisher, String category, int amount ) {
		super();
		this.bookName = bookName;
		this.writer = writer;
		this.publisher = publisher;
		this.category = category;
		this.amount = amount;
		reservates = new ArrayList<Reservation>();
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

	public List<Reservation> getReservates() {
		return reservates;
	}

	public void setReservates(List<Reservation> reservates) {
		this.reservates = reservates;
	}

	
	
	
	
}
