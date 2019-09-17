package com.bv.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bv.handler.ProductHandler;
import com.bv.model.Products;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String prodName = request.getParameter("productname");
		String manufacturerName = request.getParameter("manufacturername");
		String price = request.getParameter("price");
		
		Products prod = new Products();
		prod.setProductname(prodName);
		prod.setManufacturername(manufacturerName);
		prod.setPrice(Double.parseDouble(price));
		
		int status = ProductHandler.addProducts(prod);
		
		if(status>0) {
			out.print("<h2>Product Inserted successfully</h2>");
			out.print("<a href=''></a>");
		}else {
			out.print("<h2>Error inserting the record</h2>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
