package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair3.business.constants.Paths;

import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Customer;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "customers")
@AllArgsConstructor
public class CustomersController {
    private CustomerService customerService;
    @GetMapping("/getById")
    public DataResult<Customer> getById(@RequestParam("id") int id){
        return customerService.getById(id);
    }
    @GetMapping("/getAll")
    public DataResult<List<Customer>> getAll(){
        return customerService.getAll();
    }
    @GetMapping("/getWithPagination")
    // RequestParam => page,pageSize
    public Page<Customer> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return customerService.findAllWithPagination(pageable);
    }

    @GetMapping("/getWithSlice")
    // RequestParam => page,pageSize
    public Slice<Customer> getWithSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return customerService.findAllWithSlice(pageable);
    }
}