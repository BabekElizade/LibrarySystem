package com.babakalizada.Controller;

import com.babakalizada.Controller.impl.ICustomerController;
import com.babakalizada.DTO.CustomerDTO.DtoCustomer;
import com.babakalizada.DTO.CustomerDTO.DtoCustomerUI;
import com.babakalizada.Entity.CustomerSys.Customer;
import com.babakalizada.Service.impl.ICustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/api/customer")
@RestController
public class CustomerControllerImpl implements ICustomerController {

    private ICustomerServiceImpl customerService;

    @Autowired
    public void setCustomerService(ICustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/get-customer-by-id/{id}")
    @Override
    public DtoCustomer getCustomerById(@PathVariable(name = "id") Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping(path = "/set-customer")
    @Override
    public DtoCustomer setCustomer(@RequestBody DtoCustomerUI dtoCustomerUI) {
        return customerService.setCustomer(dtoCustomerUI);
    }


}
