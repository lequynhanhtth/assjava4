<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm sticky-top header-colors ">
	<div class="col-3">
		<a class="navbar-brand" href="#"><img id="logo"
			class="d-inline-block mr-1" alt="Logo" src="views/image/youtube.png">
			<span>Youtubi</span></a>
	</div>
	<div class="col-4"></div>
	<div class="col-5">
	
		<a type="button" href="LogoffServlet"
			class="btn btn-outline-danger float-right mr-2">Đăng xuất</a> <a
			type="button" href="openVideoServlet"
			class="btn btn-outline-success float-right mr-2">Video</a> <a
			type="button" href="openUserServlet"
			class="btn btn-outline-success float-right mr-2">Quản lý người dùng</a>

		<div class="dropdown  float-right  mr-2">
			<button class="btn btn-outline-success " type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Reports</button>
			<div class="dropdown-menu dropdown-menu-right "
				aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item" href="adminHead?actions=report">Favorites</a>
				<a class="dropdown-item" href="#">Favorites Users</a> <a
					class="dropdown-item" href="#">Shared friends</a>
			</div>
		</div>
	</div>
</nav>
