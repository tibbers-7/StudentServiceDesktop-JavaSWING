package model;

public class Address {
	private int addressId;
	private String street;
	private int number; 
	private String city;
	private String country;
	public Address() {
		super();
	}
	public Address(int addressId,String street, int number, String city, String country) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
