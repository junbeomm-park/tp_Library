package library.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import library.member.Member;

public class BookMethod {
	List<Book> products;
	List<Member> members;
	List<Cart> carts;
	Scanner sc = new Scanner(System.in);
	
	public BookMethod() {
		members = new ArrayList<Member>();
		products = new ArrayList<Book>();
		products.add(new Book("삼겹살",15000,15));
		products.add(new Book("소고기 ",45000,10));
		products.add(new Book("쌈장 ",5500,4));
		products.add(new Book("상추 ",1000,17));
		products.add(new Book("소주 ",5000,21));
		products.add(new Book("맥주 ",5000,30));
		products.add(new Book("마늘 ",1500,10));

	}
	
	public void purchase() {
		int count = 1;
		for(Book p : products) {
			System.out.print("번호 :"+count+"\t");
			System.out.print("상품명 : "+p.getP_name()+"\t");
			System.out.print("가격 : "+p.getPrice()+"\t");
			System.out.print("수량 : "+p.getAmount()+"\t");
			System.out.println();
			count++;
		}
		System.out.println("선택 : ");
		String choice = sc.nextLine();
		
		for(Book pc : products) {
			if(choice.equals(pc.getP_name())) {
				carts.add(new Cart());
			}
		}
	}
}
