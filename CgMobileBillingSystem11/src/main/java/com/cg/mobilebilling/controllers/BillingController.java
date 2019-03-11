package com.cg.mobilebilling.controllers;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.exceptions.BillDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.InvalidBillMonthException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
import com.cg.mobilebilling.services.BillingServices;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
@Controller
public class BillingController {
	@Autowired
	private BillingServices billingServices;
	Customer customer;
	PostpaidAccount postpaidAccount;
	Bill bill;
	Plan plan;
	@RequestMapping("/registerCustomer")
	public ModelAndView registerCustomerAction(@Valid@ModelAttribute Customer customer,BindingResult bindingResultCustomer)  {
		if(bindingResultCustomer.hasErrors())
			return new ModelAndView("registerPage");
		int customerID;
		try {
			customerID = billingServices.acceptCustomerDetails(customer);
		} catch (BillingServicesDownException e) {
			return new ModelAndView("registerPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		}
		return new ModelAndView("registrationSuccessPage", "customerID", customerID);
	}
	@RequestMapping("/allPlanDetails")
	public ModelAndView returnAllPlanDetails() {
		List<Plan> plans;
		try {
			plans = billingServices.getPlanAllDetails();
		} catch (BillingServicesDownException e) {
			return new ModelAndView("indexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		}
		return new ModelAndView("displayAllPlanDetailsPage", "plans", plans);
	}
	@RequestMapping("/openPostpaidMobileAccount")
	public ModelAndView openPostpaidMobileAccount() {
		List<Plan> plans;
		try {
			plans = billingServices.getPlanAllDetails();
		} catch (BillingServicesDownException e) {
			return new ModelAndView("indexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		}
		return new ModelAndView("getOpenPostpaidMobileAccountPage", "plans", plans);
	}
	@RequestMapping("/OpenPostpaidMobileAccount")
	public ModelAndView openPostpaidMobileAccount(@RequestParam("customerID")int customerID,@RequestParam("planID")int planID) {
		long mobileNo;
		try {
			mobileNo = billingServices.openPostpaidMobileAccount(customerID, planID);
		} catch (PlanDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Plan!!!!!Please Try Again");
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Customer Not Found!!!!!Please Register");
		} catch (BillingServicesDownException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		}
		return new ModelAndView("accountOpeningSuccessPage", "mobileNo", mobileNo);
	}
	@RequestMapping("/GenerateMonthlyMobileBill")
	public ModelAndView generateMonthlyMobileBill(@RequestParam("customerID")int customerID,@RequestParam("mobileNo")long mobileNo,
			@RequestParam("billMonth")String billMonth,@RequestParam("noOfLocalSMS")int noOfLocalSMS,
			@RequestParam("noOfStdSMS")int noOfStdSMS,
			@RequestParam("noOfLocalCalls")int noOfLocalCalls,@RequestParam("noOfStdCalls")int noOfStdCalls,
			@RequestParam("internetDataUsageUnits")int internetDataUsageUnits) throws FileNotFoundException, DocumentException {
		Bill bill;
		try {
			bill = billingServices.generateMonthlyMobileBill(customerID, mobileNo, billMonth, noOfLocalSMS, noOfStdSMS, noOfLocalCalls, noOfStdCalls, internetDataUsageUnits);
			Document document = new Document();
			String string="D:\\Bill "+new Integer(customerID).toString()+billMonth+".pdf";
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(string));
			document.open();
			//LocalDate str=LocalDate.now();
			document.addCreationDate();
			document.addTitle("Your Mobile Bill Amount");
			document.add(new Paragraph("CustomerId: "+new Integer(customerID).toString()));
			document.add(new Paragraph("Your MobileNo : "+new Long(mobileNo).toString()));
			document.add(new Paragraph("Bill Month: "+billMonth));
			document.add(new Paragraph("localSMSAmount: "+new Float(bill.getLocalSMSAmount()).toString()));
			document.add(new Paragraph("StdSMSAmount: "+new Float(bill.getStdSMSAmount()).toString()));
			document.add(new Paragraph("LocalCallAmount: "+new Float(bill.getLocalCallAmount()).toString()));
			document.add(new Paragraph("StdCallAmount: "+new Float(bill.getStdCallAmount()).toString()));
			document.add(new Paragraph("InternetDataUsageAmount: "+new Float(bill.getInternetDataUsageAmount()).toString()));	
			document.add(new Paragraph("ServiceTax: "+new Float(bill.getServicesTax()).toString()));	
			document.add(new Paragraph("Vat: "+new Float(bill.getVat()).toString()));	
			document.add(new Paragraph("TotalBillAmount: "+new Float(bill.getTotalBillAmount()).toString()));	
			document.close();
			writer.close();
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Customer Not Found!!!!!Please Register");
		} catch (PostpaidAccountNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Mobile Number!!!!!Please Try Again");
		} catch (InvalidBillMonthException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Bill Month!!!!!Please Try Again");
		} catch (BillingServicesDownException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		} catch (PlanDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Plan!!!!!Please Try Again");
		}
		return new ModelAndView("displayMonthlyMobileBillPage", "totalBillAmount", bill.getTotalBillAmount());
	}
	@RequestMapping("/displayCustomer")
	public ModelAndView getCustomerDetails(@RequestParam("customerID")int customerID) {
		try {
			customer=billingServices.getCustomerDetails(customerID);
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Customer Not Found!!!!!Please Register");
		} catch (BillingServicesDownException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		}
		System.out.println(customer.toString());
		return new ModelAndView("displayCustomerDetailsPage", "customer", customer);
	}
	@RequestMapping("/allCustomerDetails")
	public ModelAndView getAllCustomerDetails() {
		List<Customer> customers;
		try {
			customers = billingServices.getAllCustomerDetails();
		} catch (BillingServicesDownException e) {
			return new ModelAndView("adminIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		}
		System.out.println(customers.toString());
		return new ModelAndView("displayAllCustomerDetailsPage", "customers", customers);
	}
	
	@RequestMapping("/displayCustomerAllPostpaidAccountsDetails")
	public ModelAndView getDisplayCustomerAllPostpaidAccountsDetails(@RequestParam("customerID")int customerID) {
		List<PostpaidAccount> postpaidAccounts;
		try {
			postpaidAccounts = billingServices.getCustomerAllPostpaidAccountsDetails(customerID);
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Customer Not Found!!!!!Please Register");
		} catch (BillingServicesDownException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		}
		return new ModelAndView("displayCustomerAllPostpaidAccountsDetailsPage", "postpaidAccounts", postpaidAccounts);
	}
	@RequestMapping("/displayMonthlyBill")
	public ModelAndView getDisplayMonthlyBill(@RequestParam("customerID")int customerID,@RequestParam("mobileNo")long mobileNo,@RequestParam("billMonth")String billMonth)  {
		Bill bill;
		try {
			bill = billingServices.getMobileBillDetails(customerID, mobileNo, billMonth);
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Customer Not Found!!!!!Please Register");
		} catch (PostpaidAccountNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Mobile Number!!!!!Please Try Again");
		} catch (InvalidBillMonthException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Bill Month!!!!!Please Try Again");
		} catch (BillingServicesDownException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		} catch (PlanDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Plan!!!!!Please Try Again");
		} catch (BillDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Bill Unavailable!!!!!Please Try Again");
		}
		return new ModelAndView("displayMonthlyBillPage", "bill", bill);
	}
	@RequestMapping("/displayCustomerPostPaidAccountAllBillDetails")
	public ModelAndView getDisplayCustomerPostPaidAccountAllBillDetails(@RequestParam("customerID")int customerID,@RequestParam("mobileNo")long mobileNo)  {
		List<Bill> bills;
		try {
			bills = billingServices.getCustomerPostPaidAccountAllBillDetails(customerID, mobileNo);
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Customer Not Found!!!!!Please Register");
		} catch (PlanDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Plan!!!!!Please Try Again");
		} catch (PostpaidAccountNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Mobile Number!!!!!Please Try Again");
		} catch (BillingServicesDownException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		} catch (BillDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Bill Unavailable!!!!!Please Try Again");
		}
		return new ModelAndView("displayAllBillPage", "bills", bills);
	}
	@RequestMapping("/changePlan")
	public ModelAndView getChangePlan() {
		List<Plan> plans;
		try {
			plans = billingServices.getPlanAllDetails();
		} catch (BillingServicesDownException e) {
			return new ModelAndView("indexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		}
		return new ModelAndView("getChangePlanPage", "plans", plans);
	}
	@RequestMapping("/ChangePlan")
	public ModelAndView getChangePlan(@RequestParam("customerID")int customerID,@RequestParam("mobileNo")long mobileNo,@RequestParam("planID")int planID) {
		try {
			billingServices.changePlan(customerID, mobileNo, planID);
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Customer Not Found!!!!!Please Register");
		} catch (PostpaidAccountNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Mobile Number!!!!!Please Try Again");
		} catch (BillingServicesDownException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		} catch (PlanDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Plan!!!!!Please Try Again");
		}

		return new ModelAndView("customerIndexPage", "successMessage", "Your Plan has been changed Successfully");
	}
	@RequestMapping("/DeletePostpaidAccount")
	public ModelAndView getDeletePostpaidAccount(@RequestParam("customerID")int customerID,@RequestParam("mobileNo")long mobileNo)  {
		try {
			billingServices.closeCustomerPostPaidAccount(customerID, mobileNo);
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("adminIndexPage", "errorMessage", "Customer Not Found!!!!!Please Register");
		} catch (PostpaidAccountNotFoundException e) {
			return new ModelAndView("adminIndexPage", "errorMessage", "Invalid Mobile Number!!!!!Please Try Again");
		} catch (BillingServicesDownException e) {
			return new ModelAndView("adminIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		} catch (PlanDetailsNotFoundException e) {
			return new ModelAndView("adminIndexPage", "errorMessage", "Invalid Plan!!!!!Please Try Again");
		}
		return new ModelAndView("getDeletePostpaidAccountPage", "successMessage", "Your Account has been closed Successfully");
	}
	@RequestMapping("/DeleteCustomer")
	public ModelAndView getDeleteCustomer(@RequestParam("customerID")int customerID)  {
		try {
			billingServices.deleteCustomer(customerID);
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("adminIndexPage", "errorMessage", "Customer Not Found!!!!!Please Register");
		} catch (BillingServicesDownException e) {
			return new ModelAndView("adminIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		}
		return new ModelAndView("getDeleteCustomerPage", "successMessage", "Your Account has been closed Successfully");
	}
	@RequestMapping("/CustomerPostPaidAccountPlanDetailsPage")
	public ModelAndView getCustomerPostPaidAccountPlanDetails(@RequestParam("customerID")int customerID,@RequestParam("mobileNo")long mobileNo)  {
		Plan plan;
		try {
			plan = billingServices.getCustomerPostPaidAccountPlanDetails(customerID,mobileNo);
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Customer Not Found!!!!!Please Register");
		} catch (PostpaidAccountNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Mobile Number!!!!!Please Try Again");
		} catch (BillingServicesDownException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Error Occured!!!!!Please Try Again");
		} catch (PlanDetailsNotFoundException e) {
			return new ModelAndView("customerIndexPage", "errorMessage", "Invalid Plan!!!!!Please Try Again");
		}
		return new ModelAndView("displayCustomerPostPaidAccountPlanDetailsPage", "plan",plan);
	}
}