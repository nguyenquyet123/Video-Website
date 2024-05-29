package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.model.User;
import edu.poly.model.Video;
import eu.poly.dao.UserDao;
import eu.poly.dao.VideoDao;

@WebServlet({ "/Admin/Users", "/Admin/User/update", "/Admin/User/delete", "/Admin/User/reset", "/Admin/User/edit",
		"/Users" })
public class UsersManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("edit")) {
			edit(request, response);
			return;
		}

		findAllUser(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI().toString();

		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("update")) {
			update(request, response);
			return;
		}
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		try {
			UserDao dao = new UserDao();

			dao.delete(username);
			request.setAttribute("message", "User is delete");
			request.setAttribute("video", new User());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		findAllUser(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			UserDao dao = new UserDao();
			dao.update(user);

			request.setAttribute("user", user);
			request.setAttribute("message", "User is updated!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		findAllUser(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);

	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		request.setAttribute("user", user);
		findAllUser(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");

		try {
			UserDao dao = new UserDao();
			User user = dao.findById(username);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		findAllUser(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);

	}

	protected void findAllUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao udao = new UserDao();
		List<User> list = udao.findAll();
		request.setAttribute("ulist", list);

	}

}
