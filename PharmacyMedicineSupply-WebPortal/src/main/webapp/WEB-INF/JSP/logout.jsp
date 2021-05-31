
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<head>
<title>logout</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="style/index-
style.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: #989898
}

.button {
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.button2 {
	background-color: #008CBA;
} /* Blue */
.container {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"> <img
			src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500"
			width="30" height="30" class="d-inline-block align-top" alt="">
			Cognizant Pharmacy
		</a>
		<form action="/login" method="GET">
			<button type="button float-right" class="btn btn-outline-light">sign
				in</button>
		</form>
	</nav>
	<!-- Demo content-->
	<div class="container">


		<div class="col-lg-10 col-xl-7 mx-auto" style="margin-top: 100px;">
			<center>
				<h3 class="display-4">Logged Out</h3>
			</center>
		</div>

	</div>


</body>
</html>

























