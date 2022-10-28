package spring.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.web.entity.Author;
import spring.web.entity.Book;
import spring.web.services.AuthorServices;
import spring.web.services.BookServices;

@Controller
@RequestMapping(path="/books")
public class bookController {

	private final BookServices bookService;
    private final AuthorServices authorService;	
	
	@Autowired
	public bookController(final BookServices bookService, final AuthorServices authorService) {
		this.bookService=bookService;
		this.authorService=authorService;
	}

	@GetMapping(path="/addBookPage")
	public ModelAndView addBookPage(@ModelAttribute("bookCodeExists")String bookCodeExists, @ModelAttribute("book")Book book) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addBook");
		mv.addObject("authors", authorService.getAuthors());
		mv.addObject("bookCodeExists", bookCodeExists);
		mv.addObject("book", book);
		return mv;
	}
	
	@GetMapping(path="/updateBookPage/{id}")
	public ModelAndView updateBookPage(@PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateBook");
		mv.addObject("book", bookService.getBookById(id));
		mv.addObject("authors", authorService.getAuthors());
		return mv;
	}
	
	@GetMapping(path="/bookManagement")
	public ModelAndView bookManagement() {
		ModelAndView mv = new ModelAndView();
		List<Book> bookList = bookService.getBooks();
		mv.setViewName("booksManagement");
		mv.addObject("bookList",bookList);
		return mv;
	}
	
	@GetMapping(path="/{id}")
	public Book getBook(@PathVariable("id")int id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping(path="/allBooks")
	public List<Book> getBooks(){
		return bookService.getBooks();
	}
	
	@PostMapping(path="/postBook", consumes= {"application/x-www-form-urlencoded"})
	public String postBook(int code, String bookName, String authorId, LocalDate date, RedirectAttributes ra) {
		Book existingBook = bookService.getBookById(code);
		Author author = authorService.getAuthorById(Integer.valueOf(authorId));
		Book book = new Book(code, bookName,date, author);
		if (existingBook == null) {
			book.setAddedDate(LocalDate.now());
			bookService.postBook(book);
			return "redirect:bookManagement";
		} else {
			ra.addFlashAttribute("bookCodeExists", true);
			ra.addFlashAttribute("book", book);
			return "redirect:addBookPage";
		}
	}
	
	@RequestMapping(path="/updateBook", method=RequestMethod.POST, consumes= {"application/x-www-form-urlencoded"})
	public String putBook(int code, String bookName, int authorId, @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
		Book book = new Book(code, bookName,date, authorService.getAuthorById(authorId));
		bookService.putBook(book);
		return "redirect:bookManagement";
	}
	
	@RequestMapping(path="/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
	    bookService.deleteBookById(id);
	    return "redirect:../bookManagement";
	}
}
