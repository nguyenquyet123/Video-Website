<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-10">
	<div class="card" style="background-color: white; border: none;">
		<div class="card-header"
			style="background-color: white; border: none;">
			<strong><h1>LogIn</h1></strong>
		</div>
		<div class="card-body" style="background-color: white; border: none;">
			<jsp:include page="/commom/inform.jsp"></jsp:include>
			<form action="/OE/Login" method="post">
				<div class="form-group">
					<label for="my-input">Username</label> <input id="my-input"
						class="form-control" type="text" name="username"
						placeholder="Enter account name" required>
				</div>
				<div class="form-group">
					<label for="my-input">Password</label> <input id="my-input"
						class="form-control" type="password" name="password"
						placeholder="Enter account name" required>
				</div>
				<div class="form-check">
					<input id="my-input" class="form-check-input" type="checkbox"
						name="remember" value="true" checked> <label for="my-input"
						class="form-check-label">Remember me?</label>
				</div>
				<button type="submit" class="btn btn-primary"
					style="margin-top: 10px;">Login</button>
			</form>
		</div>
	</div>
</div>