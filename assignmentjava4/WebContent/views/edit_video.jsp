<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Video</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://code.jquery.com/jquery-3.3.1.slim.min.js">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap"
	rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-expand-sm sticky-top header-colors ">
		<div class="col-3">
			<a class="navbar-brand" href="#"><img id="logo"
				class="d-inline-block mr-1" alt="Logo" src="/image/youtube.png">
				<span>Youtubi</span></a>
		</div>
		<div class="col-6">
			<div class="collapse navbar-collapse" id="collapsibleNavId">
				<form class="form-inline my-2 my-lg-0">
					<div class="input-group" style="width: 700px;">
						<input type="text" placeholder="What're you searching for?"
							aria-describedby="button-addon5" class="form-control">
						<div class="input-group-append">
							<button id="button-addon5" type="submit"
								class=" btn btn-primary  button-not-shadow" button-not-shaodow>
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>

				</form>
			</div>
		</div>
		<div class="col-3">
			<button type="button"
				class="btn btn-outline-success float-right mr-2">Home</button>
			<div class="dropdown  float-right  mr-2">
				<button class="btn btn-outline-success " type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Video</button>
				<div class="dropdown-menu dropdown-menu-right "
					aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="#">Edit Video</a> <a
						class="dropdown-item" href="#">List Videos</a>

				</div>
			</div>
			<div class="dropdown  float-right  mr-2">
				<button class="btn btn-outline-success " type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">User</button>
				<div class="dropdown-menu dropdown-menu-right "
					aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="#">Edit User</a> <a
						class="dropdown-item" href="#">List Users</a>

				</div>
			</div>
			<div class="dropdown  float-right  mr-2">
				<button class="btn btn-outline-success " type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Reports</button>
				<div class="dropdown-menu dropdown-menu-right "
					aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="#">Favorites</a> <a
						class="dropdown-item" href="#">Favorites Users</a> <a
						class="dropdown-item" href="#">Shared friends</a>
				</div>
			</div>
		</div>
	</nav>
	<div class="row w-100 mt-5 justify-content-center">
		<div class="col-2"></div>
		<div class="col-8 rounded bg-white mt-5">
			<div class="row">
				<div class="col-md-4 border-right">
					<div
						class="d-flex flex-column align-items-center text-center p-3 py-5">
						<img class="img-thumbnail mt-5" src="/image/youtube.png"
							width="400">
					</div>
				</div>
				<div class="col-md-8">
					<div class="p-3 py-5">
						<div
							class="d-flex justify-content-between align-items-center mb-3">

							<h6 class="text-right">Edit Profile</h6>
						</div>
						<div class="row mt-2">
							<div class=" col-md-12 inputs px-4">
								<h6 class="text-uppercase">Youtube Id</h6>
								<input type="text" class="form-control" placeholder="Id"
									value="${video.id}">
							</div>
						</div>
						<div class="row mt-3">
							<div class=" col-md-12 inputs px-4">
								<h6 class="text-uppercase">Video Title</h6>
								<input type="text" class="form-control" placeholder="Title"
									value="${video.title}">
							</div>
						</div>
						<div class="row mt-3">
							<div class=" col-md-12 inputs px-4">
								<h6 class="text-uppercase">View Count</h6>
								<input type="text" class="form-control" placeholder="View count"
									value="${video.views}">
							</div>
						</div>
						<div class="row mt-3">
							<div class=" col-md-12 inputs px-4">
								<input class="form-check-inline" (${video.active}?cheked :'')
									style="top: 0.1rem !important; left: -2rem !important; width: 1.1rem !important; height: 1.1rem !important;"
									type="checkbox" value="" id="defaultCheck1"> <label
									class="form-check-label ml-n3 "
									style="font-size: 20px !important;" for="defaultCheck1">
									Active </label> <input class="form-check-inline ml-3 " (${video.active}?'' :check)
									style="top: 0.1rem !important; left: -2rem !important; width: 1.1rem !important; height: 1.1rem !important;"
									type="checkbox" value="" id="defaultCheck1"> <label
									class="form-check-label ml-n3"
									style="font-size: 20px !important;" for="defaultCheck1">
									Inactive </label>
							</div>
						</div>
						<div class="row mt-3">
							<div class=" col-md-12 inputs px-4">
								<h6 class="text-uppercase">Description</h6>
								<textarea rows="4" class="form-control" placeholder="Description"
									value="${video.description}"></textarea>
							</div>
						</div>
						<div class="mt-5 text-right">
							<button class="btn btn-primary profile-button" type="button">Save
								Profile</button>
							<button class="btn btn-danger profile-button" type="button">Delete</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2"></div>
	</div>
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
</body>

</html>
</body>
</html>