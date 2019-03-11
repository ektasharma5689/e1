package com.cg.mobilebilling.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostpaidAccount;
@Controller
public class URIController {
	Customer customer;
	PostpaidAccount postpaidAccount;
	Bill bill;
	Plan plan;
	@ModelAttribute
	public Customer getCustomer() {
		customer=new Customer();
		return customer;
	}
	@ModelAttribute
	public PostpaidAccount getAccount() {
		postpaidAccount=new PostpaidAccount();
		return postpaidAccount;
	}
	@ModelAttribute
	public Bill getBill() {
		bill = new Bill();
		return bill;
	}
	@ModelAttribute
	public Plan getPlan() {
		plan = new Plan();
		return plan;
	}
	@RequestMapping("/customer")
	public String getCustomerIndexPage() {
		return "customerIndexPage";
	}
	@RequestMapping("/admin")
	public String getAdminIndexPage() {
		return "adminIndexPage";
	}
	@RequestMapping(value= {"/","/home","/indexPage"})
	public String getIndexPage() {
		return "indexPage";
	}
	@RequestMapping("/register")
	public String getRegisterPage() {
		return "registerPage";
	}
	@RequestMapping("/generateMonthlyMobileBill")
	public String getGenerateMonthlyMobileBill() {
		return "getGenerateMonthlyMobileBillPage";
	}
	@RequestMapping("/customerDetails")
	public String getCustomerId() {
		return "getCustomerIdPage";
	}
	@RequestMapping("/postPaidAccountDetails")
	public String getPostPaidAccountDetails() {
		return "getPostPaidAccountDetailsPage";
	}
	@RequestMapping("/customerAllPostpaidAccountsDetails")
	public String getCustomerAllPostpaidAccountsDetails() {
		return "getCustomerAllPostpaidAccountsDetailsPage";
	}
	@RequestMapping("/mobileBillDetails")
	public String getMobileBillDetails() {
		return "getMobileBillDetailsPage";
	}
	@RequestMapping("/customerPostPaidAccountAllBillDetails")
	public String getCustomerPostPaidAccountAllBillDetails() {
		return "getCustomerPostPaidAccountAllBillDetails";
	}
	@RequestMapping("/deletePostpaidAccount")
	public String getDeletePostpaidAccount() {
		return "getDeletePostpaidAccountPage";
	}
	@RequestMapping("/deleteCustomer")
	public String getDeleteCustomer() {
		return "getDeleteCustomerPage";
	}
	@RequestMapping("/customerPostPaidAccountPlanDetails")
	public String getCustomerPostPaidAccountPlanDetails() {
		return "getCustomerPostPaidAccountPlanDetailsPage";
	}
}