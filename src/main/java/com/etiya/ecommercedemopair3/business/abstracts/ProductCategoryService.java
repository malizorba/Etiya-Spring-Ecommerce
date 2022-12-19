package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.productCategory.AddProductCategoryResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;

public interface ProductCategoryService {
    DataResult<AddProductCategoryResponse> addProductCategory(AddProductCategoryRequest addProductCategoryRequest);
}
