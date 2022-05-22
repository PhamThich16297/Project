<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="home.css">
<link rel="stylesheet" href="cart.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Cart</title>
</head>
<body>

	<%
	Object tk = session.getAttribute("userSession");
	%>

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
	<h3>My Cart</h3>
	<div>
		<table class="table cart_summary">
			<thead>
				<tr>
					<th>#</th>
					<th class="cart_product">Product</th>
					<th>Price</th>
					<th>Amount</th>
					<th>Total Price</th>
					<th class="action"><i class="fa fa-trash-o"></i></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${cart.items}" var="i">
					<tr>
						<td style="text-align: center;">${i.id}</td>
						<td class="cart_product"><a href="detail?id=${i.id}"><img
								src="${i.src}"></a> ${i.name}</td>
						<td class="price">$ ${i.price}</td>
						<td class="qty"><a href="AddToCart?action=add1&id=${i.id}"><i
								class="fa fa-caret-up"></i></a> ${i.number} <a
							href="AddToCart?action=tru1&id=${i.id}"><i
								class="fa fa-caret-down"></i></a></td>
						<td class="price">$ ${i.gia}</td>
						<td class="action"><a
							href="AddToCart?action=delete&id=${i.id}">Delete item</a></td>
					</tr>
				</c:forEach>
			</tbody>

			<tfoot>
				<tr>
					<td colspan="2" rowspan="2""></td>
					<td colspan="2">Total</td>
					<td colspan="1">$ ${cart.totalPrice}</td>
				</tr>
				<tr>
					<td colspan="2"><a href="home"><button>Country
								Shopping</button></a></td>
					<td colspan="1">
						<form action="PayControl" method="post">
							<button style="width: 50%">PAY</button>
							<p>${sessionScope.messCart}</p>
						</form>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>