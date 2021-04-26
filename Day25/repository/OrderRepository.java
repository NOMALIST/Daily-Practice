package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import vo.Order;

public class OrderRepository {

	private List<Order> db = new ArrayList<>();
	
	public OrderRepository() {
		try {
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 지정된 주문정보를 저장한다.
	 * @param order 주문정보
	 */
	public void insertOrder(Order order) {
		db.add(order);
	}
	
	/**
	 * 지정된 사용자의 주문내역을 반환한다.
	 * @param userId 사용자 아이디
	 * @return 주문내역
	 */
	public List<Order> getAllOrders() {
		return db;
	}
	
	
	private void loadData() throws IOException{
		
		FileReader fileReader = new FileReader("src/orders.csv");
		BufferedReader reader = new BufferedReader(fileReader);
		
		String text = null;
		while( (text = reader.readLine()) != null) {
			String[] arr = text.split(",");
			
			String userId = arr[0];
			int bookNo = Integer.parseInt(arr[1]);
			int amount = Integer.parseInt(arr[2]);
			
			db.add(new Order(userId, bookNo, amount));
		}
		
	}
	
	public void saveData() throws IOException{
		PrintWriter writer = new PrintWriter("src/orders.csv");
	
		for(Order order : db) {
			String userId = order.getUserId();
			int bookNo = order.getBookNo();
			int amount = order.getAmount();
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(userId + ",")
				.append(bookNo + ",")
				.append(amount);
			
			String text = sb.toString();
			
			writer.println(text);
		}
		writer.close();
	}
	

}
