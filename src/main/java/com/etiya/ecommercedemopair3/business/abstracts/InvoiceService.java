package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.invoice.AddInvoiceRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.invoice.AddInvoiceResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;

public interface InvoiceService {
    DataResult<AddInvoiceResponse> addInvoice(AddInvoiceRequest addInvoiceRequest);
}
