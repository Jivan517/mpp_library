package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dataaccess.BookDataAccess;

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
	private List<Author> authors;
	

	public String getAuthorsName(){
		String ret = "";
		for(int i = 0; i < authors.size(); i++){
			Author a = authors.get(i);
			ret += a.getFullname();
			if(i != authors.size() - 1){
				ret += ",";
			}
		}
		return ret;
	}
	public Book(String isbn, String title, List<Author> authors)
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
		if(a == null){
			System.out.println("a error");
			return;
		}
		if(authors == null){
			System.out.println("array error");
			return;
		}
		authors.add(a);
	}
	public void save(){
		BookDataAccess ba = new BookDataAccess();
		ba.write(this.isbn, this);
	}

	public static Book bookWithISBN(String s){
		BookDataAccess ba = new BookDataAccess();
		Book b = null;
		try{
			b = (Book)ba.read(s);
		}catch(Exception e){
			return null;
		}
		return b;

	}
	@Override
	public void checkinCopy(LendableCopy copy){
		LendableCopy p = null;
		Book nb = Book.bookWithISBN(this.isbn);
		for(int i = 0; i < this.numberOfCopies(); i++){
			p = nb.copies.get(i);
			if(p.getCopyId() == copy.getCopyId()){
				p.setAvailable(true);
				nb.save();
				return ;
			}
		}
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

}