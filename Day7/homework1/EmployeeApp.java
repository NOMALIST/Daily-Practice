package homework1;

public class EmployeeApp {

	public static void main(String[] args) {
		Employee em1 = new Employee();
		
		em1.no = 1902007;
		em1.name = "서요준";
		em1.team = "항공사업본부";
		em1.position = "사원";
		em1.salary = 40000000;
		em1.isCommission = false;
		
		em1.printEmployeeInfo();
	}
}
