package example2;

import java.util.Scanner;


/*StudentApp class 생성*/
//1.전체조회 2.상세조회 3.등록 4.수정 0.종료 출력하기
	

public class StudentApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		StudentService service = new StudentService();
		
		final int DISPLAY_ALL = 1;
		final int DISPLAY_ONE_DETAIL = 2;
		final int INSERT_STUDENT = 3;
		final int UPDATE_STUDENT = 4;
		final int EXIT = 0;
		
		
		
		while(true) {
			System.out.println("===============================================");
			System.out.println("1.전체조회  2.상세조회  3.등록  4.수정  0.종료");
			System.out.println("===============================================");
			int menu = sc.nextInt();
			
			if(menu == DISPLAY_ALL) {
				service.printAll();
			} else if(menu == DISPLAY_ONE_DETAIL) {
				System.out.print("이름을 입력하세요: ");
				String inputName = sc.next();
				service.printOne(inputName);
			} else if(menu == INSERT_STUDENT) {
				System.out.print("추가할 학생의 이름: ");
				String inputName = sc.next();
				System.out.print("추가할 학생의 국어점수: ");
				int inputKor = sc.nextInt();
				System.out.print("추가할 학생의 영어점수: ");
				int inputEng = sc.nextInt();
				System.out.print("추가할 학생의 수학점수: ");
				int inputMath = sc.nextInt();
				
				service.insertStudent(inputName, inputKor, inputEng, inputMath);
			} else if(menu == UPDATE_STUDENT) {
				System.out.print("수정할 학생의 이름: ");
				String inputName = sc.next();
				System.out.print("수정할 과목(국어, 영어, 수학 중 입력): ");
				String inputSubject = sc.next();
				System.out.print("수정할 점수: ");
				int inputScore = sc.nextInt();
				
				service.updateStudent(inputName, inputSubject, inputScore);			
				
			} else if(menu == EXIT) {
				System.out.println("[프로그램 종료]");
				break;
			} else System.out.println("잘못 입력하셨습니다.");
			
			System.out.println();
		}
	}
}
