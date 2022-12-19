package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.country.AddCountryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Country;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface CountryService {
    DataResult<Country> getById(int id);
    DataResult<AddCountryResponse> addCountry(AddCountryRequest addCountryRequest);
    Page<Country> findAllWithPagination(Pageable pageable);

    Slice<Country> findAllWithSlice(Pageable pageable);
}
