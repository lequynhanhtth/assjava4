<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://code.jquery.com/jquery-3.3.1.slim.min.js">
<link rel="stylesheet" href="views/css/style.css">
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
				class="d-inline-block mr-1" alt="Logo" src="views/image/youtube.png">
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
			<a type="button" href="indexServlet?actions=Login" class="btn btn-outline-success float-right">
				<i class="fa fa-user-circle pr-2" style="font-size: 25px"></i>Sign
				In
			</a>
			<a type="button"  href="indexServlet?actions=Login"   class="btn btn-outline-danger float-right mr-2">
				<i class="fa fa-user-plus pr-2 " style="font-size: 25px"></i>Sign Up
			</a>
		</div>
	</nav>
	<div class="row w-100 mt-4">
		<div class="col-2 "></div>
		<div class="col-8">
			<div id="video-carousel-example2"
				class="carousel slide carousel-fade" data-ride="carousel">
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
		<h5 class="card-title" style="font-size: 30px;">Top Video</h5>
	</div>
	<div class="row w-100 mt-2 align-items-start ">
		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="#"><img class="img-thumbnail img-fluid"
					src="/image/youtube.png"> </a>
				<div class="card-body">
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="#">
								<h5 class="card-title">Tage(Official Lyric Video)</h5>
								<p class="card-text">
									Tage M. <br>15tr lượt xem
								</p>
							</a>
						</div>
						<div
							class="row w-100 justify-content-center align-self-center mt-2">
							<button type="button"
								class="btn btn-outline-success float-right mr-2">
								<i class="fa fa-thumbs-up pr-2" style="font-size: 24px"></i>1N
							</button>
							<button type="button"
								class="btn btn-outline-primary float-right ">
								<i class="fa fa-share pr-2" style="font-size: 24px"></i>Chia sẽ
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="#"><img class="img-thumbnail img-fluid"
					src="/image/youtube.png"> </a>
				<div class="card-body">
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="#">
								<h5 class="card-title">Tage(Official Lyric Video)</h5>
								<p class="card-text">
									Tage M. <br>15tr lượt xem
								</p>
							</a>
						</div>
						<div
							class="row w-100 justify-content-center align-self-center mt-2">
							<button type="button"
								class="btn btn-outline-success float-right mr-2">
								<i class="fa fa-thumbs-up pr-2" style="font-size: 24px"></i>1N
							</button>
							<button type="button"
								class="btn btn-outline-primary float-right ">
								<i class="fa fa-share pr-2" style="font-size: 24px"></i>Chia sẽ
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="#"><img class="img-thumbnail img-fluid"
					src="/image/youtube.png"> </a>
				<div class="card-body">
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="#">
								<h5 class="card-title">Tage(Official Lyric Video)</h5>
								<p class="card-text">
									Tage M. <br>15tr lượt xem
								</p>
							</a>
						</div>
						<div
							class="row w-100 justify-content-center align-self-center mt-2">
							<button type="button"
								class="btn btn-outline-success float-right mr-2">
								<i class="fa fa-thumbs-up pr-2" style="font-size: 24px"></i>1N
							</button>
							<button type="button"
								class="btn btn-outline-primary float-right ">
								<i class="fa fa-share pr-2" style="font-size: 24px"></i>Chia sẽ
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="#"><img class="img-thumbnail img-fluid"
					src="/image/youtube.png"> </a>
				<div class="card-body">
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="#">
								<h5 class="card-title">Tage(Official Lyric Video)</h5>
								<p class="card-text">
									Tage M. <br>15tr lượt xem
								</p>
							</a>
						</div>
						<div
							class="row w-100 justify-content-center align-self-center mt-2">
							<button type="button"
								class="btn btn-outline-success float-right mr-2">
								<i class="fa fa-thumbs-up pr-2" style="font-size: 24px"></i>1N
							</button>
							<button type="button"
								class="btn btn-outline-primary float-right ">
								<i class="fa fa-share pr-2" style="font-size: 24px"></i>Chia sẽ
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="row w-100 mt-2 align-items-start ">
		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="#"><img class="img-thumbnail img-fluid"
					src="/image/youtube.png"> </a>
				<div class="card-body">
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="#">
								<h5 class="card-title">Tage(Official Lyric Video)</h5>
								<p class="card-text">
									Tage M. <br>15tr lượt xem
								</p>
							</a>
						</div>
						<div
							class="row w-100 justify-content-center align-self-center mt-2">
							<button type="button"
								class="btn btn-outline-success float-right mr-2">
								<i class="fa fa-thumbs-up pr-2" style="font-size: 24px"></i>1N
							</button>
							<button type="button"
								class="btn btn-outline-primary float-right ">
								<i class="fa fa-share pr-2" style="font-size: 24px"></i>Chia sẽ
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="#"><img class="img-thumbnail img-fluid"
					src="/image/youtube.png"> </a>
				<div class="card-body">
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="#">
								<h5 class="card-title">Tage(Official Lyric Video)</h5>
								<p class="card-text">
									Tage M. <br>15tr lượt xem
								</p>
							</a>
						</div>
						<div
							class="row w-100 justify-content-center align-self-center mt-2">
							<button type="button"
								class="btn btn-outline-success float-right mr-2">
								<i class="fa fa-thumbs-up pr-2" style="font-size: 24px"></i>1N
							</button>
							<button type="button"
								class="btn btn-outline-primary float-right ">
								<i class="fa fa-share pr-2" style="font-size: 24px"></i>Chia sẽ
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="#"><img class="img-thumbnail img-fluid"
					src="/image/youtube.png"> </a>
				<div class="card-body">
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="#">
								<h5 class="card-title">Tage(Official Lyric Video)</h5>
								<p class="card-text">
									Tage M. <br>15tr lượt xem
								</p>
							</a>
						</div>
						<div
							class="row w-100 justify-content-center align-self-center mt-2">
							<button type="button"
								class="btn btn-outline-success float-right mr-2">
								<i class="fa fa-thumbs-up pr-2" style="font-size: 24px"></i>1N
							</button>
							<button type="button"
								class="btn btn-outline-primary float-right ">
								<i class="fa fa-share pr-2" style="font-size: 24px"></i>Chia sẽ
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-3  ">
			<div class="float-right  " style="width: 95%">
				<a href="#"><img class="img-thumbnail img-fluid"
					src="/image/youtube.png"> </a>
				<div class="card-body">
					<div class="row">
						<div class="col-2 float-left pl-0">
							<a class="navbar-brand " href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo" src="/image/youtube.png"></a>
						</div>
						<div class="col-10 pr-0">
							<a href="#">
								<h5 class="card-title">Tage(Official Lyric Video)</h5>
								<p class="card-text">
									Tage M. <br>15tr lượt xem
								</p>
							</a>
						</div>
						<div
							class="row w-100 justify-content-center align-self-center mt-2">
							<button type="button"
								class="btn btn-outline-success float-right mr-2">
								<i class="fa fa-thumbs-up pr-2" style="font-size: 24px"></i>1N
							</button>
							<button type="button"
								class="btn btn-outline-primary float-right ">
								<i class="fa fa-share pr-2" style="font-size: 24px"></i>Chia sẽ
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<hr class="solid">
	<div class="row w-100 justify-content-center align-self-center">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a
					class="btn btn-outline-info m-1 active" href="#">1</a></li>
				<li class="page-item"><a class="btn btn-outline-info m-1"
					href="#">2</a></li>
				<li class="page-item"><a class="btn btn-outline-info m-1"
					href="#">3</a></li>
			</ul>
		</nav>
	</div>
	<div class="row w-100 justify-content-center align-self-center">

		<button type="button" class="btn btn-outline-info m-1">First</button>
		<button type="button" class="btn btn-outline-info m-1">Previous</button>
		<button type="button" class="btn btn-outline-info m-1">Next</button>
		<button type="button" class="btn btn-outline-info m-1">Last</button>
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

</body>

</html>