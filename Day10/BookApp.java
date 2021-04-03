package example1;

public class BookApp {



	
	public static void main(String[] args) {
		
		Book book1 = new Book();
		
		// 여태까지 초기화 하던 방법
		// 클래스의 변수를 private으로 선언해서 조회를 못한다.
		
		/*
		book1.no = 100;
		book1.title = "이것이 자바다";
		book1.writer ="신용권";
		book1.publisher = "한빛미디어";
		book1.price = 35000;
		book1.isSoldOut = false;
		book1.discountRate = 0.15;
		*/
		
		// Setter 메소드를 사용해서 멤버변수 초기화하기
		book1.setNo(100);
		book1.setTitle("몰입");
		book1.setWriter("황농문");
		book1.setPublisher("RHK");
		book1.setPrice(12000);
		book1.setSoldOut(false);
		book1.setDiscountRate(0.1);
		
		// 기존의 조회 방법
		// class에 프린트 메소드를 만들어서 조회함
		System.out.println("======== 프린트 메소드로 조회 ============");
		book1.printAll();
		
		// Getter을 이용하여 조회
		System.out.println("======== Getter 메소드로 조회 ============");
		System.out.println("번호: " + book1.getNo());
		System.out.println("제목: " + book1.getTitle());
		System.out.println("저자: " + book1.getWriter());
		System.out.println("출판사: " + book1.getPublisher());
		System.out.println("가격: " + book1.getPrice());
		System.out.println("품절: " + book1.isSoldOut());
		System.out.println("할인율: " + book1.getDiscountRate());
		
		
		
		
		
	}
}
