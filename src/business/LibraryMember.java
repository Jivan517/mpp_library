package business;

import java.io.Serializable;
import java.time.LocalDate;

import dataaccess.DataAccessFacade;

public class LibraryMember implements Serializable {

	private static final long serialVersionUID = -2226197306790714013L;

	private CheckoutRecord record = new CheckoutRecord();
	private PersonalInfo personalInfo;
	private String memberId;
	private transient DataAccessFacade accessFacade = new DataAccessFacade();


	public LibraryMember(String memberId, String firstName, String lastName, String phone, String street, String city, String state, String zip) {

		this.personalInfo = new PersonalInfo(firstName, lastName, phone, street, city, state, zip);
		this.memberId = memberId;
	}

	public LibraryMember(String memberId, String firstName, String lastName){
		this.personalInfo = new PersonalInfo(firstName, lastName);
		this.memberId = memberId;
	}

	public CheckoutRecord getRecord() {
		return record;
	}


	public void setRecord(CheckoutRecord record) {
		this.record = record;
	}


	public String getName() {
		return personalInfo.getName();
	}

	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public DataAccessFacade getAccessFacade() {
		return accessFacade;
	}


	public void setAccessFacade(DataAccessFacade accessFacade) {
		this.accessFacade = accessFacade;
	}

	public void checkout(Book copy, LocalDate checkoutDate, LocalDate dueDate) {
		CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
		record.addEntry(entry,this);
		System.out.println(copy.getTitle());
	}

	public CheckoutRecord getCheckoutRecord(){
		return this.record;
	}

	public String toString() {
		return "Checkout record for library member " + personalInfo.getName() + ": " + record;
	}


}
