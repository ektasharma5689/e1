package com.cg.mobilebilling.daoservices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.mobilebilling.beans.Customer;
@Qualifier("JpaRepository")
public interface CustomerDAOServices extends JpaRepository<Customer, Integer>{

}
