package example2;

import java.util.ArrayList;

public class ArrayListApp {

	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<Product>();
		
		//### ArrayList 객체에 Product객체 저장하기
		products.add(new Product(10, "노트북9", 698000, 0.05));
		products.add(new Product(11, "플렉스2", 1936060, 0.03));
		products.add(new Product(12, "그램", 1269000, 0.03));
		products.add(new Product(13, "맥북", 1959200, 0.05));
		products.add(new Product(21, "갤럭시S21", 1349000, 0.08));
		products.add(new Product(22, "아이폰12미니", 1009800, 0.08));
		products.add(new Product(23, "갤럭시폴드2", 1769000, 0.08));
		products.add(new Product(23, "갤럭시폴드2", 1769000, 0.08));
		products.add(new Product(31, "아이패드8", 414200, 0.1));
		products.add(new Product(32, "아이패드프로", 984840, 0.1));
		products.add(new Product(33, "갤럭시탭s7", 740460, 0.1));
		
		//### ArrayList 객체에 저장된 Product객체의 갯수조회하기
		System.out.println("products의 크기: " + products.size());
		System.out.println();
		
		//### ArrayList 객체에 저장된 Product객체의 정보 출력하기
		System.out.println("Products객체의 정보 출력하기");
		for(Product p : products) {
			p.print();
		}
		System.out.println();
		
		//### 특정한 객체를 저장하고 있는지 확인하기
		Product p1 = new Product(31, "아이패드8", 414200, 0.1);
		System.out.println("특정한 객체(p1)을 포함하는가? " + products.contains(p1));
		System.out.println();
		
		//### ArrayList 객체에 저장된 모든 객체 삭제하기
		products.clear();
		System.out.println("clear()명령어 실행함");
		System.out.println();
		
		//### ArrayList 객체에 저장된 Product의 갯수
		System.out.println("products의 크기: " + products.size());
		System.out.println();
		
		
	}
}
