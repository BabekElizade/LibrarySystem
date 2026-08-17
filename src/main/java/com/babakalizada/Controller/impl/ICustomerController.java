package com.babakalizada.Controller.impl;

import com.babakalizada.DTO.CustomerDTO.DtoCustomer;
import com.babakalizada.DTO.CustomerDTO.DtoCustomerUI;
import com.babakalizada.Entity.CustomerSys.Customer;

public interface ICustomerController {
    public DtoCustomer getCustomerById(Long id);
    public DtoCustomer setCustomer(DtoCustomerUI dtoCustomerUI);
}
