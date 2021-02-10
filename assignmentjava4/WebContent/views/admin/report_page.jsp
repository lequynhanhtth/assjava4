<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container-fluid mt-3">
	<h2 style="color: white;">Quản lý người dùng</h2>
	<br>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link ${report1}"
			data-toggle="tab" href="#home">Thống kê số lượng thích</a></li>
		<li class="nav-item"><a class="nav-link ${report2}"
			data-toggle="tab" href="#menu1">Thống kê người đã thích</a></li>
		<li class="nav-item"><a class="nav-link ${report3}"
			data-toggle="tab" href="#menu2">Thống kê chia sẽ</a></li>
	</ul>
	<div class="tab-content">
		<div id="home"
			class="container tab-pane ${not empty report1 ? report1 : 'fade' }">
			<br>
			<table class="table table-striped table-dark" style="color: azure;">
				<thead>
					<tr>
						<th scope="col">Chủ đề Video</th>
						<th scope="col">Số lượng thích</th>
						<th scope="col">Ngày thích đầu tiên</th>
						<th scope="col">Ngày thích cuối</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${favorites}" var="favorite">
						<tr>
							<th class="align-middle" scope="row">${favorite.groupId}</th>
							<td class="align-middle">${favorite.likes}</td>
							<td class="align-middle">${favorite.newest}</td>
							<td class="align-middle">${favorite.oldest}</td>
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
		<div id="menu1"
			class="container tab-pane ${not empty report2 ? report2 : 'fade'}">
			<br>
			<div class="row my-2">
				<div class="col-4">
					<select class="mdb-select form-control">
						<option value="" disabled selected>Choose your option</option>
						<option value="1">Option 1</option>
						<c:set var="stt" value="0" />
						<c:forEach items="titles" var="title">
							<c:set var="stt" value="${stt+1}" />
							<option value="${stt}"> ${title} </option>
						</c:forEach>
					</select>
				</div>
				<div class="col-6">
					<button type="button" class="btn btn-outline-info ">Tìm
						kiếm</button>
				</div>
			</div>
			<table class="table table-striped table-dark" style="color: azure;">
				<thead>
					<tr>
						<th scope="col">Tên đăng nhập</th>
						<th scope="col">Họ và tên</th>
						<th scope="col">Email</th>
						<th scope="col">Ngày thích</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ReportShares}" var="ReportShare">
						<tr>
							<th class="align-middle" scope="row">${ReportShare.id}</th>
							<td class="align-middle">${ReportShare.fullname}</td>
							<td class="align-middle">${ReportShare.email}</td>
							<td class="align-middle">${ReportShare.likedate}</td>
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
		<div id="menu2"
			class="container tab-pane ${not empty report3 ? report3 : 'fade'}">
			<br>
			<div class="row my-2">
				<div class="col-4">
					<select class="mdb-select form-control">
						<option value="" disabled selected>Choose your option</option>
						<option value="1">Option 1</option>
						<option value="2">Option 2</option>
						<option value="3">Option 3</option>
					</select>
				</div>
				<div class="col-6">
					<button type="button" class="btn btn-outline-info ">Tìm
						kiếm</button>
				</div>
			</div>
			<table class="table table-striped table-dark" style="color: azure;">
				<thead>
					<tr>
						<th scope="col">Người gửi</th>
						<th scope="col">Email người gửi</th>
						<th scope="col">Email người nhận</th>
						<th scope="col">Ngày gửi</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${reportshares}" var="reportshare">
						<tr>
							<th class="align-middle" scope="row">${reportshares.id}</th>
							<td class="align-middle">${reportshares.sender}</td>
							<td class="align-middle">${reportshares.receiver}</td>
							<td class="align-middle">${reportshares.sentdate}</td>
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
<script type="text/javascript">
	$(document).ready(function() {
		$('.mdb-select').materialSelect();
	});
</script>