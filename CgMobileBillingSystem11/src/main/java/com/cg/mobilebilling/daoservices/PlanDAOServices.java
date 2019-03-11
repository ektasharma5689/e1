package com.cg.mobilebilling.daoservices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.mobilebilling.beans.Plan;
@Qualifier("JpaRepository")
public interface PlanDAOServices extends JpaRepository<Plan, Integer>{
	
}
