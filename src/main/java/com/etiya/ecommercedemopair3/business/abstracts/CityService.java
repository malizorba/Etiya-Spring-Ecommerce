package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.city.AddCityResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.City;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface CityService {
    DataResult<City> getById(int id);
    DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest);
    Page<City> findAllWithPagination(Pageable pageable);

    Slice<City> findAllWithSlice(Pageable pageable);
}
