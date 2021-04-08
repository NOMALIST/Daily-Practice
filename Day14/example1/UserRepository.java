package example1;

public interface UserRepository {

	public void addUser(String id, String name);
	
	public void deleteUser(String id);
	
	public void updateUser(User user);
	
	public User getUserById(String id);
	
}
