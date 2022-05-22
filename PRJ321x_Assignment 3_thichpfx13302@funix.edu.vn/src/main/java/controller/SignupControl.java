package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import dao.LoginDAO;

/**
 * Servlet implementation class SignupControl
 * Đăng kí tài khoản
 */
@WebServlet("/SignupControl")
public class SignupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		// Lấy dữ liệu từ input
		String inputYourName = request.getParameter("inputYourName"); //not null
		String inputAddress = request.getParameter("inputAddress"); //null
		String inputPhone = request.getParameter("inputPhone"); //null
		
		String inputUserSignup = request.getParameter("inputUserSU"); //not null
		String inputPassSignup = request.getParameter("inputPassSU");	//not null
		String inputRe_PassSignup = request.getParameter("inputRe_PassSU"); //not null
		
		HttpSession session = request.getSession();
		// Định dạng userMail và pass
		String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regex = "[a-zA-Z0-9_!@#$%^&*]+";
		
		// Lỗi để trống input
		if(inputYourName=="" || inputUserSignup=="" || inputPassSignup== "" || inputRe_PassSignup=="") {
			session.setAttribute("mess", "(*) Cannot be Empty");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		// Lỗi sai định dạng
		}else if(!inputUserSignup.matches(regexMail) || !inputPassSignup.matches(regex)) {
			session.setAttribute("mess", "Invalid syntax");
			response.sendRedirect("signup.jsp");
		// Lối pass và re_pass không giống nhau
		}else if(!inputPassSignup.equals(inputRe_PassSignup)) {
			session.setAttribute("mess", "Wrong password!");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		// Các trường hợp còn lai
		} else {
			LoginDAO dao = new LoginDAO();
			try {
				Account a = dao.checkUserSignup(inputUserSignup);
				// Đăng kí thành công
				if(a==null) {
					dao.signup(inputUserSignup, inputPassSignup, inputYourName, inputAddress, inputPhone);
					response.sendRedirect("home");
				// Tên userMail đã tồn tại
				} else {
					session.setAttribute("mess", "User_mail already exists");
					response.sendRedirect("signup.jsp");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
