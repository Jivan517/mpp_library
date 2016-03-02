package dataaccess;

import business.LibraryMember;

public class DataAccessFacade  {
	
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	private LibraryMemberDataAccess libraryMember;
	
	public DataAccessFacade(){
		this.libraryMember = new LibraryMemberDataAccess();
	}
	
	public void saveLibraryMember(String name, LibraryMember member) {
		libraryMember.write(name, member);
	}
	public LibraryMember readLibraryMember(String name) {
		return (LibraryMember)libraryMember.read(name);
	}
	
}
