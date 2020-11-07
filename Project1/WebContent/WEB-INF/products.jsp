<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Products</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <h1 class="text-center">List of products</h1>
    <div class="container">
        <div class="row text-center">
            <c:forEach items="${ products }" var="product">
                <div class="col-12 col-md-6 col-lg-4 mb-5">
                    <div class="card mx-auto" style="width: 18rem;">
                        <img src="img/User_Circle_Authentification.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h4 class="card-title text-center">${ product.designation }</h4>
                            <h6 class="text-center">${ product.prix }$</h6>
                            <p class="card-text">${ product.description }.</p>
                            <div class="text-center"><a href="/Project1/Products?product_id=${ product.id }" class="btn btn-warning">Go somewhere</a></div>
                        </div>
                      </div>
                </div>
            </c:forEach>
        </div>
      </div>
</body>
</html>