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

@WebServlet({ "/feedbackpage", "/FeedbackPage" })
public class FeedbackPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String name = "";
	static String email = "";
	static String message = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			if (username.equals("admin")) {
				try {
					request.setAttribute("feedbacks", BaseModel.getFeedback());
					request.getRequestDispatcher("WEB-INF/views/feedbackAdmin.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (username != null) {
				request.getRequestDispatcher("WEB-INF/views/feedback.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("WEB-INF/views/feedback.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		name = request.getParameter("name");
		email = request.getParameter("email");
		message = request.getParameter("message");
		try {
			if (BaseModel.addFeed(name, email, message)) {
				response.getWriter().print("Ваше сообщение отправлено");
			} else {
				response.getWriter().print("Ошибка!");
			}
		} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}