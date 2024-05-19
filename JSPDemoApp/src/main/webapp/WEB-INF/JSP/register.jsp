<!DOCTYPE html>
<html>
<head>
	<title>Registration Page</title>
	<style>
		/* Add your CSS rules here */
		body {
			background-color: #f5f5f5;
			font-family: Arial, sans-serif;
			font-size: 16px;
			line-height: 1.5;
			margin: 0;
			padding: 0;
		}
		.container {
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			height: 100vh;
			max-width: 500px;
			margin: 0 auto;
			padding: 20px;
		}
		h2 {
			color: #333;
			font-size: 24px;
			font-weight: normal;
			margin-bottom: 20px;
		}
		label {
			display: block;
			margin-top: 10px;
			color: #666;
			font-size: 14px;
		}
		input[type="text"], input[type="password"] {
			border: 1px solid #ccc;
			padding: 10px;
			border-radius: 3px;
			width: 100%;
			max-width: 300px;
			font-size: 16px;
			margin-top: 5px;
		}
		button {
			background-color: #333;
			color: #fff;
			padding: 10px 20px;
			border: none;
			border-radius: 3px;
			cursor: pointer;
			font-size: 16px;
			margin-top: 20px;
		}
		button:hover {
			background-color: #444;
			transition: background-color 0.2s ease-out;
		}
		.error {
			color: red;
			font-size: 14px;
			margin-top: 10px;
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
	</style>
</head>
<body>
	<div class="container">
		<form method="post" action="/register">
			<h2>Registration Form</h2>

			<div class="error">${errorMsg}</div>

			<div>
				<label for="UserId">User Id:</label>
				<input type="text" name="UserId" id="UserId" placeholder="Enter User Id" />
			</div>
			<div>
				<label for="Password">Password:</label>
				<input type="password" name="Password" id="Password" placeholder="Enter Password" />
			</div>
			<div>
				<button>Register</button>
				<!-- Alternatively, you can use input type="submit" -->
				<!-- <input type="submit" value="Register"> -->
			</div>
		</form>
	</div>
</body>
</html>
