package example1;

public class ClassCastingApp4 {

	public static void main(String[] args) {
		Car[] cars = new Car[4];
		
		Car	car1 = new Car();
		PoliceCar car2 = new PoliceCar();
		Tank car3 = new Tank("강선포");
		FireTruck car4 = new FireTruck(50000);
		
		System.out.println("### car1 Test ###");
		testDriving(car1);
		System.out.println();

		System.out.println("### car2 Test ###");
		testDriving(car2);
		testPatrol(car2);
		System.out.println();
		
		System.out.println("### car3 Test ###");
		testDriving(car3);
		testPatrol(car3);
		testFireWeapon(car3);
		System.out.println();
		
		System.out.println("### car4 Test ###");
		testDriving(car4);
		testSuppressFire(car4);
		System.out.println();
	}
	
	
	
	public static void testDriving(Car car) {
		car.drive();
		car.stop();
	}
	
	public static void testPatrol(PoliceCar car) {
		car.patrol();
	}
	
	public static void testFireWeapon(Tank car) {
		car.fireWeapon();
	}
	
	public static void testSuppressFire(FireTruck car) {
		car.suppressFire();
	}
}
