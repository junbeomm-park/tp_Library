package hotel.room;

public class Room {
	String roomNo;
	String roomGrade;
	int price;
	int people;
	
	public Room() {
	
	}

	public Room(String roomNo, String roomGrade, int price, int people) {
		super();
		this.roomNo = roomNo;
		this.roomGrade = roomGrade;
		this.price = price;
		this.people = people;
	}
	
	public void show() {
		
		
		System.out.println("객실 등급 : " + roomGrade);
		System.out.println("1박 가격 : " + price);
		System.out.println("인원 제한 : " + people + "이하");
		System.out.println();
		
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomGrade() {
		return roomGrade;
	}

	public void setRoomGrade(String roomGrade) {
		this.roomGrade = roomGrade;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}
	
	
	
}
