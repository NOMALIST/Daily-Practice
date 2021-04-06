package example2;

public class Marine extends Unit{

	String name = "Marine";
	
	@Override
	public void attack() {
		System.out.println("원거리로 공격해 상대방의 체력을 1 감소 시킨다.");
	}

}
