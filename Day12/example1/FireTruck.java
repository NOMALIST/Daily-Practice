package example1;

public class FireTruck extends Car{

	private int water;
	
	
	public FireTruck(int water) {
		this.water = water;
	}
	
	public FireTruck() {
		
	}
	
	
	public int getWater() {
		return water;
	}
	
	public void setWater(int water) {
		this.water = water;
	}
	
	public void suppressFire() {
		System.out.println("[Shooted " + water + "L water]");
	}
}
