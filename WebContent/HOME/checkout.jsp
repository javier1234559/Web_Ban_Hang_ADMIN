<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>BoardGo</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="image/logo.png" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style1.css" rel="stylesheet">
    <link href="morestyle/main.css" rel="stylesheet">
</head>

<body>
 
<jsp:include page="header.jsp" ></jsp:include>

    <!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="#">Home</a>
                    <a class="breadcrumb-item text-dark" href="ShopServlet">Shop</a>
                    <span class="breadcrumb-item active">Checkout</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->


    <!-- Checkout Start -->
    <div class="container-fluid">
    <form method="post" action="sendEmail" class="register-form">
        <div class="row px-xl-5">
            <div class="col-lg-8">
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span></h5>
                <div class="bg-light p-30 mb-5">
                
                   
                    <div class="row">
              
                        <div class="col-md-6 form-group">
                            <label>Tên</label>
							<input class="nav-item nav-link" type="text" name="name" id="name" value = "<%=session.getAttribute("name") %>" required ="required"/>                      
						</div>
                        <div class="col-md-6 form-group">
                            <label>E-mail</label>
                            <input class="form-control" type="text" name="email" id="email" value = "${ userSession.getUemail()}" required ="required"/> 
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Số Điện Thoại</label>
                            <input class="form-control" type="text" name="mobile" id="mobile" value = "${userSession.getUmobile()}" required ="required"/>
                        </div>	
                        <div class="col-md-6 form-group">
                            <label>Địa chỉ</label>
                            <input class="form-control" type="text" name="address" id="address"  required ="required"/>
                        </div>

                    </div>
                    
                </div>
                
            </div>
            <div class="col-lg-4">
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Total</span></h5>
                <div class="bg-light p-30 mb-5">
                    <div class="border-bottom">
                        <h6 class="mb-3">Products</h6>
                        <c:forEach items="${lsCart}" var="o">
                        	
		                        <div class="d-flex justify-content-between">
		                        	<p>${o.getPro().nameproduct}</p>
		                        	<p>SL: ${o.getQuantity()} </p>
		                        	<p><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.getPro().price* o.getQuantity()}"/>VNĐ</p>
		                        </div>
		                            
                            	
		                        
	                        
	                     </c:forEach>
                        
                    <div class="border-bottom pt-3 pb-2">
                        <div class="d-flex justify-content-between mb-3">
                            <h6>Subtotal</h6>
                            <h6><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${cost == 0 ? 0 : cost}"/>VNĐ</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Shipping</h6>
                            <h6 class="font-weight-medium">10000 VNĐ</h6>
                        </div>
                    </div>
                    <div class="pt-2">
                        <div class="d-flex justify-content-between mt-2">
                            <h5>Total</h5>
                            <h5><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${cost == 0 ? 0 : (cost+10000)}"/>VNĐ</h5>
                        </div>
                    </div>
                </div>
                <div class="mb-5">
                    
                       <a href=sendEmail><button class="btn btn-block btn-primary font-weight-bold py-3">Place Order</button></a>
                </div>
            </div>
        </div>
    	</div>
    </form>
    	
    </div>
    
    </div>
    

    <!-- Checkout End -->


    <jsp:include page="footer.jsp" ></jsp:include>

    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>