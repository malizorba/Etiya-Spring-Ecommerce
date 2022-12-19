package com.etiya.ecommercedemopair3.business.dtos.requests.invoice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddInvoiceRequest {
    private String invoiceNumber;
    private LocalDate invoiceDate;

}
