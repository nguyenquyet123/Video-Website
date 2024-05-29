package edu.poly.site.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.model.Video;
import eu.poly.dao.VideoDao;

@WebServlet("/Homepage")
public class HomepageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		paginationVideo(request, response);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_HOME_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void paginationVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			VideoDao dao = new VideoDao();
			List<Video> videos = dao.findAllVideo();
			SessionUtils.add(request, "videos", videos);

			Collections.sort(videos, new Comparator<Video>() {
				@Override
				public int compare(Video video1, Video video2) {
					// Sử dụng compareTo để so sánh lượt view giảm dần
					return Integer.compare(video2.getViews(), video1.getViews());
				}
			});

			// Số video trên mỗi trang
			int videosPerPage = 6;

			// Tính toán số trang dựa trên số video và số video trên mỗi trang
			int totalVideos = videos.size();
			int totalPages = (int) Math.ceil((double) totalVideos / videosPerPage);

			// Lấy trang hiện tại từ tham số "page"
			String pageParam = request.getParameter("page");
			int currentPage = (pageParam != null) ? Integer.parseInt(pageParam) : 1;

			// Xử lý các nút điều hướng
			String action = request.getParameter("action");
			if ("first".equals(action)) {
				currentPage = 1;
			} else if ("prev".equals(action)) {
				currentPage = Math.max(currentPage - 1, 1);
			} else if ("next".equals(action)) {
				currentPage = Math.min(currentPage + 1, totalPages);
			} else if ("last".equals(action)) {
				currentPage = totalPages;
			}

			// Lấy chỉ mục bắt đầu của video trên trang hiện tại
			int startIndex = (currentPage - 1) * videosPerPage;
			// Lấy chỉ mục kết thúc của video trên trang hiện tại
			int endIndex = Math.min(startIndex + videosPerPage, totalVideos);

			// Lấy danh sách video cho trang hiện tại
			List<Video> currentVideos = videos.subList(startIndex, endIndex);

			// Lưu trang hiện tại vào session để sử dụng trong các yêu cầu tiếp theo
			SessionUtils.add(request, "currentPage", currentPage);

			// Truyền danh sách video và thông tin phân trang qua attributes để hiển thị
			// trong JSP
			request.setAttribute("videos", currentVideos);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("currentPage", currentPage);

		}
	}

