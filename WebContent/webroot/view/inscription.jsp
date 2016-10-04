<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../include/header.jsp" />
<link rel="stylesheet" type="text/css"
	href="./webroot/css/bootstrap-social/bootstrap-social.css">
	<link rel="stylesheet" type="text/css"
	href="./webroot/css/inscription.css">
<link rel="stylesheet" type="text/css"
	href="./webroot/css/bootstrap-social/assets//css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="./webroot/css/bootstrap-social/assets/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="./webroot/css/bootstrap-social/assets/css/docs.css">
	<script type="text/javascript" src="./webroot/js/inscription.js"></script>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/webroot/css/login.css" />
<body>
<c:if test="${login == 1 }">
	<script type="text/javascript">alert("email existe deja");</script>
</c:if>
	<div class="container">

		<div class="row">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
					<h2>
						Welcome to Easyrainway <small>Sign up</small>
					</h2>
					<hr class="colorgraph">
					<form method="post">
					<div class="form-group">
						<input type="text" name="user name" id="user_name"
							class="form-control input-lg" placeholder="User Name" required="required"
							tabindex="3">
					</div>
					<div class="form-group">
						<input type="email" name="email" id="email"
							class="form-control input-lg" placeholder="Email Address" required="required"
							tabindex="4">
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="password" name="password" id="password"
									class="form-control input-lg" placeholder="Password" required="required"
									tabindex="5">
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="password" name="password_confirmation"
									id="password_confirmation" class="form-control input-lg" required="required"
									placeholder="Confirm Password" tabindex="6">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-4 col-sm-3 col-md-3">
							<span class="button-checkbox">
								<button type="button" class="btn" data-color="info" tabindex="7">I
									Agree</button> <input type="checkbox" name="t_and_c" id="t_and_c"
								class="hidden" value="1">
							</span>
						</div>
						<div class="col-xs-8 col-sm-9 col-md-9">
							By clicking <strong class="label label-primary">Register</strong>,
							you agree to the <a href="#" data-toggle="modal"
								data-target="#t_and_c_m">Terms and Conditions</a>
						</div>
					</div>

					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-12 col-md-6">
							<input type="submit" value="Register"
								class="btn btn-primary btn-block btn-lg" tabindex="7" onclick="regrister();">
						</div>
						<div class="col-xs-12 col-md-6">
							<a href="http://www.voyage-supinfo.com:8080/ProjetBsc/" class="btn btn-success btn-block btn-lg">Sign In</a>
						</div>
					</div>
					</form>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
					</div>
					<div class="modal-body">
						<p>Welcome to Step by Step
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">I
							Agree</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>
	<c:import url="../include/footer.jsp" />