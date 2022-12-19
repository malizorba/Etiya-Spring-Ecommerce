package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.OrderService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.order.AddOrderRequest;
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
@RequestMapping(Paths.apiPrefix + "orders")
@AllArgsConstructor
public class OrdersController {
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddOrderRequest>> add(@RequestBody AddOrderRequest addOrderRequest) {
        return new ResponseEntity(orderService.addOrder(addOrderRequest), HttpStatus.CREATED);
    }
}
