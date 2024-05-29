<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-10">
	<div class="card" style="background-color: white; border: none;">
		<div class="card-header"
			style="background-color: white; border: none;">
			<strong><h1>Update account information</h1></strong>
		</div>
		<div class="card-body" style="background-color: white; border: none;">
			<jsp:include page="/commom/inform.jsp"></jsp:include>
			<form action="/OE/Update" method="post">
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
						placeholder="Password" required>
				</div>
				<div class="form-group">
					<label for="my-input">Email</label> <input id="my-input"
						class="form-control" type="email" name="email" 
						value="${user.email }"
						placeholder="Enter email" required>
				</div>
				<button type="submit" class="btn btn-primary">Edit</button>
			</form>
		</div>
	</div>
</div>