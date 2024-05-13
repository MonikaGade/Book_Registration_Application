package com.model;

public class BookList {
	
	private int book_id;
	private String book_name;
	private int book_Edition;
	private double book_price;
	public BookList( String book_name, int book_Edition, double book_price) {
		
		this.book_name = book_name;
		this.book_Edition = book_Edition;
		this.book_price = book_price;
	}
	public BookList() {
		super();
	}
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_Edition() {
		return book_Edition;
	}
	public void setBook_Edition(int book_Edition) {
		this.book_Edition = book_Edition;
	}
	public double getBook_price() {
		return book_price;
	}
	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}
	@Override
	public String toString() {
		return "BookList [ book_name=" + book_name + ", book_Edition=" + book_Edition
				+ ", book_price=" + book_price + "]";
	}
	

}
