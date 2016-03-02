package business;

import java.io.Serializable;
import java.util.*;
import dataaccess.*;

import dataaccess.DataAccessFacade;

public class Book extends Publication implements Serializable {

	/**
	 *
	 */
	private long id;
	private static final long serialVersionUID = 2007L;
	private String title;
	private String isbn;
	private boolean popularity;
	public boolean available;
	private int maxCheckoutLength;
	private ArrayList<Author> authors;

	public Book(String isbn, String title, ArrayList<Author> authors)
	{
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		authors = new ArrayList();
	}

	public Book() {
		authors = new ArrayList();
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
	public String getAuthor(){
		String ret = "";
		for(int i = 0; i < authors.size(); i++){
			Author a = authors.get(i);
			ret += a.getFullname();
		}
		return ret;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}

	public void setMaxCheckoutLength(int maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}
}
