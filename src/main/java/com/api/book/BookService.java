package com.api.book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import entities.Book;

@Component
public class BookService {

	private static List<Book> list=new ArrayList<Book>();
	
	static
	{
		list.add(new Book(120,"java","james gosling"));
		list.add(new Book(3,"python","abc"));
		list.add(new Book(4,"c","xyz"));
	}
	
	//get all book
	public List<Book> getAllBook()
	{
		 
		return list;
	}
   
	//single book by id
   public Book getBookById(int id)
   {
   Book book = list.stream().filter(e-> e.getId()==id).findFirst().get();
     return book;	
   }
   
   public Book addBook(Book b)
   {
	list.add(b);
	return b;
	   
}
   
   public void deleteBook(int bid)
   {
	list.stream().filter(book->
	{
		if(book.getId()!=bid)
		{
			return true;
		}else
		{
			return false;
		}
	}).collect(Collectors.toList());   
   }
}
