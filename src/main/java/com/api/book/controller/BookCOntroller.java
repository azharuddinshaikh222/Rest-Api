package com.api.book.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.BookService;
import entities.Book;


@RestController
public class BookCOntroller {
  
     @Autowired	
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		
		return this.bookService.getAllBook();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
	
		return bookService.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
	Book b=this.bookService.addBook(book);
	return b;
	}
	
	//delete book handler
	
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
    this.bookService.deleteBook(bookId);
    
	}
}
