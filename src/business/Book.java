package business;

import java.io.Serializable;
import java.util.*;

public class Book extends Publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String isbn;
	private boolean available, popularity;
	private String title;
	private ArrayList<Author> authors;
	
	public Book(String isbn, String title, ArrayList<Author> authors)
	{
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
	}
	public Book(String isbn) {
		this.isbn = isbn;
	}
	
	public static Book bookWithISBN(String s){
		Book b = new Book(s);
		return b;
		
	}
	
	public void isAvailable(boolean b) {
		available = b;
	}
	
	@Override
	public String toString() {
		return " isbn: " + isbn + ", available: " + available;
	}
}
