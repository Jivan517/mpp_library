package business;

import java.io.Serializable;

import dataaccess.DataAccessFacade;

public class LendableCopy implements Serializable {

	private static final long serialVersionUID = -6307098549062543163L;
	private Publication publication;
	private int copyId;

	public LendableCopy(int copyId, Publication p){
		this.copyId = copyId;
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
