package org.cybage.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cybage.dao.ProductDao;
import org.cybage.bean.Product;

public class MyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public MyServlet() {
    super();
    // TODO Auto-generated constructor stub
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    if (request.getParameter("Action").equals("addProduct")) {
      System.out.println("in");
      PrintWriter printWriter = response.getWriter();
      Product product = new Product();
      ProductDao dao = new ProductDao();
      product.setName((request.getParameter("name")));
      product.setPrice((request.getParameter("price")));
     
      RequestDispatcher dispatcher = request.getRequestDispatcher("addProduct.jsp");
      dispatcher.include(request, response);
      printWriter.print("<br><h2>Product added Successfully!!</h2>");
    }
    if (request.getParameter("Action").equals("edit")) {
      PrintWriter printWriter = response.getWriter();
      Product product = new Product();
      ProductDao dao = new ProductDao();
      product.setId(Integer.parseInt(request.getParameter("id")));
      product.setName(request.getParameter("name"));
      product.setPrice(request.getParameter("price"));
     
      boolean result = dao.editProduct(product);
      System.out.println(result);
      RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
      dispatcher.include(request, response);
      printWriter.print("<br><h2>Product Edited Successfully!!</h2>");
    }
    if (request.getParameter("Action").equals("delete")) {
      PrintWriter printWriter = response.getWriter();
      Product product = new Product();
      ProductDao dao = new ProductDao();
      dao.deleteProduct(Integer.parseInt(request.getParameter("id")));
      RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
      dispatcher.include(request, response);
      printWriter.print("<br><h2>Product Deleted Successfully!!</h2>");
    }
  }
}