package sample5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class App {

	public static void main(String[] args) {
		
		/*
		 * 학생성적 관리 프로그램
		 * 1. 학생 성적정보 입력기능
		 * 		이름, 국어, 영어, 수학점수를 입력받아서 ArrayList에 저장
		 * 2. 학생 성적정보 전체 조회기능
		 * 		ArrayList에 저장된 학생들의 이름, 총점, 평균을 출력
		 * 3. 학생 성적정보 상세 조회 기능
		 * 		학생이름을 입력받아서 그 학생의 이름, 국어, 영어, 수학, 총점, 평균을 출력
		 * 4. 학생 성적정보 변경 기능
		 * 		Comparable<T> 혹은 Comparator<T>를 이용해서 총점이 높은 학생부터 낮은 학생순으로 출력
		 */
		
		ArrayList<Student> students = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("  1.성적입력    2.전체조회    3.상세조회    4.성적변경    5.성적순출력    0. 종료   ");
			System.out.println("------------------------------------------------------------------------------------");
			
			int menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.print("학생이름을 입력하세요: ");
				String name = sc.next();
				System.out.print("국어성적을 입력하세요: ");
				int kor = sc.nextInt();
				System.out.print("영어성적을 입력하세요: ");
				int eng = sc.nextInt();
				System.out.print("수학성적을 입력하세요: ");
				int math = sc.nextInt();
				
				students.add(new Student(name, kor, eng, math));
				System.out.println("[" + name +" 학생의 정보가 입력되었습니다]");
			} else if(menu == 2) {
				for(Student s : students) { // 전체출력
					printStudent(s);
				}
				System.out.println();
			} else if(menu == 3) { // 상세출력
				System.out.println("성적을 출력할 학생이름: ");
				String name = sc.next();
				
				Student findedStudent = findStudent(name, students);
				
				if(findedStudent == null) {
					System.out.println("[입력한 학생을 찾을 수 없습니다]");
					continue;
				} else {
					printStudentDetail(findedStudent);
				}
				
			} else if(menu == 4) {
				System.out.print("성적을 변경할 학생이름: ");
				String name = sc.next();
				System.out.print("변경할 과목(국어/영어/수학): ");
				String subject = sc.next();
				System.out.print("변경된 점수: ");
				int score = sc.nextInt();
				
				Student findedStudent = findStudent(name, students);
				
				if(findedStudent == null || !(subject.equals("국어") || subject.equals("영어") || subject.equals("수학"))) {
					System.out.println("[입력한 정보가 잘못되었습니다.]");
					continue;
				} else {
					updateScore(findedStudent, subject, score);
					System.out.println("[" + findedStudent.getName() + " 의 " + subject + " 성적을 수정하였습니다]");
				}
				
			} else if(menu == 5) {
				Collections.sort(students, (o1, o2) -> o2.getTotal() - o1.getTotal());
				for(Student s : students) { // 전체출력
					printStudent(s);
				}
				System.out.println();
			} else if(menu == 0) {
				System.out.println("[종료합니다]");
				break;
			} else System.out.println("[잘못된 입력입니다]");
		}
		
	}
	
	public static void printStudent(Student student) {
		System.out.println("이름: " + student.getName());
		System.out.println("총점: " + student.getTotal());
		System.out.println("평균: " + student.getAverage());
		System.out.println("--------------------------------------");
	}
	
	public static void printStudentDetail(Student student) {
		System.out.println("이름: " + student.getName());
		System.out.println("국어: " + student.getKor());
		System.out.println("영어: " + student.getEng());
		System.out.println("수학: " + student.getMath());
		System.out.println("총점: " + student.getTotal());
		System.out.println("평균: " + student.getAverage());
		System.out.println("--------------------------------------");
	}
	
	public static Student findStudent(String name, ArrayList<Student> array) {
		
		Student find = null;
		
		for(Student s : array) {
			if(s.getName().equals(name)) {
				find = s;
				break;
			}
		}
		return find;
	}
	
	public static void updateScore(Student student, String subject, int score) {
		
		if(subject.equals("국어")) {
			student.setKor(score);
		} else  if(subject.equals("영어")) {
			student.setEng(score);
		} else if(subject.equals("수학")) {
			student.setMath(score);
		}
		
		int total = student.getKor() + student.getEng() + student.getMath();
		student.setTotal(total);
		student.setAverage(total/3);
	}
}
