package spring.web.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Book {
	
	private int id;
	private String title;
	@JsonFormat(pattern="yyyy-MM-dd", shape=JsonFormat.Shape.STRING)
	private LocalDate addedDate;
	private Author author;

	public Book() {
		super();
	}

	public Book(int id, String title, LocalDate addedDate, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.addedDate=addedDate;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
