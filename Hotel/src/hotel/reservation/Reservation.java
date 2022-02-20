package hotel.reservation;

import hotel.user.User;

public class Reservation extends User {
	int days;
	int resernum;
	


	public Reservation(String roomNo, String roomGrade, int price, String name, int people,
			 int days, int resernum) {
		super(roomNo, roomGrade, price, people, name);
		this.days = days;
		this.resernum = resernum;
	}
	
	public void show() {
		System.out.println("예약자 이름 : " + getName());
		System.out.println("예약한 방 : " + getRoomGrade());
		System.out.println("예약한 인원수 : " + getPeople()+"명");
		System.out.println("가격 : " + getPrice() * days+"원");
		System.out.println("예약번호 : " + resernum);
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getResernum() {
		return resernum;
	}

	public void setResernum(int resernum) {
		this.resernum = resernum;
	}
	
	

	
	
	
}
