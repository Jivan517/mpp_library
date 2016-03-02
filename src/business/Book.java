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
	private boolean popularity;
	private ArrayList<Author> authors;
	
	public void addAuthor(Author a){
		authors.add(a);
	}
	public void save(){
		BookDataAccessFacade ba = new BookDataAccessFacade();
		ba.write(this.isbn, this);
	}
//	public Book(String isbn, String title, ArrayList<Author> authors)
//	{
//		this.isbn = isbn;
//		this.title = title;
//		this.authors = authors;
//	}
	public Book() {
		authors = new ArrayList();
	}
	
	public static Book bookWithISBN(String s){
		BookDataAccessFacade ba = new BookDataAccessFacade();
		Book b = (Book)ba.read(s);
		return b;
	}
	
	
	@Override
	public String toString() {
		return " isbn: " + isbn;
	}
	public boolean isPopularity() {
		return popularity;
	}
	public void setPopularity(boolean popularity) {
		this.popularity = popularity;
	}
}
