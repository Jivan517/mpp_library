package business;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;

public class Author implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -4818431554335178421L;

	private PersonalInfo personalInfo;
	private SimpleStringProperty credential;
	private SimpleStringProperty shortBio;

	public Author(String firstName, String lName, String credential, String shortBio){
		this.personalInfo = new PersonalInfo(firstName, lName);
		this.credential = new SimpleStringProperty(credential);
		this.shortBio = new SimpleStringProperty(shortBio);
	}
	public String getFullname(){
		return this.personalInfo.getFirstName() + " " + this.personalInfo.getLastName();
	}

}
