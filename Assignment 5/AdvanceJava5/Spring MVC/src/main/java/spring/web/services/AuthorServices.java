package spring.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import spring.web.entity.Author;

@Service
public class AuthorServices {

	private final WebClient webClient;
	
	@Autowired
	public AuthorServices(final WebClient webClient) {
		this.webClient = webClient;
	}
	

	public Author getAuthorById(int id) {
		return webClient.get().uri("/authors/{id}",id)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, respone->{return null;})
				.onStatus(HttpStatus::is5xxServerError, response->{return null;})
				.bodyToMono(Author.class)
				.block();
	}

	public Author getAuthorByName(String name) {
	Author author = null;
	try {
		author = webClient.get().uri("/authors/name/{name}",name)
				.retrieve()
				.bodyToMono(Author.class)
				.block();
	}catch(WebClientResponseException wcre) {
		author = null;
	}
	return author;
	}


	public List<Author> getAuthors() {
		List<Author> authorList= webClient.get().uri("/authors")
				.retrieve()
				.bodyToFlux(Author.class)
				.collectList()
				.block();
		authorList.forEach(System.out::println);
		return authorList;
	}

	public Author postAuthor(Author author) {
		return webClient.post().uri("/authors")
				.bodyValue(author)
				.retrieve()
				.bodyToMono(Author.class)
				.block();
	}

	public Author putAuthor(Author author) {
		return webClient.put().uri("/authors")
				.bodyValue(author)
				.retrieve()
				.bodyToMono(Author.class)
				.block();
	}

	public void deleteAuthorById(int id) {
		webClient.delete().uri("/authors/{id}",id)
		.retrieve()
		.bodyToMono(Author.class)
		.block();
	}
}
