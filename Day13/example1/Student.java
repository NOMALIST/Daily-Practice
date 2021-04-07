package example1;

public class Student extends Person{

	private int grade;
	private String dept;
	
	public int getGrade() {
		return grade;
	}
	public String getDept() {
		return dept;
	}
	
	Student() {}
	
	Student(String name, int grade, String dept) {
		super(name);
		this.grade = grade;
		this.dept = dept;
	}
	
	Student(String name, String email, String tel, int grade, String dept) {
		super(name, email, tel);
		this.grade = grade;
		this.dept = dept;
	}
	
	public Student(int grade, String dept) {
		super();
		this.grade = grade;
		this.dept = dept;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("학  년: " + grade);
		System.out.println("학  과: " + dept);
	}
}
