package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Category;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.Locale;

public interface CategoryService {
    DataResult<List<Category>> getAll();
    DataResult<Category> getById(int id);
    DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest);
    Page<Category> findAllWithPagination(Pageable pageable);

    Slice<Category> findAllWithSlice(Pageable pageable);
}