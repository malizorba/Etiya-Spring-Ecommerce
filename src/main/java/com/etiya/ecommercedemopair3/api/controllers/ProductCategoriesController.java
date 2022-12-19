package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.productCategory.AddProductCategoryResponse;

import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix + "productcategories")
@AllArgsConstructor
public class ProductCategoriesController {
    private ProductCategoryService productCategoryService;

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddProductCategoryResponse>> addProductCategory(@RequestBody @Valid AddProductCategoryRequest addProductCategoryRequest) {
        return new ResponseEntity<>(productCategoryService.addProductCategory(addProductCategoryRequest), HttpStatus.CREATED);
    }
}
