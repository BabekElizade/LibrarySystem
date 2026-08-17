package com.babakalizada.DTO.CustomerDTO;

import com.babakalizada.DTO.AddressDTO.DtoAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCustomer {
    private String firstName;
    private String lastName;
    private String email;
    private DtoAddress address;
}
