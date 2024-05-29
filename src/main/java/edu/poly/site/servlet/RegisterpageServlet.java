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
import edu.poly.model.User;
import eu.poly.dao.UserDao;



@WebServlet("/Register")
public class RegisterpageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_REGISTER_PAGE);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
		
		try {
			BeanUtils.populate(user, request.getParameterMap());
			
			UserDao dao = new UserDao();
			dao.insert(user);
			
			request.setAttribute("message", "Đăng kí thành công đăng nhập tài khoản để trải nghiệm");
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_REGISTER_PAGE);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_REGISTER_PAGE);		
				
	}

}
