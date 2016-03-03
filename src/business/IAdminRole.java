package business;

public interface IAdminRole extends IRole {
	public boolean addCopy(LendableCopy copy);
	public boolean addBook(Book book);
	public boolean addMember(LibraryMember member);
	public boolean editMember(LibraryMember member);
}
