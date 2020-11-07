<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
	<title>Authentification</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<style>
		.center {
			margin: auto;
			width: 50%;
			padding: 3%;
			margin-top: 2%;
			margin-bottom: 2%;
		}
		body{
			background: linear-gradient(to bottom, #33ccff 0%, #ff99cc 100%);
		}
		.bg{
			background-color: aliceblue;
		}
	</style>
</head>
<body class="py-2">
	<div class="bg center ">
		<div class="my-auto px-4 text-left">
			<form action="Authentification"  method="post">
				<h1 class="text-center">Sign In</h1> <br>
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label>
					<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
					<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label>
					<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
				</div>
				<div class="form-group text-center">
					<input type=submit class="btn px-5 btn-success" name=submit value=Submit>
				</div>
			</form>
		</div>
	</div>
</body>
</html>