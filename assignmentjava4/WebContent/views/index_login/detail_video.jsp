<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="row w-100 mt-4 mr-0">
	<div class="col-8 ml-5 pr-0">
		<div class="row w-100 mx-0">
			<div class="float-right " style="width: 95%">
				<div class="embed-responsive embed-responsive-16by9">
					<iframe class="embed-responsive-item"
						src="https://www.youtube.com/embed/v64KOxKVLVg" allowfullscreen></iframe>
				</div>
				<div class="card-body">
					<div class="row">
						<h5 class="card-title">${videodetail.title}</h5>
						</a>
					</div>
					<div class="row">
						<div class="col-6 px-0">
							<p class="card-text " style="font-size: 16px;">${videodetail.views}
								lượt xem • Đã công chiếu vào 30 thg 11, 2020</p>
						</div>
						<div class="col-6 float-right">
							<button type="button"
								class="btn btn-outline-primary float-right ">
								<i class="fa fa-share pr-2" style="font-size: 24px"></i>Chia sẽ
							</button>
							<a type="button" href="likeServlet?id=${videodetail.id}"
								class="btn btn-outline-success ${likeEmpty} float-right mr-2">
								<i class="fa fa-thumbs-up pr-2" style="font-size: 24px"></i>
								<c:if test="${empty like}">${videodetail.like}</c:if>
								<c:if test="${not empty like}">0</c:if>
							</a>
						</div>
					</div>
					<hr class="solid">
					<div class="row">
						<div class="col-1">
							<a class="navbar-brand" href="#"><img id="logo"
								class="d-inline-block mr-1" alt="Logo"
								src="views/image/youtube.png"> </a>
						</div>
						<div class="col-10 ml-1">
							<div class="row mt-2">
								<h5 class="card-title">Lê Quý Nhẫn</h5>
							</div>
							<div class="row mt-n2">
								<p class="card-text " style="font-size: 13px;">8.55K
									subscribers</p>
							</div>
							<div class="row mt-4">
								<p class="card-title" style="font-size: 16px;">${videodetail.description}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-3 px-0">
		<c:forEach items="${videolist}" var="video1">
			<div class="row w-100 mr-0">
				<div class="float-left " style="width: 100%"></div>
				<div class="col-6 mx-0 px-0">
					<a href="openDetailVideo?id=${video1.id}" class="d-block mb-4 h-100"> <img
						class="img-fluid img-thumbnail" src="files/${video1.poster}"
						alt="">
					</a>
				</div>
				<div class="col-6 py-0">
					<a href="openDetailVideo?id=${video1.id}">
						<div class="card-body py-0 pr-0">
							<div class="row">
								<h5 class="card-title" style="font-size: 16px;">${video1.title}</h5>
								<div class="w-100"></div>
								<p class="card-text " style="font-size: 14px;">
									Lê Quý Nhẫn<br>${video1.views} lượt xem <br>1 ngày
									trước
								</p>
							</div>
						</div>
					</a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
