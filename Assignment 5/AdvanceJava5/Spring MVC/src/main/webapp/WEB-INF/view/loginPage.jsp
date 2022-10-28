<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link href="<c:url value="/resources/css/loginPageStyle.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/error.css"/>" rel="stylesheet" />

</head>

<body>
	<c:if test="${cookie.librarian.value != null }">
		<c:redirect url="/books/bookManagement" />
	</c:if>
<br>
<br>
	<section class="wrapper mt-5 ">
		<div class="container ">
			<div
				class="col-sm-8 offset-sm-2 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4 text-center">
				<form action="login" class="rounded bg-white shadow p-5"
					method="get" novalidate onsubmit="return validateUser();">
					<h3 class="text-dark fw-bolder fs-4 mb-2 ">Sign In Librarian</h3>
					<c:set var="isValidUser" scope="page" value="${doesExists}" />
					<c:if test="${isValidUser != null && isValidUser == false }">
						<div class="text-danger">Email or Password not found</div>
					</c:if>
					<div class="form-floating mb-3">
						<input type="email" class="form-control" id="email"
							placeholder="name@example.com" name="email" /> <label
							for="email">Email</label>
							
						
					</div>
					<div class="form-floating">
						<input type="password" class="form-control" id="password"
							placeholder="Password" name="password" /> <label for="password">Password</label>
							<div class="no-error col-sm-4" id="password-err">Please Enter Min 5 Character.</div>
					</div>
					<button type="submit" class="btn btn-primary submit_btn w-100 my-4">Login</button>
				</form>
			</div>
		</div>
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/js/userDataValidation.js"/>"></script>
</body>
</html>
