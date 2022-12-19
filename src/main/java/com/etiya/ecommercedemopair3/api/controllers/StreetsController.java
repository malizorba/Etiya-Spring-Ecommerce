package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.StreetService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.street.AddStreetRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.street.AddStreetResponse;

import com.etiya.ecommercedemopair3.business.dtos.responses.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.entities.concrets.Street;
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
@RequestMapping(Paths.apiPrefix + "streets")
@AllArgsConstructor
public class StreetsController {
    private StreetService streetService;

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddStreetResponse>> addStreet(@RequestBody AddStreetRequest addStreetRequest)
    {
        return new ResponseEntity<>(streetService.addStreet(addStreetRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getWithPagination")
    // RequestParam => page,pageSize
    public Page<Street> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return streetService.findAllWithPagination(pageable);
    }

    @GetMapping("/getWithSlice")
    // RequestParam => page,pageSize
    public Slice<Street> getWithSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return streetService.findAllWithSlice(pageable);
    }

    @GetMapping("/getAllCitiesDto")
    public DataResult<List<GetAllStreetsResponse>> getAllDto(){
        return this.streetService.getAllDto();
    }
}