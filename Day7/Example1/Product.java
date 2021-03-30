package Example1;

public class Product {

	int no;
	String category;
	String name;
	String maker;
	int price;
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
