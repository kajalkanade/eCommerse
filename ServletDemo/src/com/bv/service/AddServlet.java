package com.bv.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String manufracturingDate = request.getParameter("manufracturingDate");
		Date dateS=null;
		//ps.setDate(6, new java.sql.Date(affiliate.getDate().getTime()));
		SimpleDateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");
		int status = 0;
		try {
			dateS=date1.parse(manufracturingDate);
			java.sql.Date dateSql = new java.sql.Date(dateS.getTime());
			Products prod = new Products();
			prod.setProductname(prodName);
			prod.setManufacturername(manufacturerName);
			prod.setPrice(Double.parseDouble(price));
			prod.setManufracturingDate(dateSql);
			
			status = ProductHandler.addProducts(prod);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
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
