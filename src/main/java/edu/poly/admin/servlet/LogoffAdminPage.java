package edu.poly.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.CookieUtils;
import edu.poly.common.SessionUtils;

@WebServlet("/LogoffAdmin")
public class LogoffAdminPage extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieUtils.add("username", null, 0, response);
		
		SessionUtils.invalidate(request);
		
		request.setAttribute("isLogin", false);
		request.getRequestDispatcher("/Index").forward(request, response);
	}

}
