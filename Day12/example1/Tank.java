package example1;

public class Tank extends PoliceCar{

	private String weapon;
	
		
	public Tank(String weapon) {
		this.weapon = weapon;
	}
	
	public Tank() {
		
	}

	public String getWeapon() {
		return weapon;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public void fireWeapon() {
		System.out.println("[Fired " + weapon +"]");
	}
}
