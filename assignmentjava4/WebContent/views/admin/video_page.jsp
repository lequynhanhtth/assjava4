<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container-fluid mt-3">
	<h2 style="color: white;">Quản lý người dùng</h2>
	<br>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a
			class="nav-link ${empty active ? 'active':''}" data-toggle="tab"
			href="#home">Thông tin Video</a></li>
		<li class="nav-item"><a
			class="nav-link ${not empty active ? 'active':''}" data-toggle="tab"
			href="#menu1">Danh sách Video</a></li>
	</ul>
	<div class="tab-content">
		<div id="home"
			class="container tab-pane ${empty active ? 'active':'fade'}">
			<br>
			<form>
				<div class="row">

					<div class="col-md-4 border-right">
						<div
							class="d-flex flex-column align-items-center text-center p-3 py-5">
							<img class="img-thumbnail mt-5" src="views/image/youtube.png"
								width="400">
						</div>
					</div>
					<div class="col-md-8">
						<div class="p-3 py-5" style="color: white;">
							<div
								class="d-flex justify-content-between align-items-center mb-3">
								<div class="alert alert-success" role="alert">${message}</div>
								<h6 class="text-right">Quản lý video</h6>
							</div>
							<div class="row mt-2">
								<div class=" col-md-12 inputs px-4">
									<h6 class="text-uppercase">Youtube Id</h6>
									<input type="text" class="form-control" name="id"
										readonly="readonly" placeholder="Id" value="${videodetail.id}">
								</div>
							</div>
							<div class="row mt-3">
								<div class=" col-md-12 inputs px-4">
									<h6 class="text-uppercase">Video Title</h6>
									<input type="text" class="form-control" name="title"
										placeholder="Title" value="${videodetail.title}">
								</div>
							</div>
							<div class="row mt-3">
								<div class=" col-md-12 inputs px-4">
									<h6 class="text-uppercase">View Count</h6>
									<input type="text" class="form-control" name="views"
										placeholder="View count" value="${videodetail.views}">
								</div>
							</div>
							<div class="row mt-3">
								<div class=" col-md-12 inputs px-4">
									<input class="form-check-inline" name="active"
										${videodetail.active == true ? 'checked' : ''}
										style="top: 0.1rem !important; left: -2rem !important; width: 1.1rem !important; height: 1.1rem !important;"
										type="checkbox" value="true" id="defaultCheck1"> <label
										class="form-check-label ml-n3 "
										style="font-size: 20px !important;" for="defaultCheck1">
										Active </label> <input class="form-check-inline ml-3 " name="active"
										${videodetail.active == true ? '' : 'checked'}
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
									<textarea rows="4" class="form-control" name="description"
										placeholder="Description">${videodetail.description}</textarea>
								</div>
							</div>
							<div class="mt-5 text-rigx1ht">
								<input class="btn btn-primary profile-button" name="actions"
									value="${newcr}" type="submit">
									<c:if test="${empty hide} ">
									 <input
									class="btn btn-primary profile-button " name="actions"
									value="Update" type="submit"> <input
									class="btn btn-danger profile-button " name="actions"
									value="Delete" type="submit">
									</c:if>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div id="menu1"
			class="container tab-pane ${not empty active ? 'active':'fade'}">
			<br>
			<table class="table table-striped table-dark" style="color: azure;">
				<thead>
					<tr>
						<th scope="col">Youtube Id</th>
						<th scope="col">Video Title</th>
						<th scope="col">View Count</th>
						<th scope="col">Status</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listvideos}" var="listvideo">
						<tr>
							<th class="align-middle" scope="row">${listvideo.id}</th>
							<td class="align-middle">${listvideo.title}</td>
							<td class="align-middle">${listvideo.views}</td>
							<td class="align-middle">${listvideo.active}</td>
							<td><a
								href="adminVideoServlet?id=${listvideo.id}&actions=edit"
								type="button" class="btn btn-outline-success float-right">Edit
							</a></td>
						</tr>
					</c:forEach>
					<tr>
						<th class="align-middle " colspan="5">
							<div class="float-left mt-2 ">
								<h5
									class="card-title mb-0 justify-content-center align-self-center float-left ">85
									videos</h5>
							</div>
							<div class="float-right">

								<button type="button" class="btn btn-outline-info m-1">First</button>
								<button type="button" class="btn btn-outline-info m-1">Previous</button>
								<button type="button" class="btn btn-outline-info m-1">Next</button>
								<button type="button" class="btn btn-outline-info m-1">Last</button>
							</div>
						</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>