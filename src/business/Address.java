package business;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = 2240133962942272173L;
	private String street ;
	private String city;
	private String state ;
	private String zipCode ;

	//package level access
	public Address(String street, String city, String state, String zip){
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zip;
	}

	Address(){

	}

	public String getStreet(){
		return this.street;
	}

	void setStreet(String street){
		this.street = street;
	}

	public String getCity(){
		return this.city;
	}

	void setCity(String city){
		this.city = city;
	}

	public String getState(){
		return this.state;
	}

	void setState(String state){
		this.state = state;
	}

	public String getZipcode(){
		return this.zipCode;
	}

	void setZipcode(String zip){
		this.zipCode = zip;
	}

	@Override
	public String toString(){
		return street + " " + city + " " + state + " " + zipCode;
	}
}
