package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.IndividualCustomer;
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
@RequestMapping(Paths.apiPrefix + "individualCustomers")
@AllArgsConstructor
public class IndividualCustomersController {
    IndividualCustomerService individualCustomerService;

    @GetMapping("/getAll")
    public DataResult<List<IndividualCustomer>> getAll(){
        return individualCustomerService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<IndividualCustomer> getById(@RequestParam("id") int id){
        return individualCustomerService.getById(id);
    }

    @GetMapping("/firstName")
    public DataResult<List<IndividualCustomer>> getIndividualCustomerByFirstName(@RequestParam("firstName") String firstName){
        return individualCustomerService.getIndividualCustomerByFirstName(firstName);
    }

    @GetMapping("/nationalIdentity")
    public DataResult<IndividualCustomer> getIndividualCustomerBynationalIdentity(@RequestParam("nationalIdentity") String nationalIdentity){
        return individualCustomerService.getIndividualCustomerBynationalIdentity(nationalIdentity);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddIndividualCustomerResponse>> addIndividualCustomer(@RequestBody AddIndividualCustomerRequest addIndividualCustomerRequest)
    {
        return  new ResponseEntity<>(individualCustomerService.addIndividualCustomer(addIndividualCustomerRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getWithPagination")
    // RequestParam => page,pageSize
    public Page<IndividualCustomer> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return individualCustomerService.findAllWithPagination(pageable);
    }

    @GetMapping("/getWithSlice")
    // RequestParam => page,pageSize
    public Slice<IndividualCustomer> getWithSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return individualCustomerService.findAllWithSlice(pageable);
    }
}
