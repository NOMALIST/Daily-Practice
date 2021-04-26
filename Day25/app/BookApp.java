package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import exception.BookStoreException;
import repository.UserRepository;
import service.BookStoreService;
import vo.Book;
import vo.User;

public class BookApp {

	private BookStoreService service = new BookStoreService();
	private Scanner scanner = new Scanner(System.in);

	public void menu() {
		try {

			boolean isLogined = service.isLogined();

			if (!isLogined) {	// 로그인 되어있지 않을 때
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("1.도서목록  2.로그인  3.회원가입  0.종료");
				System.out.println("-----------------------------------------------------------------------");

				System.out.print("메뉴 선택 > ");
				int menuNo = scanner.nextInt();
				System.out.println();

				if (menuNo == 1) {
					displayAllBooks();
				} else if (menuNo == 2) {
					login();
				} else if (menuNo == 3) {
					register();
				} else if (menuNo == 0) {
					exit();
				}

			} else {	// 로그인 되어 있을 때
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("1.도서목록  2.검색  3.주문  4.내정보  5.주문내역  6.로그아웃  0.종료");
				System.out.println("-----------------------------------------------------------------------");

				System.out.print("메뉴 선택 > ");
				int menuNo = scanner.nextInt();
				System.out.println();

				if (menuNo == 1) {
					displayAllBooks();
				} else if (menuNo == 2) {
					searchBook();
				} else if (menuNo == 3) {
					orderBook();
				} else if (menuNo == 4) {
					displayMyInfo();
				} else if (menuNo == 5) {
					displayMyOrderHistory();
				} else if (menuNo == 6) {
					logout();
				} else if (menuNo == 0) {
					exit();
				}
			}
		} catch (BookStoreException e) {
			System.out.println("[오류] " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println();
		System.out.println();

		menu();	// 재귀호출
	}

	/**
	 * 모든 책 정보 출력하기.
	 */
	private void displayAllBooks() {
		List<Book> books = service.getAllBookList();

		Iterator<Book> iter = books.iterator();

		System.out.println("No\tPrice\tDiscountPrice\tStock\tTitle");
		while(iter.hasNext()) {
			Book book = iter.next();
			System.out.println(book.getNo() + "\t"
					+ book.getPrice() + "\t"
					+ book.getDiscountPrice() + "\t\t"
					+ book.getStock() + "\t"
					+ book.getTitle());
		}

	}

	/**
	 * 로그인하기
	 */
	private void login() {
		System.out.print("아이디를 입력하세요 > ");
		String id = scanner.next();
		System.out.print("비밀번호를 입력하요 > ");
		String password = scanner.next();

		service.login(id, password);

		if(service.isLogined()) System.out.println("[로그인 완료]");
	}

	/**
	 * 회원가입하기
	 */
	private void register() {
		System.out.print("아이디를 입력하세요 > ");
		String id = scanner.next();
		System.out.println("이름을 입력하세요 > ");
		String name = scanner.next();
		System.out.println("비밀번호를 입력하세요 > ");
		String password = scanner.next();

		User user = new User(id, name, password, 0 ,"일반");

		service.addNewUser(user);
		
		System.out.println("[가입을 환영합니다]");
	}

	/**
	 * 도서 검색
	 */
	private void searchBook() {
		while(true) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("1.제목검색  2.카테고리검색  3.가격검색  0.검색종료");
			System.out.println("-----------------------------------------------------------------------");

			System.out.print("검색 메뉴 선택 > ");
			int searchMenuNo = scanner.nextInt();
			System.out.println();
			List<Book> searchedList = new ArrayList<>();

			if (searchMenuNo == 1) {
				System.out.println("검색할 제목을 입력하세요 > ");
				String title = scanner.next();		
				searchedList = service.searchBooksByTitle(title);
			} else if (searchMenuNo == 2) {

				System.out.println("검색할 카테고리를 입력하세요 > ");
				String category = scanner.next();
				searchedList = service.searchBooksByCategory(category);

			} else if (searchMenuNo == 3) {
				System.out.println("검색할 최소가격를 입력하세요 > ");
				int minPrice = scanner.nextInt();
				System.out.println("검색할 최대가격를 입력하세요 > ");
				int maxPrice = scanner.nextInt();
				searchedList = service.searchBooksByPrice(minPrice, maxPrice);
			} else if (searchMenuNo == 0) {
				System.out.println("[검색 종료]");
				break;
			}

			if(searchedList.isEmpty()) {
				System.out.println("[검색 결과가 없습니다.]");
				System.out.println();
				continue;
			}

			Iterator<Book> iter = searchedList.iterator();

			if(searchMenuNo == 2) {
				System.out.println("No\tCategory\tPrice\tDiscountPrice\tStock\tTitle");
				while(iter.hasNext()) {
					Book book = iter.next();
					System.out.println(book.getNo() + "\t"
							+ book.getCategory() + "\t\t"
							+ book.getPrice() + "\t"
							+ book.getDiscountPrice() + "\t\t"
							+ book.getStock() + "\t"
							+ book.getTitle());
				}
			} else {
				System.out.println("No\tPrice\tDiscountPrice\tStock\tTitle");
				while(iter.hasNext()) {
					Book book = iter.next();
					System.out.println(book.getNo() + "\t"
							+ book.getPrice() + "\t"
							+ book.getDiscountPrice() + "\t\t"
							+ book.getStock() + "\t"
							+ book.getTitle());
				}
			}	

			System.out.println();

		}
	}

	/**
	 * 책 주문하기
	 */
	private void orderBook() {
		System.out.print("구매할 책 번호를 입력하세요 > ");
		int bookNo = scanner.nextInt();
		System.out.print("구매할 책의 수량을 입력하세요 > ");
		int amount = scanner.nextInt();

		service.orderBook(bookNo, amount);

		System.out.println("[주문 완료]");
	}

	/**
	 * 내 정보 보기
	 */
	private void displayMyInfo() {
		User loginedUser = service.getMyInfo();

		System.out.println("Id\tName\tGrade\tPoint\t");
		String id = loginedUser.getId();
		String name = loginedUser.getName();
		String grade = loginedUser.getGrade();
		int point = loginedUser.getPoint();
		System.out.println(id + "\t" + name + "\t" + grade + "\t" + point);
	}

	/**
	 * 내주문내역 보기
	 */
	private void displayMyOrderHistory() {

		List<Map<String, Object>> myOrderList = service.getMyOrderList();

		System.out.println("No\tAmount\tTotalPrice\tSavePoint\tTitle");

		for(Map myOrder : myOrderList) {

			int bookNo = (int)(myOrder.get("bookNo"));
			String title = (String)(myOrder.get("title"));
			int amount = (int)(myOrder.get("amount"));
			int totalPrice = (int)(myOrder.get("totalPrice"));
			int savePoint = (int)(myOrder.get("savePoint"));

			System.out.println(bookNo + "\t" 
								+ amount + "\t"
								+ totalPrice + "\t\t"
								+ savePoint + "\t\t"
								+ title);

		}
	}

	/**
	 * 로그아웃하기
	 */
	private void logout() {
		service.logout();
		System.out.println("[로그아웃 완료]");
	}

	/**
	 * 종료하기
	 */
	private void exit() throws IOException{
		System.out.println("[프로그램 종료]");
		service.restore();
		System.exit(0);
	}

	public static void main(String[] args) {
		new BookApp().menu();
	}
}
