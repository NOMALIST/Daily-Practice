package example1;

import java.util.Scanner;

public class UserApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		UserService service = new UserService();
		service.UserRepo();
		int menuNo;

		while(true) {

			try {


				System.out.println("=========================================================================");
				System.out.println("1.회원가입    2.비밀번호찾기   3.비밀번호변경   4.회원탈퇴    0.종료");
				System.out.println("=========================================================================");
				System.out.print("메뉴를 선택하세요 > ");
				menuNo = sc.nextInt();



				if(menuNo == 1) {
					System.out.print("아이디를 입력하세요 > ");
					String id = sc.next();
					System.out.print("이름을 입력하세요 > ");
					String name = sc.next();
					System.out.print("비밀번호를 입력하세요 >");
					String password = sc.next();
					
					User user = new User(id,name,password);
					
					service.insertUser(user);
					
				} else if(menuNo == 2) {	//비밀번호 찾기
					System.out.print("아이디를 입력하세요 > ");
					String id = sc.next();
					System.out.print("이름을 입력하세요 > ");
					String name = sc.next();
					
					service.findPasswordByIdName(id, name);
					
				} else if(menuNo == 3) {	// 비밀번호 변경

					System.out.print("아이디를 입력하세요 > ");
					String id = sc.next();
					System.out.print("이전 비밀번호를 입력하세요 >");
					String oldPwd = sc.next();
					System.out.print("새로운 비밀번호를 입력하세요 >");
					String newPwd = sc.next();
					
					service.changePassword(id, oldPwd, newPwd);
					
				} else if(menuNo == 4) {	// 회원탈퇴
					System.out.print("아이디를 입력하세요 > ");
					String id = sc.next();
					
					service.deletUser(id);

				} else if(menuNo == 0) {	// 종료
					System.out.println("[프로그램 종료]");
					break;
				}
				System.out.println();
			} catch (UserAlreadyExistsException e1) {
				System.out.println("[오류] 동일한 사용자가 이미 존재합니다");
			} catch (UserNotFoundException e2) {
				System.out.println("[오류] 사용자를 찾을 수 없습니다");
			} catch (PasswordMismatchException e3) {
				System.out.println("[오류] 비밀번호가 일치하지 않습니다");
			}
		}
	}
}
