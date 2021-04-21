package example1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		StudentService service = new StudentService();
		
		int menuNo;
		
		while(true) {
			
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("1.전체조회    2.추가    3.검색    4.삭제    5.석차조회   0.종료");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.print("번호를 입력하세요 > ");
			menuNo = sc.nextInt();
			
			try {
				
				if(menuNo == 1) { // 전체조회
					
					ArrayList<Student> students = service.getAllStudentList();
					
					System.out.println("==============================");
					System.out.println("이름\t총점\t평균");
					for(Student s : students) {
						System.out.print(s.getName() + "\t");
						System.out.print(s.getTotal() + "\t");
						System.out.print(s.getAvg() + "\n");
					}
					System.out.println("==============================");
					
					
					
				} else if(menuNo == 2) { // 추가
					System.out.print("학생이름을 입력하세요 > ");
					String name = sc.next();
					System.out.print("국어성적을 입력하세요 > ");
					int kor = sc.nextInt();
					System.out.print("영어성적을 입력하세요 > ");
					int eng = sc.nextInt();
					System.out.print("수학성적을 입력하세요 > ");
					int math = sc.nextInt();
					
					service.addNewStudent(new Student(name, kor, eng, math));
					
					System.out.println("[학생 등록 완료]");
					
				} else if(menuNo == 3) { // 검색
					
					System.out.print("학생이름을 입력하세요 > ");
					String name = sc.next();
					
					Student student = service.findStudentByName(name);
					
					System.out.println("==============================");
					System.out.println("학생이름: " + student.getName());
					System.out.println("국어성적: " + student.getKor());
					System.out.println("영어성적: " + student.getEng());
					System.out.println("수학성적: " + student.getMath());
					System.out.println("-------------");
					System.out.println("총점: " + student.getTotal());
					System.out.println("평균: " + student.getAvg());
					System.out.println("==============================");
					
				} else if(menuNo == 4) {  // 삭제
					
					System.out.print("학생이름을 입력하세요 > ");
					String name = sc.next();
					
					service.deleteStudentByName(name);
					
					System.out.println("[" + name + " 학생 삭제완료]");
					
				} else if(menuNo == 5) { // 석차조회
					
					ArrayList<Student> students = service.getSortedStudentList();
					System.out.println("==============================");
					for(Student s : students) {
						System.out.print(s.getName() + "\t");
						System.out.print(s.getTotal() + "\t");
						System.out.print(s.getAvg() + "\n");
					}
					System.out.println("==============================");
					
				} else if(menuNo == 0) { // 종료
					
					service.saveAllStudentData();
					System.out.println("[데이터 저장완료]");
					System.out.println("[프로그램 종료]");					
					break;
				}
				
				
				
			} catch(Exception e) {
				System.out.println("[오류발생]" + e.getMessage());
			}
			

		}
		
	}
}
