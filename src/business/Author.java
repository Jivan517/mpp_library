package business;

import java.io.Serializable;

public class Author implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -4818431554335178421L;

	private PersonalInfo personalInfo;
	 String n;
	 String shortBio;

	public Author(String firstName, String lName, String credential, String shortBio){
		this.personalInfo = new PersonalInfo(firstName, lName);
		this.n = credential;
		this.shortBio = shortBio;
	}
	public String getFullname(){
		return this.personalInfo.getFirstName() + " " + this.personalInfo.getLastName();
	}
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public String getShortBio() {
		return shortBio;
	}
	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}



}
