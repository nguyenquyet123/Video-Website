package edu.poly.site.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.model.Favorite;
import edu.poly.model.User;
import edu.poly.model.Video;
import eu.poly.dao.FavoriteDao;

@WebServlet("/LikeVideo")
public class LikeVideoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		likeVideo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void likeVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		String idVideo = request.getParameter("idVideo");

		try {
			FavoriteDao dao = new FavoriteDao();
			
			Favorite favorite = new Favorite();
			Video video = new Video();
			video.setVideoId(idVideo);
			favorite.setVideo(video);

			String username = SessionUtils.getLoginedUsername(request);
			User user = new User();
			user.setUsername(username);
			favorite.setUser(user);

			favorite.setLikeDate(new Date(0));

			dao.insert(favorite);

			request.setAttribute("message", "you liked");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}

		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_DETAIL_PAGE);
	}

}
