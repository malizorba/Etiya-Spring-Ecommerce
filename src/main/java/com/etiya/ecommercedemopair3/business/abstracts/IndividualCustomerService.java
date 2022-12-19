package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.IndividualCustomer;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IndividualCustomerService {
    DataResult<List<IndividualCustomer>> getAll();
    DataResult<IndividualCustomer> getById(int id);
    DataResult<IndividualCustomer> getIndividualCustomerBynationalIdentity(String nationalIdentity);
    DataResult<List<IndividualCustomer>> getIndividualCustomerByFirstName(String firstName);
    DataResult<AddIndividualCustomerResponse> addIndividualCustomer(AddIndividualCustomerRequest addIndividualCustomerRequest);
    Page<IndividualCustomer> findAllWithPagination(Pageable pageable);

    Slice<IndividualCustomer> findAllWithSlice(Pageable pageable);

}
