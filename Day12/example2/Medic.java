package example2;

public class Medic extends Unit{

	@Override
	public void attack() {
		System.out.println("아군의 체력을 1 증가시킨다");
	}
}
