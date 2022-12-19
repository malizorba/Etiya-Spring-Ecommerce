package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.PaymentType;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface PaymentTypeService {
    DataResult<List<PaymentType>> getAll();
    DataResult<PaymentType> getById(int id);
    DataResult<PaymentType> getByName(String name);
    DataResult<PaymentType> getByDescription(String description);
    DataResult<AddPaymentTypeResponse> addPaymentType(AddPaymentTypeRequest addPaymentTypeRequest);
    Page<PaymentType> findAllWithPagination(Pageable pageable);

    Slice<PaymentType> findAllWithSlice(Pageable pageable);
}
