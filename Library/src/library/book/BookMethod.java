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
		products.add(new Book("어린왕자     ","생떽쥐베리","열린책들   ","문학",5));
		products.add(new Book("Do it Java","김동형","이지스퍼블리싱","교육",3));
		products.add(new Book("Java의 정석","남궁성","도우출판   ","교육",8));
		products.add(new Book("해리포터     ","j.k. 롤링","문학수첩   ","판타지",2));
		products.add(new Book("아버지의 편지","정약용","함께읽는책   ","교양",12));
		

	}
	
	public void bookList() {
		int count = 1;
		
		System.out.println("도서번호\t\t도서명\t\t저자\t\t출판사\t\t분류\t\t남은수량");
		System.out.println("============================================================================================");
		for(Book p : products) {
			System.out.print(count+"\t\t");
			System.out.print(p.getBookName()+"\t");
			System.out.print(p.getWriter()+"\t\t");
			System.out.print(p.getPublisher()+"\t");
			System.out.print(p.getCategory()+"\t\t");
			System.out.print(p.getAmount()+"\t");
			System.out.println();
			count++;
		}
		System.out.println("선택 : ");
		String choice = sc.nextLine();
		
		for(Book pc : products) {
			if(choice.equals(pc.getBookName())) {
				carts.add(new Cart());
			}
		}
	}
}
