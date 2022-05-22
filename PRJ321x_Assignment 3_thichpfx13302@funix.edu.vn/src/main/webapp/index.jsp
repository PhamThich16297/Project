<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN</title>
<link rel="stylesheet" href="index.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<%
	Object tk = session.getAttribute("userSession");
	if (tk == null) {
		request.getRequestDispatcher("login.jsp").forward(request, response);
		/* response.sendRedirect("login.jsp"); */
	} else {
		String str = (String) session.getAttribute("userSession");
		String[] ds = str.split("@", 0);
		String rs = ds[0];
	%>
	<form action="LogoutControl" method="get">
		<div class="container">
			<div class="row">
				<div class="col-sm-3 admin_left">
					<h5 style="color: red">
						Welcome:
						<%=rs%></h5>
					<button>LOGOUT</button>
				</div>
				<div class="col-sm-9 admin_right">
					<img src="images/img_admin.png">
				</div>
			</div>
		</div>
	</form>
	<%
	}
	%>

</body>
</html>