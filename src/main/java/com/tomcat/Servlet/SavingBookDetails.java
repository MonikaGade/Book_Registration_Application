package com.tomcat.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.Database.BookRegistrationImplementation;
import com.dao.Database.DisplayDetailsofBooks;
import com.model.BookList;
import com.model.RetieveDetails;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet (name="register",urlPatterns = "/formSubmit")
public class SavingBookDetails extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String bookName = req.getParameter("bookName");
		String bookEdition = req.getParameter("bookEdition");
		String bookPrice = req.getParameter("bookPrice");
	   BookList bookList = new	BookList(bookName,Integer.parseInt(bookEdition),Double.parseDouble(bookPrice));
	   BookRegistrationImplementation bg = new BookRegistrationImplementation();
	   bg.save(bookList);
	   

	   PrintWriter writer = res.getWriter();
	   res.setContentType("text/html");
	   writer.println("<link rel='stylesheet' href='css/bootstrap.css'>");
	   writer.println("<a class='btn btn-primary' href='index.html'>Home</a>");
	   
	   ServletContext sc = getServletContext();
	   RequestDispatcher nd = sc.getNamedDispatcher("bookList");
	   nd.include(req, res);
	   
	   
	}

}
