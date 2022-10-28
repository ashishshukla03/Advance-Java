package com.nagarro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.controller.Factory;
import com.nagarro.dao.UserDao;
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userdao = new UserDao(Factory.getFactory());
		boolean user = userdao.getUserByEmailAndPassword(username, password);
		HttpSession httpSession = request.getSession();

		if (user != false) {
			httpSession.setAttribute("current-user", username);
			response.sendRedirect("admin.jsp");
			return;
		} else {
			httpSession.setAttribute("message", "Invalid id/password");
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
