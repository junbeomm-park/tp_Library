package mall.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
	Scanner sc = new Scanner(System.in);
	Member m = new Member();
	List<Member> list = new ArrayList<Member>();
	
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
