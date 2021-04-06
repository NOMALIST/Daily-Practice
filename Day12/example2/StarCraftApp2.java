package example2;

public class StarCraftApp2 {

	public static void main(String[] args) {
		
		Unit[] units = new Unit[5];
		
		units[0] = new Marine();
		units[1] = new Medic();
		units[2] = new Firebat();
		units[3] = new Ghost();
		units[4] = new BattleCruiser();
		
		System.out.println("###For문을 이용한 공격하기/이동하기 테스트 ###\n");
		
		for(Unit unit : units) {
			System.out.println("Unit Name: " + unit.getName()); // 낼 질문해야할듯
			unit.attack();
			unit.move();
			System.out.println();
		}
	}
	

}
