package example6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import example5.Product;

public class ArrayListApp6 {

	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		
		products.add(new Product(23, "갤럭시폴드2", 1769000, 0.08));
		products.add(new Product(10, "노트북9", 698000, 0.05));
		products.add(new Product(22, "아이폰12미니", 1009800, 0.08));
		products.add(new Product(13, "맥북", 1959200, 0.05));
		products.add(new Product(32, "아이패드프로", 984840, 0.1));
		products.add(new Product(11, "플렉스2", 1936060, 0.03));
		products.add(new Product(12, "그램", 1269000, 0.03));
		products.add(new Product(21, "갤럭시S21", 1349000, 0.08));
		products.add(new Product(33, "갤럭시탭s7", 740460, 0.1));
		products.add(new Product(23, "갤럭시폴드2", 1769000, 0.08));
		products.add(new Product(31, "아이패드8", 414200, 0.1));
		
		Collections.sort(products);
		System.out.println("-------상품번호순------------");
		for(Product p : products) {
			p.print();
		}
		System.out.println("-----------------------------");
		
		
		Comparator<Product> nameComparator = new Comparator<Product>() {
			
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		
		Collections.sort(products, nameComparator);
		
		System.out.println("-------상품이름순------------");
		for(Product p : products) {
			p.print();
		}
		System.out.println("-----------------------------");
		
		Comparator<Product> priceComparator = new Comparator<Product>() {
			
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getPrice() - o2.getPrice();
			}
		};
		
		Collections.sort(products, priceComparator);
		System.out.println("-------상품가격순------------");
		for(Product p : products) {
			p.print();
		}
		System.out.println("-----------------------------");
		
		Collections.sort(products, (o1, o2) -> (int)((o1.getPoint() - o2.getPoint())*100));
		System.out.println("-------포인트적립순------------");
		for(Product p : products) {
			p.print();
		}
		System.out.println("-----------------------------");
	}
}
