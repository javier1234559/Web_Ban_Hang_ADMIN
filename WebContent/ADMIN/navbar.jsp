<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-xl navbar-light bg-light">
		<div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
			<div class="navbar-nav">
				<!-- <a href="ADMIN/admin.html" class="nav-item nav-link active">Home</a> -->
				<a href="UserCURD" class="nav-item nav-link">User</a>
				<a href="ProductCURD" class="nav-item nav-link">Product</a>
				<a href="DetailProductCURD" class="nav-item nav-link">DetailProduct</a>				
				<a href="CartCRUD" class="nav-item nav-link">Cart</a>
				<!-- <a href="#" class="nav-item nav-link">Bill</a>
				<a href="#" class="nav-item nav-link">Contact</a> -->
			</div>
			<form class="navbar-form form-inline">
				<div class="input-group search-box">
					<input type="text" id="search" class="form-control" placeholder="Search by Name">
					<span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
				</div>
			</form>
			<div class="navbar-nav ml-auto">
				<div class="nav-item dropdown">
					<a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle user-action"> Paula Wilson <b
							class="caret"></b></a>
					<div class="dropdown-menu">
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"><i class="material-icons">&#xE8AC;</i> Logout</a></a>
					</div>
				</div>
			</div>
		</div>
	</nav>
</body>
</html>