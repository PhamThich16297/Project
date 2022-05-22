package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Account;
import context.DBContext;
// class LoginDAO làm việc với Bảng Account trong database
public class LoginDAO {
	Connection conn = null;	//Mo ket noi den SQL Server
	PreparedStatement ps = null; //Nem lenh SQL tu Eclipse sang SQL Server
	ResultSet rs = null; //Nhan ket qua tra ve
	
	// Trả về Account có trong database (Kiểm tra Account đăng nhập)
	public Account checkLogin(String user, String pass, int role) throws SQLException{
		try {
			String query = "select * from Account where user_mail = ? and password = ? and account_role = ?";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setInt(3, role);
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
				Account a = new Account(rs.getString(1), rs.getString(2));
				return a;
			}
		} catch (Exception e) {
		
		}
		return null;
	}
	
	// Trả về Account có trong database (Kiểm tra Account đăng kí)
	public Account checkUserSignup(String user) throws SQLException{
		try {
			String query = "select * from Account where user_mail = ?";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
				Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(4),rs.getString(5),rs.getString(6));
				return a;
			}
		} catch (Exception e) {
		
		}
		return null;
	}
	
	// Thêm Record(Account) vào Bảng Account trong database (Tài khoản khách hàng role = 0)
	public void signup(String user_mail, String pass, String name, String address, String phone) {
		String query = "insert into Account\r\n"
				+ "values(?,?,0,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user_mail);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setString(4, address);
			ps.setString(5, phone);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
