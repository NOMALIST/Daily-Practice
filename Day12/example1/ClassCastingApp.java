package example1;

public class ClassCastingApp {

	public static void main(String[] args) {
		Tank car1 = new Tank("105mm 강선포");
		PoliceCar car2 = new Tank("105mm 강선포");
		Car car3 = new Tank("105mm 강선포");

		
		System.out.println("### Tank 타입의 참조변수로 Tank 객체 참조하기 ###");
		car1.drive();
		car1.stop();
		car1.patrol();
		car1.fireWeapon();
		System.out.println();
		
		System.out.println("### PoliceCar 타입의 참조변수로 Tank 객체 참조하기 ###");
		car2.drive();
		car2.stop();
		car2.patrol();
		// car2.fireWeapon(); <- 오류
		((Tank) car2).fireWeapon();
		System.out.println();
		
		System.out.println("### Car 타입의 참조변수로 Tank 객체 참조하기 ###");
		car3.drive();
		car3.stop();
		// car3.patrol(); <- 오류
		// car3.fireWeapon(); <- 오류
		((PoliceCar) car3).patrol();
		((Tank) car3).fireWeapon();
		System.out.println();
		
	}
}
