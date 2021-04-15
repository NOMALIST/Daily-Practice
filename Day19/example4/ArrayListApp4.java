package example4;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListApp4 {

	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<Product>();
		
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
		
		Iterator<Product> iter = products.iterator();
		
		System.out.println("### Iterator를 사용해서 ArrayList 출력하기 ###");
		
		while(iter.hasNext()) {
			Product item = iter.next();
			item.print();
		}
		
		
		
	}
}
