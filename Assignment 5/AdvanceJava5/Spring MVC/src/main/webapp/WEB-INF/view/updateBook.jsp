<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Edit Book</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link href="<c:url value="/resources/css/addBookPageStyle.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/error.css"/>" rel="stylesheet" />

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expiers", 0);
	%>
	<c:if test="${cookie.librarian.value == null }">
		<c:redirect url="/librarian/loginPage" />
	</c:if>

	<section class="wrapper mt-5">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-sm-8 text-center">
					<div class=" d-flex flex-row justify-content-end ">
						<a href="loginPage.jsp"><button
								class="btn btn-danger btn-sm">Logout</button></a>
					</div>
					<div class="row offset-sm-3">
						<div class="col-sm-5">
							<h3 class="text-dark fw-bold fs-4 mb-3 ">Edit Book Details</h3>
						</div>
					</div>

					<form action="../../books/updateBook"
						class="rounded bg-white shadow p-4" method="post" novalidate
						onsubmit="return isTitleValid();">
						<div class="row mb-2">
							<label for="code" class="col-sm-3 col-form-label">Code</label>
							<div class="col-sm-5 offset-sm-1">
								<input type="number" class="form-control" id="code" name="code"
									placeholder="Code" value="${book.id}" readonly />
							</div>
						</div>
						<div class="row mb-2">
							<label for="name" class="col-sm-3 col-form-label">Book
								Name</label>
							<div class="col-sm-5 offset-sm-1">
								<input type="text" class="form-control" id="name"
									name="bookName" placeholder="Book Name" value="${book.title }" />
							</div>
							<div class="row col-sm-4 offset-sm-4 no-error" id="name-err">
								<span>Please enter book name</span>
							</div>
						</div>
						<div class="row mb-2">
							<label for="author" class="col-sm-3 col-form-label">Author</label>
							<div class="col-sm-5 offset-sm-1">
								<select class="form-control" name="authorId" id="author">
									<optgroup label="Select Author">
										<c:forEach items="${authors}" var="author">
											<c:choose>
												<c:when test="${author.id eq book.author.id }">
													<option value="${author.id}" selected>${author.name}</option>
												</c:when>
												<c:otherwise>
													<option value="${author.id}">${author.name}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</optgroup>
								</select>
							</div>
							<div class="row col-sm-8 no-error" id="usr-err">
								<span>Please select author</span>
							</div>
						</div>
						<div class="row mb-2">
							<label for="date_added" class="col-sm-3 col-form-label">Date
								Added</label>
							<div class="col-sm-5 offset-sm-1">
								<input type="date" class="form-control" id="date_added"
									name="date" placeholder="date_added" value="${book.addedDate}"
									readonly />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4 offset-sm-1">
								<button type="submit"
									class="btn btn-primary submit_btn w-100 my-4">Submit</button>
							</div>
							<div class="col-sm-4">
								<button type="reset"
									class="btn btn-danger submit_btn w-100 my-4">Clear</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/js/bookDetailValidation.js"/>"></script>

</body>
</html>