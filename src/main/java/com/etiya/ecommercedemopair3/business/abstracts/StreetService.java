package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.street.AddStreetRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercedemopair3.business.dtos.responses.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.entities.concrets.Street;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StreetService {
    DataResult<Street> getById(int id);
    DataResult<AddStreetResponse> addStreet(AddStreetRequest addStreetRequest);
    DataResult<List<GetAllStreetsResponse>> getAllDto();
    Page<Street> findAllWithPagination(Pageable pageable);

    Slice<Street> findAllWithSlice(Pageable pageable);
}