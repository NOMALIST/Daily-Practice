package example4;

public class ATM {

	private AbstractBanking banking;
	

	public void setBanking(AbstractBanking banking) {
		this.banking = banking;
	}
	
	public void runBanking() {
		banking.process();
	}
}
