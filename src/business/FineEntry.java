package business;

import java.io.Serializable;
import java.time.LocalDate;

import business.*;
import java.util.*;

public class FineEntry implements Serializable {

	private static final long serialVersionUID = 12345654L;
	private LendableCopy copy;
	private LocalDate datePaid;
	private String title;
	private LocalDate returnDate;
	private double fineValue;
	private boolean paid;
	private CheckoutRecordEntry checkoutRecordEntry;

	public FineEntry(LocalDate datePaid, LocalDate returnDate, double fineValue,
			CheckoutRecordEntry checkoutRecordEntry) {
		super();
		this.copy = checkoutRecordEntry.getCopy();
		this.datePaid = datePaid;
		this.setTitle(this.copy.getBook().getTitle());
		this.returnDate = returnDate;
		this.fineValue = fineValue;
		this.paid = false;
		this.checkoutRecordEntry = checkoutRecordEntry;
	}

	
	public LendableCopy getCopy() {
		return copy;
	}
	public void setCopy(LendableCopy copy) {
		this.copy = copy;
	}
	public LocalDate getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(LocalDate datePaid) {
		this.datePaid = datePaid;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public double getFineValue() {
		return fineValue;
	}
	public void setFineValue(double fineValue) {
		this.fineValue = fineValue;
	}
	public CheckoutRecordEntry getCheckoutRecordEntry() {
		return checkoutRecordEntry;
	}
	public void setCheckoutRecordEntry(CheckoutRecordEntry checkoutRecordEntry) {
		this.checkoutRecordEntry = checkoutRecordEntry;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
}
