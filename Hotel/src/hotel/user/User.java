package hotel.user;

import hotel.room.Room;

public class User extends Room{
	String name;
	String id;
	String pass;
	
	public User() {
		
	}
	
	
	public User(String id, String pass, String name) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
	}
	
	
	
	public User(String roomNo, String roomGrade, int price, int people, String name) {
		super(roomNo, roomGrade, price, people);
		this.name = name;
	}

	public void show() {
		System.out.println("이름" + name);
		System.out.println("아이디" + id);
		System.out.println("비밀번호" + pass);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
