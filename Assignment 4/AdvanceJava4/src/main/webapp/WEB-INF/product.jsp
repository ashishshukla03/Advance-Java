<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page isELIgnored="false" %>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>


<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Hind+Siliguri:wght@600&display=swap" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
  <title>Product</title>
</head>

<body>
  <nav class="navbar navbar-light">
    <div class="container-fluid"><h1>
      <span class="navbar-text">Product Management Tools </span></h1>
      <form class="d-flex" action="login.jsp" method = "post">
        <button class="logout-btn btn btn-primary" type="submit">
          logout
        </button>
      </form>
    </div>
  </nav>
  <div class="row mb-4 input-details">
  <h4>
    <span id="input-detail-text">
      Enter the details:
    </span>
    </h4>
    <form action="search" name="tshirtForm" style="align-items: center" method="post">
      <div class="row mb-3">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Colour</label>
        <div class="col-sm-10">
          <input type="text" class="form-control"  name="colour" placeholder="Enter t-shirt colour" required/>
          <span class="error"><p id="colour_error" ></p></span>
        </div>
      </div>
      <div class="row mb-3">
        <label for="inputPassword3" class="col-sm-2 col-form-label">Size</label>
        <div class="col-sm-10">
          <input type="text" class="form-control"  name="size" placeholder="S, M, L, XL, XXL" required />
          <span class="error"><p id="size_error" ></p></span>
        </div>
      </div>
      <div class="row mb-3">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Gender</label>
        <div class="col-sm-10">
          <input type="text" class="form-control"  name="gender" placeholder="M, F, U" required />
          <span class="error"><p id="gender_error" ></p></span>
        </div>
      </div>
      <div class="row mb-3">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Output Preferences</label>
        <div class="col-sm-10">
          1<input class="form-check-input" type="radio" name="preference" id="Price" value="1">
          2<input class="form-check-input" type="radio" name="preference" id="Rating" value="2">
          <span class="error"><p id="prefer_error"></p></span>
          <div class="form-text" name="size-text"><span>1-&nbsp;Sorted by Price <br>2-&nbsp; Sorted by Rating</span></div>
        </div>
      </div>
      <div class="d-grid gap-2 d-md-block">
        <button class="browse-btn btn btn-primary" type="submit">
          Search
        </button>
      </div>
    </form>
  </div>
  <div class="container-fluid">
  <c:if test="${list!=null}">
  <table class="table table-striped">
  
  		<thead>
        	<th class="table-heading" style="text-align: center;">ID</th>
        	<th class="table-heading" style="text-align: center;">Name</th>
        	<th class="table-heading" style="text-align: center;">Colour</th>
            <th class="table-heading" style="text-align: center;">Gender_Recommendation</th>
            <th class="table-heading" style="text-align: center;">Size</th>
            <th class="table-heading" style="text-align: center;">Price</th>
            <th class="table-heading" style="text-align: center;">Rating</th>
            <th class="table-heading" style="text-align: center;">Availability</th>
         </thead>
         <tbody>
         <c:forEach items="${list}" var="iter">
			<tr>
				<td style="text-align: center;">${iter.getId()}</td>
				<td style="text-align: center;">${iter.getName()}</td>
				<td style="text-align: center;">${iter.getColour()}</td>
         		<td style="text-align: center;">${iter.getGender_Recommendation()}</td>
         		<td style="text-align: center;">${iter.getSize() }</td>
         		<td style="text-align: center;">${iter.getPrice()}</td>
         		<td style="text-align: center;">${iter.getRating()}</td>
         		<td style="text-align: center;">${iter.getAvailability() }</td>
         		
			</tr>
         </c:forEach>
         </tbody>
  </table>
  </c:if>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
</body>

</html>
