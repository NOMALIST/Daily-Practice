package example3;

public class ItemService {
	Item[] items = new Item[100];
	int position = 0;

	// Item 배열에 Item 객체 5개 등록하기
	// items[position++] = new Item(100, "노트북", "맥북", "애플, 1900000);
	ItemService() {

		items[position++] = new Item(100,"노트북", "맥북", "애플", 1900000);
		items[position++] = new Item(110,"노트북", "그램", "LG", 1500000);
		items[position++] = new Item(200,"스마트폰", "S21", "삼성", 990000);
		items[position++] = new Item(210,"스마트폰", "아이폰12", "애플", 1200000);
		items[position++] = new Item(300,"웨어러블", "애플워치", "애플", 600000);
	}
	
	// items 배열에 저장된 모든 Item객체의 번호, 상품명, 가격을 출력한다.
	void printAllItems() {
		System.out.printf("%-8s%-15s%-15s\n","번호","상품명","가격");
		for(Item x : items) {
			if(x == null) break;
			System.out.printf("%-10d%-15s%-15s\n", x.no, x.name, x.price);
		}
	}
	
	// items 배열에 저장된 Item객체 중에서 전달받은 category에 속하는 Item객체의 번호, 상품명, 가격을 출력한다 
	void printItemsByCategory(String category) {
		System.out.printf("%-8s%-15s%-15s\n","번호","상품명","가격");
		for(Item x : items) {
			if(x == null) break;
			if(category.equals(x.category)) System.out.printf("%-10d%-15s%-15s\n", x.no, x.name, x.price);
		}
	}
	
	// items 배열에 저장된 Item객체 중에서 전달받은 상품명을 포함하고 있는 Item객체의 번호, 상품명, 가격을 출력한다.
	// .equals(name)은 상품명이 name과 일치하면 true
	// .contains(name)은 상품명에 name이 포함되어있으면 true
	void printItemByName(String name) {
		System.out.printf("%-8s%-15s%-15s\n","번호","상품명","가격");
		for(Item x : items) {
			if(x == null) break;
			if(x.name.contains(name)) System.out.printf("%-10d%-15s%-15s\n", x.no, x.name, x.price);
		}
	}
	
	// items 배열에 저장된 Item객체 중에서 전달받은 가격범위에 속하는 Item객체의 번호, 상품명, 가격을 출력한다.
	void printItemByPrice(int minPrice, int maxPrice) {
		System.out.printf("%-8s%-15s%-15s\n","번호","상품명","가격");
		for(Item x : items) {
			if(x == null) break;
			if(minPrice <= x.price && x.price <= maxPrice) System.out.printf("%-10d%-15s%-15s\n", x.no, x.name, x.price);
		}
	}
	
	// items 배열에 저장된 Item객체 중에서 전달받은 번호와 일치하는 Item객체의 모든 정보를 출력한다.
	void printItemByDetail(int no) {
		Item foundItem = null;
		for(Item x : items) {
			if(x == null) break;
			if(no == x.no) {
				foundItem = x;
				break;
			}
		}
		
		if(foundItem == null) System.out.println("일치하는 상품이 없습니다.");
		else {
			System.out.println("상품번호: " + foundItem.no);
			System.out.println("카테고리: " + foundItem.category);
			System.out.println("제 품 명: " + foundItem.name);
			System.out.println("제 조 사: " + foundItem.maker);
			System.out.println("상품가격: " + foundItem.price);
		}
	}
	
	// items 배열에 전달받은 Item 객체를 등록한다.
	void insertItem(Item item) {
		items[position++] = item;
	}
	
	// items 배열에서 전달받은 번호에 해당하는 Item 객체를 제거한다.
	// 제거된 자리에는 다음위치에 있는 Item객체들이 채워진다.(조금어려움)
	void deleteItem(int no) {
		
		int foundItemNo = -1;
		for(int i=0; i<100;i++) {
			if(items[i] == null) break;
			if(items[i].no == no) {
				foundItemNo = i;
				break;
			}
		}
		
		for(int i=foundItemNo; items[i] != null; i++) {
			if(foundItemNo == -1) {
				System.out.println("일치하는 상품이 없습니다");
				break;
			}
			items[i] = items[i+1];
		}
	}
}
