package example2;

public class Unit {

	private String name;
	private int life;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	
	public void attack() {
		System.out.println("상대방의 생명력을 1 감소시킨다.");
	}
	
	public void defence() {
		System.out.println("상대방의 공격을 방어한다.");
	}
	
	public void move() {
		System.out.println("지상으로 이동한다.");
	}
	
}
