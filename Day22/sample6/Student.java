package sample6;

public class Student {

	int no;
	String name;
	String dept;
	int grade;
	
	public Student() {}

	public Student(int no, String name, String dept, int grade) {
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
