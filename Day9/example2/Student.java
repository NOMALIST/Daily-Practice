package example2;

public class Student {

	/*Student class 생성*/
	//기본 생성자
	//학생이름, 국어점수, 영어점수, 수학점수를 전달받아서 멤버변수를 초기화하는 생성자 정의하기
	
	String name;
	int kor;
	int eng;
	int math;
	int total;
	double average;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = total/3.0;
	}
	
}
