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
 * Servlet implementation class Search
 * Tìm kiểm Sp theo tên
 */
@WebServlet("/timkiem")
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			// Lấy từ khóa cần tìm
			String txtSearch = request.getParameter("search");
			// Lấy số trang
			String indexStr = request.getParameter("index");
			int index;
			// Lần đầu chạy vào trang 1
			if(indexStr == null) {
				index = 1;
			} else {
				index = Integer.parseInt(indexStr);
			}
			
			ProductDAO productDAO = new ProductDAO();
			// Số trang của danh sách tìm được theo từ khóa
			int countSearch = productDAO.countSearch(txtSearch);
			// 1 trang có 9 sp
			int pageSize = 9;
			// trang cuối
			int endPage = 0;
			endPage = countSearch/pageSize;
			if(countSearch%pageSize != 0) {
				endPage++;
			}
			// Danh sách sp  tìm được theo trang
			List<Product> listSearch = productDAO.listSearch(txtSearch, index, pageSize);
			// Danh sách top 3 sp có giá cao nhất
			List<Product> listTop3 = productDAO.getTop3Product();
			// Gửi data lên request
			request.setAttribute("endSearch", endPage);
			request.setAttribute("listSearch", listSearch);
			request.setAttribute("index", index);
			request.setAttribute("saveSearch", txtSearch);
			request.setAttribute("listTop3", listTop3);
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
