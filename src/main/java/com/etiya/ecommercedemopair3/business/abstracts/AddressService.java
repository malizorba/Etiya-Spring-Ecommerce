package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Address;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface AddressService {
    DataResult<List<Address>> getAll();
    DataResult<Address> getById(int id);
    List<Address> getAllAddressByTitle(String title);
    Address findByDescription(String description);
    DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest);
    Page<Address> findAllWithPagination(Pageable pageable);

    Slice<Address> findAllWithSlice(Pageable pageable);
}
