import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		String driverClassName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		
		//1. JDBC드라이버를 메모리에 로딩하기
		Class.forName(driverClassName);
		
		//2. DBMS와 연결하고, Connection구현객체 획득하기
		Connection connection = DriverManager.getConnection(url, username, password);
		
		//3. PrepareStatement구현객체 획득하기
		String sql = "insert into sample values(?, ?, ?, ?, ?, ?, sysdate)";
		PreparedStatement pstmt = connection.prepareStatement(sql); 
		
		//4. ?에 값 바인딩하기
		pstmt.setInt(1, 101);
		pstmt.setString(2, "이것이 자바다");
		pstmt.setString(3, "신용권");
		pstmt.setInt(4, 35000);
		pstmt.setInt(5, 32000);
		pstmt.setInt(6, 50);
		
		//5. SQL 구문을 DBMS로 보내기
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 추가되었습니다.");

		//6. DBMS와 연결에 사용했던 모든 자원에 대한 점유 해제하기
		pstmt.close();
		connection.close();
		
		
	}
}
