<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="home.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Search</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="body_body row">
		<div class="leftcolumn">
			<div class="card">
				<div class="row">
					<c:forEach items="${listSearch}" var="p">
						<div class="col-4">
							<h2>${p.name}</h2>
							<h5>${p.type}</h5>
							<div class="fakeimg">
								<a href="detail?id=${p.id}"> <img src="${p.src}"
									style="height: 200px">
								</a>
							</div>
							<p>${p.price}</p>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="pageindex">
				<c:forEach begin="1" end="${endSearch}" var="i">
					<a class="${i==index?"
						active":""}" href="timkiem?index=${i}&search=${saveSearch}">${i}</a>
				</c:forEach>
			</div>
		</div>

		<div class="rightcolumn">
			<div class="card">
				<h2>Shopping cart</h2>
				<div class="fakeimg" style="height: 100px;">Cart</div>
				<p>Sumary information of your cart can be displayed here</p>
			</div>
			<div class="card">
				<h3>Popular products or banners</h3>
				<c:forEach items="${listTop3}" var="p">
					<div class="fakeimg">
						<a href="detail?id=${p.id}"> <img src="${p.src}"
							style="height: 200px">
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>