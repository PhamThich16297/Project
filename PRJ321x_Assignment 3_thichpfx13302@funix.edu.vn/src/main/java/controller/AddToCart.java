package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.Product;
import bean.OrderDetail;
import dao.ProductDAO;

/**
 * Servlet implementation class CartControl
 * Thêm sp vào cart
 */

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			HttpSession session = request.getSession(true);
			// Lấy action và id từ detal.jsp
			String idd = request.getParameter("id");
			String action = request.getParameter("action");
			// add vào cart
			if (action != null && action.equals("add")) {
				// cart isEmpty
				if (session.getAttribute("cart") == null) {
					session.setAttribute("cart", new Cart());
				}
				// cart !isEmpty
				int id = Integer.parseInt(idd);
				Product p = new ProductDAO().getProduct(id);
				Cart c = (Cart) session.getAttribute("cart");
				c.add(new Product(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getSrc(), p.getType(),
						p.getBrand(), 1));
				session.setAttribute("cart", c);
			// xóa sp trong cart
			} else if (action != null && action.equals("delete")) {
				int id = Integer.parseInt(idd);
				Cart c = (Cart) session.getAttribute("cart");
				c.remove(id);
			// +1 số lượng sp (sp đã có trong cart)
			} else if (action != null && action.equals("add1")) {
				int id = Integer.parseInt(idd);
				Cart c = (Cart) session.getAttribute("cart");
				for (Product product : c.getItems()) {
					if (product.getId() == id) {
						product.setNumber(product.getNumber() + 1);
					}
				}
				session.setAttribute("cart", c);
			// -1 số lượng sp
			} else if (action != null && action.equals("tru1")) {
				int id = Integer.parseInt(idd);
				Cart c = (Cart) session.getAttribute("cart");

				boolean b = false;
				for (Product product : c.getItems()) {
					if (product.getId() == id) {
						product.setNumber(product.getNumber() - 1);
						if (product.getNumber() == 0) {
							b = true;
						}
					}
				}
				// số lượng sp = 0 => xóa sp trong cart
				if (b) {
					c.remove(id);
				}
			}
			response.sendRedirect("cart.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
