package com.cg.mobilebilling.daoservices;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.cg.mobilebilling.beans.Bill;
@Qualifier("JpaRepository")
public interface BillingDAOServices extends JpaRepository<Bill, Integer>{
	@Query(value="SELECT * FROM Bill WHERE MOBILE_NO=?1 AND BILL_MONTH=?2", nativeQuery=true)
	Bill getMonthlyBill(long mobileNo, String billMonth);
	
	@Query(value="SELECT * FROM Bill WHERE MOBILE_NO=?", nativeQuery=true)
	List<Bill> getCustomerPostPaidAccountAllBills(long mobileNo);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM Bill WHERE MOBILE_NO=?", nativeQuery=true)
	int deleteByMobileNo(long mobileNo);
	
}