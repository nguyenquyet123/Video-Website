<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-11">
	<form action="/OE/Admin/Detail" method="post">
		<input type="hidden" name="videoId" value="${videoInfor.videoId }">
		<div class="row">
			<div class="col-md-9" style="border: none;">
				<div class="card col-md-12" style="border: none;">
					<div class="card-body" style="border: none;">
						<div class="embed-responsive embed-responsive-16by9"
							style="width: 750px; margin-left: 2px;">
							<iframe class="embed-responsive-item"
								src="https://www.youtube.com/embed/${videoInfor.getHref() }"
								allowfullscreen></iframe>
						</div>
					</div>
					<div class="card-footer"
						style="border: none; background-color: white; margin: none;">
						<jsp:include page="/commom/inform.jsp"></jsp:include>
						<button type="submit" class="btn btn-info" formaction="/OE/Admin/Detail/islike">Like</button>
						<button type="submit" class="btn btn-info" formaction="/OE/Admin/Detail/share">Share</button>
						<%-- 						<a href="Detail?action=like&idVideo=${videoInfor.getVideoId()}" class="btn btn-primary">Like</a>		
						<a href="<%=request.getContextPath()%>/ShareVideo?videoid=${videoInfor.getVideoId()}" class="btn btn-primary" class="btn btn-secondary">Share</a> --%>
						<h5 class="card-title">${videoInfor.getTitle() }</h5>
						<p>${videoInfor.getDescription() }</p>
						<p class="card-text">${videoInfor.getViews() }&nbspviews</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<c:forEach var="item" items="${items }">
					<div class="row">
						<div class="card flex-row"
							style="border: none; width: 350px; padding: none;">
							<div class="card-body" style="border: none;">
								<div class="embed-responsive embed-responsive-16by9"
									style="width: 180px;">
									<iframe class="embed-responsive-item"
										src="https://www.youtube.com/embed/${item.getHref() }"
										allowfullscreen></iframe>
								</div>
							</div>
							<div class="card-footer"
								style="border: none; background-color: white; margin: none;">
								<h5 class="card-title">${item.getTitle() }</h5>
								<p class="card-text">${item.getViews() }</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</form>
</div>
<!-- ----------------------------------------------- -->
<div class="col-md-1"></div>