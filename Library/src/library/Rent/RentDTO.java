package library.Rent;

import java.io.Serializable;

public class RentDTO implements Serializable{
	private int reservationIndex;//예약 index
	private String id; //대여한 사람 id
	private int index; //책 index
	private int rentDay; // 대여 일수
	private String reservationDate ; //대여한 날짜
	private String returnDate; //도서 반납 날짜
	private int lateFee; //연체료
	
	public RentDTO() {
		
	}
	
	public RentDTO(int reservationIndex, String id, int index, int rentDay, String reservationDate, String returnDate,
			int lateFee) {
		super();
		this.reservationIndex = reservationIndex;
		this.id = id;
		this.index = index;
		this.rentDay = rentDay;
		this.reservationDate = reservationDate;
		this.returnDate = returnDate;
		this.lateFee = lateFee;
	}

	public int getReservationIndex() {
		return reservationIndex;
	}

	public void setReservationIndex(int reservationIndex) {
		this.reservationIndex = reservationIndex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
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

	public int getLateFee() {
		return lateFee;
	}

	public void setLateFee(int lateFee) {
		this.lateFee = lateFee;
	}

	public int getRentDay() {
		return rentDay;
	}

	public void setRentDay(int rentDay) {
		this.rentDay = rentDay;
	}
	
	
	
	
	
	
	
}