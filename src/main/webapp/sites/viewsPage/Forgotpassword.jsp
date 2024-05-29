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
			<form action="">
				<div class="form-group">
					<label for="my-input">Accountname</label> <input id="my-input"
						class="form-control" type="text" name=""
						placeholder="Enter account name">
				</div>
				<div class="form-group">
					<label for="my-input">Email</label> <input id="my-input"
						class="form-control" type="email" name=""
						placeholder="Enter email">
				</div>
				<button type="button" class="btn btn-primary">Retrive</button>
			</form>
		</div>
	</div>
</div>