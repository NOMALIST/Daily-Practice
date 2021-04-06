package example1;

public class Car {

	private String color;
	
	public Car(String color) {
		this.color = color;
	}
	
	public Car() {}
		
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void drive() {
		System.out.println("[Driving Start...]");
	}
	
	public void stop() {
		System.out.println("[Driving Stop...]");
	}
}
