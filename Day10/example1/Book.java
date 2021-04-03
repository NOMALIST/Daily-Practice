package example1;

public class Book {

	/*Book class*/
	private int no;
	private String title;
	private String writer;
	private String publisher;
	private int price;
	private boolean isSoldOut;
	private double discountRate;
	private Event event;
	private Gift gift;
	public int getNo() {
		return no;
	}
	
	public Book() {}
	
	public Book(int no, String title, String writer, String publisher, int price, boolean isSoldOut,
			double discountRate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.isSoldOut = isSoldOut;
		this.discountRate = discountRate;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isSoldOut() {
		return isSoldOut;
	}
	public void setSoldOut(boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Gift getGift() {
		return gift;
	}
	public void setGift(Gift gift) {
		this.gift = gift;
	}
	
	public void printAll() {
		System.out.println("번호: " + no);
		System.out.println("제목: " + title);
		System.out.println("저자: " + writer);
		System.out.println("출판사: " + publisher);
		System.out.println("가격: " + price);
		System.out.println("품절: " + isSoldOut);
		System.out.println("할인율: " + discountRate);
	}
}
