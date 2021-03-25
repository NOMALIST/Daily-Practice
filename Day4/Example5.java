import java.util.Scanner;

public class Example5 {

	// 5. if - else 문/ 내포된 if문 / if ~ else if / while 문 (WhileDemo2.java)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		/*
		   while문을 통한 무한루프
		   결제, 충전, 종료 서비스 구현하기
		   코드 작성 후 주석으로 리뷰 해보기 추천! (어떤 식으로 작동되는지..)
		*/
		
		int balance = 50000;
		while(true) {
			System.out.println("===================================");
			System.out.println("1.결제하기  2.충전하기  3.종료하기");
			System.out.println("잔액 : " + balance + " 원");
			System.out.println("===================================");
			
			int answer = sc.nextInt();
			
			if(answer == 1) {
				System.out.println("============================");
				System.out.println("결제금액을 입력해 주세요.");
				int payment = sc.nextInt();
				
				if(payment > balance) {
					System.out.println("잔액이 부족합니다. 충전 후 사용하세요");
					continue;
				}
				
				balance -= payment;
				
				System.out.println("[결재 완료]");
				
			} else if(answer == 2) {
				System.out.println("============================");
				System.out.println("충전금액을 입력해 주세요.");
				int payment = sc.nextInt();
				
				balance += payment;
				
				System.out.println("[충전 완료]");
			} else if(answer == 3) {
				System.out.println("============================");
				System.out.println("[프로그램 종료]");
				break;
			} else {
				System.out.println("============================");
				System.out.println("잘못 입력 하셨습니다.");
			}
			
		}
	}
}
