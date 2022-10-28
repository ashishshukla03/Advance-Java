<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Book Management</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.14/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,300;0,400;0,500;0,600;0,700;1,800&display=swap"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bookManagementPageStyle.css"/>"
	rel="stylesheet" />
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
	
  	<header>
		<nav class="container-fluid bg-success" style=" height:60px ">
			<div class="row d-flex">
				<div class="col-sm-2 col-sm-offset-8">
					Hi  ${cookie.librarian.value }
				</div>
				<div class="col-sm-1 col-sm-offset-1">
					<a href="/springLibrary/librarian/logout"><button
							class="logout_button">Logout</button></a>
				</div>
			</div>
		</nav>
	</header>
	
	
	<div class="container ">
		<div class="row">
			<div class="col-md-12 main-datatable">
				<div class="card_body">
					
					<div class="row d-flex">
						<div class="col-sm-4 col-sm-offset-5">
							<h3 class="text-dark fw-bolder fs-4 mb-2 ">Books Listing</h3>
						</div>
						<div class="col-sm-4 col-sm-offset-2 createSegment">
							<a href="addBookPage" class="btn dim_button create_new"> <span
								class="glyphicon glyphicon-plus"></span> Add a Book
							</a>
						</div>
					</div>
					<div class="overflow-x">
						<table style="width: 100%;" id="filtertable"
							class="table cust-datatable dataTable no-footer">
							<thead>
								<tr>
									<th style="min-width: 50px;">Code</th>
									<th style="min-width: 150px;">Book Name</th>
									<th style="min-width: 150px;">Author</th>
									<th style="min-width: 100px;">Date Added</th>
									<th style="min-width: 150px;">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${fn:length(bookList) gt 0 }">
									<c:forEach items="${bookList}" var="book">
										<tr>
											<td>${book.id }</td>
											<td>${book.title }</td>
											<td>${book.author.name }</td>
											<td>${book.addedDate}</td>
											<td>
												<a href="updateBookPage/${book.id }" class="btn dim_button Edit"> Edit </a>
												<a href="deleteBook/${book.id}" class="btn dim_button Delete"> Delete </a>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.14/js/jquery.dataTables.min.js"></script>
	<script src="<c:url value="/resources/js/bookManagement.js"/>"></script>
</body>
</html>

