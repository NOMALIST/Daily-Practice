package sample1;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// 학생들의 정보를 입력받아서 배열에 저장하기
		
		// 1. 5명의 학생정보를 저장할 수 있는 배열을 정의한다.
		// 2. 키보드 입력을 읽어오는 Scanner객체를 생성한다.
		// 3. 반복문(for문)을 사용해서 5회 반복한다.
		//		1. 이름, 국어, 영어, 수학 점수를 차례로 입력받는다.
		//		2. Student객체를 생성해서 입력받은 값을 저장한다.
		//		2. 배열에 순서대로 Student객체를 저장한다.
		// 4. 배열에 저장된 학생들의 이름을 반복문(향상된 for문)을 사용해서 출력한다.
		
		Scanner sc = new Scanner(System.in);
		
		Student[] arr = new Student[5];
		System.out.println("학생 5명의 정보를 입력하세요.");
		for(int i=0; i<5; i++) {
			Student student = new Student();
			System.out.print(i+1 + "번째 학생의 이름: ");
			student.name = sc.next();
			System.out.print(i+1 + "번째 학생의 국어점수: ");
			student.kor = sc.nextInt();
			System.out.print(i+1 + "번째 학생의 영어점수: ");
			student.eng = sc.nextInt();
			System.out.print(i+1 + "번째 학생의 수학점수: ");
			student.math = sc.nextInt();
			
			arr[i] = student;
		}
		
		System.out.println("------------모든학생의 정보 출력--------------");
		for(Student x : arr) {
			System.out.println(x.name + "  " + x.kor + "  " + x.eng + "  " + x.math);
		}
		
	}
	
}
