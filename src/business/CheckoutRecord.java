package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dataaccess.CheckOutRecordAccess;

public class CheckoutRecord implements Serializable {

	private static final long serialVersionUID = -3119855589946373695L;
	private LibraryMember member;
	private List<CheckoutRecordEntry> entries = new ArrayList<>();

	public void addEntry(CheckoutRecordEntry c) {
		entries.add(c);
		saveCheckoutRecord();
	}

	public void addEntry(CheckoutRecordEntry c,LibraryMember member) {
		this.member=member;

		CheckoutRecord ccc = readCheckoutRecord(member.getMemberId());

		if(ccc!=null)
		if(ccc.getEentries()!=null)
		entries=ccc.getEentries();
		entries.add(c);
		saveCheckoutRecord();
	}



	public CheckoutRecord() {
		// TODO Auto-generated constructor stub
	}

	public List<CheckoutRecordEntry> getEentries()
	{
		return this.entries;
	}

	public String toString() {
		return entries.toString();
	}

	public void saveCheckoutRecord()
	{
		CheckOutRecordAccess crda = new CheckOutRecordAccess();
		crda.write(member.getMemberId(), this);

		System.out.println(member.getMemberId());
	}

	public CheckoutRecord readCheckoutRecord(String memID)
	{
		CheckOutRecordAccess crda = new CheckOutRecordAccess();
		return (CheckoutRecord) crda.read(memID);
	}
}
