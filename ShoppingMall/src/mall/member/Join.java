package mall.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Join {
	Scanner sc = new Scanner(System.in);
	List<Member> list = new ArrayList<Member>();
	Member m = new Member();
	
	public  void join() {
		System.out.println("=================회원가입=================");
		System.out.print("이름 입력 :");
		String name = sc.nextLine();
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		System.out.print("비밀 번호 입력 : ");
		String password = sc.nextLine();
		System.out.print("생년월일 입력 : ");
		int birth = Integer.parseInt(sc.nextLine());
		System.out.print("주소 입력 : ");
		String address = sc.nextLine();
		
		list.add(new Member(name, id, password, birth, address));
		
		System.out.println("회원 가입 성공 !!!!");
	}
	
	public void print() {
		for(Member b : list) {
			System.out.println("이름 : " + b.getName());
			System.out.println("아이디 : " + b.getId());
			System.out.println("비밀번호 : " + b.getPassword());
			System.out.println("생년월일 : " + b.getbirth());
			System.out.println("주소 : " + b.getAddress());
		}
	}
	
	public void login() {
		System.out.print("아이디를 입력 하세요 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력 하세요 : ");
		String password = sc.nextLine();
		
		for(Member c : list) {
			if(id.equals(c.getId()) && password.equals(c.getPassword())) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패 다시 시도 해주세요.");
			}
		}
	}
}
