package example4;

public abstract class AbstractBanking {

	public void before() {
		System.out.println("은행 전산망과 연결...");
		System.out.println("계좌 및 비밀번호 인증...");
	}
	
	public void after() {
		System.out.println("은행 전산망과 연결 해제...");
	}
	
	public abstract void job();
	
	public void process() {
		before();
		job();
		after();
	}
}
