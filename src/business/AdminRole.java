package business;

import dataaccess.DataAccessFacade;

public class AdminRole implements IRole, IAdminRole {
	
	DataAccessFacade accessFacade = new DataAccessFacade();

	@Override
	public boolean addCopy(LendableCopy copy) {
		try{
			accessFacade.saveLendableCopy(copy.getCopyId(), copy);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean addBook(Book book) {
		try{
			accessFacade.saveBook(book.getTitle(), book);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean addMember(LibraryMember member) {
		
		try{
			accessFacade.saveLibraryMember(member.getName(), member);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean editMember(LibraryMember member) {
		
		try{
			accessFacade.editLibraryMember(member.getName(), member);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

}
