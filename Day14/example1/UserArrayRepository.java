package example1;

public class UserArrayRepository implements UserRepository{
	
	User[] users = new User[100];
	int position = 0;
	

	
	public UserArrayRepository() {
		users[position++] = new User("hong","홍길동");
		users[position++] = new User("lee","이순신");
		users[position++] = new User("yoo","유관순");
		users[position++] = new User("kim","김시민");
		users[position++] = new User("gang","강감찬");
	}
	
	@Override
	public void addUser(String id, String name) {
		User user = new User(id,name);
		users[position++] = user;
		System.out.println("["+name+"] 님 등록완료");
	}
	
	@Override
	public void deleteUser(String id) {
		
		int foundedIndex = -1;
		
		for(int i=0; i<position; i++) {
			if(id.equals(users[i].getId())) {
				foundedIndex = i;
				break;
			}
		}
		
		if(foundedIndex == -1) System.out.println("일치하는 ID가 없습니다.");
		else if(foundedIndex == position-1) {
			users[position-1] = null;
			position--;
			System.out.println("[삭제 완료]");
		} else {
			users[foundedIndex] = users[position-1];
			users[position--] = null;
			System.out.println("[삭제 완료]");
		}
		
	}
	
	
	@Override
	public User getUserById(String id) {
		User foundedUser = null;
		
		for(User x: users) {
			if(x == null) break;
			
			if(id.equals(x.getId())) {
				foundedUser = x;
				break;
			}
		}
		
		if(foundedUser == null) System.out.println("일치하는 ID가 없습니다.");
		
		return foundedUser;
	}
	
	@Override
	public void updateUser(User user) {
		User foundedUser = null;
		
		for(User x: users) {
			if(x == null) break;
			
			if(user.getId().equals(x.getId())) {
				user.setName(user.getName());
				break;
			}
		}
		
		if(foundedUser == null) System.out.println("일치하는 ID가 없습니다.");
		
	}
	
	

}
