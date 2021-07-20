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

@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean answer = false;
	public String username = "";
	public String password = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		username = request.getParameter("username");
		password = request.getParameter("password");
		try {
			if (BaseModel.FindUser(username, password) == -1) {
				response.getWriter().print(answer);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				answer = true;
				response.getWriter().print(answer);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
