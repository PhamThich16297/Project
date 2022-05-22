<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="home.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>

<body>
	<%
	Object tk = session.getAttribute("userSession");
	%>
	<div class="header_banner">
		<img src="images/header.png">
	</div>
	<div class="header_body">
		<div class="left">
			<img src="images/logo.png">
			<button class="button_login">
				<a href="home">Home</a>
			</button>
			<button class="button_login">
				<a href="#">Products</a>
			</button>
			<%
			if (tk != null) {
				String str = (String) session.getAttribute("userSession");
				String[] ds = str.split("@", 0);
				String rs = ds[0];
			%>
			<button class="button_login">
				<%=rs%>
			</button>
			<button>
				<a href="LogoutControl">LogOut</a>
			</button>
			<%
			} else {
			%>
			<button class="button_login">
				<a href="login.jsp">LOGIN</a>
			</button>
			<button class="button_login">
				<a href="signup.jsp">SIGNUP</a>
			</button>
			<%
			}
			%>
		</div>
		<div class="right">
			<div class="container-1">
				<form action="timkiem" method="get">
					<span class="icon_search"><i class="fa fa-search"></i></span> <input
						type="search" id="search" name="search" placeholder="Search..." />
				</form>
			</div>
		</div>
	</div>
	<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> -->

	<div id="slideshow">
		<div class="slide-wrapper">
			<div class="slide">
				<img src="images/slide1.png">
			</div>
			<div class="slide">
				<img src="images/slide2.png">
			</div>
			<div class="slide">
				<img src="images/slide3.png">
			</div>
		</div>
	</div>
	<div id="right_qc">
		<div class="img_qc">
			<img src="images/qc1.png">
		</div>
		<div class="img_qc">
			<img src="images/qc2.png">
		</div>
	</div>

	<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> -->
	<div class="header_menu">
		<button>
			<a href="#"><img src="images/iphone.png"></a>
		</button>
		<button>
			<img src="images/samsung.png">
		</button>
		<button>
			<img src="images/oppo.png">
		</button>
		<button>
			<img src="images/vivo.png">
		</button>
		<button>
			<img src="images/xiaomi.png">
		</button>
		<button>
			<img src="images/realme.png">
		</button>
	</div>
</body>

</html>