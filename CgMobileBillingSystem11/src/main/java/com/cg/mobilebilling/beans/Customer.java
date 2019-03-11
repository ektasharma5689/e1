package com.cg.mobilebilling.beans;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
@SequenceGenerator(name="sequenceCustomer",initialValue=1001,allocationSize=1)
@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequenceCustomer")
	private int customerID;
	@NotEmpty(message="Enter First Name")
	@Pattern(regexp="^[a-zA-Z]{2,}$",message="Enter Valid First Name")
	private String firstName;
	@NotEmpty(message="Enter Last Name")
	@Pattern(regexp="^[a-zA-Z]{2,}$",message="Enter Valid Last Name")
	private String lastName;
	@NotEmpty(message="Enter Email")
	@Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{1,3})$",message="Enter Valid Email")
	private String emailID;
	@NotEmpty(message="Enter Date")
	private String dateOfBirth;
	@Valid
	@Embedded
	private Address billingAddress;
	@MapKey
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval=true)
	private Map<Long, PostpaidAccount> postpaidAccounts;
	public Customer() {}
	public Customer(String firstName, String lastName, String emailID, String dateOfBirth, Address billingAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.dateOfBirth = dateOfBirth;
		this.billingAddress = billingAddress;
	}
	public Customer(int customerID, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String emailID,
			@NotEmpty String dateOfBirth, Address billingAddress) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.dateOfBirth = dateOfBirth;
		this.billingAddress = billingAddress;
	}
	public Customer(int customerID, String firstName, String lastName, String emailID, String dateOfBirth,
			Address billingAddress, Map<Long, PostpaidAccount> postpaidAccounts) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.dateOfBirth = dateOfBirth;
		this.billingAddress = billingAddress;
		this.postpaidAccounts = postpaidAccounts;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Map<Long,PostpaidAccount> getPostpaidAccounts() {
		return postpaidAccounts;
	}
	public void setPostpaidAccounts(Map<Long, PostpaidAccount> postpaidAccounts) {
		this.postpaidAccounts = postpaidAccounts;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailID=" + emailID + ", dateOfBirth=" + dateOfBirth + ", billingAddress=" + billingAddress
				+ ", postpaidAccounts=" + postpaidAccounts + "]";
	}
	
}