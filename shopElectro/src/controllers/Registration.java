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

@WebServlet({ "/Registration", "/registration" })
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean answer = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int IdUser = 0;

		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			if (BaseModel.findIdUser(phone) == -1) {
				if (BaseModel.findbyUsername(username) != (-1)) {
					response.getWriter().print(answer);
				} else if (BaseModel.addUser(username, password, phone)) {
					answer = true;
					response.getWriter().print(answer);
				}
			} else {
				response.getWriter().print(answer);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
