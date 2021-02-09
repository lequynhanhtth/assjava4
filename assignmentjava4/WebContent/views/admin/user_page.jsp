<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container-fluid mt-3">
	<h2 style="color: white;">Quản lý người dùng</h2>
	<br>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a
			class="nav-link ${empty active ? 'active':''}" data-toggle="tab"
			href="#home">Thông tin người dùng</a></li>
		<li class="nav-item"><a
			class="nav-link ${not empty active ? 'active':''}" data-toggle="tab"
			href="#menu1">Danh sách người dùng</a></li>
	</ul>
	<div class="tab-content">
		<div id="home"
			class="container tab-pane ${empty active ? 'active':'fade'}">
			<br>
			<div class="row">
				<div class="col-md-4 border-right">
					<div
						class="d-flex flex-column align-items-center text-center p-3 py-5">
						<img class="rounded-circle mt-5" src="views/image/youtube.png"
							width="90"><span style="color: white;"
							class="font-weight-bold">${userdetail.fullname}</span><span
							class="text-white-50">${userdetail.email}</span><span
							style="color: white;">Việt Nam</span>
					</div>
				</div>
				<div class="col-md-8">
					<form action="adminUserServlet">
						<div class="p-3 py-5">
							<div
								class="d-flex justify-content-between align-items-center mb-3">
								<div class="alert alert-success" role="alert">${message}</div>
								<h6 class="text-right" style="color: white;">Edit Profile</h6>
							</div>
							<div class="row mt-2">
								<div class="col-md-6">
									<input type="text" name="id" class="form-control"
										placeholder="Username" value="${userdetail.id}" readonly>
								</div>
								<div class="col-md-6">
									<input type="password" name="password" class="form-control"
										value="${userdetail.password}" placeholder="Password" readonly>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-md-6">
									<input type="text" name="email" class="form-control"
										placeholder="Email" value="${userdetail.email}">
								</div>
								<div class="col-md-6">
									<input type="text" name="fullname" class="form-control"
										value="${userdetail.fullname}" placeholder="Fullname">
								</div>
							</div>

							<div class="mt-5 text-right">
								<input class="btn btn-primary profile-button mr-2" type="submit"
									name="actions" value="Save Profile">
								<input class="btn btn-danger profile-button mr-2" type="submit"
									name="actions" value="Delete">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="menu1"
			class="container tab-pane ${not empty active ? 'active':'fade'}">
			<br>
			<table class="table table-striped table-dark" style="color: azure;">
				<thead>
					<tr>
						<th scope="col">Username</th>
						<th scope="col">Password</th>
						<th scope="col">FullName</th>
						<th scope="col">Email</th>
						<th scope="col">Role</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listusers}" var="listuser">
						<tr>
							<th class="align-middle" scope="row">${listuser.id}</th>
							<td class="align-middle">${listuser.password}</td>
							<td class="align-middle">${listuser.fullname}</td>
							<td class="align-middle">${listuser.email}</td>
							<td class="align-middle">${listuser.admin}</td>
							<td><a
								href="adminUserServlet?id=${listuser.id}&actions=edit"
								type="button" class="btn btn-outline-success float-right">Edit
							</a></td>
						</tr>
					</c:forEach>
					<tr>
						<th class="align-middle " colspan="5">
							<div class="float-left mt-2 ">
								<h5
									class="card-title mb-0 justify-content-center align-self-center float-left ">85
									Users</h5>
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