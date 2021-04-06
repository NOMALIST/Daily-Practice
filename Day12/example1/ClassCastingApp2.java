package example1;

public class ClassCastingApp2 {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new PoliceCar();
		Car car3 = new Tank("105mm 강선포");
		
		System.out.println("### Car 타입의 참조변수로 Car 객체 참조하기 ###");
		car1.drive();
		car1.stop();
		// car1.patrol(); <- 오류 객체가 없기 때문
		// car1.fireWeapon(); <- 오류
		System.out.println();
		
		System.out.println("### Car 타입의 참조변수로 PoliceCar 객체 참조하기 ###");
		car2.drive();
		car2.stop();
		// car2.patrol(); <- 오류
		// car2.fireWeapon(); <- 오류
		((PoliceCar) car2).patrol();
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
