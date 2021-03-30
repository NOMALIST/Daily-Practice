package Example3;

public class BankingApp {

	public static void main(String[] args) {
		Banking banking = new Banking();
		
		// 신규계좌 등록해보기
		// 매개변수 : 번호, 예금주, 최초잔액, 비밀번호 입력받음
		
		banking.addAcc(100, "홍길동", 1111, 5000);
		banking.addAcc(200, "김유신", 1122, 25000 );
		banking.addAcc(300, "강감찬", 1133, 125000);
		banking.addAcc(400, "이순신", 1144, 5000000);
		banking.addAcc(500, "류관순", 1155, 10004000);
		
		System.out.println("------------------------------------------------------");
		System.out.println("### 계좌정보 조회하기 ###");
		
		Account result1 = banking.getAcc(300, 1233);
		if(result1 != null) {
			System.out.println("계좌번호 : " + result1.no);
			System.out.println("예 금 주 : " + result1.name);
			System.out.println("잔    액 : " + result1.balance);
			System.out.println("비밀번호 : " + result1.password);
			System.out.println();
		} else
			System.out.println("일치하는 계좌가 없습니다 \n");
		
		// 예금하기
		banking.deposit(400, 500000);
		
		// 송금하기
		banking.transferByAccNo(500, 200, 10000000);
		
		// 비밀번호 변경하기
		banking.changePasswordByName("류관순", 1155, 1234);
		
		// 전계좌 조회
		banking.printAll();
	}
}
