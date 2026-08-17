package com.babakalizada.Repository.CustomerRepositorySys;

import com.babakalizada.Entity.CustomerSys.AddressSys.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
