package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.messages.MessageSourceService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Customer;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    CustomerRepository customerRepository;
    private MessageSourceService messageSourceService;

    @Override
    public DataResult<Customer> getById(int id) {
        Customer response = customerRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Customer>(response, messageSourceService.getMessages(Messages.Customer.customerGetAllSuccessMessage));
    }

    @Override
    public SuccessDataResult<List<Customer>> getAll() {
        List<Customer> response = customerRepository.findAll();
        return new SuccessDataResult<List<Customer>>(response, messageSourceService.getMessages(Messages.Customer.customerGetByIdSuccessMessage));
    }
    @Override
    public Page<Customer> findAllWithPagination(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Slice<Customer> findAllWithSlice(Pageable pageable) {
        return customerRepository.getAllWithSlice(pageable);
    }
}
