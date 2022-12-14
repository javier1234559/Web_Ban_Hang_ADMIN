<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>PRODUCT ADMIN</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Merienda+One">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	background: #eeeeee;
}

.form-inline {
	display: inline-block;
}

.navbar-header.col {
	padding: 0 !important;
}

.navbar {
	background: #fff;
	padding-left: 16px;
	padding-right: 16px;
	border-bottom: 1px solid #d6d6d6;
	box-shadow: 0 0 4px rgba(0, 0, 0, .1);
}

.nav-link img {
	border-radius: 50%;
	width: 36px;
	height: 36px;
	margin: -8px 0;
	float: left;
	margin-right: 10px;
}

.navbar .navbar-brand {
	color: #555;
	padding-left: 0;
	padding-right: 50px;
	font-family: 'Merienda One', sans-serif;
}

.navbar .navbar-brand i {
	font-size: 20px;
	margin-right: 5px;
}

.search-box {
	position: relative;
}

.search-box input {
	box-shadow: none;
	padding-right: 35px;
	border-radius: 3px !important;
}

.search-box .input-group-addon {
	min-width: 35px;
	border: none;
	background: transparent;
	position: absolute;
	right: 0;
	z-index: 9;
	padding: 7px;
	height: 100%;
}

.search-box i {
	color: #a0a5b1;
	font-size: 19px;
}

.navbar .nav-item i {
	font-size: 18px;
}

.navbar .dropdown-item i {
	font-size: 16px;
	min-width: 22px;
}

.navbar .nav-item.open>a {
	background: none !important;
}

.navbar .dropdown-menu {
	border-radius: 1px;
	border-color: #e5e5e5;
	box-shadow: 0 2px 8px rgba(0, 0, 0, .05);
}

.navbar .dropdown-menu a {
	color: #777;
	padding: 8px 20px;
	line-height: normal;
}

.navbar .dropdown-menu a:hover, .navbar .dropdown-menu a:active {
	color: #333;
}

.navbar .dropdown-item .material-icons {
	font-size: 21px;
	line-height: 16px;
	vertical-align: middle;
	margin-top: -2px;
}

.navbar .badge {
	color: #fff;
	background: #f44336;
	font-size: 11px;
	border-radius: 20px;
	position: absolute;
	min-width: 10px;
	padding: 4px 6px 0;
	min-height: 18px;
	top: 5px;
}

.navbar a.notifications, .navbar a.messages {
	position: relative;
	margin-right: 10px;
}

.navbar a.messages {
	margin-right: 20px;
}

.navbar a.notifications .badge {
	margin-left: -8px;
}

.navbar a.messages .badge {
	margin-left: -4px;
}

.navbar .active a, .navbar .active a:hover, .navbar .active a:focus {
	background: transparent !important;
}

@media ( min-width : 1200px) {
	.form-inline .input-group {
		width: 300px;
		margin-left: 30px;
	}
}

@media ( max-width : 1199px) {
	.form-inline {
		display: block;
		margin-bottom: 10px;
	}
	.input-group {
		width: 100%;
	}
}

body {
	color: #666;
	background: #f5f5f5;
	font-family: 'Roboto', sans-serif;
}

.table-responsive {
	margin: 30px 0;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
}

table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}

.table-wrapper {
	min-width: 1000px;
	background: #fff;
	padding: 20px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.pagination {
	margin: 10px 0 5px;
}

.pagination li a {
	border: none;
	min-width: 30px;
	min-height: 30px;
	color: #999;
	margin: 0 2px;
	line-height: 30px;
	border-radius: 4px !important;
	text-align: center;
	padding: 0;
}

.pagination li a:hover {
	color: #666;
}

.pagination li.active a, .pagination li.active a.page-link {
	background: #59bdb3;
}

.pagination li.active a:hover {
	background: #45aba0;
}

.pagination li:first-child a, .pagination li:last-child a {
	padding: 0 10px;
}

.pagination li.disabled a {
	color: #ccc;
}

.pagination li i {
	font-size: 17px;
	position: relative;
	top: 1px;
	margin: 0 2px;
}
</style>
</head>

<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-10">
							<h2>
								Table <b>Product</b>
							</h2>
						</div>
						<div class="col-sm-2">
							<a href="ProductCURD/Add">
								<button type="button" class="btn btn-info add-new">
									<i class="fa fa-plus"></i> Add New
								</button>
							</a>
						</div>
					</div>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>id</th>
							<th>Nameproduct</th>
							<th>Price</th>
							<th>Category</th>
							<th>image</th>
							<th>MoTa</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="o">
							<tr>
								<td>${o.getIdproduct() }</td>
								<td>${o.getNameproduct() }</td>
								<td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.price}"/>VNĐ</td>								
								<td>${o.getCategory() }</td>
								<td><div class="img-box">
									<img src="${o.getImage()}" class="img-fluid" alt="">
								</div></td>
								<%-- <td>${o.getImage() }</td> --%>
								<td>${o.getMoTa() }</td>
								<td><a href="ProductCURD/Edit?id=${o.getIdproduct()}" class="edit" title="Edit"
									data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
								</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
				<ul class="pagination justify-content-center">
					<li class="page-item disabled"><a href="#"><i
							class="fa fa-long-arrow-left"></i> Previous</a></li>
					<li class="page-item"><a href="#" class="page-link">1</a></li>
					<li class="page-item"><a href="#" class="page-link">2</a></li>
					<li class="page-item active"><a href="#" class="page-link">3</a></li>
					<li class="page-item"><a href="#" class="page-link">4</a></li>
					<li class="page-item"><a href="#" class="page-link">5</a></li>
					<li class="page-item"><a href="#" class="page-link">Next <i
							class="fa fa-long-arrow-right"></i></a></li>
				</ul>
			</div>
		</div>
	</div>



</body>

</html>