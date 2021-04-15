package example4;

public class Product {

	private int no;
	private String name;
	private int price;
	private double pointRate;
	
	public Product() {}
	
	public Product(int no, String name, int price, double pointRate) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.pointRate = pointRate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getPoint() {
		return pointRate;
	}

	public void setPoint(double pointRate) {
		this.pointRate = pointRate;
	}
	
	public void print() {
		System.out.println("[" + this.no + " " 
							+ this.name + " " 
							+ this.price + " "
							+ this.pointRate + "]");
	}
}
