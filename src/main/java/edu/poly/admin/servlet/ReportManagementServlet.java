package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.model.Video;
import eu.poly.dao.FavoriteDao;
import eu.poly.dao.VideoDao;
import poly.edu.todo.FavoriteReport;
import poly.edu.todo.FavoriteUserReport;

@WebServlet({ "/Report", "/taps2" })
public class ReportManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reportFavoritesByVideo(request, response);
		reportFavoritesUsersByvideo(request, response);
		tapsLocation(request, response);

		PageInfo.prepareAndForward(request, response, PageType.REPORT_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void reportFavoritesUsersByvideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String videoUsersId = request.getParameter("videoUserId");

			VideoDao vdao = new VideoDao();
			List<Video> vlist = vdao.findAll();

			if (videoUsersId == null && vlist.size() > 0) {
				videoUsersId = vlist.get(0).getVideoId();
			}

			FavoriteDao dao = new FavoriteDao();
			List<FavoriteUserReport> list = dao.reportFavoriteUserByVideo(videoUsersId);

			request.setAttribute("videoUserId", videoUsersId);
			request.setAttribute("vidList", vlist);
			request.setAttribute("favUsers", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error" + e.getMessage());
		}
	}

	protected void reportFavoritesByVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavoriteDao fdao = new FavoriteDao();
			List<FavoriteReport> list = fdao.reportFavoritesByVideos();
			request.setAttribute("favlist", list);

		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void tapsLocation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selectedTab = "videoEditing";
		String uri = request.getRequestURI();
		if (uri.contains("taps2")) {
			selectedTab = "videolist";
		}

		// Lưu giá trị của tab vào session
		HttpSession session = request.getSession();
		session.setAttribute("selectedTab", selectedTab);
		session.setAttribute("showTab", selectedTab);
	}

}
