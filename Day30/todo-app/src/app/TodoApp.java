package app;

import service.TodoService;
import vo.Todo;
import vo.User;

import static utils.KeyboardUtils.readInt;
import static utils.KeyboardUtils.readString;

import java.util.Date;
import java.util.List;

import static utils.KeyboardUtils.readDate;
import static utils.KeyboardUtils.readDateTime;

import exception.TodoException;

public class TodoApp {

	private TodoService service = new TodoService();
	
	public TodoApp() {
		service.프로그램시작서비스();
	}
	
	public void menu() {
		try {
		if (!service.로그인여부제공서비스()) {
			System.out.println("---------------------------------------------------------------------------------------------------------");
			System.out.println("1.로그인 2.회원가입 0.종료");
			
			System.out.print("메뉴 선택 > ");
			int menuNo = readInt();
			System.out.println();
			
			if (menuNo == 1) {
				로그인();
			} else if (menuNo == 2) {
				회원가입();
			} else if(menuNo == 0) {
				종료();
			}
			
		} else {
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			System.out.println("1.일정조회 2.일정상세조회 3.일정추가 4.일정변경 5.일정완료처리 6.일정삭제 7.비밀번호변경 8.로그아웃 9.회원탈퇴  0.종료");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			
			System.out.print("메뉴 선택 > ");
			int menuNo = readInt();
			
			if (menuNo == 1) {
				일정조회();
			} else if(menuNo == 2) {
				일정상세조회();
			} else if (menuNo == 3) {
				일정추가();
			} else if (menuNo == 4) {
				일정변경();
			} else if (menuNo == 5) {
				일정완료처리();
			} else if (menuNo == 6) {
				일정삭제();
			} else if (menuNo == 7) {
				비밀번호변경();
			} else if (menuNo == 8) {
				로그아웃();
			} else if (menuNo == 9) {
				회원탈퇴();
			} else if(menuNo == 0) {
				종료();
			}
		}
		} catch (TodoException e) {
			System.out.println("[오류] " + e.getMessage());
		}
		System.out.println();
		
		menu();
	}
	
	// 아이디와 비밀번호를 입력받아서 로그인 서비스를 실행한다.
	private void 로그인() {
		System.out.println("[로그인]");
		
		System.out.print("아이디를 입력하세요 > ");
		String userId = readString();
		
		System.out.print("비밀번호를 입력하세요 > ");
		String password = readString();
		
		service.로그인서비스(userId, password);
		System.out.println("[안내] 로그인이 완료되었습니다.");
	}
	
	// 로그아웃 서비스를 실행한다.
	private void 로그아웃() {
		service.로그아웃서비스();
		System.out.println("[안내] 로그아웃이 완료되었습니다.");
	}
	
	// 아이디, 비밀번호, 사용자명을 입력받아서 회원가입 서비스를 실행한다.
	private void 회원가입() {
		System.out.println("[회원가입]");
		
		System.out.print("아이디를 입력하세요 > ");
		String userId = readString();
		
		System.out.print("비밀번호를 입력하세요 > ");
		String password = readString();
		
		System.out.print("이름을 입력하세요 > ");
		String username = readString();
		
		Date date = new Date();
		
		User user = new User();
		user.setId(userId);
		user.setPassword(password);
		user.setUsername(username);
		user.setDisabled(false);
		user.setCreatedDate(date);
		user.setDeletedDate(null);
		
		service.회원가입서비스(user);
		System.out.println("[안내] 회원가입이 완료되었습니다");
	}
	
	// 종료 서비스를 실행한다.
	private void 종료() {
		System.out.println("[프로그램 종료]");
		service.프로그램종료서비스();
		System.exit(0);
	}
	
	// 나의모든일정조회서비스를 실행한다.
	private void 일정조회() {
		List<Todo> todoList = service.나의모든일정조회서비스();
		if(todoList.isEmpty()) throw new TodoException("일정이 없습니다.");
		
		System.out.println("--------------------------------------------------");
		for(Todo todo : todoList) {
			System.out.println("No\t| " + todo.getNo());
			System.out.println("Title\t| " + todo.getTitle());
			System.out.println("Writer\t| " + todo.getWriter());
			System.out.println("Day\t| " + todo.getDay());
			System.out.println("Status\t| " + todo.getStatus());
			System.out.println("----------------------");
			//System.out.println("Text\t| " + todo.getText());
			//System.out.println("CreateDate\t| " + todo.getCreatedDate());
			//System.out.println("Completed\t| " + todo.getCompletedDate());
			//System.out.println("DeletedDate\t| " + todo.getDeletedDate());
		}
		System.out.println("--------------------------------------------------");
	}
	
	private void 일정상세조회() {
		System.out.print("상세조회할 일정 번호를 입력하세요 > ");
		int no = readInt();
		
		Todo todo = service.일정상세조회서비스(no);
		
		System.out.println("No\t| " + todo.getNo());
		System.out.println("Title\t| " + todo.getTitle());
		System.out.println("Writer\t| " + todo.getWriter());
		System.out.println("Day\t| " + todo.getDay());
		System.out.println("Status\t| " + todo.getStatus());
		System.out.println("Text\t| " + todo.getText());
		
		System.out.println("CreateDate\t| " + todo.getCreatedDate());
		if(todo.getStatus().equals("종료")) System.out.println("Completed\t| " + todo.getCompletedDate());
		else if(todo.getStatus().equals("삭제")) System.out.println("DeletedDate\t| " + todo.getDeletedDate());
	}
	
	// 일정제목, 내용, 예정일을 입력받아서 새일정추가서비스를 실행한다.
	private void 일정추가() {
		System.out.println("[새 일정 추가]");
		
		System.out.print("일정 제목을 입력하세요 > ");
		String title = readString();
		System.out.print("일정 내용을 입력하세요 > ");
		String text = readString();
		System.out.print("일정 실행일을 입력하세요(2021-04-30) > ");
		Date day = readDate();
		
		Todo todo = new Todo();
		
		todo.setTitle(title);
		todo.setText(text);
		todo.setDay(day);
		
		service.새일정추가서비스(todo);
		System.out.println("[안내] 새일정을 추가완료 했습니다.");
	} 
	
	// 변경할 일정번호, 제목, 내용을 입력받아서 일정변경서비스를 실행한다.
	private void 일정변경() {
		System.out.print("변경할 일정번호를 입력하세요 > ");
		int no = readInt();
		System.out.print("일정 제목을 입력하세요 > ");
		String title = readString();
		System.out.print("일정 내용을 입력하세요 > ");
		String text = readString();
		
		service.일정변경서비스(no, title, text);
		
		System.out.println("[안내] 일정변경을 완료하였습니다.");
	}
	
	// 완료처리할 일정번호를 입력받아서 일정완료처리서비스를 실행한다.
	private void 일정완료처리() {
		System.out.print("완료 처리할 일정번호를 입력하세요 > ");
		int no = readInt();
		
		service.일정완료처리서비스(no);
		System.out.println("[안내] 일정을 완료처리 했습니다.");
	}
	
	// 삭제할 일정번호를 입력받아서 일정삭제서비스를 실행한다.
	private void 일정삭제() {
		System.out.print("삭제 처리할 일정번호를 입력하세요 > ");
		int no = readInt();
		
		service.일정삭제서비스(no);
		System.out.println("[안내] 일정을 삭제처리 했습니다.");
	}
	
	// 이전비밀번호, 새비밀번호를 입력받아서 비밀번호변경서비스를 실행한다.
	private void 비밀번호변경() {
		System.out.print("이전 비밀번호를 입력하세요 > ");
		String oldPassword = readString();
		System.out.print("새 비밀번호를 입력하세요 > ");
		String newPassword = readString();
		
		service.비밀번호변경서비스(oldPassword, newPassword);
		System.out.println("[안내] 비밀번호를 변경하였습니다.");
	}
	
	// 비밀번호를 입력받아서 회원탈퇴서비스를 실행한다.
	private void 회원탈퇴() {
		System.out.print("비밀번호를 입력하세요 > ");
		String password = readString();
		
		service.회원탈퇴서비스(password);
		
		System.out.println("[안내] 탈퇴처리를 완료하였습니다.");
	}
		
	public static void main(String[] args) {
		new TodoApp().menu();
	}
}
