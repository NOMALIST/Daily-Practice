package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.StringUtils;

import vo.User;

public class UserDao {

	private List<User> db = new ArrayList<User>();

	/**
	 * 새 User을 db에 추가한다.
	 * @param user 새 User
	 */
	public void insertUser(User user) {
		db.add(user);
		
	}

	/**
	 * 모든 User 정보를 반환한다.
	 * @return User 리스트
	 */
	public List<User> getUsers() {
		return db;
	}

	/**
	 * 지정한 사용자 아이디의 User 정보를 반환한다.
	 * @param id userId
	 * @return User 정보
	 */
	public User getUserById(String id) {

		User searchedUser = null;
		for(User user : db) {
			if(user.getId().equals(id)) {
				searchedUser = user;
				break;
			}
		}
		return searchedUser;
	}

	/**
	 * users.csv에 기록된 사용자정보를 읽어서 db에 저장한다.
	 */
	public void loadData() {
		try {
			FileReader fr = new FileReader("src/users.csv");						
			BufferedReader reader = new BufferedReader(fr);

			String value;
			while( (value = reader.readLine()) != null) {
				String[] items = value.split(",");
				
				User user = new User();
				user.setId(items[0]);
				user.setPassword(items[1]);
				user.setUsername(items[2]);
				user.setDisabled(StringUtils.stringToBoolean(items[3]));
				user.setCreatedDate(StringUtils.stringToDate(items[4]));
				user.setDeletedDate(StringUtils.stringToDate(items[5]));
				
				db.add(user);
			}
			reader.close();
			fr.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * db에 저장된 사용자 정보를 users.csv 파일에 저장한다.
	 */
	public void saveData() {

		try(PrintWriter writer = new PrintWriter("src/users.csv")) {

			for(User user : db) {
				StringBuilder sb = new StringBuilder();
				sb.append(user.getId() + ",")
				.append(user.getPassword() + ",")
				.append(user.getUsername() + ",")
				.append(String.valueOf(user.isDisabled()) + ",")
				.append(StringUtils.dateTimeToString(user.getCreatedDate()) + ",")
				.append(StringUtils.dateToString(user.getDeletedDate()));

				String text = sb.toString();
				writer.println(text);
			}

			writer.close();

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
