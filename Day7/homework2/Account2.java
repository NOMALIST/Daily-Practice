package homework2;

public class Account2 {

	// 예금주, 비밀번호, 잔액정보
	String name;
	int password;
	long balance;
	
	// 출력기능
	// 매개변수 : 예금주, 비밀번호
	// 반환값 : 없음
	
	/**
	 * 계좌정보를 출력하는 메서드
	 * @param accName 예금주 입력
	 * @param accPassword 비밀번호 입력
	 */
	void printAccount(String accName, int accPassword) {
		if(accName.equals(name) && (password == accPassword)) {
			System.out.println("============== 계좌 정보 출력 ===============");
			System.out.println("예금주 : " + name);
			System.out.println("잔  액 : " + balance);
			System.out.println();
		} else {
			System.out.println("이름 / 비밀번호와 일치하는 계좌를 찾을 수 없습니다.");
			System.out.println();
		}
	}
	
	// 입금기능
	// 매개변수 : 입금액
	// 리턴값 : 없음
	void deposit(long amount) {
		balance += amount;
		System.out.println(amount + "원 입금 완료 되었습니다.");
		System.out.println("잔  액 : " + balance);
		System.out.println();
	}
	
	// 출금기능
	// 매개변수 : 예금주, 비밀번호, 출금액
	// 리턴값 : 없음
	void withdraw(String accName, int accPassword, long amount) {
		if(accName.equals(name) && password == accPassword) {
			balance -= amount;
			System.out.println(amount + "원 입금 출금 되었습니다.");
			System.out.println("예금주 : " + name);
			System.out.println("잔  액 : " + balance);
			System.out.println();
		} else {
			System.out.println("이름 / 비밀번호와 일치하는 계좌를 찾을 수 없습니다.");
			System.out.println();
		}
	}
}
