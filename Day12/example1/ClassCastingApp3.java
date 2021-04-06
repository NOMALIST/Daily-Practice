package example1;

public class ClassCastingApp3 {

	public static void main(String[] args) {
		
		Car[] cars = new Car[4];
		
		cars[0] = new Car();
		cars[1] = new PoliceCar();
		cars[2] = new Tank("강선포");
		cars[3] = new FireTruck(50000);
		
		
		
		for(Car car : cars) {
			
			System.out.println("### 객체의 기능 테스트 ###");
			if(car instanceof Car) {
				car.drive();
				car.stop();
			}
			
			if(car instanceof PoliceCar) {
				((PoliceCar) car).patrol();
			}
			
			if(car instanceof Tank) {
				((Tank) car).fireWeapon();
			}
			
			if(car instanceof FireTruck) {
				((FireTruck) car).suppressFire();
			}
			System.out.println();
		}
	}
}
