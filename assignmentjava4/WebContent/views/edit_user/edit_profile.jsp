
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row w-100 mt-5 justify-content-center">
	<div class="col-2"></div>
	<div class="col-8 rounded bg-white mt-5">
		<div class="row">
			<div class="col-md-4 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<img class="rounded-circle mt-5" src="/image/youtube.png"
						width="90"><span class="font-weight-bold">${user.fullname}</span><span
						class="text-black-50">${user.email}</span><span>Việt Nam</span>
				</div>
			</div>
			<div class="col-md-8">
				<div class="p-3 py-5">
					<div class="d-flex justify-content-between align-items-center mb-3">
						<div class="alert alert-success" role="alert">${message}</div>
						<h6 class="text-right">Edit Profile</h6>
					</div>
					<div class="row mt-2">
						<div class="col-md-6">
							<input type="text" class="form-control" name="id"
								placeholder="Username" value="${user.id}" readonly>
						</div>
						<div class="col-md-6">
							<input type="password" class="form-control" name="password"
								value="${user.password}" placeholder="Password" readonly>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-md-6">
							<input type="text" class="form-control" name="email"
								placeholder="Email" value="${user.email}">
						</div>
						<div class="col-md-6">
							<input type="text" class="form-control" value="${user.fullname}"
								name="fullname" placeholder="Fullname">
						</div>
					</div>
					<div class="mt-5 text-right">
						<a href="saveChangeServlet"
							class="btn btn-primary profile-button mr-2" type="button">Save
							Profile</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-2"></div>
</div>
