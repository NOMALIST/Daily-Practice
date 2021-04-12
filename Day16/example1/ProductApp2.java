package example1;

public class ProductApp2 {

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
		
		Predicate p1 = new Predicate() {
			@Override
			public boolean test(Product item) {
				return item.getSize() == "S";
			}
		};
		
		Predicate p2 = new Predicate() {
			@Override
			public boolean test(Product item) {
				return item.getPrice() == 50000;
			}
		};
		
		System.out.println("### Size가 S인 바지 출력하기 ###");
		printProducts(products, p1);
		System.out.println();
		
		System.out.println("### Price가 50000인 바지 출력하기 ###");
		printProducts(products, p2);
		System.out.println();
		
		System.out.println("### Price가 5만원 이상 10만원 이하인 상품만 출력 ###");

		printProducts(products, new Predicate() {
			@Override
			public boolean test(Product item) {
			
				return item.getPrice() >= 50000 && item.getPrice() <= 100000;
			}
		});
		System.out.println();
		System.out.println("$$$ 람다표현식 $$$");
		printProducts(products, item -> {return item.getPrice() >= 50000 && item.getPrice() <= 100000;} );
		System.out.println();
		
		System.out.println("### Size가 S이고 Price가 5만원 이상 10만원 이하인 상품만 출력");
		printProducts(products, new Predicate() {
			@Override
			public boolean test(Product item) {
				return item.getSize().equals("S") && item.getPrice() >= 50000 && item.getPrice() <= 100000;
			}
		});
		System.out.println();
		System.out.println("$$$ 람다 표현식 $$$");
		printProducts(products, item -> {return item.getSize().equals("S")
				&& item.getPrice() >= 50000 
				&& item.getPrice() <= 100000;});
		System.out.println();
		
		System.out.println("### Size가 XL인 바지 출력하기 ###\n$$$ 람다표현식2 $$$");
		printProducts(products, item -> item.getSize().equals("XL"));
		
	}
	
	static interface Predicate {
		boolean test(Product item);
	}
	
	public static void printProducts(Product[] items, Predicate p) {
		for(Product x : items) {
			if(p.test(x)) System.out.println(x.getName() + ", " + x.getSize() + ", " + x.getPrice());			
		}
	}
}
