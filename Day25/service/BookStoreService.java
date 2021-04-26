package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.BookException;
import exception.OrderException;
import exception.UserException;
import repository.BookRepository;
import repository.OrderRepository;
import repository.UserRepository;
import vo.Book;
import vo.Order;
import vo.User;

public class BookStoreService {

	private BookRepository bookRepository = new BookRepository();
	private UserRepository userRepository = new UserRepository();
	private OrderRepository orderRepository = new OrderRepository();

	// 로그인 인증과정을 마친 사용자정보가 저장된다
	private User loginedUser = null;	

	/**
	 * 모든 책정보를 조회하는 기능.
	 * @return 도서 목록
	 */
	public List<Book> getAllBookList() {
		List<Book> bookDB = bookRepository.getAllBooks();

		return bookDB;
	}

	/**
	 * 지정된 카테고리에 해당하는 책 정보들을 조회하는 기능.
	 * @param category 조회할 도서 카테고리
	 * @return 도서 목록
	 */
	public List<Book> searchBooksByCategory(String category) {
		ArrayList<Book> searchedBook = new ArrayList<Book>();

		List<Book> bookDB = getAllBookList();

		for(Book book : bookDB) {
			if(book.getCategory().equals(category)) {
				searchedBook.add(book);
			}
		}

		return searchedBook;
	}

	/**
	 * 지정된 책 제목을 포함하고 잇는 책 정보들을 조회하는 기능.
	 * @param title 조회할 도서 제목
	 * @return 도서 목록
	 */
	public List<Book> searchBooksByTitle(String title) {
		ArrayList<Book> searchedBook = new ArrayList<Book>();

		List<Book> bookDB = getAllBookList();

		for(Book book : bookDB) {
			if(title.contains(book.getTitle())) {
				searchedBook.add(book);
			}
		}

		return searchedBook;
	}

	/**
	 * 지정된 가격범위에 속하는 책 정보들을 조회하는 기능.
	 * @param minPrice 최소 가격
	 * @param maxPrice 최대 가격
	 * @return 도서 목록
	 */
	public List<Book> searchBooksByPrice(int minPrice, int maxPrice) {
		ArrayList<Book> searchedBook = new ArrayList<Book>();

		List<Book> bookDB = getAllBookList();

		for(Book book : bookDB) {
			if(book.getPrice() >= minPrice && book.getPrice() <= maxPrice) {
				searchedBook.add(book);
			}
		}

		return searchedBook;
	}

	/**
	 * 지정된 책번호에 해당하는 책정보를 조회하는 기능.
	 * @param no 조회할 책 번호
	 * @return 도서
	 */
	public Book findBook(int no) {
		return null;
	}

	/**
	 * 지정된 책번호의 재고를 변경하는 기능.
	 * @param no 책번호
	 * @param stock 변경된 재고량
	 */
	public void updateBookStock(int no, int stock) {

	}

	/**
	 * 지정된 사용자정보를 등록하는 기능.
	 * @param user 새 사용자
	 */
	public void addNewUser(User user) {
		User foundeduser = null;

		foundeduser = userRepository.getUserById(user.getName());
		if(foundeduser != null) throw new UserException("이미 등록된 아이디입니다");

		userRepository.insertUser(user);
	}

	/**
	 * 지정된 아이디와 비밀번호로 사용자정보를 인증하는 기능.
	 * @param id 아이디
	 * @param password 비밀번호
	 */
	public void login(String id, String password) {
		User user = userRepository.getUserById(id);

		if(user == null) throw new UserException("아이디 혹은 비밀번호가 일치하지 않습니다");

		if(!(user.getPassword().equals(password))) throw new UserException("아이디 혹은 비밀번호가 일치하지 않습니다");

		loginedUser = user;
	}

	/**
	 * 로그인된 사용자 정보를 초기화하는 기능.
	 */
	public void logout() {
		loginedUser = null;
	}

	/**
	 * 로그인여부를 반환하는 기능.
	 * @return 로그인된 사용자정보가 존재하면 true를 반환한다.
	 */
	public boolean isLogined() {
		if(loginedUser != null) return true;
		else return false;
	}

	/**
	 * 주문하기 기능.
	 * @param bookNo 책번호
	 * @param amount 주문수량
	 */
	public void orderBook(int bookNo, int amount) {
		
		if(loginedUser == null) {
			throw new UserException("로그인이 필요한 서비스입니다");
		}

		Book searchedBook = bookRepository.getBookByNo(bookNo);
		
		if(searchedBook == null) {
			throw new BookException("책번호가 올바르지 않습니다");
		}
		
		if(searchedBook.getStock() < amount) {
			throw new BookException("재고량이 부족합니다");
		}
		
		Order order = new Order(loginedUser.getId(), bookNo, amount);
		orderRepository.insertOrder(order);
		Book book = bookRepository.getBookByNo(bookNo);
		int stock = book.getStock() - amount;
		book.setStock(stock);
		int point = loginedUser.getPoint() + (int)(book.getDiscountPrice()*amount*0.01);
		loginedUser.setPoint(point);
		// 일반 :                 ~    99,999
		// 로얄 :      100,000    ~   999,999
		// 골드 :    1,000,000    ~ 4,999,999
		// 플레티넘 : 5,000,000
		
		if(point < 100000) {
			loginedUser.setGrade("일반");
		} else if(point < 1000000) {
			loginedUser.setGrade("로얄");
		} else if(point < 5000000) {
			loginedUser.setGrade("골드");
		} else {
			loginedUser.setGrade("플래티넘");
		}
		
		
	}

	/**
	 * 로그인한 사용자의 주문내역을 조회하는 기능.
	 * @return 주문 목록
	 */
	public List<Map<String, Object>> getMyOrderList() {
		
		if(loginedUser == null) throw new UserException("로그인이 필요한 서비스입니다");
		
		List<Map<String, Object>> orderMapList = new ArrayList<Map<String, Object>>(); 
		List<Order> orders = orderRepository.getAllOrders();
		
		for(Order order : orders) {
			if(order.getUserId().equals(loginedUser.getId())) {
				HashMap<String, Object> orderMap = new HashMap<>();
				
				orderMap.put("bookNo", order.getBookNo());
				Book book = bookRepository.getBookByNo(order.getBookNo());
				orderMap.put("title", book.getTitle());
				orderMap.put("amount", order.getAmount());
				int totalPrice = order.getAmount()*book.getDiscountPrice();
				orderMap.put("totalPrice", totalPrice);
				int savePoint = (int)(totalPrice*0.01);
				orderMap.put("savePoint", savePoint);				
				
				orderMapList.add(orderMap);
			}
		}
		if(orderMapList.isEmpty()) throw new OrderException("주문내역이 없습니다");
		
		return orderMapList;
	}
	

	/**
	 * 로그인한 사용자의 상세정보를 조회하는 기능.
	 * @return
	 */
	public User getMyInfo() {
		if(loginedUser == null) throw new UserException("로그인이 필요한 서비스입니다");
		else return loginedUser;
	}

	/**
	 * 모든 정보를 저장하는 기능.
	 */
	public void restore() throws IOException{
		userRepository.saveData();
		bookRepository.saveData();
		orderRepository.saveData();
	}
}

