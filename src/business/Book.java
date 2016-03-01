package business;

import java.io.Serializable;
import java.util.*;

public class Book extends Publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String isbn;
	private boolean available, popularity;
	private String title;
	private ArrayList<Author> authors;
	
	public static Book bookWithISBN(String s){
		Book b = new Book(s);
		return b;
		
	}
	public Book(String isbn) {
		this.isbn = isbn;
	}
	public void isAvailable(boolean b) {
		available = b;
	}
	@Override
	public String toString() {
		return "id: " + id + ", isbn: " + isbn + ", available: " + available;
	}
}
