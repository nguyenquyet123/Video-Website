package edu.poly.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashedMap();
	
	static {
		pageRoute.put(PageType.HOME_MANAGEMENT_PAGE, new PageInfo("HomeManagement", "/admin/viewsPage/home.jsp", null));
		pageRoute.put(PageType.LOGIN_MANAGEMENT_PAGE, new PageInfo("loginManagement", "/admin/usersPage/loginAdmin.jsp", null));
		pageRoute.put(PageType.INDEX_MANAGEMENT_PAGE, new PageInfo("IndexManagement", "/admin/viewsPage/home.jsp", null));
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("UserManagement", "/admin/viewsPage/user.jsp", null));
		pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("ReportsManagement", "/admin/viewsPage/report.jsp", null));
		pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("VideoManagement", "/admin/viewsPage/video.jsp", null));
		
		pageRoute.put(PageType.SITE_SHAREVIDEO_PAGE, new PageInfo("SHAREPAGE", "/sites/viewsPage/shareMail.jsp", null));
		pageRoute.put(PageType.SITE_CHANGEPASSWORD_PAGE, new PageInfo("Changepage", "/sites/viewsPage/changepassword.jsp", null));
		pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("loginpage", "/sites/usersPage/login.jsp", null));
		pageRoute.put(PageType.SITE_REGISTER_PAGE, new PageInfo("Registerpage", "/sites/usersPage/register.jsp", null));
		pageRoute.put(PageType.SITE_DETAIL_PAGE, new PageInfo("Detailpage", "/sites/viewsPage/detail.jsp", null));
		pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Homepage", "/sites/viewsPage/home.jsp", null));
		pageRoute.put(PageType.SITE_FAVORITES_PAGE, new PageInfo("Favoritespage", "/sites/viewsPage/Favorite.jsp", null));
		pageRoute.put(PageType.SITE_FORGOTPASS_PAGE, new PageInfo("FogotPasspage", "/sites/viewsPage/Forgotpassword.jsp", null));
		pageRoute.put(PageType.SITE_UPDATEACCOUNT_PAGE, new PageInfo("UpdateAcountpage", "/sites/viewsPage/Updateaccount.jsp", null));
	}
	
	public static void prepareAndForward(HttpServletRequest request, HttpServletResponse response, PageType pagetype)
	throws SecurityException, IOException, ServletException{
		PageInfo page = pageRoute.get(pagetype);
		
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}
	
	public static void prepareAndForwardSite(HttpServletRequest request, HttpServletResponse response, PageType pagetype)
	throws SecurityException, IOException, ServletException{
		PageInfo page = pageRoute.get(pagetype);
		
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/sites/index.jsp").forward(request, response);
	}
	
	private String title;
	private String contentUrl;
	private String  scriptUrl;
	
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
}
