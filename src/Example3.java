import java.util.Scanner;


public class Example3 {

	//3. break / continue 문
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			for(int i=1; i<=10; i++) {
				System.out.print("*");
			}
			System.out.println("*을 10개 출력하였습니다.");
			System.out.println("한번 더 출력하시겠습니까?(1. 계속출력  /  2. 종료)");
			
			int answer = sc.nextInt();
			
			if(answer == 1) {
				continue;
			} else if(answer == 2) {
				System.out.println("[종료되었습니다.]");
				break;
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
}
