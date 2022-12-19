package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Category;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "categories")
@AllArgsConstructor
public class CategoriesController {
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public DataResult<List<Category>> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddCategoryResponse>> addCategory(@RequestBody AddCategoryRequest addCategoryRequest){
        return new ResponseEntity<>(categoryService.addCategory(addCategoryRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getWithPagination")
    public Page<Category> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return categoryService.findAllWithPagination(pageable);
    }

    @GetMapping("/getWithSlice")
    public Slice<Category> getWithSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return categoryService.findAllWithSlice(pageable);
    }
}
