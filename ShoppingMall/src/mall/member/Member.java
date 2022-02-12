package mall.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Member {
	Scanner sc = new Scanner(System.in);
	private String name;
	private String id;
	private String password;
	private int birth;
	private String address;
	
	public Member() {
		
	}
	
	public Member(String name, String id, String password, int birth, String address) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.birth = birth;
		this.address = address;
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
