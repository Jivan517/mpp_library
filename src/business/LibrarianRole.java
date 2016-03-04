package business;

import java.time.LocalDate;

import dataaccess.DataAccessFacade;

public class LibrarianRole implements ILibrarianRole, IRole {

	private DataAccessFacade accessFacade = new DataAccessFacade();


	@Override
	public boolean checkOut(LibraryMember member, LendableCopy copy, LocalDate dueDate, LocalDate checkoutDate) {
		try{

			member.checkout(copy, checkoutDate, dueDate);
			accessFacade.saveCheckOutRecord(member.getName(), member.getCheckoutRecord());
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

}
