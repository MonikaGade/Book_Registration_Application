package com.dao.Database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.BookList;
import com.model.RetieveDetails;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet (name="bookList",urlPatterns = "/bookList")
public class DisplayDetailsofBooks extends GenericServlet implements BookRegistration {

		

	@Override
	public void save(BookList b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest res, ServletResponse req) throws ServletException, IOException {
		String sql="select * from bookLists";
		ConnectionFactory conn = new ConnectionFactory();
		try {
			Connection co = conn.getConnection();
			Statement st = co.createStatement();
			ResultSet rs= st.executeQuery(sql);
			PrintWriter writer =req.getWriter();
			req.setContentType("text/html");
			writer.println("<link rel='stylesheet' href='css/bootstrap.css'>");
			   writer.println("<table class='table'>");
			   writer.println("<thead>");
			   writer.println("<tr>");
			   writer.println("<th>Book Id</th>");
			   writer.println("<th>Book Name</th> ");
			   writer.println("<th>Book Edition</th> ");
			   writer.println("<th>Book Price</th>");
			   writer.println("<th>Edit</th> ");
			   writer.println("<th>Delete</th>");
			   writer.println("</tr>");
			    
			while(rs.next()) {
				int id=rs.getInt(1);
				String book_name=rs.getString(2);
				int book_edition=rs.getInt(3);
				Double book_price=rs.getDouble(4);
				System.out.println(id+ " "+ book_name+" "+ book_edition+ " " +book_price);
 
				  writer.println("<tr>");
				  writer.println("<td>"+ id +"</td>");
				  writer.println("<td>"+ book_name +"</td>");
				  writer.println("<td>"+ book_edition +"</td>");
				  writer.println("<td>"+book_price +"</td>");
				  writer.println("<td>"+"<a class='btn btn-success' href='edit?id="+ id +"'" + " >EDIT</a>");
				  writer.println("<td>"+"<a class='btn btn-danger' href='delete?id="+ id +"'" + " >DELETE</a>");
				  writer.println("</tr>");

			}
			
			writer.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
		
	}
	
}
