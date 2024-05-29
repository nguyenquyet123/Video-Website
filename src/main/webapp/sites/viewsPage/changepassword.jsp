<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-10">
	<div class="card" style="background-color: white; border: none;">
		<div class="card-header"
			style="background-color: white; border: none;">
			<strong><h1>Password retrieval</h1></strong>
		</div>
		<div class="card-body" style="background-color: white; border: none;">
			<form action="/OE/Change" method="post">
				<jsp:include page="/commom/inform.jsp"></jsp:include>
				<div class="form-group">
					<label for="my-input">Username</label> <input id="my-input"
						class="form-control" type="text" name="username" value="${username }"
						placeholder="Username" required>
				</div>
				<div class="form-group">
					<label for="my-input">Password</label> <input id="my-input" 
						class="form-control" type="password" name="password"
						placeholder="Password" required>
				</div>
				<div class="form-group">
					<label for="my-input">Current Password</label> <input id="my-input"
						class="form-control" type="password" name="currentPassword"
						placeholder="Current Password" required>
				</div>
				<div class="form-group">
					<label for="my-input">Confirm Password</label> <input id="my-input"
						class="form-control" type="password" name="confirmPassword"
						placeholder="Confirm Password" required>
				</div>
				<button type="submit" class="btn btn-primary">Change</button>
			</form>
		</div>
	</div>
</div>