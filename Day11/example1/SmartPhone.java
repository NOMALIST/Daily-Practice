package example1;

public class SmartPhone extends Phone{

	private String ip;
	private String emailAddress;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void web() {
		System.out.println("[" + ip + "] 의 ip주소로 인터넷에 연결합니다");
	}
	
	public void mail() {
		System.out.println("[" + emailAddress + "]의 메일주소로 메일을 송신합니다");
	}
}
