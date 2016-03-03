package business;

import java.io.Serializable;
import java.util.*;
import dataaccess.*;

import dataaccess.DataAccessFacade;

public class Book extends Publication implements Serializable {

	/**
	 *
	 */
	private int id;
	private static final long serialVersionUID = 2007L;
	private String title;
	private String isbn;
	private boolean popularity;
	public boolean available;
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
	public String getISBN(){
		return isbn;
	}
	public void setISBN(String i){
		this.isbn = i;
	}
	public void addAuthor(Author a){
		authors.add(a);
	}
	public void save(){
		BookDataAccessFacade ba = new BookDataAccessFacade();
		ba.write(this.isbn, this);
	}

	public static Book bookWithISBN(String s){
		BookDataAccessFacade ba = new BookDataAccessFacade();
		Book b = null;
		try{
			b = (Book)ba.read(s);
		}catch(Exception e){
			return null;
		}
		return b;

	}

	public void isAvailable(boolean b) {
		available = b;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
