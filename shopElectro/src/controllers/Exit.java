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

@WebServlet({ "/Exit", "/exit" })
public class Exit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.invalidate();
		try {
			if (request.getParameter("id") != null) {
				request.setAttribute("goods", BaseModel.getGoods(Integer.parseInt(request.getParameter("id"))));
				request.getRequestDispatcher("WEB-INF/views/goods.jsp").forward(request, response);
			} else {
				request.setAttribute("categories", BaseModel.getCategories());
				request.getRequestDispatcher("WEB-INF/views/mainPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
