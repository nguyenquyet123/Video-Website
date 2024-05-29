<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-11">

	<div class="row">
		<c:forEach var="item" items="${vlist }">
			<div class="card col-md-4" style="border: none;">
				<div class="card-body" style="border: none;">
					<div class="embed-responsive embed-responsive-16by9">
						<iframe class="embed-responsive-item"
							src="https://www.youtube.com/embed/${item.getHref()}" allowfullscreen></iframe>
					</div>
				</div>
				<div class="card-footer"
					style="border: none; background-color: white; margin: none;">
					<a
						href="<%=request.getContextPath()%>/Admin/Detail?action=wath&idVideo=${item.getVideoId()}">
						<h5 class="card-title">${item.getTitle() }</h5>
					</a>
					<p class="card-text">${item.getViews() }&nbspviews</p>
				</div>
			</div>
		</c:forEach>

	</div>
</div>
<!-- ----------------------------------------------- -->
<%-- <div class="col-md-1"></div>
<nav class="navbar navbar-expand-lg navbar-light bg-white mx-auto">
	<div class="container">
		<ul class="navbar-nav mr-auto" style="margin-left: 350px;">
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/Homepage?action=first&page=1">
					<button type="button" class="btn btn-info">|<</button>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/Homepage?action=prev&page=${currentPage - 1}">
					<button type="button" class="btn btn-info"><<</button>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/Homepage?action=next&page=${currentPage + 1}">
					<button type="button" class="btn btn-info">>></button>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/Homepage?action=last&page=${totalPages}">
					<button type="button" class="btn btn-info">>|</button>
			</a></li>
		</ul>
	</div>
</nav> --%>