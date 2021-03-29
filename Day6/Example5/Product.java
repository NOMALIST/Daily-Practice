package Example5;

		/*class : Product 생성*/
		//상품정보를 표현하는 객체에 대한 설계도를 작성하시오
		//멤버변수 정의하시오
		//상품번호, 상품카테고리, 상품명, 제조사, 가격, 재고수량, 절판여부에 대한 멤버변수를 정의하시오.
		//(no, category, name, maker, price, stock, isSoldOut)
		
		//멤버메소드를 정의하시오
		//상품정보를 화면에 출력하는 void printInfo(){...} 메소드를 작성하시오
public class Product {

	int no;
	String category;
	String name;
	String maker;
	String price;
	int stock;
	boolean isSoldOut;
	
	void printInfo() {
		System.out.println("===========상품정보=============");
		System.out.println("상품번호 : " + no);
		System.out.println("카테고리 : " + category);
		System.out.println("상 품 명 : " + name);
		System.out.println("제 조 사 : " + maker);
		System.out.println("가    격 : " + price);
		System.out.println("재고수량 : " + stock);
		System.out.println("품절여부 : " + (isSoldOut ? "품절" : "재고있음"));
		System.out.println();
	}
	
}
