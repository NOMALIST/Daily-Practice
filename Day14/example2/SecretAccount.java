package example2;

public class SecretAccount extends Account implements UnCopiable{

	private String secretKey;
	
	public SecretAccount() {}
	
	public SecretAccount(String name, int balance, String password, String secretKey) {
		super(name, balance, password);
		this.secretKey = secretKey;
	}
	
	public String getSecretKey() {
		return secretKey;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
}
