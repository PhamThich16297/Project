package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import dao.LoginDAO;

/**
 * Servlet implementation class LoginControl
 * Đăng Nhập tài khoản
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		// Ghi nhớ đăng nhập cho lần tiếp theo
		if(cookies != null) {
			for (Cookie cook : cookies) {
				if(cook.getName().equals("userCook")) {
					request.setAttribute("userName", cook.getValue());
				}
				if(cook.getName().equals("passCook")) {
					request.setAttribute("passWord", cook.getValue());
				}
			}
		}
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		try {
			//Lay du lieu tu nguoi dung nhap
			String inputUserName = request.getParameter("inputUser");
			String inputPassWord = request.getParameter("inputPass");
			
			String remember = request.getParameter("remember");
			// Định dạng userMail và pass
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			
			HttpSession session = request.getSession();
			LoginDAO loginDAO = new LoginDAO();
			// Kiểm tra tài khoản login
			Account a = loginDAO.checkLogin(inputUserName, inputPassWord, 1);
			Account b = loginDAO.checkLogin(inputUserName, inputPassWord, 0);
			
			//Lỗi để trống input
			if(inputUserName == "" || inputPassWord == "") {
				session.setAttribute("error", "UserName or Password cannot be Empty");
				response.sendRedirect("login.jsp");
			// Lỗi sai định dạng
			}else if(!inputUserName.matches(regexMail) || !inputPassWord.matches(regex)) {
				session.setAttribute("error", "invalid syntax");
				response.sendRedirect("login.jsp");
			// Đăng nhập thành công
			}else if(inputUserName != null && (a != null || b != null)) {
				// Gửi usermail lên session
				session.setAttribute("userSession", inputUserName);
				
				// Tạo userMail, pass lên cookie
				Cookie u = new Cookie("userCook", inputUserName);
				Cookie p = new Cookie("passCook", inputPassWord);
				
				// Thời gian lưu 60s
				u.setMaxAge(60);
				if(remember != null) {
					p.setMaxAge(60);
				} else {
					p.setMaxAge(0);
				}
				
				//Luu cookie len client
				response.addCookie(u);
				response.addCookie(p);
				// Tài khoản admin
				if(a!=null) {
					response.sendRedirect("index.jsp");
				}
				// Tài Khoản khách hàng
				if(b!=null) {
					response.sendRedirect("home");
				}
//				request.getRequestDispatcher("index.jsp").forward(request, response);
			// Sai userMail hoặc pass 
			} else {
				session.setAttribute("error", "wrong username or password");
				response.sendRedirect("login.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
