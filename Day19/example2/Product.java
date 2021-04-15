package example2;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		long temp;
		temp = Double.doubleToLongBits(pointRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		if (Double.doubleToLongBits(pointRate) != Double.doubleToLongBits(other.pointRate))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	
	
	
}
