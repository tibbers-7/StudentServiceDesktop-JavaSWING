package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {
	private int addressId;
	private String street;
	private String number;
	private String city;
	private String country;
	public Address() {
		super();
	}
	public Address(String street, String number, String city, String country) {
		super();
//		this.addressId = addressId;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
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

	public static Address formatAddress(String s) {
		Pattern p = Pattern.compile("^(.+),(.+),(\\D+),(\\D+)");
		Matcher m = p.matcher(s);

		if(m.find()) {
//			if(m.group(2) != null) {
//				street=m.group(1)+" "+m.group(2);
//			} else street=m.group(1);
			Address a=new Address(m.group(1),m.group(2),m.group(3),m.group(4));
			return a;

		} else {
			return null;
		}
	}

	public String addressToStr() {
		String ret=this.street+","+this.number+","+this.city+","+this.country;
		return ret;
	}



}
