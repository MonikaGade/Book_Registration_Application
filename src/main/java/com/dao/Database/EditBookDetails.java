package com.dao.Database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "edit", urlPatterns = "/edit")
public class EditBookDetails extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		ConnectionFactory cn = new ConnectionFactory();
		String sql = "select book_name,book_edition, book_price from bookLists where book_id=?";
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		PrintWriter w = res.getWriter();
		w.println("<html>");
		w.println("<head>");
		w.println("<link rel='stylesheet' href='css/bootstrap.css'>");
		w.println("</head>");
		w.println("<body>");
		w.println("<form method='post' action='editurl?id="+id+"'" + " >");
		w.println("<table class='table text-center table-hover' style='margin-top:1rem'>");
		try {
			Connection conn = cn.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String book_name = rs.getString(1);
				int book_edition = rs.getInt(2);
				Double book_price = rs.getDouble(3);
				System.out.println("-----------------------Editing details data -----------------------------");
				System.out.println(id + " " + book_name + " " + book_edition + " " + book_price);
				w.println("<tr>");
				w.println("<td>Book Name</td>");
				w.println("<td><input type='text' name='bookName' value="+ book_name +"></td>");
				w.println("</tr>");
				w.println("<tr>");
				w.println("<td>Book Edition</td>");
				w.println("<td><input type='text' name='bookEdition' value="+ book_edition +"></td>");
				w.println("</tr>");
				w.println("<tr>");
				w.println("<td>Book Price</td>");
				w.println("<td><input type='text' name='bookPrice' value="+ book_price +"></td>");
				w.println("</tr>");
				w.println("<tr>");
				w.println("<td><input type='submit' class='btn btn-success' value='Edit'></td>");
				w.println("<td><input type='reset' class='btn btn-primary text-white' value='cancel'></td>");
				w.println("</tr>");
				
				
			}
//			w.println("</table>");
//			w.println("</form >");
//			w.println("</body>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

