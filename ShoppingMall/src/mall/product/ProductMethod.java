package mall.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mall.member.Member;

public class ProductMethod {
	List<Product> products;
	List<Member> members;
	List<Cart> carts;
	Scanner sc = new Scanner(System.in);
	
	public ProductMethod() {
		members = new ArrayList<Member>();
		products = new ArrayList<Product>();
		products.add(new Product("삼겹살",15000,15));
		products.add(new Product("소고기 ",45000,10));
		products.add(new Product("쌈장 ",5500,4));
		products.add(new Product("상추 ",1000,17));
		products.add(new Product("소주 ",5000,21));
		products.add(new Product("맥주 ",5000,30));
		products.add(new Product("마늘 ",1500,10));

	}
	
	public void purchase() {
		for(Product p : products) {
			System.out.print("상품명 : "+p.getP_name()+"\t");
			System.out.print("가격 : "+p.getPrice()+"\t");
			System.out.print("수량 : "+p.getAmount()+"\t");
			System.out.println();
		}
		System.out.println("선택 : ");
		String choice = sc.nextLine();
		
		for(Product pc : products) {
			if(choice.equals(pc.getP_name())) {
				carts.add(new Cart());
			}
		}
	}
}
