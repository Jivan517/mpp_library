package business;

import java.time.LocalDate;

public interface ILibrarianRole extends IRole {
public boolean checkOut(LibraryMember member,Book copy,
		LocalDate dueDate,LocalDate checkoutDate);
}
