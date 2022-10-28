package com.nagarro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.dao.ProductDao;
import com.nagarro.controller.Factory;
import com.nagarro.entities.Products;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		try {
	
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String size=request.getParameter("size");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String image=request.getParameter("image");
		
  
		ProductDao pdao=new ProductDao(Factory.getFactory());
		Products prod = new Products(id, title, quantity, size, image);
		pdao.updateProduct(prod);
		response.sendRedirect("admin.jsp");	
		} catch (Exception e) {
		}
		doGet(request, response);
		doGet(request, response);
	}
}
