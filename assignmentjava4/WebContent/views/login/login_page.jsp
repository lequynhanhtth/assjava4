<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="limiter">
	<div class="container-login100">
		<div class="wrap-login100">
			<form class="login100-form validate-form" action = "loginServlet" method = "post">
				<div class="alert alert-success" role="alert">${message}</div>
				<span class="login100-form-title p-b-26"> Welcome </span> <span
					class="login100-form-title p-b-48"> <i
					class="zmdi zmdi-font"></i>
				</span>

				<div class="wrap-input100 validate-input">
					<input class="input100" type="text" value="${username}" name="username"> <span
						class="focus-input100" data-placeholder="Username"></span>
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Enter password">
					<span class="btn-show-pass"> <i class="zmdi zmdi-eye"></i>
					</span> <input class="input100" type="password" name="password"> <span
						class="focus-input100" data-placeholder="Password"></span>
				</div>
				<input type="checkbox" id="scales" name="remember" checked> <label
					for="scales">Remember?</label>
				<div class="container-login100-form-btn">
					<div class="wrap-login100-form-btn">
						<div class="login100-form-bgbtn"></div>
						<button class="login100-form-btn">
							Login </button>
					</div>
				</div>

				<div class="text-center p-t-115">
					<span class="txt1"> Don’t have an account? </span> <a class="txt2"
						href="indexServlet?actions=Sign up"> Sign Up </a>
				</div>
			</form>
		</div>
	</div>
</div>
<div id="dropDownSelect1"></div>

