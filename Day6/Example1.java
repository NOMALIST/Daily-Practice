import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 Scanner sc = new Scanner(System.in);
		 String value1 = "홍길동";
		 System.out.print("이름을 입력하세요 : ");
		 String value2 = sc.next();
		*/
		// value1변수의 주소값과 value2변수의 주소값을 비교
		// value1변수의 문자열과 value2변수의 문자열을 비교
		
		
		 String value1 = "홍길동";
		 System.out.print("이름을 입력하세요 : ");
		 String value2 = sc.next();
		 
		 System.out.println();
		 System.out.println("=== value1 변수와 value2 변수의 주소값 비교 ===");
		 
		 boolean compare = (value1 == value2);
		 
		 System.out.println("(value1 == value2)의 결과: " + compare);
		 
		 compare = value1.equals(value2);

		 System.out.println("value1.equals(value2) 의 결과: " + compare);
	}
}
