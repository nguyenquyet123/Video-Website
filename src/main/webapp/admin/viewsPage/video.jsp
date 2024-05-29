<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-9">
	<ul class="nav nav-tabs" id="myTabs">
		<li class="nav-item"><a class="nav-link active" id="tab1-tab"
			data-toggle="tab" href="#tab1">Video Edittion</a></li>
		<li class="nav-item"><a class="nav-link" id="tab2-tab"
			data-toggle="tab" href="#tab2">Video List</a></li>
	</ul>

	<div class="tab-content mt-2">
		<div class="tab-pane fade show active" id="tab1">
			<form action="/OE/Admin/VideosServlet" method="post"
				enctype="multipart/data">
				<div class="card flex-row" style="border: none;">
					<div
						class="card-header col-md-4 d-flex flex-column justify-content-center"
						style="border: none; background-color: white;">
						<img src="${video.getPoster() }" alt="" width="250px"
							height="200px" style="margin-top: 50px;">
						<!-- 						<div class="custom-file">
							<input type="file" class="custom-file-input" name="cover"
								id="cover"> <label for="cover" class="custom-file-label"
								for="customFile">Choose file</label>
						</div> -->
					</div>
					<div class="card-body col-md-8">
						<jsp:include page="/commom/inform.jsp"></jsp:include>

						<div class="form-group">
							<label for="my-input">VideoID</label> <input id="my-input"
								class="form-control" type="text" name="videoId"
								value="${video.videoId }" placeholder="VideoId" required>
						</div>
						<div class="form-group">
							<label for="my-input">IDVideoYoutube</label> <input id="my-input"
								value="${video.href }" class="form-control" type="text"
								name="href" placeholder="IDVideoYoutube" required>
						</div>
						<div class="form-group">
							<label for="my-input">IDPoster</label> <input id="my-input"
								value="${video.poster }" class="form-control" type="text"
								name="poster" placeholder="IDVideoYoutube" required>
						</div>
						<div class="form-group">
							<label for="my-input">VideoTitle</label> <input id="my-input"
								value="${video.title }" class="form-control" type="text"
								name="title" placeholder="VideoTitle" required>
						</div>
						<div class="form-group">
							<label for="my-input">ViewsCount</label> <input id="my-input"
								value="${video.views }" class="form-control" type="text"
								name="views" placeholder="VideoViews" required>
						</div>
						<div class="form-check">
							<label class="form-check-label" style="margin-right: 50px;">
								<input type="radio" class="form-check-input" id="status"
								name="active" ${video.active? 'checked': '' } value="true">
								Active
							</label> <label class="form-check-label"> <input type="radio"
								class="form-check-input" id="status" name="active" value="false"
								${ ! video.active? 'checked': '' }> Inactive
							</label>
						</div>

					</div>
				</div>
				<div class="card" style="border: none;">
					<div class="card-body">
						<div class="form-group">
							<label for="exampleFormControlTextarea1">Example textarea</label>
							<textarea class="form-control" id="exampleFormControlTextarea1"
								name="description" rows="3"></textarea>
						</div>
					</div>
					<div class="card-footer d-flex justify-content-end"
						style="background-color: white; border: none;">
						<button type="submit" formaction="/OE/Admin/VideosServlet/create"
							class="btn btn-info" style="margin-right: 10px;">Create</button>
						<button type="submit" class="btn btn-info"
							formaction="/OE/Admin/VideosServlet/update"
							style="margin-right: 10px;">Update</button>
						<button type="submit" class="btn btn-info"
							formaction="/OE/Admin/VideosServlet/delete"
							style="margin-right: 10px;">Delete</button>
						<button type="submit" class="btn btn-info"
							formaction="/OE/Admin/VideosServlet/reset"
							style="margin-right: 10px;">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="tab2" style="margin-top: none">
			<!-- Table content for Tab 2 -->
			<table class="table table-light">
				<thead>
					<tr>
						<th>Youtube ID</th>
						<th>Video Title</th>
						<th>View Count</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<tbody>
					<c:forEach var="item" items="${vlist }">
						<tr>
							<td>${item.getHref() }</td>
							<td>${item.getTitle() }</td>
							<td>${item.getViews() }</td>
							<td>${item.getActive()?'Active':'Inactive' }</td>
							<td><a
								href="<%=request.getContextPath()%>/Admin/VideosServlet/edit?videoId=${item.getVideoId()}">Edit</a></td>
						</tr>
					</c:forEach>
					<!-- Add more rows as needed -->
				</tbody>
				</tbody>
			</table>
			<nav class="navbar navbar-expand-lg navbar-light bg-white mx-auto">
				<div class="container">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><a class="nav-link" href="#page1"><button
									type="button" class="btn btn-info">|<</button></a></li>
						<li class="nav-item"><a class="nav-link" href="#page2"><button
									type="button" class="btn btn-info"><<</button></a></li>
						<li class="nav-item"><a class="nav-link" href="#page3"><button
									type="button" class="btn btn-info">>></button></a></li>
						<li class="nav-item"><a class="nav-link" href="#page4"><button
									type="button" class="btn btn-info">>|</button></a></li>
						<li class="nav-item"><a class="nav-link" href="#page4"><Strong>Size:
							</Strong></a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</div>
<!-- ----------------------------------------------- -->
<div class="col-md-4"></div>