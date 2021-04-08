package example1;

public class UserManagementApp {

	public static void main(String[] args) {
		UserArrayRepository userData = new UserArrayRepository();
		
		UserManagement management = new UserManagement();
		
		management.setRepo(userData);
		
		System.out.println("### 아이디로 사용자 조회하기 ###");
		User user1 = management.getUser("gang");
		System.out.println(user1.getId() + " " + user1.getName());
		System.out.println();
		
		System.out.println("### 신규 사용자 등록하기 ###");
		management.addUser("king", "세종대왕");
		System.out.println();
		
		System.out.println("### 아이디로 사용자 조회하기 ###");
		User user2 = management.getUser("king");
		System.out.println(user2.getId() + " " + user2.getName());
		System.out.println();
		
		System.out.println("### 신규 사용자 등록하기 ###");
		management.addUser("yoon", "윤봉길");
		System.out.println();
		
		System.out.println("### 등록된 사용자 삭제하기 ###");
		management.delUser("lee");
		System.out.println();
		
		System.out.println("### 삭제된 사용자 조회하기 ###");
		User user3 = management.getUser("lee");
		System.out.println();

		System.out.println("### 다른 사용자 조회하기 ###");
		System.out.println(management.getUser("kim").getName());
		System.out.println();
		
	}
}
