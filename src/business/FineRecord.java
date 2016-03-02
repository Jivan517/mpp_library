package business;

import java.io.Serializable;
import java.util.*;

public class FineRecord implements Serializable {

	/**
	 * 
	 */
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
}
