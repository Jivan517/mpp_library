package business;

import java.io.Serializable;
import java.util.*;

import dataaccess.DataAccessFacade;
import dataaccess.FineRecordDataAccess;

public class FineRecord implements Serializable {

	private static final long serialVersionUID = 3333L;
	private LibraryMember lmember;
	private ArrayList<FineEntry> entries;
	public void addEntry(FineEntry fe){
		entries.add(fe);
	}
	public FineRecord(LibraryMember m){
		setLmember(m);
		entries = new ArrayList<FineEntry>();
	}
	public LibraryMember getLmember() {
		return lmember;
	}
	public void setLmember(LibraryMember lmember) {
		this.lmember = lmember;
	}
	public ArrayList<FineEntry> getEntries(){
		return entries;
	}
	public static FineRecord readFineRecord(String memberid){
		DataAccessFacade da = new DataAccessFacade();
		return da.readFines(memberid);
	}
	public void save(String memberId){
		DataAccessFacade da = new DataAccessFacade();
		da.saveFineRecord(memberId, this);
	}
}
