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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String prodName = request.getParameter("productname");
		String manufacturerName = request.getParameter("manufacturername");
		String price = request.getParameter("price");

		Products prod = new Products();
		prod.setId(id);
		prod.setProductname(prodName);
		prod.setManufacturername(manufacturerName);
		prod.setPrice(Double.parseDouble(price));

		int status = ProductHandler.updateProducts(prod);

		if (status > 0) {
			/*
			 * out.print("<h2>Product Updated successfully</h2>");
			 */
			response.sendRedirect("viewProducts.jsp");
		} else {
			out.print("<h2>Error updating the record</h2>");
			out.print("<a href='viewProducts.jsp'>view products</a>");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
