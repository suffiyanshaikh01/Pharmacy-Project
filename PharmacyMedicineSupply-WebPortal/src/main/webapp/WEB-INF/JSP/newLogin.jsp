<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
    
<head>
	<style type="text/css">
		
		
		
		body,html {
			font-family: 'Roboto', sans-serif;
			margin: 0;
			padding: 0;
			height: 100%;
			/* background: #60a3bc !important */;
			
		}
		
		
		.headingTop{
		 padding-top: 50px;
		 }
		.user_card {
			
			height: 400px;
			width: 350px;
			margin-top: auto;
			margin-bottom: auto;
			/* background: #00ead3; */
			position: relative;
			display: flex;
			justify-content: center;
			flex-direction: column;
			padding: 10px;
			box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			-webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			-moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			border-radius: 20px;
			background: #233e8b;

		}
		.brand_logo_container {
			position: absolute;
			height: 170px;
			width: 170px;
			top: -75px;
			border-radius: 50%;
			background:	#1eae98;
			padding: 10px;
			text-align: center;
		}
		.brand_logo {
			height: 150px;
			width: 150px;
			border-radius: 50%;
			border: 2px solid white;
			background: white;
		}
		.form_container {
			margin-top: 100px;
		}
		.login_btn {
			width: 100%;
			background: #c0392b !important;
			color: white !important;
		}
		.login_btn:focus {
			box-shadow: none !important;
			outline: 0px !important;
		}
		.login_container {
			padding: 0 2rem;
		}
		.input-group-text {
			background: 	#1eae98 !important;
			color: white !important;
			border: 0 !important;
			border-radius: 0.25rem 0 0 0.25rem !important;
		}
		.input_user,
		.input_pass:focus {
			box-shadow: none !important;
			outline: 0px !important;
		}
		.custom-checkbox .custom-control-input:checked~.custom-control-label::before {
			background-color: #c0392b !important;
		}
		.body1{
		background:#fdfaf6;
	/* 	background:
   linear-gradient(
    140deg,
    #4B1248 0%,
    #4B1248 50%,
    #F0C27B 75%
  ) !important; */
		}
	</style>
	<title>Med-life Pharmacy Login</title>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
</head>

<body style="font-family: 'Roboto', sans-serif;" class="body1">
	
	<div id="headingTop" class="text-center">
		<h1 style="font-weight: bold; margin-top: 50px;">Med-life Pharmacy</h1>
	</div>
	
	<div class="container-fluid d-flex justify-content-center" style="padding-top: 5px;">
			<div class="user_card" style="margin-top: 10rem;">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500" class="brand_logo" alt="Logo">
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
					<form method="post">
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" name="userName" required class="form-control input_user" value="" placeholder="username">
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" name="password" required class="form-control input_pass" value="" placeholder="password">
						</div>
							<p style="color: red;text-align: center;">${errorMessage}</p>
							<div class="d-flex justify-content-center mt-3 login_container">
							<kbd style="display: none;">ALT+S</kbd>
				 	<button type="submit" accesskey="s" name="submit" class="btn btn-light btn-lg" style="margin-top: 25px"><u>L</u>ogin</button>
				   </div>
					</form>
				</div>
		
			</div>
		</div>
</body>
</html>
