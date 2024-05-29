package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.UploadUtils;
import edu.poly.model.Video;
import eu.poly.dao.VideoDao;

/**
 * Servlet implementation class VideosManagementServlet
 */
@WebServlet({ "/Admin/VideosServlet", "/Admin/VideosServlet/create", "/Admin/VideosServlet/update",
		"/Admin/VideosServlet/delete", "/Admin/VideosServlet/reset", "/Admin/VideosServlet/edit", "/Video" })
@MultipartConfig
public class VideosManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("edit")) {
			edit(request, response);
			return;
		}
		findAllVideo(request, response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI().toString();

		if (url.contains("create")) {
			create(request, response);
			return;
		}
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

	private void create(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException, ServletException {
		// TODO Auto-generated method stub
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());

//			video.setPoster(
//					"uploads/" + UploadUtils.processUploadField("cover", request, "/uploads", video.getVideoId()));

			VideoDao dao = new VideoDao();
			dao.insert(video);

			request.setAttribute("video", video);
			request.setAttribute("message", "Video is inserted!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		findAllVideo(request, response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException, ServletException {
		// TODO Auto-generated method stub
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			VideoDao dao = new VideoDao();
			dao.update(video);

			request.setAttribute("video", video);
			request.setAttribute("message", "Video is updated!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		findAllVideo(request, response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		try {
			VideoDao dao = new VideoDao();
			
			dao.delete(id);
			request.setAttribute("message", "Video is delete");
			request.setAttribute("video", new Video());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		findAllVideo(request, response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		request.setAttribute("video", video);
		findAllVideo(request, response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		if (id == null) {
			request.setAttribute("error", "Khong tim thay video");
			PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);
			request.setAttribute("video", video);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		findAllVideo(request, response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void findAllVideo(HttpServletRequest request, HttpServletResponse response) {

		try {
			VideoDao vdao = new VideoDao();
			List<Video> list = vdao.findAll();

			request.setAttribute("vlist", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}

	}

}
