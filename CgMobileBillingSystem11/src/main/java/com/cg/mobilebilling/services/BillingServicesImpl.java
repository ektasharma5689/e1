package com.cg.mobilebilling.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.daoservices.BillingDAOServices;
import com.cg.mobilebilling.daoservices.CustomerDAOServices;
import com.cg.mobilebilling.daoservices.PlanDAOServices;
import com.cg.mobilebilling.daoservices.PostpaidAccountDAOServices;
import com.cg.mobilebilling.exceptions.BillDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.InvalidBillMonthException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
@Component("billingServices")
public class BillingServicesImpl implements BillingServices {
	@Autowired
	private PlanDAOServices planDAOService;
	@Autowired
	private CustomerDAOServices customerDAOService;
	@Autowired
	private PostpaidAccountDAOServices postpaidAccountDAOService;
	@Autowired
	private BillingDAOServices billingDAOServices;
	static int COUNTER=0;
	public BillingServicesImpl() {
		super();
	}
	public BillingServicesImpl(BillingDAOServices mockBillingDAOServices) {
		this.billingDAOServices=mockBillingDAOServices;
	}
	public BillingServicesImpl(CustomerDAOServices mockCustomerDAOServices) {
		this.customerDAOService=mockCustomerDAOServices;
	}
	public BillingServicesImpl(PostpaidAccountDAOServices mockPostpaidAccountDAOServices) {
		this.postpaidAccountDAOService=mockPostpaidAccountDAOServices;
	}
	public BillingServicesImpl(PlanDAOServices mockPlanDAOServices) {
		this.planDAOService=mockPlanDAOServices;
	}
	@Override
	public List<Plan> getPlanAllDetails() throws BillingServicesDownException {
		if(COUNTER<1) {
			Plan plan=new Plan(150, 100, 100, 100, 100, 1024, 0.1f, 0.1f, 1.0f, 1.0f, 1.0f, "pune", "offer");
			planDAOService.save(plan);
			plan=new Plan(250, 200, 200, 200, 200, 2048, 0.1f, 0.1f, 1.0f, 1.0f, 1.0f, "pune", "Super offer");
			planDAOService.save(plan);
			plan=new Plan(50, 50, 50, 50, 50, 1024, 0.1f, 0.1f, 1.0f, 1.0f, 1.0f, "pune", "Diwali offer");
			planDAOService.save(plan);
			plan=new Plan(100, 75, 75, 75, 75, 1024, 0.1f, 0.1f, 1.0f, 1.0f, 1.0f, "pune", "Super saver pack");
			planDAOService.save(plan);
			plan=new Plan(500, 500, 500, 500, 500, 5128, 0.1f, 0.1f, 1.0f, 1.0f, 1.0f, "pune", "Jumbo pack");
			planDAOService.save(plan);
			COUNTER++;
		}
		List<Plan> listPlan=planDAOService.findAll();
		return listPlan;
	}
	@Override
	public int acceptCustomerDetails(Customer customer)
			throws BillingServicesDownException {
		customer=customerDAOService.save(customer);
		return customer.getCustomerID();
	}
	@Override
	public long openPostpaidMobileAccount(int customerID, int planID)
			throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException {
		Customer customer=customerDAOService.findById(customerID).orElseThrow(()->new CustomerDetailsNotFoundException("Customer not found"));
		Plan plan=planDAOService.findById(planID).orElseThrow(()->new PlanDetailsNotFoundException("Enter valid plan"));
		PostpaidAccount postpaidAccount=new PostpaidAccount(customer,plan);
		postpaidAccount=postpaidAccountDAOService.save(postpaidAccount);
		return postpaidAccount.getMobileNo();
	}
	@Override
	public Bill generateMonthlyMobileBill(int customerID, long mobileNo, String billMonth, int noOfLocalSMS,
			int noOfStdSMS, int noOfLocalCalls, int noOfStdCalls, int internetDataUsageUnits)
					throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
					BillingServicesDownException, PlanDetailsNotFoundException {
		PostpaidAccount postpaidAccount = postpaidAccountDAOService.findById(mobileNo).orElseThrow(()->new PlanDetailsNotFoundException("Postpaid Account not found"));
		Plan plan=postpaidAccount.getPlan();
		if(plan==null)
			throw new PlanDetailsNotFoundException("Plan details not found.");
		Map<Integer, Bill> bills=postpaidAccount.getBills();
		List<Bill> billCheck=new ArrayList<>(bills.values());
		for(Bill b:billCheck) {
			if(b.getBillMonth().equalsIgnoreCase(billMonth))
				throw new InvalidBillMonthException();
		}
		float  localSMSAmount=0,stdSMSAmount=0,localCallAmount=0,stdCallAmount=0,internetDataUsageAmount=0,monthlyRental=0,billAmount=0,servicesTax=0,vat=0,totalBillAmount=0;
		if(noOfLocalSMS>plan.getFreeLocalSMS())
			localSMSAmount = (int) ((noOfLocalSMS-plan.getFreeLocalSMS())*plan.getLocalSMSRate());

		if(noOfLocalCalls>plan.getFreeLocalCalls())
			localCallAmount=(int) ((noOfLocalCalls-plan.getFreeLocalCalls())*plan.getLocalCallRate());

		if(noOfStdSMS>plan.getFreeStdSMS())
			stdSMSAmount=(int) ((noOfStdSMS-plan.getFreeStdSMS())*plan.getStdSMSRate());

		if(noOfStdCalls>plan.getFreeStdCalls())
			stdCallAmount=(int) ((noOfStdCalls-plan.getFreeStdCalls())*plan.getStdCallRate());

		if(internetDataUsageUnits>plan.getFreeInternetDataUsageUnits())
			internetDataUsageAmount=(int) ((internetDataUsageUnits-plan.getFreeInternetDataUsageUnits())*plan.getInternetDataUsageRate());

		monthlyRental= plan.getMonthlyRental();
		billAmount=monthlyRental+localSMSAmount+stdSMSAmount+localCallAmount+stdCallAmount+internetDataUsageAmount;
		servicesTax=(int)billAmount*10/100;
		vat=(int)billAmount*5/100;
		totalBillAmount = billAmount+servicesTax+vat;
		Bill bill=new Bill(noOfLocalSMS, noOfStdSMS, noOfLocalCalls, noOfStdCalls, internetDataUsageUnits, billMonth, totalBillAmount, localSMSAmount, stdSMSAmount, localCallAmount, stdCallAmount, internetDataUsageAmount, servicesTax, vat, postpaidAccount);
		bill=billingDAOServices.save(bill);
		return bill;
	}
	@Override
	public Customer getCustomerDetails(int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException {
		return customerDAOService.findById(customerID).orElseThrow(()->new CustomerDetailsNotFoundException("Customer not found"));
	}
	@Override
	public List<Customer> getAllCustomerDetails() throws BillingServicesDownException {
		return customerDAOService.findAll();
	}
	
	@Override
	public List<PostpaidAccount> getCustomerAllPostpaidAccountsDetails(int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException {
		Customer customer = customerDAOService.findById(customerID).orElseThrow(()->new CustomerDetailsNotFoundException("Customer not found"));
		Map<Long,PostpaidAccount> customers= customer.getPostpaidAccounts();
		List<PostpaidAccount> postpaidAccounts =new ArrayList<>(customers.values());
		return postpaidAccounts;
	}
	@Override
	public Bill getMobileBillDetails(int customerID, long mobileNo, String billMonth)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
			BillDetailsNotFoundException, BillingServicesDownException, PlanDetailsNotFoundException {
		customerDAOService.findById(customerID).orElseThrow(()->new CustomerDetailsNotFoundException("Customer not found"));
		PostpaidAccount postpaidAccount=postpaidAccountDAOService.findById(mobileNo).orElseThrow(()->new PlanDetailsNotFoundException("Postpaid Account not found"));
		Map<Integer, Bill> mapBill=postpaidAccount.getBills();
		Bill bill=null;
		if(mapBill.isEmpty()==true)
			throw new BillDetailsNotFoundException();
		boolean flag=false;
		List<Bill> bills=new ArrayList<>(mapBill.values());
		for(Bill bill1:bills)
			if(bill1.getBillMonth().equalsIgnoreCase(billMonth)) {
				bill = billingDAOServices.getMonthlyBill(mobileNo,billMonth);
				flag=true;
				break;
			}
		if(!flag)
			throw new InvalidBillMonthException();
		return bill;
	}
	@Override
	public List<Bill> getCustomerPostPaidAccountAllBillDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException,
			BillDetailsNotFoundException, PlanDetailsNotFoundException {
		customerDAOService.findById(customerID).orElseThrow(()->new CustomerDetailsNotFoundException());
		postpaidAccountDAOService.findById(mobileNo).orElseThrow(()->new PlanDetailsNotFoundException());
		List<Bill> bills=billingDAOServices.getCustomerPostPaidAccountAllBills(mobileNo);
		if(bills.isEmpty()==true)
			throw new BillDetailsNotFoundException();
		return bills;
	}
	@Override
	public int changePlan(int customerID, long mobileNo, int planID) throws CustomerDetailsNotFoundException,
	PostpaidAccountNotFoundException, PlanDetailsNotFoundException, BillingServicesDownException {
		postpaidAccountDAOService.findById(mobileNo).orElseThrow(()->new PlanDetailsNotFoundException());
		planDAOService.findById(planID).orElseThrow(()->new PlanDetailsNotFoundException());
		return postpaidAccountDAOService.changePlan(planID, mobileNo);
	}
	@Override
	public boolean closeCustomerPostPaidAccount(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException, PlanDetailsNotFoundException {
		customerDAOService.findById(customerID).orElseThrow(()->new CustomerDetailsNotFoundException());
		postpaidAccountDAOService.findById(mobileNo).orElseThrow(()->new PlanDetailsNotFoundException());
		//billingDAOServices.deleteByMobileNo(mobileNo);
		postpaidAccountDAOService.removeMobileNo(mobileNo);
		//postpaidAccountDAOService.deleteById(postpaidAccount.getMobileNo());
		return true;
	}
	@Override
	public boolean deleteCustomer(int customerID)
			throws BillingServicesDownException, CustomerDetailsNotFoundException {
		customerDAOService.findById(customerID).orElseThrow(()->new CustomerDetailsNotFoundException());
		customerDAOService.deleteById(customerID);
		return true;
	}
	@Override
	public Plan getCustomerPostPaidAccountPlanDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException,
			PlanDetailsNotFoundException {
		customerDAOService.findById(customerID).orElseThrow(()->new CustomerDetailsNotFoundException());
		PostpaidAccount postpaidAccount=postpaidAccountDAOService.findById(mobileNo).orElseThrow(()->new PlanDetailsNotFoundException());
		Plan plan=postpaidAccount.getPlan();
		if(plan==null)
			throw new PlanDetailsNotFoundException();
		return plan;
	}
}