package Example3;

public class User {
	//*User class 생성*/
	//번호, 이름, 아이디, 비밀번호, 이메일, 전화번호, 나이, 주소, 결혼여부 멤버변수 선언
	//생성자 메소드에 위의 멤버변수 값을 초기화하기
	//생성자 메소드 중복정의
	//정보값출력 메소드

	int no;
	String name;
	String id;
	String password;
	String email;
	String tel;
	int age;
	String address;
	boolean isMarried;
	
	User() {
		no = -1;
		name = "###";
		id = "####";
		password = "qwe123!";
		tel = "01012341234";
		age = -1;
		address = "대한민국";
		isMarried = false;
	}
	
	User(int inputNo, String inputName, String inputId, String inputPassword, String inputTel, int inputAge, String inputAddress, boolean inputIsMarried) {
		no = inputNo;
		name = inputName;
		id = inputId;
		password = inputPassword;
		tel = inputTel;
		age = inputAge;
		address = inputAddress;
		isMarried = inputIsMarried;
	}
	
	User(String inputName, String inputId, String inputPassword) {
		no = -1;
		name = "###";
		id = "####";
		password = "qwe123!";
		tel = "01012341234";
		age = -1;
		address = "대한민국";
		isMarried = false;
	}
	
	void printUserInfo() {
		System.out.println("고객번호: " + no);
		System.out.println("고객이름: " + name);
		System.out.println("고객계정: " + id);
		System.out.println("비밀번호: " + password);
		System.out.println("전화번호: " + tel);
		System.out.println("고객나이: " + age);
		System.out.println("고객주소: " + address);
		System.out.println("결혼여부: " + isMarried);
		System.out.println();
	}
	
	//UserApp class 생성*/
	//User1 객체 생성
	//정보값출력메소드 실행

	//User2객체 생성
	//기본생성자에 값 추가 후 정보값출력

	//User3객체 생성
	//생성자 중복정의 메소드로 매개변수 입력 후 출력
}
