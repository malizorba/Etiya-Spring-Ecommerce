package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Customer;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CustomerService {
    //    AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest);
    DataResult<Customer> getById(int id);
    SuccessDataResult<List<Customer>> getAll();
    Page<Customer> findAllWithPagination(Pageable pageable);

    Slice<Customer> findAllWithSlice(Pageable pageable);
}
