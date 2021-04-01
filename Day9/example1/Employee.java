package example1;

/* Employee class 생성 */


//기본생성자

//직원번호, 직원이름, 직원급여를 초기화하는 작업을 수행하는 중복 생성자
//﻿ Generate Constructor using Fields 사용

//멤버변수 전체를 초기화하는 작업을 수행하는 중복 생성자
//﻿Generate Constructor using Fields 사용

public class Employee {

	//멤버변수 (직원번호, 직원이름, 소속부서, 직원직위, 직원급여, 커미션지급율)
	
	int no;
	String name;
	String team;
	String position;
	int salary;
	double commissionRate;
	
	Employee () {
	}
	
	Employee (int no, String name, int salary) {
		this.no = no;
		this.name = name;
		this.salary = salary;
	}
	
	Employee (int no, String name, String team, String position, int salary, double commissionRate) {
		this.no = no;
		this.name = name;
		this.team = team;
		this.position = position;
		this.salary = salary;
		this.commissionRate = commissionRate;
	}
	
	void print() {
		System.out.println("============ 직원 정보 ==============");
		System.out.println("직원번호: " + no);
		System.out.println("직원이름: " + name);
		System.out.println("소속부서: " + team);
		System.out.println("직원직책: " + position);
		System.out.println("직원급여: " + salary);
		System.out.println("커미션율: " + commissionRate);
		System.out.println();
	}
	
}
