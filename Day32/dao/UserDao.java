package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.ConnectionUtils.getConnection;
import vo.User;

public class UserDao {

	// CRUD 수행
	
	public void insertUser(User user) {
		String sql = "insert into sample_users "
					+"(user_id, user_name, user_password, user_email, user_phone) "
					+"values "
					+"(?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try  {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhone());
			
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + "개의 행을 추가하였습니다.");
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
			try { if(con != null) con.close(); } catch(SQLException e) {}
		}
		
	}
	
	public User getUsetById(String userId) {
		
		String sql = "select user_id, user_name, user_password, user_email, user_phone, user_status, user_created_date "
					+ "from sample_users "
					+ "where user_id = ? ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		User foundedUser = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				User user = new User();
				user.setId(rs.getString("user_id"));
				user.setPassword(rs.getString("user_password"));
				user.setName(rs.getString("user_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPhone(rs.getString("user_phone"));
				user.setStatus(rs.getString("user_status"));
				user.setCreatedDate(rs.getDate("user_created_date"));
				
				foundedUser = user;
				
			} else {
				System.out.println("일치하는 사용자가 없습니다.");
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) {}
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(con != null) con.close(); } catch (SQLException e) {}
		}
		
		
		
		
		return foundedUser;
	}
	
	public void updateUser(User user) {
		String sql = "update sample_users "
					+"set "
					+"user_password = ?, "
					+"user_email = ?, "
					+"user_phone = ?, "
					+"user_status = ? "
					+"where user_id = ? ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getStatus());
			pstmt.setString(5, user.getId());
			
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + "개의 행을 수정하였습니다.");
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(con != null) con.close(); } catch (SQLException e) {}
		}
		
	}
	
	public void deleteUser(String userId) {
		
		String sql = "delete from sample_users "
					+"where user_id = ?";
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + "개의 행을 삭제하였습니다.");
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(con != null) con.close(); } catch (SQLException e) {}
		}
	}
}
