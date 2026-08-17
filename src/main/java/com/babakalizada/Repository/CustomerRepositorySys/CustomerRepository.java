package com.babakalizada.Repository.CustomerRepositorySys;

import com.babakalizada.Controller.impl.ICustomerController;
import com.babakalizada.Entity.CustomerSys.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
