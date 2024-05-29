package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.model.Video;
import eu.poly.dao.VideoDao;

@WebServlet("/ShareVideo")
public class ShareVideoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		if (!SessionUtils.isLogin(request)) {
//			response.sendRedirect("Login");
//			return;
//		}
//		String videoId = request.getParameter("videoid");
//
//		if (videoId == null) {
//			response.sendRedirect("Homepage");
//			return;
//
//		}
//		try {
//			VideoDao dao = new VideoDao();
//			Video vid = dao.findById(videoId);
//
//			request.setAttribute("vid", vid);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SHAREVIDEO_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
