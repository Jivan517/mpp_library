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

public LibraryMember(){

}
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

	public String getFirstName() {
		return personalInfo.getFirstName();
	}

	public String getLastName() {
		return personalInfo.getLastName();
	}
	public String getMemberId() {
		return memberId;
	}


	public Address getAddress() {
		return personalInfo.getAddressObject();
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

	public void checkout(LendableCopy copy, LocalDate checkoutDate, LocalDate dueDate) {
		CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
		record.addEntry(entry,this);
	}

	public CheckoutRecord getCheckoutRecord(){
		return this.record;
	}

	public String toString() {
		return "Checkout record for library member " + personalInfo.getName() + ": " + record;
	}
	public LibraryMember getLiberaryMemberByID(String id)
	{
		return accessFacade.readLibraryMember(id);
	}
	public String getPhone(){
		return this.personalInfo.getPhone();
	}
	public void addFineEntry(CheckoutRecordEntry re, double fine){
		FineRecord fr = FineRecord.readFineRecord(this.memberId);
		if(fr == null){
			fr = new FineRecord(this);
		}
		FineEntry fe = new FineEntry(null, re.getReturnedDate(), fine, re);
		fr.addEntry(fe);
		fr.save(this.memberId);
	}
}
