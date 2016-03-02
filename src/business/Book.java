package business;

import java.io.Serializable;
import java.util.*;
import dataaccess.*;

public class Book extends Publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2007L;
	
	private String isbn;
	private boolean available;
	private boolean popularity;
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
		BookDataAccessFacade ba = new BookDataAccessFacade();
		Book b = (Book)ba.read(s);
		return b;
	}
	
	public void isAvailable(boolean b) {
		available = b;
	}
	
	@Override
	public String toString() {
		return " isbn: " + isbn + ", available: " + available;
	}
	public boolean isPopularity() {
		return popularity;
	}
	public void setPopularity(boolean popularity) {
		this.popularity = popularity;
	}
}
