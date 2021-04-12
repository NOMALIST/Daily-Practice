package example1;

public class ProductApp {

	public static void main(String[] args) {
		
		Product[] products = new Product[10];
		
		products[0] = new Product("청바지", "S", 100000);
		products[1] = new Product("반바지", "M", 50000);
		products[2] = new Product("운동용바지", "L", 70000);
		products[3] = new Product("정장바지", "XL", 160000);
		products[4] = new Product("치마", "S", 80000);
		products[5] = new Product("스커트", "M", 120000);
		products[6] = new Product("린넨바지", "L", 30000);
		products[7] = new Product("카고바지", "XL", 200000);
		products[8] = new Product("나팔바지", "S", 110000);
		products[9] = new Product("면바지", "M", 40000);
		
		System.out.println("### Size가 S인 바지만 출력하기 ###");
		for(Product x : products) {
			if(x.getSize().equals("S")) {
				System.out.println(x.getName() + ", " + x.getSize() + ", " + x.getPrice());
			}
		}
		System.out.println();
		
		System.out.println("### Price가 15000이상인 바지만 화면에 출력하기 ###");
		for(Product x : products) {
			if(x.getPrice() >= 15000) {
				System.out.println(x.getName() + ", " + x.getSize() + ", " + x.getPrice());
			}
		}
		System.out.println();
		
		System.out.println("### Size가 M이고 Price가 1만원 이상 5만원 이하인 바지만 화면에 출력하기 ###");
		for(Product x : products) {
			if(x.getSize().equals("M") && x.getPrice() >= 10000 && x.getPrice() <= 50000) {
				System.out.println(x.getName() + ", " + x.getSize() + ", " + x.getPrice());
			}
		}
		System.out.println();
		
	}
}
