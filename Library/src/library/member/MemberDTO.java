package library.member;

import java.io.Serializable;
import java.util.Date;

public class MemberDTO implements Serializable{
	private String id;
	private String pass;
	private String name;
	private String address;
	private String email;
	private String phone_num;

	
	public MemberDTO() {
		super();
	}
	
	public MemberDTO(String id, String pass, String name, String address, String email, String phone_num) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone_num = phone_num;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	
	
	
	

	

	

	
	
	
}
