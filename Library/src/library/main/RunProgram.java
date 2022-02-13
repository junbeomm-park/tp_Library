package library.main;

import java.util.Scanner;

import library.book.Book;
import library.book.BookMethod;
import library.member.MemberMethod;

public class RunProgram {
	Scanner sc;
	MemberMethod mm = new MemberMethod();
	BookMethod pm = new BookMethod();
	Book p = new Book();
	
	public RunProgram() {
		sc = new Scanner(System.in);
		
	}
	
	public void index() {
		while(true) {
			System.out.println("=================준범's mall=================");
			System.out.println("처음 이용 하시는 고객님은 회원 가입을 진행 해주세요 ! \n\n\n");
			System.out.println("1. 회원가입 2. 로그인 3. 관리자로그인 4.test");
			System.out.print("선택 : ");
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1":
				mm.join();
				
				
				break;
			case "2":
				mm.login();
				shopping();
				
				break;
			case "4":
				mm.print();
				break;
	
			default:
				break;
			}
		}	
	}
	
	public void shopping() {
		
		System.out.println("1.상품구매하기 2.장바구니 3.회원정보 수정 4.회원탈퇴 5.뒤로가기");
		System.out.print("선택 : ");
		String menu = sc.nextLine();
		
		switch (menu) {
		case "1":
				pm.purchase();
			break;
			
		case "3":
			
			break;
		case "5":
			
			break;

		default:
			break;
		}
	}
}
