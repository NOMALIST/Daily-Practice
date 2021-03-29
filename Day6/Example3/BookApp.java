package Example3;

public class BookApp {

	/* main method가 있는 BookApp 생성 */
	//book1, book2, book3 객체 생성하기
	//book1, book2, book3 객체의 속성에 값 저장하기
	//객체의 기능(Method) 사용하기

	
	public static void main(String[] args) {
	
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		
		book1.name = "에이트";
		book1.writer = "이지성";
		book1.publisher = "차이정원";
		book1.price = 17000;
		
		book2.name = "몰입";
		book2.writer = "황농문";
		book2.publisher = "RHK";
		book2.price = 12000;
		
		book3.name = "SMALL BIG";
		book3.writer = "Jeff Haden";
		book3.publisher = "리더스북";
		book3.price = 15000;
		
		book1.viewBook();
		book2.viewBook();
		book3.viewBook();
		
		
	}
}
