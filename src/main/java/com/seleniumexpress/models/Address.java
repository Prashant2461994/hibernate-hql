package com.seleniumexpress.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address { // value type -> no primary key

	@Column(name = "address_line_1", length = 100)
	public String addressLine1;

	@Column(name = "address_line_2", length = 100)
	public String addressLine2;

	@Column(name = "country", length = 15)
	public String country;

	@Column(name = "city", length = 15)
	public String city;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address() {
	}
}