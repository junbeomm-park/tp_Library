package library.reservation;

import java.util.List;

public class Reservation {
	private String id;
	private int bookIndex;
	private String reservationDate;
	private String returnDate;
	List<Reservation> reservates;
	
	public Reservation() {
		
	}

	public Reservation(String id, int bookIndex, String reservationDate, String returnDate) {
		super();
		this.id = id;
		this.bookIndex = bookIndex;
		this.reservationDate = reservationDate;
		this.returnDate = returnDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBookIndex() {
		return bookIndex;
	}

	public void setBookIndex(int bookIndex) {
		this.bookIndex = bookIndex;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public List<Reservation> getReservates() {
		return reservates;
	}

	public void setReservates(List<Reservation> reservates) {
		this.reservates = reservates;
	}
	
	
	
	
	
}
