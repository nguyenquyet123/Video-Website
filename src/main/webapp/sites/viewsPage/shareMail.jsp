<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-10">
	<div class="card" style="background-color: white; border: none;">
		<div class="card-header"
			style="background-color: white; border: none;">
			<strong><h1>Share Video</h1></strong>
		</div>
		<div class="card-body" style="background-color: white; border: none;">
			<%-- <input type="hidden" name="videoInfor" value="${videoInfor }"> --%>
			<form action="/OE/ShareVideo" method="post">
				<div class="form-group">
					<label for="my-input">To</label> <input id="my-input"
						class="form-control" type="text" name="" placeholder="Enter Email">
				</div>
				<div class="form-group">
					<label for="my-input">Subject</label> <input id="my-input"
						class="form-control" type="text" name="href" value="${vid.getHref() }"
						placeholder="Enter Subject">
				</div>
				<div class="form-group">
					<label for="exampleFormControlTextarea1">Content</label>
					<textarea class="form-control" id="exampleFormControlTextarea1"
						name="description" rows="3" required></textarea>
				</div>
				<button type="button" class="btn btn-primary">Send</button>
			</form>
		</div>
	</div>
</div>