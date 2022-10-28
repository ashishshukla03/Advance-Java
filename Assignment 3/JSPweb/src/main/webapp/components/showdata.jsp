<%@page import="com.nagarro.controller.Factory"%>
<%@page import="com.nagarro.dao.ProductDao"%>
<%@page import="java.util.List"%>
<%@page import="com.nagarro.entities.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management Tool</title>
</head>
<body>

<%
ProductDao pdao=new ProductDao(Factory.getFactory());
List<Products>list=pdao.getProducts();

%>
 <div class="show-content">
                <table class="content-table" border="1">
                    <tr>
                        <th>ProdID</th>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Size</th>
                        <th>Image</th>
                        <th>Actions</th>
                    </tr>
                    <% for(Products prod:list){%>
                    <tr>
                    
                        <td><%=prod.getprodID() %></td>
                        <td><%=prod.getTitle() %></td>
                        <td><%= prod.getQuantity() %></td>
                        <td><%=prod.getSize() %></td>
                        <td>
                            <image class="brand-img"
                                src="<%= prod.getImage() %>" />
                        </td>
                        <td>3</td>
                    </tr>
                    <% }%>
                </table>
            </div>
</body>
</html>
