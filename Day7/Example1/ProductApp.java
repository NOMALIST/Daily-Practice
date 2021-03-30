package Example1;

public class ProductApp {

	public static void main(String[] args) {
		//상품정보를 3개 저장하는 배열객체를 생성하기
		Product[] p = new Product[3];
		
		//상품정보를 담을 수 있는 Product객체 3개 생성하기
		Product p1 = new Product(); 
		Product p2 = new Product(); 
		Product p3 = new Product();
		
		//배열의 0번째 칸부터 2번째 칸에 생성된 Product객체를 저장하기
		p[0] = p1; 		p[1] = p2;		p[2] = p3;
		
		p1.no = 100;
		
		p1.category = "SUV";
		p1.maker = "HYUNDAI";
		p1.name = "TUCSAN";
		p1.price = 32000000;
		p1.stock = 1400;
		p1.isSoldOut = false;
		
		p2.no = 110;
		p2.category = "SUV";
		p2.maker = "HYUNDAI";
		p2.name = "SANTAFE";
		p2.price = 40000000;
		p2.stock = 0;
		p2.isSoldOut = true;
		
		p3.no = 200;
		p3.category = "SUV";
		p3.maker = "GENESIS";
		p3.name = "GV80";
		p3.price = 690000;
		p3.stock = 50;
		p3.isSoldOut = false;
		
		//### products 배열에 저장된 상품중에서 재고수량이 25개 이상인 상품의 정보만 출력하기
		System.out.println("### 재고수량이 25개 이상인 상품의 정보만 출력하기 ###");
		for(Product x : p) {
			if(x.stock >= 25) x.printInfo();
		}
		//### products 배열에 저장된 상품중에서 제품의 가격이 100만원 이상인 상품의 정보만 출력하기
		System.out.println("### 가격이 100만원 이상인 상품의 정보만 출력하기 ###");
		for(Product x : p) {
			if(x.price >= 1000000)	x.printInfo();
		}
		
		//### products 배열에 저장된 상품중에서 애플에서 제조한 상품정보만 출력하기
		System.out.println("### 현대에서 제조한 정보만 출력하기 ###");
		for(Product x : p) {
			if("HYUNDAI".equals(x.maker))	x.printInfo();
		}
	}
}
