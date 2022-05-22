package bean;

import java.util.Date;

// Chi Tiết Hóa đơn theo tài khoản
public class ProductOrder {
	private String userMail;
	private int orderId;
	private int orderStatus;
	private Date orderDate;
	private String code;
	private String orderAddress;
	
	public ProductOrder(String userMail, int orderId, int orderStatus, Date orderDate, String code,
			String orderAddress) {
		this.userMail = userMail;
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.code = code;
		this.orderAddress = orderAddress;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	
	
}
