package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.ProductService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair3.business.dtos.responses.product.GetProductResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "products")
public class ProductsController {
    @Autowired
    private ProductService productService;


    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Product> getById(@RequestParam("id") int id){
        return productService.getById(id);
    }

    @GetMapping("/getByStockGreaterThan")
    public DataResult<List<Product>> getAllByStock(@RequestParam("stock") int stock){
        return productService.getAllByStockGreaterThan(stock);
    }

    @GetMapping("/getByName")
    public DataResult<Product> getByName(@RequestParam("name") String name){
        return productService.getByName(name);
    }
    @PostMapping("/add")
    public ResponseEntity<DataResult<AddProductResponse>> addProduct(@RequestBody @Valid AddProductRequest addProductRequest)
    {
        return  new ResponseEntity<>(productService.addProduct(addProductRequest), HttpStatus.CREATED);
    }

    @GetMapping("getProductsByCategory")
    public DataResult<List<GetProductResponse>> getProductsByCategoryId(int identity){
        return productService.getProductsByCategoryId(identity);
    }
    @GetMapping("/getWithPagination")
    // RequestParam => page,pageSize
    public Page<Product> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return productService.findAllWithPagination(pageable);
    }

    @GetMapping("/getWithSlice")
    // RequestParam => page,pageSize
    public Slice<Product> getWithSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return productService.findAllWithSlice(pageable);
    }


}
