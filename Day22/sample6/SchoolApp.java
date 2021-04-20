package sample6;

import java.util.Scanner;

public class SchoolApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		SchoolRepo repo = new SchoolRepo();
		
		while(true) {
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("1.학생등록   2.과정등록   3.전과정조회   4.수강신청   5.수강취소   6.나의 신청내역   0.종료");
			System.out.println("--------------------------------------------------------------------------------------------");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();
			System.out.println();
			
			if(menuNo == 1) {
				System.out.println("학번을 입력하세요 > ");
				int no = scanner.nextInt();
				System.out.println("이름을 입력하세요 > ");
				String name = scanner.next();
				System.out.println("학과을 입력하세요 > ");
				String dept = scanner.next();
				System.out.println("학년을 입력하세요 > ");
				int grade = scanner.nextInt();
				
				repo.addStudent(new Student(no, name, dept, grade));
			} else if(menuNo == 2) {
				System.out.println("과정번호를 입력하세요 > ");
				int no = scanner.nextInt();
				System.out.println("과정명을 입력하세요 > ");
				String name = scanner.next();
				System.out.println("정원을 입력하세요 > ");
				int quota = scanner.nextInt();
				
				repo.addCourse(new Course(no, name, quota));
			} else if(menuNo == 3 ) {	// 전과정 조회
				repo.displayAllCourses();
			} else if(menuNo == 4) {	// 수강신청
				System.out.println("학번을 입력하세요 > ");
				int stuNo = scanner.nextInt();
				System.out.println("과정번호를 입력하세요 > ");
				int courseNo = scanner.nextInt();
				
				repo.addRegistration(stuNo, courseNo);
			} else if(menuNo == 5) {	// 수강취소
				System.out.println("학번을 입력하세요 > ");
				int stuNo = scanner.nextInt();
				System.out.println("과정번호를 입력하세요 > ");
				int courseNo = scanner.nextInt();
				
				repo.cancelRegistration(stuNo, courseNo);
			} else if(menuNo == 6) {	// 나의 수강신청 조회
				System.out.println("학번을 입력하세요 > ");
				int stuNo = scanner.nextInt();
				
				repo.displayMyRegistrations(stuNo);
			} else if(menuNo == 0 ) {
				System.out.println("[프로그램 종료]");
				break;
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
		
		scanner.close();
	}
}
