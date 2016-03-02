package dataaccess;

import business.Book;
import business.LendableCopy;
import business.LibraryMember;

public class DataAccessFacade  {

	public static final String DATE_PATTERN = "MM/dd/yyyy";
	private DataAccess libraryMember;
	private DataAccess book;
	private DataAccess lendableCopy;
	private DataAccess fines;

	public DataAccessFacade(){
		this.libraryMember = new LibraryMemberDataAccess();
		this.book = new BookDataAccessFacade();
		this.lendableCopy =  new LendableCopyDataAccess();
	}

	public void saveLibraryMember(String name, LibraryMember member) {
		libraryMember.write(name, member);
	}


	public LibraryMember readLibraryMember(String name) {
		return (LibraryMember)libraryMember.read(name);
	}


	public void saveBook(String name, Book book) {
		this.book.write(name, book);
	}
	public Book readBook(String isbn) {
		return (Book)book.read(isbn);
	}

	public void saveLendableCopy(int copyId, LendableCopy lendableCopy) {
			this.lendableCopy.write(Integer.toString(copyId), lendableCopy);
	}

	public LendableCopy readLendableCopy(int copyId) {
		return (LendableCopy)lendableCopy.read(Integer.toString(copyId));
	}

}
