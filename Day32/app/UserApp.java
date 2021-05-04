package app;

import java.util.Scanner;

import dao.UserDao;
import vo.User;

public class UserApp {

	static UserDao userDao = new UserDao();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int menuNo;
		
		while(true) {
			
			System.out.println("------------------------------------------------------------");
			System.out.println("     1.등록     2.조회     3.수정     4.삭제     0.종료");
			System.out.println("------------------------------------------------------------");
			
			menuNo = sc.nextInt();
			sc.nextLine();
			
			if(menuNo == 1) {
				User user = new User();
				
				System.out.println("아이디를 입력하세요 > ");
				String userId = sc.nextLine();
				System.out.println("비밀번호를 입력하세요 > ");
				String password = sc.nextLine();
				System.out.println("이름를 입력하세요 > ");
				String userName = sc.nextLine();
				System.out.println("이메일를 입력하세요 > ");
				String userEmail = sc.nextLine();
				System.out.println("연락처를 입력하세요 > ");
				String userPhone = sc.nextLine();
				
				user.setId(userId);
				user.setPassword(password);
				user.setName(userName);
				user.setEmail(userEmail);
				user.setPhone(userPhone);
				
				userDao.insertUser(user);
				
			} else if(menuNo == 2) {
				System.out.println("조회할 아이디를 입력하세요 > ");
				String userId = sc.nextLine();
				
				User user = userDao.getUsetById(userId);
				
				if(user != null) System.out.println(user.toString());
				
			} else if(menuNo == 3) {
				
				System.out.println("정보를 변경할 아이디를 입력하세요 > ");
				String userId = sc.nextLine();
				
				User user = userDao.getUsetById(userId);
				
				String answer;
				System.out.println("비밀번호를 변경하시겠습니까? ( Y / N )");
				answer = sc.nextLine();
				if(answer.equals("Y")) {
					System.out.println("변경할 비밀번호를 입력하세요 > ");
					String password = sc.nextLine();
					user.setPassword(password);
				}
				
				System.out.println("이메일주소를 변경하시겠습니까? ( Y / N )");
				answer = sc.nextLine();
				if(answer.equals("Y")) {
					System.out.println("변경할 이메일주소를 입력하세요 > ");
					String email = sc.nextLine();
					user.setEmail(email);
				}
				
				System.out.println("계정상태를 변경하시겠습니까? ( Y / N )");
				answer = sc.nextLine();
				if(answer.equals("Y")) {
					System.out.println("변경할 계정상태를 입력하세요 (현재)" + user.getStatus());
					String status = sc.nextLine();
					user.setStatus(status);
				}
				
				System.out.println("연락처를 변경하시겠습니까? ( Y / N )");
				answer = sc.nextLine();
				if(answer.equals("Y")) {
					System.out.println("변경할 연락처를 입력하세요 > ");
					String phone = sc.nextLine();
					user.setPhone(phone);
				}
				
				userDao.updateUser(user);
				
				
			} else if(menuNo == 4) {
				System.out.println("삭제할 아이디를 입력하세요 > ");
				String userId = sc.nextLine();
				
				userDao.deleteUser(userId);
				
			} else if(menuNo == 0) {
				System.out.println("[안내] 종료합니다.");
				break;
			}
			
			System.out.println();
			
		}
		
		
	}
}
