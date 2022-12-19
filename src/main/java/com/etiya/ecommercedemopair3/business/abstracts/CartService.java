package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.cart.AddCartRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.cart.AddCartResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Cart;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface CartService {
    DataResult<AddCartResponse> addCart(AddCartRequest addCartRequest);
    Page<Cart> findAllWithPagination(Pageable pageable);

    Slice<Cart> findAllWithSlice(Pageable pageable);
}