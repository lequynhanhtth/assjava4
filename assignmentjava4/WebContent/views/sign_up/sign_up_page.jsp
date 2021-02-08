<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="limiter">
	<div class="container-login100">
		<div class="wrap-login100">
			<form class="login100-form validate-form" action="signupServlet"
				method="post">
				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if>
				<span class="login100-form-title p-b-26"> Welcome </span> <span
					class="login100-form-title p-b-48"> <i
					class="zmdi zmdi-font"></i>
				</span>

				<div class="wrap-input100 validate-input">
					<input class="input100" value ="" type="text" name="id"> <span
						class="focus-input100" data-placeholder="Username"></span>
				</div>
				<div class="wrap-input100 validate-input">
					<input class="input100" value="" type="text" name="fullname"> <span
						class="focus-input100" data-placeholder="Fullname"></span>
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Enter password">
					<span class="btn-show-pass"> <i class="zmdi zmdi-eye"></i>
					</span> <input class="input100" type="password" value="" name="password"> <span
						class="focus-input100" data-placeholder="Password"></span>
				</div>
					<div class="wrap-input100 validate-input"
					data-validate="Enter password">
					<span class="btn-show-pass"> <i class="zmdi zmdi-eye"></i>
					</span> <input class="input100" type="password" value="" name="confirmpassword"> <span
						class="focus-input100" data-placeholder="Password"></span>
				</div>
				<div class="wrap-input100 validate-input">
					<input class="input100" type="text" value="" name="email"> <span
						class="focus-input100"  data-placeholder="Email"></span>
				</div>
				
				<div class="container-login100-form-btn">
					<div class="wrap-login100-form-btn">
						<div class="login100-form-bgbtn"></div>
						<button class="login100-form-btn">Sign Up</button>
					</div>
				</div>

				<div class="text-center p-t-115">
					<span class="txt1"> Don’t have an account? </span> <a class="txt2"
						href="#"> Sign Up </a>
				</div>
			</form>
		</div>
	</div>
</div>


<div id="dropDownSelect1"></div>
