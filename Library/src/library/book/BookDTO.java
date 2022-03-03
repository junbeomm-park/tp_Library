package library.book;

import java.io.Serializable;

public class BookDTO implements Serializable{
	private int index; //도서 번호(index)
	private String b_name; //도서명
	private int b_price; //도서 대여 가격
	private String category; //분류
	private int isAvailable; //대여상태(대여 가능: 0, 대여 불가: 1) 
	private String registerDate ; //도서 등록 날짜
	private int amount; //도서 수량
	
	
	public BookDTO() {
		
	}


	public BookDTO(int index, String b_name, int b_price, String category, int isAvailable, String registerDate,
			int amount) {
		super();
		this.index = index;
		this.b_name = b_name;
		this.b_price = b_price;
		this.category = category;
		this.isAvailable = isAvailable;
		this.registerDate = registerDate;
		this.amount = amount;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public String getB_name() {
		return b_name;
	}


	public void setB_name(String b_name) {
		this.b_name = b_name;
	}


	public int getB_price() {
		return b_price;
	}


	public void setB_price(int b_price) {
		this.b_price = b_price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}


	public String getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
}
