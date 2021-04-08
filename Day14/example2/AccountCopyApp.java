package example2;

public class AccountCopyApp {

	public static void main(String[] args) {
		
		Account[] accounts = new Account[5];
		
		accounts[0] = new Account("피카츄", 10000000, "1234");
		accounts[1] = new Account("파이리", 1000, "1234");
		accounts[2] = new SecretAccount("꼬부기", 500000000, "1234", "1111");
		accounts[3] = new Account("이상해씨", 700000, "1234");
		accounts[4] = new Account("구구", 10000000, "1234");
		
		for(Account x : accounts) {
			if(x instanceof SecretAccount) System.out.println("[" + x.getName() + "]님의 계좌는 비밀계좌이므로 복사할 수 없습니다.");
			else System.out.println("[" + x.getName() + "] 님의 계좌가 복사되었습니다.");
		}
	}
}
