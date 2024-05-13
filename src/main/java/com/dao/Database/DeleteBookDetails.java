package com.dao.Database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet (name="delete",urlPatterns = "/delete")
public class DeleteBookDetails extends GenericServlet {

	public void service(ServletRequest res, ServletResponse req) throws ServletException, IOException {
		String sql="delete from bookLists where book_id=?";
		ConnectionFactory conn = new ConnectionFactory();
		 int id = Integer.parseInt(res.getParameter("id"));
		 
		
		try {
			
			Connection co = conn.getConnection();
			PreparedStatement ps = co.prepareStatement(sql);
			ps.setInt(1,id);
			int deleted = ps.executeUpdate();
			PrintWriter writer = req.getWriter();
			req.setContentType("text/html");
			writer.println("<link rel='stylesheet' href='css/bootstrap.css'>");
			writer.println("<h2 class='text-danger center'>Records are deleted successully</h2>");
			writer.println("<a href='index.html' class='btn btn-primary'>Home</a>");
			writer.println("<a href='bookList' class='btn btn-success'>BookList</a>");	
		} catch (SQLException e) {

			e.printStackTrace();
		}
		   
		   
		
	}

}
