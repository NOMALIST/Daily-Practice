package example1;

public class Phone {

	private String tel;
	
	public void call() {
		System.out.println("[" + tel + "]으로 전화를 겁니다");
	}
	
	public void receive() {
		System.out.println("전화를 받습니다");
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
