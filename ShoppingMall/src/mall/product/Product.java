package mall.product;

public class Product {
	String p_name;
	int price;
	int amount;
	
	public Product() {
		
	}
	
	public Product(String p_name, int price, int amount) {
		super();
		this.p_name = p_name;
		this.price = price;
		this.amount = amount;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
