package example1;

public class EmployeeApp {

	//정보 출력 메소드
	//--------------------------------------------
	/* EmployeeApp class 생성 */
	//### 객체 생성후 기본 생성자가 실행되도록 한 경우 출력
	//Employee e1 객체 생성
	//출력

	//### 객체 생성후 번호, 이름, 급여를 초기화시키는 생성자가 실행되로록 한 경우
	//Employee e2 객체 생성 후 매개변수 입력 (직원번호, 이름, 급여)
	//Employee e3 객체 생성 후 매개변수 입력 (직원번호, 이름, 급여)
	//출력

	//### 객체 생성후 모든 멤버변수를 초기화시키는 생성자가 실행되도록 한 경우
	//Employee e4 객체 생성 후 매개변수 입력 (직원번호, 이름, 부서, 직급, 급여, 커미션율)
	//Employee e5 객체 생성 후 매개변수 입력 (직원번호, 이름, 부서, 직급, 급여, 커미션율)
	//출력
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		e1.print();
		
		Employee e2 = new Employee(2021001, "장보고", 38000000);
		Employee e3 = new Employee(2021002, "임꺽정", 35000000);
		e2.print();
		e3.print();
		
		Employee e4 = new Employee(2021003, "유관순", "해외영업팀", "부장", 9000000, 0.05);
		Employee e5 = new Employee(2021004, "문익점", "감사팀", "사원", 3000000, 0);
		Employee e6 = new Employee(2021005, "정약용", "연구개발팀", "과장", 54000000, 0.1);
		e4.print();
		e5.print();
		e6.print();
		
		
	}
}
