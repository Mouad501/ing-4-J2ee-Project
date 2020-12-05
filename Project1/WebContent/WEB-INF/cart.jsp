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
<style>
	.quantity {
	  position: relative;
	}
	
	input[type=number]::-webkit-inner-spin-button,
	input[type=number]::-webkit-outer-spin-button
	{
	  -webkit-appearance: none;
	  margin: 0;
	}
	
	input[type=number]
	{
	  -moz-appearance: textfield;
	}
	
	.quantity input {
	  width: 60px;
	  height: 42px;
	  line-height: 1.65;
	  float: left;
	  display: block;
	  padding: 0;
	  margin: 0;
	  padding-left: 20px;
	  border: 1px solid #eee;
	}
	
	.quantity input:focus {
	  outline: 0;
	}
	
	.quantity-nav {
	  float: left;
	  position: relative;
	  height: 42px;
	}
	
	.quantity-button {
	  position: relative;
	  cursor: pointer;
	  border: 1px solid #eee;
	  width: 20px;
	  text-align: center;
	  color: #333;
	  font-size: 13px;
	  font-family: "Trebuchet MS", Helvetica, sans-serif !important;
	  line-height: 1.7;
	  -webkit-transform: translateX(-100%);
	  transform: translateX(-100%);
	  -webkit-user-select: none;
	  -moz-user-select: none;
	  -ms-user-select: none;
	  -o-user-select: none;
	  user-select: none;
	}
	
	.quantity-button.quantity-up {
	  position: absolute;
	  height: 50%;
	  top: 0;
	  border-bottom: 1px solid #eee;
	}
	
	.quantity-button.quantity-down {
	  position: absolute;
	  bottom: -1px;
	  height: 50%;
	}
</style>
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
						<c:forEach items="${ sessionScope.cart.listOfProducts }" var="item">
							<form action="Cart?id_update=${ item.product.id }" method="post">
								<ul class="cart_list">
									<li class="cart_item clearfix">
										<div class="cart_item_image"><img src="images/${ item.product.image }" alt=""></div>
										<div class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
											<div class="cart_item_name cart_info_col">
												<div class="cart_item_title">Name</div>
												<div class="cart_item_text">${ item.product.designation }</div>
											</div>
											
											<div class="cart_item_quantity cart_info_col">
												<div class="cart_item_title">Quantity</div>
												<div class="quantity mt-3">
												  <input type="number" name="quantity" min="1" max="20" step="1" value="${ item.quantity}">
												</div>
												
											</div>
											<div class="cart_item_price cart_info_col">
												<div class="cart_item_title">Price</div>
												<div class="cart_item_text">$${ item.product.prix }</div>
											</div>
											<div class="cart_item_total cart_info_col">
												<div class="cart_item_text">
												<a href="Cart?id_remove=${ item.product.id }"><input type="button" value="Remove" class="btn mt-1 btn-danger"></a>
												</div>
											</div>
											<div class="cart_item_total cart_info_col">
												<div class="cart_item_text">
												<input type="submit" value="Update" class="btn mt-1 btn-primary">
												</div>
											</div>
										</div>
									</li>
								</ul>
							</form>
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
							<form action="Cart" method="post">
								<a href="Cart?clear=1"><button type="button" class="button cart_button_clear">Clear</button></a>
							
								<button type="submit" name="Buy" class="button cart_button_checkout">Buy</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	<%@ include file="footer.html" %>
	<%@ include file="jsToImport.html" %>
	<script src="js/cart_custom.js"></script>
	<script>
	    jQuery('<div class="quantity-nav"><div class="quantity-button quantity-up">+</div><div class="quantity-button quantity-down">-</div></div>').insertAfter('.quantity input');
	    jQuery('.quantity').each(function() {
	      var spinner = jQuery(this),
	        input = spinner.find('input[type="number"]'),
	        btnUp = spinner.find('.quantity-up'),
	        btnDown = spinner.find('.quantity-down'),
	        min = input.attr('min'),
	        max = input.attr('max');
	
	      btnUp.click(function() {
	        var oldValue = parseFloat(input.val());
	        if (oldValue >= max) {
	          var newVal = oldValue;
	        } else {
	          var newVal = oldValue + 1;
	        }
	        spinner.find("input").val(newVal);
	        spinner.find("input").trigger("change");
	      });
	
	      btnDown.click(function() {
	        var oldValue = parseFloat(input.val());
	        if (oldValue <= min) {
	          var newVal = oldValue;
	        } else {
	          var newVal = oldValue - 1;
	        }
	        spinner.find("input").val(newVal);
	        spinner.find("input").trigger("change");
	      });
	
	    });
	</script>
	
</body>
</html>