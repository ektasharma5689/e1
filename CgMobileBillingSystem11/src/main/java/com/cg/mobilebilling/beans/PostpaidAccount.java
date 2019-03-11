package com.cg.mobilebilling.beans;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@SequenceGenerator(name="sequenceMobile",initialValue=905904276,allocationSize=1)
@Entity
@Table(name="PostpaidAccount")
public class PostpaidAccount {
	public PostpaidAccount(long mobileNo, Customer customer, Plan plan) {
		super();
		this.mobileNo = mobileNo;
		this.customer = customer;
		this.plan = plan;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequenceMobile")
	private long mobileNo;
	@ManyToOne
	@MapKey
	@JoinColumn(name="customerID")
	private Customer customer;
	@ManyToOne
	@MapKey
	@JoinColumn(name="planID")
	private Plan plan;
	@MapKey
	@OneToMany(mappedBy="postpaidAccount",cascade=CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval=true)
	private  Map<Integer, Bill> bills;
	public PostpaidAccount() {}
	public PostpaidAccount(long mobileNo, Plan plan, Map<Integer,Bill> bills) {
		super();
		this.mobileNo = mobileNo;
		this.plan = plan;
		this.bills = bills;
	}
	
	public PostpaidAccount(Customer customer, Plan plan) {
		super();
		this.customer = customer;
		this.plan = plan;
	}
	
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public Map<Integer,Bill> getBills() {
		return bills;
	}
	public void setBills(Map<Integer,Bill> bills) {
		this.bills = bills;
	}
	@Override
	public String toString() {
		return "PostpaidAccount [mobileNo=" + mobileNo + ", plan=" + plan + ", bills=" + bills + "]";
	}
	
}