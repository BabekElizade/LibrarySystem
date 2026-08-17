package com.babakalizada.DTO.CustomerDTO;

import com.babakalizada.DTO.AddressDTO.DtoAddress;
import com.babakalizada.Entity.CustomerSys.AddressSys.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCustomerUI {
    private String firstName;
    private String lastName;
    private String email;
    private DtoAddress address;
    private String password;
}
