
package com.cg.mobilebilling.beans;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Embeddable
public class Address {
	@NotNull(message="Enter valid pincode")
	@Min(100000)
	@Max(999999)
	private int pinCode;
	@NotEmpty(message="Enter city")
	@Pattern(regexp="^[a-zA-Z]{2,}$",message="Enter Valid city")
	private String city;
	@NotEmpty(message="Enter State")
	@Pattern(regexp="^[a-zA-Z]{1,}$",message="Enter Valid State")
	private String state;
	public Address() {}
	public Address(int pinCode, String city, String state) {
		super();
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + pinCode;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (pinCode != other.pinCode)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address pinCode=" + pinCode + ", city=" + city + ", state="
				+ state + " ";
	}
}