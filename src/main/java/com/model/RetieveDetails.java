package com.model;

public class RetieveDetails {
private int book_id;
private String book_name;
private int book_edition;
private double book_price;
public RetieveDetails(int book_id, String book_name, int book_edition, double book_price) {
	super();
	this.book_id = book_id;
	this.book_name = book_name;
	this.book_edition = book_edition;
	this.book_price = book_price;
}
public int getBook_id() {
	return book_id;
}
public void setBook_id(int book_id) {
	this.book_id = book_id;
}
public String getBook_name() {
	return book_name;
}
public void setBook_name(String book_name) {
	this.book_name = book_name;
}
public int getBook_edition() {
	return book_edition;
}
public void setBook_edition(int book_edition) {
	this.book_edition = book_edition;
}
public double getBook_price() {
	return book_price;
}
public void setBook_price(double book_price) {
	this.book_price = book_price;
}


}
