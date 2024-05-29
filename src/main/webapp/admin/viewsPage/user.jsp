
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-9">

	<ul class="nav nav-tabs" id="myTabs">
		<li class="nav-item"><a class="nav-link active" id="tab1-tab"
			data-toggle="tab" href="#tab1">User Edittion</a></li>
		<li class="nav-item"><a class="nav-link" id="tab2-tab"
			data-toggle="tab" href="#tab2">User List</a></li>
	</ul>

	<div class="tab-content mt-2">
		<div class="tab-pane fade show active" id="tab1">
			<form action="/OE/Admin/Users" method="post">
				<jsp:include page="/commom/inform.jsp"></jsp:include>
				<div class="card" style="background-color: white; border: none;">
					<div class="card-header"
						style="background-color: white; border: none;">
						<strong><h1>Update account information</h1></strong>
					</div>
					<div class="card-body"
						style="background-color: white; border: none;">
						<div class="form-group">
							<label for="my-input">Username</label> <input id="my-input"
								class="form-control" type="text" name="username"
								value="${user.username }" placeholder="Username" required>
						</div>
						<div class="form-group">
							<label for="my-input">Fullname</label> <input id="my-input"
								class="form-control" type="text" name="fullname"
								value="${user.fullname }" placeholder="Fullname" required>
						</div>
						<div class="form-group">
							<label for="my-input">Password</label> <input id="my-input"
								class="form-control" type="password" name="password"
								value="${user.password }" placeholder="Password" required>
						</div>
						<div class="form-group">
							<label for="my-input">Email</label> <input id="my-input"
								class="form-control" type="email" name="email"
								value="${user.email }" placeholder="Enter email" required>
						</div>
					</div>
				</div>
				<div class="card" style="border: none;">
					<div class="card-footer d-flex justify-content-end"
						style="background-color: white; border: none;">
						<button type="submit" class="btn btn-info"
							formaction="/OE/Admin/User/update" style="margin-right: 10px;">Update</button>
						<button type="submit" class="btn btn-info"
							formaction="/OE/Admin/User/delete" style="margin-right: 10px;">Delete</button>
						<button type="submit" class="btn btn-info"
							formaction="/OE/Admin/User/reset" style="margin-right: 10px;">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="tab2">
			<!-- Table content for Tab 2 -->
			<table class="table table-light">
				<thead>
					<tr>
						<th>Username</th>
						<th>Password</th>
						<th>Fullname</th>
						<th>Email</th>
						<th>Role</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<tbody>
					<c:forEach var="item" items="${ulist }">
						<tr>
							<td>${item.getUsername() }</td>
							<td>${item.getPassword() }</td>
							<td>${item.getFullname() }</td>
							<td>${item.getEmail() }</td>
							<td>${item.getAdmin()?'Admin':'User' }</td>
							<td><a
								href="<%=request.getContextPath()%>/Admin/User/edit?username=${item.getUsername()}">Edit</a></td>
						</tr>
					</c:forEach>
					<!-- Add more rows as needed -->
				</tbody>
				</tbody>
			</table>
			<nav class="navbar navbar-expand-lg navbar-light bg-white mx-auto">
				<div class="container">
					<ul class="navbar-nav mr-auto ">
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