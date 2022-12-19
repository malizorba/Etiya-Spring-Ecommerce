package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.InvoiceService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.invoice.AddInvoiceRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.invoice.AddInvoiceResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.messages.MessageSourceService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Invoice;
import com.etiya.ecommercedemopair3.repository.abstracts.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private ModelMapperService modelMapperService;
    private MessageSourceService messageSourceService;

    @Override
    public DataResult<AddInvoiceResponse> addInvoice(AddInvoiceRequest addInvoiceRequest) {
        Invoice invoice = modelMapperService.getMapperRequest().map(addInvoiceRequest, Invoice.class);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        AddInvoiceResponse response = modelMapperService.getMapperResponse().map(savedInvoice, AddInvoiceResponse.class);
        return new SuccessDataResult<AddInvoiceResponse>(response, messageSourceService.getMessages(Messages.Invoice.invoiceAddSuccessMessage));
    }
}