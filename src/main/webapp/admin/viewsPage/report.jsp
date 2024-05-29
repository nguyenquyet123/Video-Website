<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-9">
	<ul class="nav nav-tabs" id="myTabs" role="tablist">
		<li class="nav-item"><a class="nav-link ${selectedTab eq 'videoEditing' ? 'active' : ''}"
			id="videoEditing-tab" data-toggle="tab" href="#videoEditing">Favorites</a></li>
		<li class="nav-item"><a class="nav-link ${selectedTab eq 'videolist' ? 'active' : ''}" id="videolist-tab"
			data-toggle="tab" href="#videolist">Favorite user</a></li>
		<li class="nav-item"><a class="nav-link ${selectedTab eq 'tab3' ? 'active' : ''}" id="tab2-tab"
			data-toggle="tab" href="#tab3">Shares friends</a></li>
	</ul>

	<div class="tab-content mt-2">
		<div class="tab-pane fade ${showTab eq 'videoEditing' ? 'show active' : ''}" id="videoEditing">
			<table class="table table-light">
				<thead>
					<tr>
						<th>Video Title</th>
						<th>Favorite Count</th>
						<th>Lated date</th>
						<th>Oldest date</th>
					</tr>
				</thead>
				<c:forEach var="item" items="${favlist }">
					<tbody>
						<tr>
							<td>${item.getVideoTitle() }</td>
							<td>${item.getFavoriteCount() }</td>
							<td>${item.getNewestDate() }</td>
							<td>${item.getOldestDate() }</td>
						</tr>
						<!-- Add more rows as needed -->
					</tbody>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade ${selectedTab eq 'videolist' ? 'show active' : ''}" id="videolist" role="tabpanel">
			<!-- Table content for Tab 2 -->
			<form action="/OE/Report" method="get">
				<div>
					<div class="input-group" style="width: 500px; margin-left: 200px;">
						<div class="input-group-prepend">
							<span class="input-group-text"
								style="border: none; background-color: white;">Video
								Title?</span>
						</div>
						<select name="videoUserId" id="videoUserId"
							class="form-control ml-3">
							<c:forEach var="item" items="${vidList }">
								<option value="${item.videoId }"
									${item.videoId == videoUserId?'selected':''}>
									${item.title }</option>
							</c:forEach>
						</select>
						<div class="input-group-append">
							<button type="submit" class="btn btn-info ml-3" formaction="/OE/taps2">Serch</button>
						</div>
					</div>
				</div>
				<table class="table table-light">
					<thead>
						<tr>
							<th>Username</th>
							<th>Fullname</th>
							<th>Email</th>
							<th>Favorite date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${favUsers }">
							<tr>
								<td>${item.getUsername() }</td>
								<td>${item.getFullname() }</td>
								<td>${item.getEmail() }</td>
								<td>${item.getLikeDate() }</td>
							</tr>
						</c:forEach>
						<!-- Add more rows as needed -->
					</tbody>
				</table>
			</form>
		</div>
		<div class="tab-pane fade ${selectedTab eq 'tab3' ? 'show active' : ''}" id="tab3" role="tabpanel">
			<!-- Table content for Tab 2 -->
			<div>
				<div class="input-group" style="width: 500px; margin-left: 200px;">
					<div class="input-group-prepend">
						<span class="input-group-text"
							style="border: none; background-color: white;">Video
							Title?</span>
					</div>
					<input class="form-control" type="search" name=""
						placeholder="Recipient's text" aria-label="Recipient's text">
					<div class="input-group-append">
						<button class="input-group-text">Tìm kiếm</button>
					</div>
				</div>
			</div>
			<table class="table table-light">
				<thead>
					<tr>
						<th>Sender name</th>
						<th>Sender email</th>
						<th>Receiver email</th>
						<th>Sent date</th>
					</tr>
				</thead>
				<tbody>
				<tbody>
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
					</tr>
					<!-- Add more rows as needed -->
				</tbody>
				</tbody>
			</table>

		</div>
	</div>
</div>

<!-- ----------------------------------------------- -->
<div class="col-md-4"></div>