package dataaccess;

import business.Book;
import business.CheckoutRecord;
import business.LendableCopy;
import business.LibraryMember;

public interface IDataAccessFacade {

	
	void saveLibraryMember(String name, LibraryMember member);
	
	LibraryMember readLibraryMember(String name);
	
	void editLibraryMember(String name, LibraryMember member);
	
	void saveBook(String name, Book book);
	
	Book readBook(String isbn);
	
	void saveLendableCopy(int copyId, LendableCopy lendableCopy);
	
	LendableCopy readLendableCopy(int copyId);
	
	void saveCheckoutRecord(String memberName, CheckoutRecord record);
}
