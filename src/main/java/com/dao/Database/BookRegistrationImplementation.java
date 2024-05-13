package com.dao.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.BookList;
import com.model.RetieveDetails;


public class BookRegistrationImplementation implements BookRegistration{
	
	public void save(BookList b) {
		System.out.println("records are saved");
		String sql = "insert into bookLists( book_name,book_edition, book_price) values(?,?,?)";
		try {
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1,b.getBook_name());
			prepareStatement.setInt(2, b.getBook_Edition());
			prepareStatement.setDouble(3, b.getBook_price());
			prepareStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
