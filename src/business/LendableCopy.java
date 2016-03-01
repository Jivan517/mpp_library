package business;

import java.io.Serializable;

public class LendableCopy implements Serializable {
	private Publication publication;
	private int copyId; 
	public LendableCopy(int cid, Publication p){
		copyId = cid;
		publication = p;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}
	public String toString() {
		return publication.toString();
	}
	
}
