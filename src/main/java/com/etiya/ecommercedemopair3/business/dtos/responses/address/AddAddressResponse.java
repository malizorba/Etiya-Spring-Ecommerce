package com.etiya.ecommercedemopair3.business.dtos.responses.address;


import com.etiya.ecommercedemopair3.entities.concrets.Customer;
import com.etiya.ecommercedemopair3.entities.concrets.Street;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressResponse {
    private int id;
    private String title;
    private String description;
    private int customerId;
    private int streetId;
}