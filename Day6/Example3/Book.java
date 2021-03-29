package Example3;

public class Book {

	/* class : Book 생성 */
	//필드 정의하기(제목, 저자, 출판사, 가격)
	//메소드 정의하기
	
	String name;
	String writer;
	String publisher;
	int price;
	
	void viewBook () {
		System.out.println("도서명 : " + name);
		System.out.println("저  자 : " + writer);
		System.out.println("출판사 : " + publisher);
		System.out.println("가  격 : " + price);
		System.out.println();
	}
}
