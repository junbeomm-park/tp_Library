package mall.main;

import java.util.Scanner;

import mall.member.Join;
import mall.member.Login;

public class Main {

	public static void main(String[] args) {
		Join j = new Join();
		Login l = new Login();
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("=================준범's mall=================");
			System.out.println("처음 이용 하시는 고객님은 회원 가입을 진행 해주세요 ! \n\n\n");
			System.out.println("1. 회원가입 2. 로그인 3. 관리자로그인 4.test");
			System.out.print("선택 : ");
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1":
				j.join();
				
				
				break;
			case "2":
				j.login();
				
				break;
			case "4":
				j.print();
				break;

			default:
				break;
			}
		}
		
	}

}
