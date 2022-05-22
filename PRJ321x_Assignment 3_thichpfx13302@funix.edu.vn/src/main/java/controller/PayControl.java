package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import bean.Cart;
import dao.LoginDAO;
import dao.OrderDAO;

/**
 * Servlet implementation class PayControl
 * Thanh toán sp trong cart
 */
@WebServlet("/PayControl")
public class PayControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			HttpSession session = request.getSession();
			// Lấy userMail đã lưu trên session khi Login 
			String userMail = (String) session.getAttribute("userSession");
			// Lấy cart đã lưu trên session
			Cart cart = (Cart) session.getAttribute("cart");
			// cart không có sp
			if(session.getAttribute("cart") == null) {
				session.setAttribute("messCart", "Cart is Empty");
				response.sendRedirect("cart.jsp");
			// Chưa Login
			} else if(session.getAttribute("userSession") == null) {
				response.sendRedirect("login.jsp");
			// Lấy các thông tin cart và tài khoản gửi về SQL Server
			} else {
				Account a = new LoginDAO().checkUserSignup(userMail);
				OrderDAO order = new OrderDAO();
				order.addOrder(a, cart);
				// Xóa các sp trong cart (sp đã mua sẽ ko còn trong cart)
				session.setAttribute("cart", null);
				session.setAttribute("messCart", "Order Success");
				response.sendRedirect("cart.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
