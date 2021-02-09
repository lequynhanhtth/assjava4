
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row w-100 mt-5 justify-content-center">
	<div class="col-2"></div>
	<div class="col-8 rounded bg-white mt-5">
		<form action="changePasswordServlet" method="post">
			<div class="row">
				<div class="col-md-12">
					<div class="p-3 py-5">
						<div
							class="d-flex justify-content-between align-items-center mb-3">
							<div class="alert alert-success" role="alert">${message}</div>
							<h6 class="text-right">Change Password</h6>
						</div>
						<div class="row mt-2">
							<div class="col-md-6">
								<input type="password" class="form-control" name="password"
									placeholder="Mật khẩu cũ" value="">
							</div>
							<div class="col-md-6">
								<input type="password" class="form-control" name="newpassword"
									value="" placeholder="Mật khẩu mới">
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-md-6">
								<input type="password" class="form-control"
									name="confirmpassword" value="" placeholder="Xác nhận mật khẩu">
							</div>
						</div>
						<div class="mt-5 text-right">
							<input class="btn btn-primary profile-button mr-2" value="Save"
								type="submit">
						</div>

					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="col-2"></div>
</div>
