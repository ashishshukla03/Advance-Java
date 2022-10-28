package com.nagarro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nagarro.dao.ProductDao;
import com.nagarro.controller.Factory;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteServlet() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unused")
		PrintWriter out=response.getWriter();
		try {
	
		int id=Integer.parseInt(request.getParameter("id"));
		ProductDao pdao=new ProductDao(Factory.getFactory());
		pdao.deleteProduct(id);

		response.sendRedirect("admin.jsp");	
		} catch (Exception e) {
			
		}
		doGet(request, response);
	}

}
