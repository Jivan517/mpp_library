package business;

import java.io.Serializable;

public class Author implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4818431554335178421L;
	
	private PersonalInfo personalInfo;
	private String credential;
	private String shortBio;
	
	public Author(String firstName, String lName, String credential, String shortBio, String street, String city, String state, String zip, String tel){
		this.personalInfo = new PersonalInfo(firstName, lName, tel, street, city, state, zip);
		this.credential = credential;
		this.shortBio = shortBio;
	}
	public String getFullname(){
		return this.personalInfo.getFirstName() + " " + this.personalInfo.getLastName();
	}

}
