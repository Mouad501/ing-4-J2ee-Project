<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<%@ include file="styleToImport.html" %>
<link rel="stylesheet" type="text/css" href="styles/cart_styles.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">

</head>
<body>
	<%@ include file="header.html" %>
	
	
	
	<!-- Cart -->

	<div class="cart_section">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 offset-lg-1">
					<div class="cart_container">
						<div class="cart_title">Shopping Cart</div>
						<div class="cart_items">
						<c:forEach items="${ sessionScope.cart.listOfProduct }" var="product">
							<ul class="cart_list">
								<li class="cart_item clearfix">
									<div class="cart_item_image"><img src="images/${ product.image }" alt=""></div>
									<div class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
										<div class="cart_item_name cart_info_col">
											<div class="cart_item_title">Name</div>
											<div class="cart_item_text">${ product.designation }</div>
										</div>
										<div class="cart_item_color cart_info_col">
											<div class="cart_item_title">Color</div>
											<div class="cart_item_text"><span style="background-color:#999999;"></span>Silver</div>
										</div>
										<div class="cart_item_quantity cart_info_col">
											<div class="cart_item_title">Quantity</div>
											<div class="cart_item_text">1</div>
										</div>
										<div class="cart_item_price cart_info_col">
											<div class="cart_item_title">Price</div>
											<div class="cart_item_text">$${ product.prix }</div>
										</div>
										<div class="cart_item_total cart_info_col">
											<div class="cart_item_text">
											<a href="Cart?id_remove=${ product.id }"><input type="submit" value="Remove" class="btn mt-1 btn-danger"></a>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</c:forEach>
							
						</div>
						
						<!-- Order Total -->
						<div class="order_total">
							<div class="order_total_content text-md-right">
								<div class="order_total_title">Order Total:</div>
								<div class="order_total_amount">$${sessionScope.cart.total_price }</div>
							</div>
						</div>

						<div class="cart_buttons">
							<a href="Cart?clear=1"><button type="button" class="button cart_button_clear">Clear</button></a>
							<button type="button" class="button cart_button_checkout">Buy</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	<%@ include file="footer.html" %>
	<%@ include file="jsToImport.html" %>
	<script src="js/cart_custom.js"></script>
</body>
</html>