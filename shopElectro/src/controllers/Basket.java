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

@WebServlet("/Basket")
public class Basket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		try {
			request.setAttribute("basket", BaseModel.getCard(username));
			request.getRequestDispatcher("WEB-INF/views/UserBasket.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("id_good") != null) {
			try {
				if (BaseModel.promote(Integer.parseInt(request.getParameter("id_good")))) {
					response.getWriter().print("Товар оплачен!");
				} else {
					response.getWriter().print("Ошибка!");
				}
			} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("id_good_drop") != null) {
			try {
				if (BaseModel.drop(Integer.parseInt(request.getParameter("id_good_drop")))) {
					response.getWriter().print("Товар Удален!");
				} else {
					response.getWriter().print("Ошибка!");
				}
			} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
