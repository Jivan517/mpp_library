package business;

import java.time.LocalDate;

public class LibrarianRole implements ILibrarianRole, IRole {

	@Override
	public boolean checkOut(LibraryMember member, LendableCopy copy, LocalDate dueDate, LocalDate checkoutDate) {
		// TODO Auto-generated method stub
		return false;
	}

}
