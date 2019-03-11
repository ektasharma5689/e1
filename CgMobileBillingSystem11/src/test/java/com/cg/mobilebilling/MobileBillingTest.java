package com.cg.mobilebilling;
import java.util.ArrayList;
import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.cg.mobilebilling.beans.Address;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.daoservices.BillingDAOServices;
import com.cg.mobilebilling.daoservices.CustomerDAOServices;
import com.cg.mobilebilling.daoservices.PlanDAOServices;
import com.cg.mobilebilling.daoservices.PostpaidAccountDAOServices;
import com.cg.mobilebilling.services.BillingServices;
import com.cg.mobilebilling.services.BillingServicesImpl;
public class MobileBillingTest {
	@Mock
	private static BillingServices billingServices;
	private  static BillingDAOServices mockBillingDAOServices;
	private static CustomerDAOServices mockCustomerDAOServices;
	private static PlanDAOServices mockPlanDAOServices;
	private static PostpaidAccountDAOServices mockPostpaidAccountDAOServices;
	@BeforeClass
	public static void setUpTestEnv() {
	
		mockBillingDAOServices = EasyMock.createMock(BillingDAOServices.class);
		mockCustomerDAOServices=EasyMock.createMock(CustomerDAOServices.class);
		mockPlanDAOServices=EasyMock.createMock(PlanDAOServices.class);
		mockPostpaidAccountDAOServices=EasyMock.createMock(PostpaidAccountDAOServices.class);
		billingServices=new BillingServicesImpl(mockBillingDAOServices);
		billingServices=new BillingServicesImpl(mockCustomerDAOServices);
		billingServices=new BillingServicesImpl(mockPlanDAOServices);
		billingServices=new BillingServicesImpl(mockPostpaidAccountDAOServices);
	}
	
	@Test
	public void setUpTestData() {	
		Customer customer1=new Customer(1001, "lokesh", "Kumar", "lokesh1431994@gmail.com", "21/01/1996", new Address(282006, "jsr", "jhk"));
		
	
		
		
		ArrayList<Customer> customerList = new ArrayList<>();
		customerList.add(customer1);
		
		
		new Customer( 1003, "jghjh ", "Tjgjj", "jhgjkg.jhg@capgemini.com", "11/1/1997",new Address(816222, "puna", "maharastra"));
		EasyMock.expect(mockCustomerDAOServices.findById(1001).get()).andReturn(customer1);
		
		EasyMock.expect(mockCustomerDAOServices.findById(1000).get()).andReturn(null);

}
}
