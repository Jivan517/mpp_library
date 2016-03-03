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
	public int getAvailableNumber(){
		int ret = 0;
		for(int i = 0; i < copies.size(); i++){
			LendableCopy p = copies.get(i);
			if(p.isAvailable()){
				ret++;
			}
		}
		return ret;
	}
	public abstract void save(); 
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
				this.save();
				return ;
			}
		}
	}
	public boolean addCopy(int copyid){
		for(int i = 0; i < copies.size(); i++){
			LendableCopy c = copies.get(i);
			if(c.getCopyId() == copyid){
				return false;
			}
		}
		LendableCopy lc = new LendableCopy(copyid, this);
		lc.setAvailable(true);
		copies.add(lc);
		return true;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
