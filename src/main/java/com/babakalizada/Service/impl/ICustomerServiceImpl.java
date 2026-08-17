package com.babakalizada.Service.impl;

import com.babakalizada.DTO.CustomerDTO.DtoCustomer;
import com.babakalizada.DTO.CustomerDTO.DtoCustomerUI;
import com.babakalizada.Entity.CustomerSys.Customer;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICustomerServiceImpl {
    public DtoCustomer getCustomerById(Long id);
    public DtoCustomer setCustomer(DtoCustomerUI dtoCustomerUI);
}
