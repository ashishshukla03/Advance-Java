package spring.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;

import spring.web.entity.Librarian;

@Service
public class LibrarianServices {

	private final WebClient webClient;
	
	@Autowired
	public LibrarianServices(final WebClient webClient) {
		this.webClient=webClient;
	}
	

	public Librarian getLibrarianById(int id) {
		return webClient.get().uri("/librarians/{id}",id)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, respone->{return null;})
				.onStatus(HttpStatus::is5xxServerError, response->{return null;})
				.bodyToMono(Librarian.class)
				.block();
	}


	public Librarian getLibrarianByEmail(String email) {
		Librarian lib = null;
		try {
		lib= webClient.get().uri("/librarians/email-id/{id}",email)
				.retrieve()
				.bodyToMono(Librarian.class)
				.block();
		}catch(WebClientResponseException wcre) {
			if(wcre.getStatusCode().is4xxClientError()) {
				return null;
			}
		}
		return lib;
	}
	

	public Librarian getLibrarianByEmailAndPassword(String email, String password) {
		String uri = UriComponentsBuilder.fromUriString("/librarians")
				     .queryParam("uesrname", email)
				     .queryParam("password", password)
				     .build()
				     .toUriString();
		return webClient.get().uri(uri)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, respone->{return null;})
				.onStatus(HttpStatus::is5xxServerError, response->{return null;})
				.bodyToMono(Librarian.class)
				.block();
	}



	public List<Librarian> getLibrarians() {
		return webClient.get().uri("/librarians/all-librarians")
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, respone->{return null;})
				.onStatus(HttpStatus::is5xxServerError, response->{return null;})
				.bodyToFlux(Librarian.class)
				.collectList()
				.block();
	}


	public Librarian postLibrarian(Librarian librarian) {
		return webClient.post().uri("/librarians")
				.bodyValue(librarian)
				.retrieve()
				.onStatus(HttpStatus::is5xxServerError, response->{return null;})
				.bodyToMono(Librarian.class)
				.block();
	}


	public Librarian putLibrarian(Librarian librarian) {
		return webClient.put().uri("/librarians")
				.bodyValue(librarian)
				.retrieve()
				.bodyToMono(Librarian.class)
				.block();
	}
	

	public void deleteLibrarianById(int id) {
		webClient.delete().uri("/librarians/{id}",id)
		.retrieve()
		.bodyToMono(Librarian.class)
		.block();
	}
}
