package dataaccess;

import business.Book;
import business.FineRecord;
import business.CheckoutRecord;
import business.LendableCopy;
import business.LibraryMember;

public class DataAccessFacade implements IDataAccessFacade  {

	public static final String DATE_PATTERN = "MM/dd/yyyy";
	private DataAccess libraryMember;
	private DataAccess book;
	private DataAccess lendableCopy;
	private DataAccess fines;

	public DataAccessFacade(){
		this.libraryMember = new LibraryMemberDataAccess();
		this.book = new BookDataAccessFacade();
		this.lendableCopy =  new LendableCopyDataAccess();
		this.fines =  new FineRecordDataAccess();
	}

	@Override
	public void saveLibraryMember(String name, LibraryMember member) {
		libraryMember.write(name, member);
	}


	@Override
	public LibraryMember readLibraryMember(String memberID) {
		return (LibraryMember)libraryMember.read(memberID);
	}


	@Override
	public void saveBook(String name, Book book) {
		this.book.write(name, book);
	}

	@Override
	public Book readBook(String isbn) {
		return (Book)book.read(isbn);
	}

	@Override
	public void saveLendableCopy(int copyId, LendableCopy lendableCopy) {
			this.lendableCopy.write(Integer.toString(copyId), lendableCopy);
	}

	@Override
	public LendableCopy readLendableCopy(int copyId) {
		return (LendableCopy)lendableCopy.read(Integer.toString(copyId));
	}


	public void saveFineRecord(String memBerId, FineRecord records) {
		this.fines.write(memBerId, records);
	}

	public FineRecord readFines(String memID) {
		return (FineRecord)fines.read(memID);
	}

	@Override
	public void editLibraryMember(String name, LibraryMember member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveCheckoutRecord(String memberName, CheckoutRecord record) {
		// TODO Auto-generated method stub

	}

}
