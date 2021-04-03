package example1;

public class BookApp2 {

	public static void main(String[] args) {
		
		Book book1 = new Book();
		Event event1 = new Event("동영상강의 특가", "무료 동영상강의 제공","2021-04-01","2021-04-07",false);
		Event event2 = new Event("할인 이벤트","무조건 반값 할인","2021-04-01","2021-04-04",true);
		Gift gift = new Gift("카카오 책갈피", 5000);
		
		// Book객체와 Event 객체. Gift 객체 연결짓기
		// book1이 참조하는 Book 객체의 event 멤버변수에 event1이 참조하는 Event객체의 주소값을 전달한다.
		book1.setEvent(event1);
		
		// book1이 참조하는 Book 객체의 gift 멤버변수에 gift1이 참조하는 Gift객체의 주소값을 전달한다.
		book1.setGift(gift);
		
		// event1, e, book1.getEvent() 주소값이 다 같은지 확인하기
		Event e = book1.getEvent();
		System.out.println("event1의 주소값: " + "\t\t" + event1);
		System.out.println("e의 주소값: " + "\t\t\t" + e);
		System.out.println("book1.getEvent의 주소값: " + "\t" + book1.getEvent());
		
		Book book2 = new Book();
		book2.setNo(200);
		book2.setTitle("항공역학");
		book2.setWriter("이봉준, 김학봉, 김문상 공저");
		book2.setPublisher("세화");
		book2.setPrice(55000);
		book2.setSoldOut(false);
		book2.setDiscountRate(0.05);
		
		
		System.out.println("========== book2 객체의 멤버변수 Getter 메소드로 출력하기 ============");
		System.out.println("번호: " + book2.getNo());
		System.out.println("제목: " + book2.getTitle());
		System.out.println("저자: " + book2.getWriter());
		System.out.println("출판사: " + book2.getPublisher());
		System.out.println("가격: " + book2.getPrice());
		System.out.println("품절: " + book2.isSoldOut());
		System.out.println("할인율: " + book2.getDiscountRate());
		
		System.out.println("====== book2가 참조하는 event2 의 정보 출력하기 =======");
		book2.setEvent(event2);
		System.out.println("이벤트: " + book2.getEvent().getTitle());
		System.out.println("설명: " + book2.getEvent().getDescription());
		System.out.println("시작: " + book2.getEvent().getStartDate());
		System.out.println("종료: " + book2.getEvent().getEndDate());
		System.out.println("마감여부: " + (book2.getEvent().isClosed() ? "마감" : "진행중"));
		
		book2.setGift(gift);
		
		System.out.println("======= 사은품 ========");
		System.out.println("사은품: " + book2.getGift().getName());
		System.out.println("가격: " + book2.getGift().getPrice());
		
	}
}
