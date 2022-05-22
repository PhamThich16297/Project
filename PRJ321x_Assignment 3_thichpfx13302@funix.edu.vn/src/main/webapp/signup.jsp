<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="login.css">
<title>Sign Up</title>
</head>
<body>
	<div class="login-box">
		<h5>SIGN UP</h5>
		<form action="SignupControl" method="post">

			<div class="user-box">
				<input type="text" name="inputYourName"> <label>Your
					Name (*)</label>
			</div>
			<div class="user-box">
				<input type="text" name="inputAddress"> <label>Address</label>
			</div>
			<div class="user-box">
				<input type="text" name="inputPhone"> <label>Phone</label>
			</div>

			<div class="user-box">
				<input type="text" name="inputUserSU"> <label>User_mail
					(*)</label>
			</div>
			<div class="user-box">
				<input type="password" name="inputPassSU"> <label>Password
					(*)</label>
			</div>
			<div class="user-box">
				<input type="password" name="inputRe_PassSU"> <label>Repeat
					Password (*)</label>
			</div>
			<p style="color: red; font-size: 10px">${sessionScope.mess}</p>

			<div class="login">
				<button type="submit">
					<span></span> <span></span> <span></span> <span></span> SIGN UP
				</button>
			</div>
		</form>
		<div class="footer">
			<a href="home"><button>Back</button></a>
		</div>
	</div>
</body>
</html>