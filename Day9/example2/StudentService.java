package example2;

public class StudentService {

	
	/*StudentService class 생성*/



	
	
	//Student 배열 생성 / positon = 0 초기화
	Student[] students = new Student[100];
	int position = 0;
	
	//기본 생성자 초기화
	StudentService() {
		students[position++] = new Student("손흥민", 100, 100, 100);
		students[position++] = new Student("박지성", 95, 95, 100);
		students[position++] = new Student("차두리", 80, 82, 95);
		students[position++] = new Student("기성용", 90, 78, 75);
		students[position++] = new Student("황의조", 95, 75, 75);
		students[position++] = new Student("이청용", 88, 72, 76);
		students[position++] = new Student("최홍만", 98, 60, 99);
		students[position++] = new Student("황희찬", 80, 88, 83);
		students[position++] = new Student("조현우", 71, 100, 50);
		students[position++] = new Student("이강인", 67, 68, 70);

	}
	
	//전체 학생의 성적정보를 출력한다.
	void printAll() {
		System.out.println("   이름    국어    영어    수학    총점    평균");
		for(Student x : students) {
			if(x == null) break;
			System.out.printf("%6s%6d%8d%8d%8d%8.1f\n", x.name, x.kor, x.eng, x.math, x.total, x.average);
		}
	}
	
	
	//지정된 학생의 성적정보를 조회한다.
	void printOne(String name) {
		System.out.println("   이름    국어    영어    수학    총점    평균");
		
		Student check = null;
		for(Student x : students) {
			if(x == null) break;
			if(name.equals(x.name)) {
				check = x;
				break;
			}
		}
		
		if(check == null) System.out.println("[일치하는 정보를 찾을 수 없습니다]");
		else System.out.printf("%6s%6d%8d%8d%8d%8.1f\n", check.name, check.kor, check.eng, check.math, check.total, check.average);
	}
	
	//학생정보를 등록한다.
	void insertStudent(String name, int kor, int eng, int math) {
		students[position++] = new Student(name, kor, eng, math);
		System.out.println("[" + name + "의 성적정보가 추가되었습니다]");
	}
	
	//학생정보를 수정한다.
	void updateStudent(String name, String subject, int score) {
		
		Student checkStudent = null;
		int checkSubject = -1;
		for(Student x : students) {
			if(x == null) break;
			if(name.equals(x.name)) {
				if("국어".equals(subject)) {
					checkStudent = x;
					checkSubject = 1;
				} else if("영어".equals(subject)) {
					checkStudent = x;
					checkSubject = 2;
				} else if("수학".equals(subject)) {
					checkStudent = x;
					checkSubject = 3;
				}
			}
		}
		
		if(checkStudent != null && checkSubject == 1) {
			checkStudent.kor = score;
			checkStudent.total = checkStudent.kor + checkStudent.eng + checkStudent.math;
			checkStudent.average = checkStudent.total/3.0;
			System.out.println("[" + checkStudent.name + "의" + " 국어 성적이 수정되었습니다]");
		} else if(checkStudent != null && checkSubject == 2) {
			checkStudent.eng = score;
			checkStudent.total = checkStudent.kor + checkStudent.eng + checkStudent.math;
			checkStudent.average = checkStudent.total/3.0;
			System.out.println("[" + checkStudent.name + "의" + " 영어 성적이 수정되었습니다]");
		} else if(checkStudent != null && checkSubject == 3) {
			checkStudent.math = score;
			checkStudent.total = checkStudent.kor + checkStudent.eng + checkStudent.math;
			checkStudent.average = checkStudent.total/3.0;
			System.out.println("[" + checkStudent.name + "의" + " 수학 성적이 수정되었습니다]");
		} else System.out.println("[일치하는 정보를 찾을 수 없습니다]");
		 
	}
	
	
}
