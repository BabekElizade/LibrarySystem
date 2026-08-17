package com.babakalizada.Service;

import com.babakalizada.DTO.AddressDTO.DtoAddress;
import com.babakalizada.DTO.CustomerDTO.DtoCustomer;
import com.babakalizada.DTO.CustomerDTO.DtoCustomerUI;
import com.babakalizada.Entity.CustomerSys.AddressSys.Address;
import com.babakalizada.Entity.CustomerSys.Customer;
import com.babakalizada.Repository.CustomerRepositorySys.AddressRepository;
import com.babakalizada.Repository.CustomerRepositorySys.CustomerRepository;
import com.babakalizada.Service.impl.ICustomerServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerServiceImpl {

    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public DtoCustomer getCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Customer> optional = customerRepository.findById(id);
        if(optional.isPresent()) {
            Customer customer = optional.get();
            Address address = optional.get().getAddress();
            BeanUtils.copyProperties(customer,dtoCustomer);
            BeanUtils.copyProperties(address,dtoAddress);
            dtoCustomer.setAddress(dtoAddress);
            return dtoCustomer;
        }
        return null;
    }

    @Override
    public DtoCustomer setCustomer(DtoCustomerUI dtoCustomerUI) {
        // 1. Gələn məlumatların boş olub olmadığını yoxlayırıq
        if (dtoCustomerUI.getAddress() == null) {
            throw new RuntimeException("Address sahəsi göndərilməyib!");
        }

        // 2. Müştəri obyektini yaradırıq
        Customer customer = new Customer();
        customer.setFirstName(dtoCustomerUI.getFirstName());
        customer.setLastName(dtoCustomerUI.getLastName());
        customer.setEmail(dtoCustomerUI.getEmail());
        customer.setPassword(dtoCustomerUI.getPassword());

        // 3. Ünvan obyektini yaradırıq və məlumatı köçürürük
        Address address = new Address();
        address.setDescription(dtoCustomerUI.getAddress().getDescription());

        // 4. Əvvəlcə ünvanı bazaya yazırıq (ID alması üçün)
        address = addressRepository.save(address);

        // 5. Ünvanı müştəriyə bağlayırıq
        customer.setAddress(address);

        // 6. Müştərini bazaya yazırıq
        customerRepository.save(customer);

        // 7. Cavab üçün DTO-ları hazırlayırıq
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();

        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(address, dtoAddress);
        dtoCustomer.setAddress(dtoAddress);

        return dtoCustomer;
    }


}
