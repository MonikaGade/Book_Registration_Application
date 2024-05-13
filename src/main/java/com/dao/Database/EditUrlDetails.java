package com.dao.Database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet (name="editdetails", urlPatterns = "/editurl")
public class EditUrlDetails extends GenericServlet {

	public void service(ServletRequest res, ServletResponse req) throws ServletException, IOException {
		String sql="update bookLists set book_name=?,book_edition=?,book_price=? where book_id=?";
		ConnectionFactory conn = new ConnectionFactory();
		 int id = Integer.parseInt(res.getParameter("id"));
		 String book_name = res.getParameter("bookName");
		 int book_edition =Integer.parseInt( res.getParameter("bookEdition"));
		 double book_price=Double.parseDouble(res.getParameter("bookPrice"));
		 System.out.println("editing book_details");
		 System.out.println("--------------------");
		 System.out.println(id+" "+book_name+" "+book_edition+" "+book_price);
		 
		 
		
		try {
			
			Connection co = conn.getConnection();
			PreparedStatement ps = co.prepareStatement(sql);
			ps.setString(1, book_name);
			ps.setInt(2, book_edition);
			ps.setDouble(3, book_price);
			ps.setInt(4, id);
			
			int count = ps.executeUpdate();
			System.out.println(count);
			PrintWriter writer =req.getWriter();
			req.setContentType("text/html");
			 if(count==1) {
				 writer.println("<link rel='stylesheet' href='css/bootstrap.css'>");
				 writer.println("<h2 class='text-success'>Records are edited</h2>");
				 
				 writer.println("<a href='index.html' class='btn btn-primary'>Home</a>");
				 writer.println("<a href='bookList' class='btn btn-success'>BookList</a>");
				 
			 }
			 else {
				 writer.println("Records are not edited succesfully");
			 }
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		   
		   
		
	}

}
