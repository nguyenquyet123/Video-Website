package edu.poly.site.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
import eu.poly.dao.VideoDao;

@WebServlet({ "/Admin/Detail", "/Admin/Detail/islike", "/Admin/Detail/share"})
public class DetailpageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idVideo = request.getParameter("idVideo");
		findAllVideo(request, response, idVideo);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_DETAIL_PAGE);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);

		if (username == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}

		String url = request.getRequestURI().toString();

		if (url.contains("islike")) {
			try {
				String videoID = request.getParameter("videoId");
				FavoriteDao dao = new FavoriteDao();

				Favorite favorite = new Favorite();
				Video video = new Video();
				video.setVideoId(videoID);
				favorite.setVideo(video);

				User user = new User();
				user.setUsername(username);
				favorite.setUser(user);

				favorite.setLikeDate(new Date(0));

				dao.insert(favorite);
				
				findAllVideo(request, response, videoID);
				request.setAttribute("message", "you liked");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
		}
		if (url.contains("share")) {
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SHAREVIDEO_PAGE);
		}
		

//		findAllVideo(request, response);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_DETAIL_PAGE);

	}

	protected void findAllVideo(HttpServletRequest request, HttpServletResponse response, String idVideo)
			throws ServletException, IOException {
		VideoDao dao = new VideoDao();
		
		List<Video> videos = dao.findAll();
		List<Video> items = videos.subList(0, 6);
		Video videoInfor = dao.findById(idVideo);

		request.setAttribute("items", items);
		request.setAttribute("videoInfor", videoInfor);
	}

}
