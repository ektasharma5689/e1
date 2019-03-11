package com.cg.mobilebilling.daoservices;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mobilebilling.beans.PostpaidAccount;
@Qualifier("JpaRepository")
public interface PostpaidAccountDAOServices extends JpaRepository<PostpaidAccount, Long>{
	@Modifying
	@Transactional
	@Query(value="UPDATE PostpaidAccount SET PLANID=?1 WHERE MOBILE_NO=?2", nativeQuery=false)
	int changePlan(Integer planID, Long mobileNo);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM PostpaidAccount WHERE MOBILE_NO=?1", nativeQuery=false)
	int removeMobileNo(long mobileNo);
}
