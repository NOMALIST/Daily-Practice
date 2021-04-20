package sample6;

import java.util.ArrayList;
import java.util.TreeSet;

public class SchoolRepo {

	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<Registration> registrations =  new ArrayList<Registration>();
	
	public SchoolRepo() {
		// 학생등록
		students.add(new Student(10, "홍길동", "컴퓨터공학과", 2));
		students.add(new Student(11, "김유신", "컴퓨터공학과", 1));
		students.add(new Student(12, "강감찬", "컴퓨터공학과", 2));
		students.add(new Student(13, "이순신", "정보통신학과", 1));
		students.add(new Student(14, "류관순", "정보통신학과", 2));
		
		// 과정등록
		courses.add(new Course(100, "컴퓨터개론", 5));
		courses.add(new Course(101, "소프트웨어공학", 5));
		courses.add(new Course(102, "데이터베이스", 5));
		courses.add(new Course(103, "운영체제", 5));
		courses.add(new Course(104, "컴퓨터구조", 5));
		courses.add(new Course(105, "이산수학", 5));
		courses.add(new Course(106, "프로그래밍기초", 5));
	}

	
	// 학생등록기능
	// 학생정보를 전달받아서 students가 참조하는 ArrayList 객체에 저장하는 기능
	public void addStudent(Student student) {
		Student foundedStudent = null;
		for(Student s : students) {
			if(s.getName().equals(student.getName())) {
				foundedStudent = s;
				break;
			}
		}
		
		if(foundedStudent == null) {
			students.add(student);
			System.out.println("[학생정보가 등록되었습니다.]");
			return;
		} else {
			System.out.println("[이미 동일한 이름의 학생이 있습니다.]");
		}
		
	}
	
	// 과정등록기능
	// 과정정보를 전달받아서 students가 참조하는 ArrayList 객체에 저장하는 기능
	public void addCourse(Course course) {
		Course foundedCourse = null;
		for(Course s : courses) {
			if(s.getName().equals(course.getName())) {
				foundedCourse = s;
				break;
			}
		}
		
		if(foundedCourse == null) {
			courses.add(course);
			System.out.println("[과정정보가 등록되었습니다.]");
			return;
		} else {
			System.out.println("[이미 동일한 이름의 과정이 있습니다.]");
		}
	}
	
	// 과정조회기능
	// courses가 참조하는 ArrayList 객체에 저장된 모든 과정정보를 출력하는 기능
	public void displayAllCourses() {
		for(Course c : courses) {
			System.out.println("과정번호: " + c.getNo() +"\t 과정명: " + c.getName() + "\t\t 정원: " + c.getQuota());
		}
	}
	
	// 과정신청기능
	// 학생번호, 과정번호를 전달받아서 registrations가 참조하는 ArrayList 객체에 저장하는 기능
	// * 이미 신청한 과목은 신청할 수 없음
	// * 정원이 부족하면 신청할 수 없음
	public void addRegistration(int studentNo, int courseNo) {
		// 1. 학생번호에 해당하는 학생이 그 과정을 신청했는지 확인하기
		// 2. 그 과정에 정원이 충분한지 확인하기
		// 3. registrations가 참조하는 ArrayList에 등록정보 추가하기
		// 4. 해당 과정의 신청자수를 1증가시키기
		
		
		for(Registration r : registrations) {
			if(courseNo == r.getCourseNo()) {
				if(studentNo == r.getStudNo()) {
					System.out.println("[이미 신청한 과정입니다.]");
					return;
				}
			}
		}
		
		Course foundedCourse = null;
		
		for(Course c : courses) {
			if(c.getNo() == courseNo) {
				if(c.getQuota() <= c.getRegisteredCount()) {
					System.out.println("[정원 초과 입니다.]");
					return;
				}
				foundedCourse = c;
				break;
			}
		}
		
		foundedCourse.setRegisteredCount(foundedCourse.getRegisteredCount()+1);
		registrations.add(new Registration(studentNo,courseNo));
		System.out.println("[과정등록을 완료하였습니다.]");
		
		
		
		
		
	}
	
	
	// 신청취소기능
	// 학생번호, 과정번호를 전달받아서 registrations가 참조하는 ArrayList 객체에서 해당 과정을 삭제하는 기능
	public void cancelRegistration(int studentNo, int courseNo) {

		int check = -1; 
		for(Registration r : registrations) {
			if(courseNo == r.getCourseNo()) {
				if(studentNo == r.getStudNo()) {
					registrations.remove(r);
					check = 1;
					System.out.println("[신청취소 하였습니다.]");
					break;
				}
			}
		}
		
		if(check == -1) {
			System.out.println("[일치하는 신청정보가 없습니다.]");
			return;
		}
		
		for(Course c : courses) {
			if(c.getNo() == courseNo) {
				c.setRegisteredCount(c.getRegisteredCount()-1);
				break;
			}
		}
	}
	
	
	// 나의 수강신청과정 조회하기
	// 학번을 전달받아서 그 학생이 수강신청한 과정을 출력하는 기능
	public void displayMyRegistrations(int studentNo) {
		
		TreeSet<Integer> registedCourse = new TreeSet<Integer>();
		
		for(Registration r : registrations) {
			if(r.getStudNo() == studentNo) {
				registedCourse.add(r.getCourseNo());
			}
		}
		
		if(registedCourse.isEmpty()) {
			System.out.println("[신청정보가 없습니다.]");
			return;
		}
		
		for(int a : registedCourse) {
			for(Course c : courses) {
				if(a == c.getNo()) {
					System.out.println("과정번호: " + c.getNo() +"\t 과정명: " + c.getName() + "\t\t 정원: " + c.getQuota());
					break;
				}
			}
		}
		
		
	}
	
}
