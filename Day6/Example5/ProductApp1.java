package Example5;

public class ProductApp1 {

	public static void main(String[] args) {
		
		/*main method가 있는 ProductApp 생성 */
		//상품정보를 표현하는 객체를 생성하고, 객체의 멤버변수에 적절한 상품정보를 저장한다.

		//위에서 생성한 상품객체에 저장된 상품정보를 화면에 출력하는 메소드를 실행한다.
		
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
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
		
		p1.printInfo();
		p2.printInfo();
		p3.printInfo();
		
	}
}
