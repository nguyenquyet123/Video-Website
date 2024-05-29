package edu.poly.site.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.CookieUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.model.Favorite;
import edu.poly.model.Video;
import eu.poly.dao.FavoriteDao;
import eu.poly.dao.VideoDao;

@WebServlet("/Favorites")
public class FavoritespageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = CookieUtils.get("username", request);
		paginationVideo(request, response, username);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FAVORITES_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void paginationVideo(HttpServletRequest request, HttpServletResponse response, String username)
			throws ServletException, IOException {
		FavoriteDao dao = new FavoriteDao();
		List<Video> vlist = dao.findVideoByUsername(username);
		request.setAttribute("vlist", vlist);
	}

}
