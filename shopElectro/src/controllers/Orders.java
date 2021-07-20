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

@WebServlet({ "/AllOrders", "/allOrders", "/Orders", "/orders" })
public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username.equals("admin")) {
			try {
				request.setAttribute("basket", BaseModel.getBasket());
				request.getRequestDispatcher("WEB-INF/views/AdmOrders.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (username != null) {
			try {
				request.setAttribute("basket", BaseModel.getBasket(username));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("WEB-INF/views/UserOrders.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			if (BaseModel.promote(Integer.parseInt(request.getParameter("id_good")))) {
				response.getWriter().print("Товар перведен на следующий этап!");
			} else {
				response.getWriter().print("Ошибка!");
			}
		} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
