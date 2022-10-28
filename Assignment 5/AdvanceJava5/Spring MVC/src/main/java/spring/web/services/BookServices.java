package spring.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import spring.web.entity.Book;

@Service
public class BookServices {

private final WebClient webClient;
	
	@Autowired
	public BookServices(final WebClient webClient) {
		this.webClient=webClient;
	}
	
	public Book getBookById(int id) {
		Book book = null;
		try {
		book =  webClient.get().uri("/books/{id}",id)
				.retrieve()
				.bodyToMono(Book.class)
				.block();
		}catch(WebClientResponseException wcre) {
			wcre.printStackTrace();
		}
		return book;
	}

	public List<Book> getBooks() {
		List<Book> bookList = null;
		try {
		bookList = webClient.get().uri("/books")
				.retrieve()
				.bodyToFlux(Book.class)
				.collectList()
				.block();
		}catch(WebClientResponseException wcre) {
			wcre.printStackTrace();
		}
		return bookList;
	}

	public Book postBook(Book book) {
		return webClient.post().uri("/books")
				.bodyValue(book)
				.retrieve()
				.bodyToMono(Book.class)
				.block();
	}

	public Book putBook(Book book) {
		return webClient.put().uri("/books")
				.bodyValue(book)
				.retrieve()
				.bodyToMono(Book.class)
				.block();
	}

	public void deleteBookById(Integer id) {
		webClient.delete()
		.uri("/books/{id}",id)
		.retrieve()
		.bodyToMono(Book.class)
		.block();
	}	
}
