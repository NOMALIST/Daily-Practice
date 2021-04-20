package example1;

import java.util.ArrayList;

public class UserService {

	ArrayList<User> users = new ArrayList<User>();
	
	public void UserRepo() {
		users.add(new User("hong", "홍길동", "1234"));
		users.add(new User("kim", "김유신", "1234"));
		users.add(new User("lee", "이순신", "1234"));
		users.add(new User("kang", "강감찬", "1234"));
		users.add(new User("ryu", "류관순", "1234"));		
	}
	
	// 새 사용자(아이디, 이름, 비밀번호 포함) 등록기능
	// 동일한 아이디로 가입된 사용자가 존재하면 UserAlreadyExistsException을 던진다.

	public void insertUser(User user) {
		
		User foundedUser = findUserById(user.getId());
		
		if(foundedUser != null) throw new UserAlreadyExistsException(user.getId());
		
		users.add(user);
		System.out.println("[가입완료]");
	}
	
	// 아이디를 전달받아서 해당 아이디로 가입한 사용자를 반환하는 기능
	// 아이디에 해당하는 사용자가 존재하지 않으면 UserNotFoundException을 던진다.
	public User findUserById(String id) {
		User foundedUser = null;
		for(User u : users) {
			if(u.getId().equals(id)) {
				foundedUser = u;
			}
		}
		// if(foundedUser == null) throw new UserNotFoundException(id);
		return foundedUser;
	}
	
	// 비밀번호 찾기
	// 아이디 이름을 입력받아 조회해봄
	public void findPasswordByIdName(String id, String name) {
		User foundedUser = findUserById(id);
		
		if(foundedUser == null) throw new UserNotFoundException(id);
		
		if(foundedUser.getName().equals(name)) {
			System.out.println("비밀번호는 [" + foundedUser.getPassword() + "] 입니다");
		} else throw new UserNotFoundException(name);
		
	}

	// 아이디, 이전 비밀번호, 새 비밀번호를 전달받아서 비밀번호를 변경하는 기능
	// 아이디에 해당하는 사용자가 존재하지 않으면 UserNotFoundException을 던진다.
	// 비밀번호가 일치하지 않으면 PasswordMismatchException을 던진다.

	public void changePassword(String id, String oldPwd, String NewPwd) {
		
		User foundedUser = findUserById(id);
		
		if(foundedUser == null) throw new UserNotFoundException(id);
		
		if(foundedUser.getPassword().equals(oldPwd)) {
			foundedUser.setPassword(NewPwd);
			System.out.println("[비밀번호 변경완료]");
		} else throw new PasswordMismatchException(id);
			
	}
	
	
	
	// 아이디를 전달받아서 해당 아이디로 가입한 사용자를 삭제하는 기능
	// 아이디에 해당하는 사용자가 존재하지 않으면 UserNotFoundException을 던진다.
	
	
	public void deletUser(String id) {
		User foundedUser = findUserById(id);
		
		if(foundedUser == null) throw new UserNotFoundException(id);
		
		users.remove(foundedUser);
		System.out.println("[회원탈퇴 완료]");
	}
	
	
	
	
}
