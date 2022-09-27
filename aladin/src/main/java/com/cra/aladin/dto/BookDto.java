package com.cra.aladin.dto;

import java.util.Date;

public class BookDto {
	int book_no;
	int category_no;
	String book_title;
	String book_author;
	String book_publisher;
	String book_image;
	String book_image_src;
	String book_summary;
	String book_publish_date;
	int isbn;
	int book_page;
	Date book_input_date;
	
	public BookDto(){
		
	}
	
	public BookDto(int book_no, int category_no, String book_title, String book_author, String book_publisher,
			String book_image, String book_image_src, String book_summary, String book_publish_date, int isbn,
			int book_page, Date book_input_date) {
		super();
		this.book_no = book_no;
		this.category_no = category_no;
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_publisher = book_publisher;
		this.book_image = book_image;
		this.book_image_src = book_image_src;
		this.book_summary = book_summary;
		this.book_publish_date = book_publish_date;
		this.isbn = isbn;
		this.book_page = book_page;
		this.book_input_date = book_input_date;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_publisher() {
		return book_publisher;
	}

	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	public String getBook_image_src() {
		return book_image_src;
	}

	public void setBook_image_src(String book_imageSrc) {
		this.book_image_src = book_imageSrc;
	}

	public String getBook_summary() {
		return book_summary;
	}

	public void setBook_summary(String book_summary) {
		this.book_summary = book_summary;
	}

	public String getBook_publish_date() {
		return book_publish_date;
	}

	public void setBook_publish_date(String book_publish_date) {
		this.book_publish_date = book_publish_date;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getBook_page() {
		return book_page;
	}

	public void setBook_page(int book_page) {
		this.book_page = book_page;
	}

	public Date getBook_input_date() {
		return book_input_date;
	}

	public void setBook_input_date(Date book_input_date) {
		this.book_input_date = book_input_date;
	}

	@Override
	public String toString() {
		return "BookDto [book_no=" + book_no + ", category_no=" + category_no + ", book_title=" + book_title
				+ ", book_author=" + book_author + ", book_publisher=" + book_publisher + ", book_image=" + book_image
				+ ", book_imageSrc=" + book_image_src + ", book_summary=" + book_summary + ", book_publish_date="
				+ book_publish_date + ", isbn=" + isbn + ", book_page=" + book_page + ", book_input_date="
				+ book_input_date + "]";
	}



	
	
}
