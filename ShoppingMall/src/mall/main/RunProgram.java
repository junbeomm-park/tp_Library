package mall.main;

import java.util.Scanner;

import mall.member.MemberMethod;
import mall.product.Product;
import mall.product.ProductMethod;

public class RunProgram {
	Scanner sc;
	MemberMethod mm = new MemberMethod();
	ProductMethod pm = new ProductMethod();
	Product p = new Product();
	
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
		
		System.out.println("1.상품목록보기 2.장바구니 3.회원정보 수정 4.회원탈퇴 5.뒤로가기");
		System.out.print("선택 : ");
		String menu = sc.nextLine();
		
		switch (menu) {
		case "1":
				pm.print();
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
