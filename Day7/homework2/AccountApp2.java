package homework2;

public class AccountApp2 {

	public static void main(String[] args) {
		
		Account2[] arr = new Account2[6];
		Account2 arr1 = new Account2();
		Account2 arr2 = new Account2();
		Account2 arr3 = new Account2();
		Account2 arr4 = new Account2();
		Account2 arr5 = new Account2();

		arr1.name = "이건희";
		arr1.password = 1111;
		arr1.balance = 200000000000L;
		
		// 이거 왜 안됨;;;
		// arr[0].name = "이건희";
		// arr[0].password = 1111;
		// arr[0].balance = 200000000000L;
		
		arr2.name = "서정진";
		arr2.password = 2222;
		arr2.balance = 90000000;
		
		arr3.name = "김정주";
		arr3.password = 3333;
		arr3.balance = 70000000;
		
		arr4.name = "이재용";
		arr4.password = 4444;
		arr4.balance = 6000;
		
		arr5.name = "정몽구";
		arr5.password = 5555;
		arr5.balance = 40000000000L;
		
		arr[0] = arr1;
		arr[1] = arr2;
		arr[2] = arr3;
		arr[3] = arr4;
		arr[4] = arr5;

		// 이거는 또 왜 안되지?
		/*
		System.out.println("========== 계좌 정보 출력 =============");
		for (Account2 x : arr) {
			x.printAccount(x.name, x.password);
		}		
		*/
		
		arr[0].printAccount("이건희", 1111);
		arr[1].printAccount("서정진", 2222);
		arr[2].printAccount("김정주", 3333);
		arr[3].printAccount("이재용", 1234);	// <- 일부러 틀린값
		arr[4].printAccount("정몽구", 5555);
		
		arr[2].deposit(500000);

		arr[4].withdraw("정몽구", 5555, 40000000000L);

		
	}
}
