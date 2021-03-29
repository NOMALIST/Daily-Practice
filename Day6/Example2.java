import java.util.Scanner;

public class Example2 {
	
	public static void main(String[] args) {
		
		/*
		 String[] name = {"김유신", "강감찬", "이순신", "홍길동", "류관순"};
		 Scanner sc = new Scanner(System.in);
		 System.out.print("조회할 이름을 입력하세요 : ");
		 String value = sc.next();
		*/
		//입력한 이름이 배열에 존재하는지 확인해보기
		
		
		String[] names = {"김유신", "강감찬", "이순신", "홍길동", "류관순"};
		 Scanner sc = new Scanner(System.in);
		 System.out.print("조회할 이름을 입력하세요 : ");
		 String value = sc.next();
		 
		 boolean jed = false;
		 
		 for(String x : names) {
			 if(x.equals(value) == true) jed = true;
		 }

		 System.out.println("입력한 이름의 존재여부: " + jed);
	}
}
