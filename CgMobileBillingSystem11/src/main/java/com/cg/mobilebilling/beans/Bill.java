package com.cg.mobilebilling.beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="Bill")
@SequenceGenerator(name="sequenceBill",initialValue=1111,allocationSize=1)
public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequenceBill")
	private int billID;
	@NotNull
	//@Pattern(regexp="^[0-9]{1,}$")
	private int noOfLocalSMS;
	@NotNull
	//@Pattern(regexp="^[0-9]{1,}$")
	private int noOfStdSMS;
	@NotNull
	//@Pattern(regexp="^[0-9]{1,}$")
	private int noOfLocalCalls;
	@NotNull
	//@Pattern(regexp="^[0-9]{1,}$")
	private int noOfStdCalls;
	@NotNull
	//@Pattern(regexp="^[0-9]{1,}$")
	private int internetDataUsageUnits;
	@NotEmpty(message="Enter Month")
	//@Pattern(regexp="^[a-zA-Z]{3,}$",message="Enter Valid Month")
	private String billMonth;
	private float totalBillAmount;
	private float localSMSAmount;
	private float stdSMSAmount;
	private float localCallAmount;
	private float stdCallAmount;
	private float internetDataUsageAmount;
	private float servicesTax;
	private float vat;
	@ManyToOne
	@MapKey
	@JoinColumn(name="mobileNo")
	private PostpaidAccount postpaidAccount; 
	public Bill() {
		super();
	}
	public Bill(int billID, int noOfLocalSMS, int noOfStdSMS, int noOfLocalCalls, int noOfStdCalls,
			int internetDataUsageUnits, String billMonth, float totalBillAmount, float localSMSAmount,
			float stdSMSAmount, float localCallAmount, float stdCallAmount, float internetDataUsageAmount,
			float servicesTax, float vat, PostpaidAccount postpaidAccount) {
		super();
		this.billID = billID;
		this.noOfLocalSMS = noOfLocalSMS;
		this.noOfStdSMS = noOfStdSMS;
		this.noOfLocalCalls = noOfLocalCalls;
		this.noOfStdCalls = noOfStdCalls;
		this.internetDataUsageUnits = internetDataUsageUnits;
		this.billMonth = billMonth;
		this.totalBillAmount = totalBillAmount;
		this.localSMSAmount = localSMSAmount;
		this.stdSMSAmount = stdSMSAmount;
		this.localCallAmount = localCallAmount;
		this.stdCallAmount = stdCallAmount;
		this.internetDataUsageAmount = internetDataUsageAmount;
		this.servicesTax = servicesTax;
		this.vat = vat;
		this.postpaidAccount = postpaidAccount;
	}
	public Bill(int noOfLocalSMS, int noOfStdSMS, int noOfLocalCalls, int noOfStdCalls, int internetDataUsageUnits,
			String billMonth, float totalBillAmount, float localSMSAmount, float stdSMSAmount, float localCallAmount,
			float stdCallAmount, float internetDataUsageAmount, float servicesTax, float vat,
			PostpaidAccount postpaidAccount) {
		super();
		this.noOfLocalSMS = noOfLocalSMS;
		this.noOfStdSMS = noOfStdSMS;
		this.noOfLocalCalls = noOfLocalCalls;
		this.noOfStdCalls = noOfStdCalls;
		this.internetDataUsageUnits = internetDataUsageUnits;
		this.billMonth = billMonth;
		this.totalBillAmount = totalBillAmount;
		this.localSMSAmount = localSMSAmount;
		this.stdSMSAmount = stdSMSAmount;
		this.localCallAmount = localCallAmount;
		this.stdCallAmount = stdCallAmount;
		this.internetDataUsageAmount = internetDataUsageAmount;
		this.servicesTax = servicesTax;
		this.vat = vat;
		this.postpaidAccount = postpaidAccount;
	}
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public int getNoOfLocalSMS() {
		return noOfLocalSMS;
	}
	public void setNoOfLocalSMS(int noOfLocalSMS) {
		this.noOfLocalSMS = noOfLocalSMS;
	}
	public int getNoOfStdSMS() {
		return noOfStdSMS;
	}
	public void setNoOfStdSMS(int noOfStdSMS) {
		this.noOfStdSMS = noOfStdSMS;
	}
	public int getNoOfLocalCalls() {
		return noOfLocalCalls;
	}
	public void setNoOfLocalCalls(int noOfLocalCalls) {
		this.noOfLocalCalls = noOfLocalCalls;
	}
	public int getNoOfStdCalls() {
		return noOfStdCalls;
	}
	public void setNoOfStdCalls(int noOfStdCalls) {
		this.noOfStdCalls = noOfStdCalls;
	}
	public int getInternetDataUsageUnits() {
		return internetDataUsageUnits;
	}
	public void setInternetDataUsageUnits(int internetDataUsageUnits) {
		this.internetDataUsageUnits = internetDataUsageUnits;
	}
	public String getBillMonth() {
		return billMonth;
	}
	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}
	public float getTotalBillAmount() {
		return totalBillAmount;
	}
	public void setTotalBillAmount(float totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}
	public float getLocalSMSAmount() {
		return localSMSAmount;
	}
	public void setLocalSMSAmount(float localSMSAmount) {
		this.localSMSAmount = localSMSAmount;
	}
	public float getStdSMSAmount() {
		return stdSMSAmount;
	}
	public void setStdSMSAmount(float stdSMSAmount) {
		this.stdSMSAmount = stdSMSAmount;
	}
	public float getLocalCallAmount() {
		return localCallAmount;
	}
	public void setLocalCallAmount(float localCallAmount) {
		this.localCallAmount = localCallAmount;
	}
	public float getStdCallAmount() {
		return stdCallAmount;
	}
	public void setStdCallAmount(float stdCallAmount) {
		this.stdCallAmount = stdCallAmount;
	}
	public float getInternetDataUsageAmount() {
		return internetDataUsageAmount;
	}
	public void setInternetDataUsageAmount(float internetDataUsageAmount) {
		this.internetDataUsageAmount = internetDataUsageAmount;
	}
	public float getServicesTax() {
		return servicesTax;
	}
	public void setServicesTax(float servicesTax) {
		this.servicesTax = servicesTax;
	}
	public float getVat() {
		return vat;
	}
	public void setVat(float vat) {
		this.vat = vat;
	}
	public PostpaidAccount getPostpaidAccount() {
		return postpaidAccount;
	}
	public void setPostpaidAccount(PostpaidAccount postpaidAccount) {
		this.postpaidAccount = postpaidAccount;
	}
	@Override
	public String toString() {
		return "Bill [billID=" + billID + ", noOfLocalSMS=" + noOfLocalSMS + ", noOfStdSMS=" + noOfStdSMS
				+ ", noOfLocalCalls=" + noOfLocalCalls + ", noOfStdCalls=" + noOfStdCalls + ", internetDataUsageUnits="
				+ internetDataUsageUnits + ", billMonth=" + billMonth + ", totalBillAmount=" + totalBillAmount
				+ ", localSMSAmount=" + localSMSAmount + ", stdSMSAmount=" + stdSMSAmount + ", localCallAmount="
				+ localCallAmount + ", stdCallAmount=" + stdCallAmount + ", internetDataUsageAmount="
				+ internetDataUsageAmount + ", servicesTax=" + servicesTax + ", vat=" + vat + "]";
	}	
}