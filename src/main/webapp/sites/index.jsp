<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<title>${page.title}</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/OE/">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="./vstyle.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.min.js"></script>
<script src="./myApp.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"> -->
</head>
<body>
	<div class="container-fluid">

		<!-- phần đầu ------------------------------------------------->
		<div class="row">
			<nav class="navbar navbar-light bg-white col-md-12">
				<a class="navbar-brand"><i class="fa-solid fa-video"
					style="color: darkgoldenrod; font-size: 30px; margin-left: 20px;">OE</i></a>
				<form class="form-inline mx-auto">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search" style="width: 400px;">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
						style="width: 100px;">Search</button>
				</form>
				<form class="form-inline">
					<a href="Login">
						<button class="btn btn-outline-success" type="button"
							style="width: 100px; margin-right: 20px;">Login</button>
					</a> <a href="Register">
						<button class="btn btn-outline-success" type="button"
							style="width: 100px;">Register</button>
					</a>
				</form>
			</nav>
		</div>
		<!-- ---------------------------------------------------------- -->

		<!-- Phần thân --------------------------------------------------->
		<div class="row">
			<!--  Thanh chức năng dọc------------------------------>
			<div class="col-md-2">
				<div class="card-textfa-pull-left" style="background-color: white;">
					<div class="card-header item-border"
						style="background-color: white; border: none;">
						<span class="glyphicon glyphicon-list-alt"></span> <Strong
							style="font-size: 30px; color: darkgoldenrod;"><i
							class="fa-solid fa-list"></i></Strong>
					</div>
					<ul class="list-group list-group-flush" id="cungcap"
						style="background-color: white; border: none;">
						<li class="list-group-item border-0"><a href="Homepage"><i
								class="fa-solid fa-house">Home</i></a></li>
						<c:if test="${ isLogin }">
							<li class="list-group-item border-0"><a href="Favorites"><i
									class="fa-solid fa-star">Favorites</i></a></li>
							<li class="list-group-item border-0" data-toggle="collapse"
								href="#danhmuc"><i class="fa-solid fa-shield"
								style="color: blueviolet;">Security</i></li>
							<ul class="list-group list-group-flush collapse" id="danhmuc"
								style="background-color: white; border: none;">
								<li class="list-group-item border-0"><a href="Forgot">Forgot
										password</a></li>
								<li class="list-group-item border-0"><a href="Update">Update
										account</a></li>
								<li class="list-group-item border-0"><a href="Change">Change
										password </a></li>
							</ul>
							<li class="list-group-item border-0"><a href="ShareVideo"><i
									class="fa-solid fa-share">ShareVideo</i></a></li>
							<li class="list-group-item border-0"><a href="Logoff"><i
									class="fa-solid fa-right-from-bracket">LogOff</i></a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<!--  ---------------------------------------------------->
			<!-- Phần sản phẩm ----------------------------->
			<div class="col-md-10">
				<jsp:include page="${page.contentUrl}"></jsp:include>
			</div>
		</div>

		<!--  ------------------------------------------------------>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<c:if test="${not empty page.scriptUrl}">
		<jsp:include page="${page.scriptUrl }"></jsp:include>
	</c:if>

</body>
</html>