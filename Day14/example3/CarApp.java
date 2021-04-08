package example3;

public class CarApp {

	public static void main(String[] args) {
		Spark car1 = new Spark();
		
		car1.drive();
		car1.stop();
		car1.speedUp();
		car1.speedUp();
		car1.speedUp();
		car1.speedUp();
		System.out.println("현재속도: " + car1.getCurrentSpeed());
		car1.speedDown();
		System.out.println("현재속도: " + car1.getCurrentSpeed());
		
	}
	
}
