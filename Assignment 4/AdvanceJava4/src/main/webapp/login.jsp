<html>
	<head>
		<style type="text/css">
.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

input[type=submit] {
	background-color: #1E90FF;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
  background-color: #4169E1;
}

input[type=text], input[type = password] {
   width: 100%; 
  padding: 12px; 
  border: 1px solid #ccc; 
  border-radius: 4px; 
  margin-top: 3px; 
  margin-bottom: 3px; 
}

</style>
		<title> TShirt Searcher </title>
	</head>
	<h1 style="margin-left:40%"> Login Information</h1>
		<div align = "center" class = "container">
			<div >
			<form action="login" method = "post"> <br>
			<br> <br>
				<%@include file="components/message.jsp"%>
				<table>
					<tr>
						<td>Username  :</td>
						<td><input type = "text" name = "uname" ></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type = "password" name = "pass"> <br></td>
					</tr>
					<tr>
						<th></th>
						<td align = "right"><input type = "submit" value = "Submit" align = "right"></td>
				</table>
			</form>
		</div>
		<br>
		
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>
</html>
