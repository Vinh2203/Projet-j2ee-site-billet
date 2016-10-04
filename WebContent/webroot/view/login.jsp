<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../include/headerLogin.jsp" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/webroot/css/login.css" />
<link rel="stylesheet" type="text/css"
	href="./webroot/css/bootstrap-social/bootstrap-social.css">
<link rel="stylesheet" type="text/css"
	href="./webroot/css/bootstrap-social/assets//css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="./webroot/css/bootstrap-social/assets/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="./webroot/css/bootstrap-social/assets/css/docs.css">
<script type="text/javascript" src="./webroot/js/jquery/jquery-confirm.js"></script>
<link rel="stylesheet" type="text/css" href="./webroot/css/jquery/jquery-confirm.css">

<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="243513681209-42s9q0tr4i6cdima8eqjmqeakog7mnq4.apps.googleusercontent.com" />

<body>
	<div class="blur"></div>
	<div id="fb-root"></div>
	<script>
		window.fbAsyncInit = function() {
			FB.init({
				appId : '1770446936517741',
				status : true,
				cookie : true,
				xfbml : true
			});
		};

		(function(d) {
			var js, id = 'facebook-jssdk', ref = d
					.getElementsByTagName('script')[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement('script');
			js.id = id;
			js.async = true;
			js.src = "//connect.facebook.net/en_US/all.js";
			ref.parentNode.insertBefore(js, ref);
		}(document));

		function testAPI() {
			FB
			.api(
				'/me',
				function(response) {
					$.ajax({
						type : "POST",
						url : "http://www.voyage-supinfo.com:8080/ProjetBsc/Index",
						data : {
							email : response.email,
							name : response.name,
							id : response.id,
							type : "1"
						},
						success : function(msg) {
							window.location
									.assign("http://www.voyage-supinfo.com:8080/ProjetBsc/Index")
						}
					});
				});
		}
		function loginFB() {
			FB.login(function(response) {
				// handle the response
				if (response.status === 'connected') {
					testAPI();
				} else if (response.status === 'not_authorized') {

				} else {

				}
			}, {
				scope : 'public_profile,email'
			});
		}

		function logout() {
			FB.logout(function(response) {
				// user is now logged out
			});
		}

		function login() {
			var myParams = {
				'clientid' : '243513681209-42s9q0tr4i6cdima8eqjmqeakog7mnq4.apps.googleusercontent.com', //You need to set client id
				'cookiepolicy' : 'single_host_origin',
				'callback' : 'loginCallback', //callback function
				'approvalprompt' : 'force',
				'scope' : 'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.profile.emails.read'
			};
			gapi.auth.signIn(myParams);
		}

		function loginCallback(result) {
			if (result['status']['signed_in']) {
				var request = gapi.client.plus.people.get({
					'userId' : 'me'
				});
				request.execute(function(resp) {
					var email = '';
					if (resp['emails']) {
						for (i = 0; i < resp['emails'].length; i++) {
							if (resp['emails'][i]['type'] == 'account') {
								email = resp['emails'][i]['value'];
							}
						}
					}
					$.ajax({
						type : "POST",
						url : "http://www.voyage-supinfo.com:8080/ProjetBsc/Index?",
						data : {
							email : email,
							name : resp['displayName'],
							picture : resp['image']['url'],
							type : "0"
						},
						success : function(msg) {
							window.location
									.assign("http://www.voyage-supinfo.com:8080/ProjetBsc/Index")
						}
					});
				});

			}

		}
		function onLoadCallback() {
			gapi.client.setApiKey('AIzaSyAKH0RcjlSShELpMIe4EoaDFLkCfh3s9Ac');
			gapi.client.load('plus', 'v1', function() {
			});
		}
	</script>
	<c:if test="${test == false }">
		<script type="text/javascript">
			$.alert({
			    title: '',
			    content: 'error login|password!'
			});
		</script>
	</c:if>
	<div class="zoneLogin">
		<h1>Connectez - Vous</h1>
		<form class="form" action="Index" method="POST">
			<input type="hidden" name="type" value="2"> <input
				type="email" id="input_login" name="email" placeholder="email"
				required="required"> <input type="password"
				id="input_password" name="password" placeholder="Password"
				required="required"> <br /> <input type="submit"
				id="checkLogin" value="Submit">
		</form>

		<form action="Index" method="get">
			<button id="notLogin">Continue</button>
		</form>
		<a class="btn btn-block btn-social btn-facebook" onclick="loginFB();"
			style="width: 218px; margin-top: 10px"> <span
			class="fa fa-facebook"></span> Sign in with Facebook
		</a> <a class="btn btn-block btn-social btn-google" onclick="login();"
			style="width: 218px; margin-top: 10px"> <span
			class="fa fa-google"></span> Sign in with Google
		</a>
		<form action=Inscription method="get">
			<button id="inscription">Inscription</button>
		</form>
	</div>
	<script type="text/javascript">
		(function() {
			var po = document.createElement('script');
			po.type = 'text/javascript';
			po.async = true;
			po.src = 'https://apis.google.com/js/client.js?onload=onLoadCallback';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(po, s);
		})();
	</script>
	<c:import url="../include/footer.jsp" />