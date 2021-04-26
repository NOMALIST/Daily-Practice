
package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import vo.Book;

public class BookRepository {

	private List<Book> db = new ArrayList<>();

	public BookRepository() {
		try {
			loadData();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 모든 책정보를 반환한다.
	 * @return 도서 목록
	 */
	public List<Book> getAllBooks() {
		return db;
	}

	/**
	 * 지정된 책번호의 책을 반환한다.
	 * @param no 책번호
	 * @return 도서
	 */
	public Book getBookByNo(int no) {
		
		Book searchedBook = null;
		
		for(Book book: db) {
			if(book.getNo() == no) {
				searchedBook = book;
				break;
			}
		}
		
		return searchedBook;
	}

	/**
	 * 지정된 책으로 책정보를 변경한다.
	 * @param book 변경된 책정보를 포함하고 있는 책
	 */
	public void updateBook(Book book) {

	}

	private void loadData() throws IOException{
		FileReader fileReader = new FileReader("src/books.csv");
		BufferedReader data = new BufferedReader(fileReader);

		String text = null;


		while( (text = data.readLine()) != null) {
			String[] arr = text.split(",");

			int no = Integer.parseInt(arr[0]);
			String category = arr[1];
			String title = arr[2];
			String writer = arr[3];
			String publicsher = arr[4];
			int price = Integer.parseInt(arr[5]);
			int discountPrice = Integer.parseInt(arr[6]);
			int stock = Integer.parseInt(arr[7]);

			db.add(new Book(no, category, title, writer, publicsher, price, discountPrice, stock));

		}

	}

	public void saveData() throws IOException{

		PrintWriter fileWriter = new PrintWriter("src/books.csv");
		
		for(Book book : db) {

			StringBuilder sb = new StringBuilder();
			
			sb.append(book.getNo() + ",")
				.append(book.getCategory() + ",")
				.append(book.getTitle() + ",")
				.append(book.getWriter() + ",")
				.append(book.getPublisher() + ",")
				.append(book.getPrice() + ",")
				.append(book.getDiscountPrice() + ",")
				.append(book.getStock());
			
			String text = sb.toString();
			
			fileWriter.println(text);
		}
		fileWriter.close();
	}
}
