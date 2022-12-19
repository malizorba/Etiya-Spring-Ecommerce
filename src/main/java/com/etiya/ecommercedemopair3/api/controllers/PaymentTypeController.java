package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.PaymentTypeService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.PaymentType;
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
@RequestMapping(Paths.apiPrefix + "paymentTypes")
@AllArgsConstructor
public class PaymentTypeController {
    PaymentTypeService paymentTypeService;

    @GetMapping("/getAll")
    public DataResult<List<PaymentType>> getAll(){
        return paymentTypeService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<PaymentType> getById(@PathVariable int id){
        return paymentTypeService.getById(id);
    }

    @GetMapping("/name")
    public DataResult<PaymentType> getByName(@RequestParam("name") String name){
        return paymentTypeService.getByName(name);
    }

    @GetMapping("/description")
    public DataResult<PaymentType> getByDescription(@RequestParam("description") String description){
        return paymentTypeService.getByDescription(description);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddPaymentTypeResponse>> addPaymentType(@RequestBody AddPaymentTypeRequest addPaymentTypeRequest)
    {
        return  new ResponseEntity<>(paymentTypeService.addPaymentType(addPaymentTypeRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getWithPagination")
    // RequestParam => page,pageSize
    public Page<PaymentType> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return paymentTypeService.findAllWithPagination(pageable);
    }

    @GetMapping("/getWithSlice")
    // RequestParam => page,pageSize
    public Slice<PaymentType> getWithSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return paymentTypeService.findAllWithSlice(pageable);
    }
}
