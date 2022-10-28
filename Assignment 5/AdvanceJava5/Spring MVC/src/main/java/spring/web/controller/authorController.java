package spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.web.entity.Author;
import spring.web.services.AuthorServices;

@Controller
@RequestMapping(path="/authors")
public class authorController {

private final AuthorServices authorService;
	
	@Autowired
	public authorController(final AuthorServices authorService) {
		this.authorService=authorService;
	}
	
	@GetMapping()
	public List<Author> getAuthors(){
		return authorService.getAuthors();
	}
}
