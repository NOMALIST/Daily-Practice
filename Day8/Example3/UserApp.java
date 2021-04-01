package Example3;

public class UserApp {

	public static void main(String[] args) {
		
		User user1 = new User();
		user1.printUserInfo();
		
		User user2 = new User("철수", "seoul", "qwer1234");
		User user3 = new User("영희", "busan", "rewq4321");
		user2.printUserInfo();
		user3.printUserInfo();
		
		User user4 = new User(100,"이순신","Leee","1234","01044445555", 18,"미국",false);
		User user5 = new User(200,"김시민","Kim","4321","01066667777", 55,"이집트",true);
		User user6 = new User(300,"최희","choi","5555","01088889999", 30,"중국",false);
		user4.printUserInfo();
		user5.printUserInfo();
		user6.printUserInfo();
	}
}
