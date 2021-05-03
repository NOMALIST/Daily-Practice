import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) throws Exception{
	
		Scanner sc = new Scanner(System.in);
		
		String driverClassName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		
		Class.forName(driverClassName);
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql = "insert into sample values(?,?,?,?,?,?,sysdate)";
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		System.out.println("[책 등록하기]");
		
		System.out.print("책 제목을 입력하세요 > ");
		String title = sc.nextLine();
		
		System.out.print("책 저자를 입력하세요 > ");
		String writer = sc.nextLine();
		
		System.out.print("책 번호를 입력하세요 >");
		int no = sc.nextInt();
		
		System.out.print("책 가격을 입력하세요 >");
		int price = sc.nextInt();
		
		System.out.print("할인된 책 가격을 입력하세요 >");
		int discountPrice = sc.nextInt();
		
		System.out.print("재고를 입력하세요 >");
		int stock = sc.nextInt();
		
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, writer);
		pstmt.setInt(4, price);
		pstmt.setInt(5, discountPrice);
		pstmt.setInt(6, stock);
		
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 추가되었습니다.");
		
		pstmt.close();
		connection.close();
	}
	
}
