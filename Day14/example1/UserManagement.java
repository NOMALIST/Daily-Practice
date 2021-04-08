package example1;

public class UserManagement {

	private UserRepository repo;
	
	// Constructor
	public UserManagement() {}
	
	public UserManagement(UserRepository repo) {
		this.repo = repo;
	}
	
	// setter
	public void setRepo(UserRepository repo) {
		this.repo = repo;
	}
	
	//getter
	public UserRepository getRepo() {
		return repo;
	}
	
	public void addUser(String id, String name) {
		repo.addUser(id, name);
	}
	
	public void updateUser(User user) {
		repo.updateUser(user);
	}
	
	public User getUser(String id) {
		
		User user;
		user = repo.getUserById(id);		
		return user;
	}
	
	public void delUser(String id) {
		repo.deleteUser(id);
	}
	
	
	
}
