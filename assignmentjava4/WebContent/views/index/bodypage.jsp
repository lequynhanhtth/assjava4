<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="row w-100 mt-4">
	<div class="col-2 "></div>
	<div class="col-8">
		<div id="video-carousel-example2" class="carousel slide carousel-fade"
			data-ride="carousel">
			<!--Indicators-->
			<ol class="carousel-indicators">
				<li data-target="#video-carousel-example2" data-slide-to="0"
					class="active"></li>
				<li data-target="#video-carousel-example2" data-slide-to="1"></li>
				<li data-target="#video-carousel-example2" data-slide-to="2"></li>
			</ol>
			<!--/.Indicators-->
			<!--Slides-->
			<div class="carousel-inner" role="listbox">
				<!-- First slide -->
				<div class="carousel-item active">
					<!--Mask color-->
					<div class="view">
						<!--Video source-->
						<div class="embed-responsive embed-responsive-16by9">
							<iframe class="embed-responsive-item"
								src="https://www.youtube.com/embed/v64KOxKVLVg" allowfullscreen></iframe>
						</div>
					</div>

					<!--Caption-->
					<div class="carousel-caption">
						<div class="animated fadeInDown">
							<h3 class="h3-responsive">Light mask</h3>
						</div>
					</div>
					<!--Caption-->
				</div>
				<!-- /.First slide -->

				<!-- Second slide -->
				<div class="carousel-item">
					<!--Mask color-->
					<div class="view">
						<!--Video source-->
						<div class="embed-responsive embed-responsive-16by9">
							<iframe class="embed-responsive-item"
								src="https://www.youtube.com/embed/v64KOxKVLVg" allowfullscreen></iframe>
						</div>
					</div>

					<!--Caption-->
					<div class="carousel-caption">
						<div class="animated fadeInDown">
							<h3 class="h3-responsive">Super light mask</h3>
						</div>
					</div>
					<!--Caption-->
				</div>
				<!-- /.Second slide -->

				<!-- Third slide -->
				<div class="carousel-item">
					<!--Mask color-->
					<div class="view">
						<!--Video source-->
						<div class="embed-responsive embed-responsive-16by9">
							<iframe class="embed-responsive-item"
								src="https://www.youtube.com/embed/YDzv0GC1SfI" allowfullscreen></iframe>
						</div>
					</div>

					<!--Caption-->
					<div class="carousel-caption">
						<div class="animated fadeInDown">
							<h3 class="h3-responsive">Strong mask</h3>
						</div>
					</div>
					<!--Caption-->
				</div>
				<!-- /.Third slide -->
			</div>
			<!--/.Slides-->
			<!--Controls-->
			<a class="carousel-control-prev" href="#video-carousel-example2"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#video-carousel-example2"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
			<!--/.Controls-->
		</div>
	</div>
	<div class="col-2"></div>
</div>
<div class="row w-100 mt-5 align-items-start pl-5 mr-0 mb-0 ">
	<h5 class="card-title" style="font-size: 30px;">Video</h5>
</div>
<div class="row w-100 mt-2 align-items-start ">
	<c:forEach items="${listvideo1}" var="video1">
		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="opendetail?id=${video1.id}"><img class="img-thumbnail img-fluid"
					src="files/${video1.poster}"> </a>
				<div class="card-body">
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="views/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="opendetail?id=${video1.id}">
								<h5 class="card-title">${video1.title}</h5>
								<p class="card-text">
									LAL <br>${video1.views} Lượt xem
								</p>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

	</c:forEach>
</div>
<div class="row w-100 mt-2 align-items-start ">
	<c:forEach items="${listvideo2}" var="video2">

		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="opendetail?id=${video2.id}"><img class="img-thumbnail img-fluid"
					src="files/${video2.poster}"> </a>
				<div class="card-body"> 
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="views/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="#">
								<h5 class="card-title">${video2.title}</h5>
								<p class="card-text">
									LAL <br>${video2.views}  Lượt xem
								</p>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

	</c:forEach>
</div>
<div class="row w-100 mt-2 align-items-start ">
	<c:forEach items="${listvideo3}" var="video3">
		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="opendetail?id=${video3.id}"><img class="img-thumbnail img-fluid"
					src="files/${video3.poster}"> </a>
				<div class="card-body">
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="views/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="#">
								<h5 class="card-title">${video3.title}</h5>
								<p class="card-text">
									LQN <br>${video3.views} Lượt xem
								</p>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<hr class="solid">
<div class="row w-100 justify-content-center align-self-center">
	<nav aria-label="Page navigation example">
		<ul class="pagination">
		<c:forEach items="${countPage}" var="count">
		<li class="page-item"><a class="btn btn-outline-info m-1 ${not empty countSelect ? 'active' : '' } "
				href="#">${count}</a></li>
		</c:forEach>
		</ul>
	</nav>
</div>
<div class="row w-100 justify-content-center align-self-center">

	<button type="button" class="btn btn-outline-info m-1">First</button>
	<button type="button" class="btn btn-outline-info m-1">Previous</button>
	<button type="button" class="btn btn-outline-info m-1">Next</button>
	<button type="button" class="btn btn-outline-info m-1">Last</button>
</div>