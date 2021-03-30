package homework1;

public class Employee {

	// 사원번호, 사원이름, 소속부서명, 직위, 급여, 커미션지급여부
	
	int no;
	String name;
	String team;
	String position;
	int salary;
	boolean isCommission;
	
	
	// 사원정보를 출력하는 기능
	// 매개변수 : 없음
	// 리턴값 : 없음
	void printEmployeeInfo() {
		System.out.println("======== 사원 정보 출력 =========");
		System.out.println("사번 : " + no);
		System.out.println("이름 : " + name);
		System.out.println("소속 : " + team);
		System.out.println("직급 : " + position);
		System.out.println("급여 : " + salary);
		System.out.println("커미션 여부 : " + (isCommission ? "지급" : "미지급"));
		System.out.println();
	}
}
