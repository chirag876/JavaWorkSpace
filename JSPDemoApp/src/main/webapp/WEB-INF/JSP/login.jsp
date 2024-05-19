<!DOCTYPE html>
<html>

<head>
	<title>Login Page</title>
	<link href="webjars/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet">
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f2f2f2;
		}

		form {
			background-color: #ffffff;
			border-radius: 5px;
			box-shadow: 0px 0px 10px #dcdcdc;
			padding: 20px;
			margin: auto;
			width: 50%;
			max-width: 500px;
			margin-top: 50px;
		}

		h2 {
			color: #ff0000;
			text-align: center;
			margin-bottom: 30px;
		}

		input[type="text"],
		input[type="password"] {
			padding: 10px;
			width: 100%;
			border-radius: 5px;
			border: 1px solid #dcdcdc;
			margin-bottom: 20px;
			box-sizing: border-box;
			font-size: 16px;
		}

		button {
			background-color: #ff0000;
			color: #ffffff;
			padding: 10px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
			font-size: 16px;
		}

		button:hover {
			background-color: #cc0000;
		}
	</style>
</head>

<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<form method="post" class="p-3 mt-5">
					<h2 class="text-center mb-4">Login</h2>

    <div class="alert-danger" role="alert">${errorMsg}</div>
<div class="alert-success" role="alert">${successMsg}</div>
					<div class="form-group">
						<label for="UserId">User Id:</label>
						<input type="text" name="UserId" id="UserId" class="form-control" placeholder="Enter User Id" />
					</div>
					<div class="form-group">
						<label for="Password">Password:</label>
						<input type="password" name="Password" id="Password" class="form-control" placeholder="Enter Password" />
					</div>
					<div class="form-group text-center">
						<button class="btn btn-primary btn-block">Login</button>
					</div>
					
					<div class="mt-3">
					<a href="/register" class="btn btn-success btn-block mt3">Register</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>
