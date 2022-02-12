package mall.product;

import java.util.ArrayList;
import java.util.List;

public class ProductMethod {
	List<Product> products;
	
	public ProductMethod() {
		products = new ArrayList<Product>();
		products.add(new Product("삼겹살",15000,15));
	}
	
	public void print() {
		for(Product p : products) {
			System.out.println("상품명 : "+p.p_name);
			System.out.println("가격 : "+p.price);
			System.out.println("수량 : "+p.amount);
		}
	}
}
