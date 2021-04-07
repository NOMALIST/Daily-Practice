package example4;

import java.util.Scanner;

public class ATMApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ATM atm = new ATM();
		
		while(true) {
			
			System.out.println("----------------------------------------------");
			System.out.println("      [1]입금     [2]송금     [0]종료");
			System.out.println("----------------------------------------------");
			int a = sc.nextInt();
			
			if(a == 1) {
				Deposit deposit = new Deposit();
				atm.setBanking(deposit);
				atm.runBanking();
			} else if(a == 2) {
				Transfer transfer = new Transfer();
				atm.setBanking(transfer);
				atm.runBanking();
			} else if(a == 0) {
				System.out.println("종료합니다...");
				break;
			} else {
				System.out.println("잘못된 입력입니다...");
			}
			
		}
	}
}
