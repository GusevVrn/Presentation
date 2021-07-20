package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.BaseModel;

@WebServlet({ "/Goods", "/goods" })
public class Goods extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String username = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			if (request.getParameter("id_cat") != null) {
				request.setAttribute("goods", BaseModel.getGoods(Integer.parseInt(request.getParameter("id_cat"))));
				request.getRequestDispatcher("WEB-INF/views/goods.jsp").forward(request, response);
			} else if (request.getParameter("id") != null) {
				request.setAttribute("good", BaseModel.getGood(Integer.parseInt(request.getParameter("id"))));
				request.getRequestDispatcher("WEB-INF/views/goodInfo.jsp").forward(request, response);
			} else {
				request.setAttribute("goods", BaseModel.getGoods());
				request.getRequestDispatcher("WEB-INF/views/goods.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		username = (String) session.getAttribute("username");
		try {
			if (BaseModel.findbyUsername(username) > 0) {
				if (request.getParameter("id_good") != null) {
					try {
						if (BaseModel.addToCart(Integer.parseInt(request.getParameter("id_good")), username)) {
							response.getWriter().print("Товар успешно добавлен в корзину!");
						} else {
							response.getWriter().print("Ошибка при добавлении товара в корзину!");
						}
					} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException e) {
						e.printStackTrace();
					}
				}
			} else {
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
