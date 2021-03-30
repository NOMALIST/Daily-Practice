package Example3;

public class Banking {

	Account[] accs = new Account[5];
	int position = 0;

	//신규계좌 개설(등록) 기능

	void addAcc(int accNo, String accName, int accPassword, int accBal) {

		Account temp = new Account();

		temp.no = accNo;
		temp.name = accName;
		temp.password = accPassword;
		temp.balance = accBal;
		accs[position++] = temp;

	}

	//계좌정보 조회 기능

	Account getAcc(int accNo, int accPassword) {

		Account result = null;

		for(Account x : accs) {
			if(accNo == x.no && accPassword == x.password)
			{
				result = x;
				break;
			}
		}
		return result;	
	}

	// 계좌 예금
	void deposit(int accNo, int amount) {
		for(Account x : accs) {
			if(accNo == x.no)
			{
				x.balance += amount;
				break;
			}
		}
		System.out.println(accNo + " 계좌에 " + amount + "원 입금하였습니다.\n");
	}

	// 계좌 이체

	/**
	 * 
	 * @param accNo1 보내는 사람 계좌번호
	 * @param accNo2 받는 사람 계좌번호
	 * @param amount 송금액
	 */
	void transferByAccNo(int accNo1, int accNo2, int amount) {

		Account sender = null;
		Account receiver = null;

		for(Account x : accs) {
			if(accNo1 == x.no) sender = x;
			if(accNo2 == x.no) receiver = x;
		}
		if(sender != null && receiver != null) {
			sender.balance -= amount;
			receiver.balance += amount;
			System.out.println(accNo1 + " 계좌에서 " + accNo2 + " 계좌로 " + amount + "원 송금하였습니다.\n");
		}
	}

	// 비밀번호 변경
	
	void changePasswordByName(String accName, int oldPassword, int newPassword) {
		
		for(Account x : accs) {
			if(accName.equals(x.name) && oldPassword == x.password) {
				x.password = newPassword;
				System.out.println("비밀번호가 변경되었습니다.\n");
				break;
			}
		}
	}
	
	// 전계좌 출력
	void printAll() {
		for(Account x : accs) {
			System.out.println("==========================");
			System.out.println("계좌번호 : " + x.no);
			System.out.println("예 금 주 : " + x.name);
			System.out.println("잔    액 : " + x.balance);
			System.out.println("비밀번호 : " + x.password);
			System.out.println();
		}
	}
}

