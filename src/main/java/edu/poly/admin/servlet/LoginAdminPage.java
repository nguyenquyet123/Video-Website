package edu.poly.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.CookieUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.model.User;
import eu.poly.dao.UserDao;
import poly.edu.todo.LoginForm;

@WebServlet("/LoginAdmin")
public class LoginAdminPage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = CookieUtils.get("username", request);
		if (username == null) {
			PageInfo.prepareAndForwardSite(request, response, PageType.LOGIN_MANAGEMENT_PAGE);
		}
		SessionUtils.add(request, "username", username);

		PageInfo.prepareAndForwardSite(request, response, PageType.LOGIN_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			LoginForm form = new LoginForm();

			BeanUtils.populate(form, request.getParameterMap());

			UserDao dao = new UserDao();
			User user = dao.findById(form.getUsername());

			if (user.getAdmin() == true && user.getPassword().equals(form.getPassword())) {
				SessionUtils.add(request, "username", user.getUsername());
				
				if (form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, response);
				}else {
					CookieUtils.add(getServletName(), form.getUsername(), 0, response);
				}
				request.setAttribute("isLogin", true);
				response.sendRedirect("Index");
				return;
			}
			request.setAttribute("error", "invalid username or password");
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}

		PageInfo.prepareAndForwardSite(request, response, PageType.LOGIN_MANAGEMENT_PAGE);
	}

}
