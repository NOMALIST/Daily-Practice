package Example5;

public class ProductApp2 {

	/*main method가 있는 ProductApp2 생성*/
	
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
		p1.price = "32000000";
		p1.stock = 1400;
		p1.isSoldOut = false;
		
		p2.no = 110;
		p2.category = "SUV";
		p2.maker = "HYUNDAI";
		p2.name = "SANTAFE";
		p2.price = "40000000";
		p2.stock = 0;
		p2.isSoldOut = true;
		
		p3.no = 200;
		p3.category = "SUV";
		p3.maker = "GENESIS";
		p3.name = "GV80";
		p3.price = "69000000";
		p3.stock = 50;
		p3.isSoldOut = false;
		
		//모든상품의 이름을 화면에 출력하기
		p[0].printInfo();
		p[1].printInfo();
		p[2].printInfo();
		
		//모든 상품의 이름을 향상된 for문을 사용해서 출력하기
		System.out.println("========향상된 for문을 사용하여 출력==========");
		for(Product x : p) {
			x.printInfo();
		}
		
	}
}
