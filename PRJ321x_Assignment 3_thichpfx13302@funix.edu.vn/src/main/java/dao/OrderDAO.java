package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;



import bean.Account;
import bean.Cart;
import bean.Product;
import context.DBContext;

// class OrderDAO : Làm việc với bảng Orders và Bảng Orders_detail trong database
public class OrderDAO {
	
	//Thêm hóa đơn
	public void addOrder(Account a, Cart c) {
		// Thời gian hiện tại khi tạo đơn hàng
		LocalDate dateCur=LocalDate.now();
		String date = dateCur.toString();
		try {
			// Thêm thông tin người mua hàng vào bảng Orders trong database
			String query1 = "insert into Orders(user_mail, order_status, order_date, order_discount_code, order_address)\r\n"
					+ "values(?, 0, ?,'0',?)";
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setString(1, a.getUsername());
			ps.setString(2, date);
			ps.setString(3, a.getAddress());
			ps.executeUpdate();
			
			// Lấy order_id mới nhất trong bảng Orders
			String query2 = "select top 1 order_id from Orders order by order_id desc";
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ResultSet rs2 = ps2.executeQuery();
			
			if(rs2.next()) {
				int orderId = rs2.getInt("order_id");
				// Lần lượt thêm thông tin các sp trong cart
				for (Product p : c.getItems()) {
					String query3 = "insert into Orders_detail\r\n"
							+ "values(?,?,?,?)";
					PreparedStatement ps3 = conn.prepareStatement(query3);
					ps3.setInt(1, orderId);
					ps3.setInt(2, p.getId());
					ps3.setInt(3, p.getNumber());
					ps3.setDouble(4, p.getPrice()); //getPrice 1 sp
					ps3.executeUpdate();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
