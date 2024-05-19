<!DOCTYPE html>
<html>
<head>
	<title>Welcome</title>
	<link href=webjars/bootstrap/4.6.0/css/bootstrap.min.css rel="stylesheet">
	<style>
		body {
			background-color: #f2f2f2;
			font-family: Arial, sans-serif;
			padding: 50px;
		}

		h2 {
			color: #ff0000;
			font-size: 36px;
			font-weight: bold;
			text-align: center;
			margin-bottom: 50px;
		}

		.card {
			background-color: #ffffff;
			border-radius: 5px;
			box-shadow: 0px 0px 10px #dcdcdc;
			padding: 20px;
			margin: auto;
			width: 50%;
			max-width: 500px;
			margin-top: 50px;
		}

		.btn {
			background-color: #ff0000;
			border-color: #ff0000;
			font-size: 16px;
			font-weight: bold;
			padding: 10px 20px;
			border-radius: 5px;
			cursor: pointer;
		}

		.btn:hover {
			background-color: #cc0000;
			border-color: #cc0000;
		}
	</style>
</head>
<body>
	<div class="card">
		<h2>Welcome ${UserId} to the site</h2>
		<a href="#" class="btn btn-primary btn-block">Go to Dashboard</a>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
