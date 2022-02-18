package hotel.reservation;

import hotel.user.User;

public class Reservation extends User {
	int days;
	


	public Reservation(String roomNo, String roomGrade, int price, String name, int people,
			 int days) {
		super(roomNo, roomGrade, price, people, name);
		this.days = days;
	}
	
	public void show() {
		System.out.println("예약자 이름 : " + getName());
		System.out.println("예약한 방 : " + getRoomGrade());
		System.out.println("예약한 인원수 : " + getPeople()+"명");
		System.out.println("가격 : " + getPrice() * days+"원");
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	

	
	
	
}
