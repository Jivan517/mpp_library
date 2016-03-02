package business;

import java.io.Serializable;
import java.time.LocalDate;

import dataaccess.DataAccessFacade;
import dataaccess.LibraryMemberDataAccess;

public class LibraryMember implements Serializable {
	private CheckoutRecord record = new CheckoutRecord();
	private String name;
	private String memberId;
	private transient DataAccessFacade accessFacade = new DataAccessFacade();
	
	public LibraryMember(String memberId, String name) {
		this.name = name;
		this.memberId = memberId;
	}
	
	
	public void checkout(LendableCopy copy, LocalDate checkoutDate, LocalDate dueDate) {
		CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
		record.addEntry(entry);
		
	}
	
	public void save(){
		
		accessFacade.saveLibraryMember(this.name, this);
	}
	
	public String toString() {
		return "Checkout record for library member " + name + ": " + record;
	}
	
	private static final long serialVersionUID = -2226197306790714013L;
}
