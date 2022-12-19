package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair3.business.dtos.responses.product.GetProductResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.business.dtos.requests.product.AddProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;


import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<Product> getById(int id);
    DataResult<List<Product>> getAllByStockGreaterThan(int stock);
    DataResult<Product> getByName(String name);
    DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest);
    DataResult<List<GetProductResponse>> getProductsByCategoryId(int identity);
    Page<Product> findAllWithPagination(Pageable pageable);

    Slice<Product> findAllWithSlice(Pageable pageable);
}
