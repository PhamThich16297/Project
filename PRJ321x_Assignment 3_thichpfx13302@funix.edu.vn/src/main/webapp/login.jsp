<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
<link rel="stylesheet" href="login.css">
</head>

<body>

	<!-- <script>
		function myFunction() {
		  let user = document.getElementById("user").value;
		  let pass = document.getElementById("pass").value;

		  	if(user=="") {
				  alert("UserName cannot be Empty")
			  } else if(pass=="") {
				  alert("Password cannot be Empty")
			  }
		}
	</script> -->
	
	
	<div class="login-box">
  		<img src="images/man.png">
  		<form action="LoginControl" method="post">
    		<div class="user-box">
      			<input type="text" name="inputUser" value="${cookie['userCook'].value}" id="user">
      			<label>UserName</label>
    		</div>
    		<div class="user-box">
      			<input type="password" name="inputPass" value="${cookie['passCook'].value}" id="pass">
      			<label>Password</label>
    		</div>
    		<p style="color:red;font-size:10px">${sessionScope.error}</p>
    		
    		<div class="user-checkbox">
    			<input type="checkbox" name="remember" value="${cookie['rememberCook'].value}">
  				<label>Remember me</label><br>
    		</div>
    		<div class="login">
    			<button type="submit">   <!--  onclick="myFunction()" -->
			      <span></span>
			      <span></span>
			      <span></span>
			      <span></span>
      			LOGIN
    			</button>
    		</div>
  		</form>
  		<div class="footer">
    		<a href="home"><button>Cancel</button></a>
    		<div class="right">
    			<a>Forgot Password?</a>
    		</div>
    		
    	</div>
	</div>
</body>
</html>