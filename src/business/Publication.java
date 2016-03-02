package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

abstract public class Publication implements Serializable {
	
	private static final long serialVersionUID = 2010893663327964921L;
	private LocalDate dateDue;
	private String title;
	private ArrayList<LendableCopy> copies;
	public int numberOfCopies(){
		return copies.size();
	}
	protected void setDateDue(LocalDate d) {
		dateDue = d;
	}
	public Publication() {
		copies = new ArrayList();
	}
	public LocalDate getDateDue() {
		return dateDue;
	}
	public LendableCopy checkoutCopy(){
		LendableCopy p = null;
		for(int i = 0; i < this.numberOfCopies(); i++){
			p = copies.get(i);
			if(p.isAvailable()){
				p.setAvailable(false);
				return p;
			}
		}
		return null;
	}
	public void checkinCopy(LendableCopy copy){
		LendableCopy p = null;
		for(int i = 0; i < this.numberOfCopies(); i++){
			p = copies.get(i);
			if(p.getCopyId() == copy.getCopyId()){
				p.setAvailable(true);
				return ;
			}
		}
	}
	public void addCopy(int copyid){
		LendableCopy lc = new LendableCopy(copyid, this);
		copies.add(lc);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
