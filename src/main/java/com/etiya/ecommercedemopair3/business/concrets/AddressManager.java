package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.*;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.messages.MessageSourceService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.*;
import com.etiya.ecommercedemopair3.repository.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private AddressRepository addressRepository;
    private StreetRepository streetRepository;
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private MessageSourceService messageSourceService;


    @Override
    public DataResult<List<Address>> getAll() {
        List<Address> response = addressRepository.findAll();
        return new SuccessDataResult<List<Address>>(response,messageSourceService.getMessages(Messages.Address.addressListAllSuccessMessage));
    }

    @Override
    public DataResult<Address> getById(int id) {
        Address response = addressRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Address>(response,messageSourceService.getMessages(Messages.Address.addressGetByIdSuccessMessage));
    }

    @Override
    public List<Address> getAllAddressByTitle(String title) {
        return addressRepository.findAllAddressByTitle(title);
    }

    @Override
    public Address findByDescription(String description) {
        return addressRepository.findByDescription(description);
    }

    @Override
    public DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest) {

        checkIfStreetExists(addAddressRequest.getStreetId());

        checkIfCustomerExists(addAddressRequest.getCustomerId());

        Address address= modelMapperService.getMapperRequest().map(addAddressRequest,Address.class);

        Address savedAddress = addressRepository.save(address);

        AddAddressResponse response= modelMapperService.getMapperResponse().map(savedAddress,AddAddressResponse.class);
        return new SuccessDataResult<AddAddressResponse>(response,Messages.Address.addressAddingSuccessMessage);
    }

    @Override
    public Page<Address> findAllWithPagination(Pageable pageable) {
        return  addressRepository.findAll(pageable);
    }

    @Override
    public Slice<Address> findAllWithSlice(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }

    private void checkIfStreetExists(int id){
        boolean isExists = streetRepository.existsById(id);
        if(!isExists) {
            throw new BusinessException(messageSourceService.getMessages(Messages.Street.StreetNotExistWithId));
        }
    }

    private void checkIfCustomerExists(int id){
        boolean isExists = customerRepository.existsById(id);
        if(!isExists) {
            throw new BusinessException(messageSourceService.getMessages(Messages.Customer.CustomerNotExistWithId));
        }
    }

}