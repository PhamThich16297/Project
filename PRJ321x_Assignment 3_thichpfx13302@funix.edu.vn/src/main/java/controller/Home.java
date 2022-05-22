package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

/**
 * Servlet implementation class ProductControl
 * Trang chủ => Chạy đầu tiên
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			// Lấy số trang
			String pageStr = request.getParameter("page");
			int page;
			// Chạy lần đầu => chưa có số trang
			if(pageStr == null) {
				page = 1;
			} else {
				page = Integer.parseInt(pageStr);
			}
			ProductDAO productDAO = new ProductDAO();
			// Danh sách các sp trong 1 trang
			List<Product> listPage = productDAO.getListPage(page);
			// Danh sách gồm 3 sp có giá cao nhất
			List<Product> listTop3 = productDAO.getTop3Product();
			// Số trang cần hiển thị
			int count = productDAO.count();
			//Gửi data lên request
			request.setAttribute("listPage", listPage);
			request.setAttribute("listTop3", listTop3);
			request.setAttribute("page", page);
			request.setAttribute("count", count);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
