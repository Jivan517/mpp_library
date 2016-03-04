package business;

import java.io.Serializable;
import java.time.LocalDate;

import business.*;
import java.util.*;

public class FineEntry implements Serializable {

	private static final long serialVersionUID = 12345654L;
	private LendableCopy copy;
	private LocalDate datePaid;
	private LocalDate returnDate;
	private double fineValue;


	public FineEntry(LendableCopy copy, LocalDate datePaid, LocalDate returnDate, double fineValue,
			CheckoutRecordEntry checkoutRecordEntry) {
		super();
		this.copy = copy;
		this.datePaid = datePaid;
		this.returnDate = returnDate;
		this.fineValue = fineValue;
		this.checkoutRecordEntry = checkoutRecordEntry;
	}

	private CheckoutRecordEntry checkoutRecordEntry;
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
}
