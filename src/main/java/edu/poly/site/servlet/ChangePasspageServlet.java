package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import eu.poly.dao.UserDao;
import poly.edu.todo.ChangePasswordForm;


@WebServlet("/Change")
public class ChangePasspageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = SessionUtils.getLoginedUsername(request);
		
		if (username == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
		}
		
		request.setAttribute("username", username);
		
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = SessionUtils.getLoginedUsername(request);
			
			ChangePasswordForm form = new ChangePasswordForm();
			BeanUtils.populate(form, request.getParameterMap());
			
			if (!form.getConfirmPassword().equals(form.getCurrentPassword())) {
				request.setAttribute("error", "new pass word and new confirm password are not identical");
			}else {
				UserDao dao = new UserDao();
				dao.changePassword(form.getUsername(), form.getCurrentPassword());
				request.setAttribute("message", "Password has bean changed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);

	}

}
