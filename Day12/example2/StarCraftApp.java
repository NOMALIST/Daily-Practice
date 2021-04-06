package example2;

public class StarCraftApp {

	public static void main(String[] args) {
		
		Marine marine = new Marine();
		Medic medic = new Medic();
		Firebat firebat = new Firebat();
		Ghost ghost = new Ghost();
		BattleCruiser battleCruiser = new BattleCruiser();
		
		
		
		
		System.out.println("Marine 객체 이동하기/공격하기");
		marine.attack();
		marine.move();
		System.out.println();
		
		System.out.println("Medic 객체 이동하기/공격하기");
		medic.attack();
		medic.move();
		System.out.println();
		
		System.out.println("Firebat 객체 이동하기/공격하기");
		firebat.attack();
		firebat.move();
		System.out.println();
		
		System.out.println("Ghost 객체 이동하기/공격하기");
		ghost.attack();
		ghost.move();
		System.out.println();
		
		System.out.println("BattleCruiser 객체 이동하기/공격하기");
		battleCruiser.attack();
		battleCruiser.move();
		System.out.println();
		
	}
}
