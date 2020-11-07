<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sign Up</title>
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
<body>
	

	<div class="bg center ">
		<div class="my-auto px-4 text-left">
			<form method="post" action="Inscription">
				<h1 class="text-center">Sign Up</h1> <br>
				<div class="form-group">
					<label for="exampleInputEmail1">First Name</label>
					<input type="text" name="firstname" class="form-control" placeholder="First name">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Last Name</label>
					<input type="text" name="lastname" class="form-control" placeholder="Last name">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Email</label>
					<input type="email" name="email" class="form-control" placeholder="Email">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label>
					<input type="password" name="password" class="form-control" placeholder="Password">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Num telephone</label>
					<input type="tel" name="tel" class="form-control" placeholder="Num tel">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Address</label>
					<input type="text" name="address" class="form-control" placeholder="Address">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Sex</label><br>
					<label class="mr-2">Male </label><input type="radio" class="mr-2" name="sex" value="Male">
					<label class="mr-2">Female </label><input type="radio" name="sex" value="Female">
				</div>
				<div class="form-group text-center">
					<input type=submit class="btn px-5 btn-success" name=submit value=Submit>
				</div>
			</form>
		</div>
	</div>
</body>
</html>