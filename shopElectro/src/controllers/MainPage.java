package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.BaseModel;

@WebServlet({ "/MainPage", "/mainpage", "/mainPage" })
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		request.setAttribute("username", username);
		try {
			if (request.getParameter("id") != null) {
				request.setAttribute("goods", BaseModel.getGoods(Integer.parseInt(request.getParameter("id"))));
				request.getRequestDispatcher("WEB-INF/views/goods.jsp").forward(request, response);
			} else {
				request.setAttribute("categories", BaseModel.getCategories());
				request.getRequestDispatcher("WEB-INF/views/mainPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	}
}
