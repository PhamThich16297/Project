package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import bean.Product;
import context.DBContext;

//class ProductDAO : Làm việc với bảng Products trong database
public class ProductDAO {
	
	// Lấy danh sách tất cả các sp trong bảng Products
	public List<Product> getListProducts() {
		String query = "select * from Products";
		List<Product> list = new ArrayList<>();
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7));
				list.add(p);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// Lấy danh sách gồm 3 sp có giá cao nhất
	public List<Product> getTop3Product() {
		String query = "select top 3 * from Products\r\n"
				+ "order by product_price desc";
		List<Product> list = new ArrayList<>();
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7));
				list.add(p);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// Lấy số trang, mỗi trang gồm 9 sp
	public int count() {
		List<Product> list = new ProductDAO().getListProducts();
		int size = list.size();
		int count = size/9;
		if(size%9 !=0) {
			count = count+1;
		}
		return count;
	}
	
	// Lấy danh sách các sp trong 1 trang
	public List<Product> getListPage(int index) {
		String query = "select * from Products where product_id between ?*9-8 and ?*9";
		List<Product> list = new ArrayList<>();
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, index);
			ps.setInt(2, index);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7));
				list.add(p);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// Lấy số trang tìm kiếm với từ khóa search
	public int countSearch(String search) {
		String query = "select count(*) from Products where product_name like ?";
		
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + search + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}
	
	//Lấy danh sách các sp tìm kiếm được
	public List<Product> listSearch(String search, int index, int size) {
		String query = "with x as(select ROW_NUMBER() over (order by product_brand) as STT \r\n"
				+ ",* from Products where product_name like ?)\r\n"
				+ "select * from x where STT between ?*9-8 and ?*9";
		List<Product> listSearch = new ArrayList<>();
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + search + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getDouble(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8));
				listSearch.add(p);
			}
			return listSearch;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	// Lấy sp theo id sp
	public Product getProduct(int id) {
		try {
			String query = "select * from Products where product_id = ?";
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4),
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7));
				return p;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
