package example3;

import java.util.Scanner;

public class ItemApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int DISPLAY_ALL_STUDENT = 1;
		final int SEARCH_BY_CATEGORY = 2;
		final int SEARCH_BY_NAME = 3;
		final int SEARCH_BY_PRICE = 4;
		final int SEARCH_BY_NUMBER = 5;
		final int INSERT_PRODUCT = 6;
		final int DELETE_PRODUCT = 7;
		final int EXIT = 0;
		
		// Item객체에 대한 조회/검색/추가/삭제 기능을 제공하는 객체 생성
		ItemService service = new ItemService();
		
		
		while(true) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("1.전체   2.카테고리   3.이름   4.가격   5.번호   6.등록   7.삭제   0.종료");
			System.out.println("---------------------------------------------------------------------------");
			
			System.out.print("메뉴번호를 선택하세요: ");
			
			int menuNo = sc.nextInt();
			
			if(menuNo == DISPLAY_ALL_STUDENT) {
				service.printAllItems();
				
			} else if(menuNo == SEARCH_BY_CATEGORY) {
				
				System.out.print("검색할 카테고리를 입력하세요: ");
				String input = sc.next();
				service.printItemsByCategory(input);
				
			} else if(menuNo == SEARCH_BY_NAME) {
				
				System.out.print("검색할 상품명을 입력하세요: ");
				String input = sc.next();
				service.printItemByName(input);
				
			} else if(menuNo == SEARCH_BY_PRICE) {
				
				System.out.print("검색할 최소가격을 입력하세요: ");
				int min = sc.nextInt();
				System.out.print("검색할 최대가격을 입력하세요: ");
				int max = sc.nextInt();
				service.printItemByPrice(min, max);
				
			} else if(menuNo == SEARCH_BY_NUMBER) {
				
				System.out.print("검색할 제품번호를 입력하세요: ");
				int input = sc.nextInt();
				service.printItemByDetail(input);
				
			} else if(menuNo == INSERT_PRODUCT) {
				
				Item inputItem = new Item();
				
				System.out.print("추가할 제품 번호를 입력하세요: ");
				inputItem.no = sc.nextInt();
				System.out.print("추가할 제품 카테고리를 입력하세요: ");
				inputItem.category = sc.next();
				System.out.print("추가할 제품 이름을 입력하세요: ");
				inputItem.name = sc.next();
				System.out.print("추가할 제품 제조사를 입력하세요: ");
				inputItem.maker = sc.next();
				System.out.print("추가할 제품 가격을 입력하세요: ");
				inputItem.price = sc.nextInt();
				
				service.insertItem(inputItem);
				
				System.out.println("[제품이 등록되었습니다.]");
				
			} else if(menuNo == DELETE_PRODUCT) {
				
				System.out.print("삭제할 제품번호를 입력하세요: ");
				int input = sc.nextInt();
				service.deleteItem(input);
				System.out.println("[제품이 삭제되었습니다.]");
				
			} else if(menuNo == EXIT) {
				System.out.println("[종료되었습니다]");
				break;
			} 
		}
	}
}
