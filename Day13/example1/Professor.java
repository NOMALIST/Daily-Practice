package example1;

public class Professor extends Person{

	private String position;
	private String dept;
	
	public String getPosition() {
		return position;
	}
	public String getDept() {
		return dept;
	}
	
	Professor() {}
	
	Professor(String name, String position, String dept) {
		super(name);
		this.position = position;
		this.dept = dept;
	}
	
	Professor(String name, String email, String tel, String position, String dept) {
		super(name, email, tel);
		this.position = position;
		this.dept = dept;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("직  위: " + position);
		System.out.println("학  과: " + dept);
	}
}
