import java.util.Scanner;

public class Example4 {

	// 4. while문 (WhileDemo1.java)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// while문을 이용해서 무한반복 구현하기
		/* 
		   충전금액 설정
		   사용금액이 남아있는 충전금액보다 크면, 잔액부족을 표시한다.
		   사용금액이 남아있는 충전금액보다 작거나 같으면 충전금액에서 사용금액만큼 차감하고,
		   사용금액과 현재 남아있는 충전금액을 출력한다.
		*/
		
		int balance = 50000;
		while(true) {
			System.out.println("====================");
			System.out.println("지불금액을 입력하세요.");
			System.out.println("잔액 : " + balance + " 원");
			System.out.println("====================");
			
			int payment = sc.nextInt();
			
			if(balance >= payment) {
				balance -= payment;
				System.out.println("정상 지불되었습니다");
				System.out.println("잔액은" + balance + " 원 입니다.");
			} else {
				System.out.println("잔액이 부족합니다. 충전후 사용하세요.");
				System.out.println("[프로그램을 종료합니다.]");
				break;
			}
		}
	}
}
