<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm sticky-top header-colors ">
	<div class="col-3">
		<a class="navbar-brand" href="indexServlet?actions=''"><img id="logo"
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
		<a type="button" href="indexServlet?actions=Login"
			class="btn btn-outline-success float-right"> <i
			class="fa fa-user-circle pr-2" style="font-size: 25px"></i>Sign In
		</a> <a type="button" href="indexServlet?actions=Sign up"
			class="btn btn-outline-danger float-right mr-2"> <i
			class="fa fa-user-plus pr-2 " style="font-size: 25px"></i>Sign Up
		</a>
	</div>

</nav>